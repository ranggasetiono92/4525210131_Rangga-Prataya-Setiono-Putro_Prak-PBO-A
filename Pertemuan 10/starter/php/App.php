<?php
declare(strict_types=1);

require_once __DIR__ . '/LibraryService.php';

$perpustakaan = new LibraryService();
$perpustakaan->daftarkanAnggota('A001');
$perpustakaan->tambahBuku('978-1', 'Pemrograman PHP', 2);
$perpustakaan->tambahBuku('978-2', 'Dasar-Dasar PBO', 1);
$perpustakaan->tambahBuku('978-3', 'Struktur Data', 1);

echo "=== DEMO SISTEM PERPUSTAKAAN ===\n";
echo "Anggota terdaftar: A001\n";
echo 'Batas pinjam: ' . LibraryService::BATAS_PINJAM . " buku\n\n";

$jalankanSkenario = static function (string $judul, callable $aksi): void {
    echo $judul . "\n";

    try {
        $aksi();
    } catch (PerpustakaanException $exception) {
        echo 'Gagal: ' . $exception->getMessage() . "\n";

        if ($exception instanceof BukuTidakDitemukanException) {
            echo 'ISBN: ' . $exception->getIsbn() . "\n";
        } elseif ($exception instanceof AnggotaTidakDitemukanException) {
            echo 'ID anggota: ' . $exception->getIdAnggota() . "\n";
        } elseif ($exception instanceof BukuSedangDipinjamException) {
            echo 'ISBN: ' . $exception->getIsbn()
                . ', judul: ' . $exception->getJudul() . "\n";
        } elseif ($exception instanceof BatasPinjamTerlampauiException) {
            echo 'ID anggota: ' . $exception->getIdAnggota()
                . ', batas maksimum: ' . $exception->getBatas() . "\n";
        }
    }

    echo "\n";
};

$jalankanSkenario('1. Peminjaman buku berhasil', static function () use ($perpustakaan): void {
    $perpustakaan->pinjam('A001', '978-1');
    echo 'Berhasil meminjam: ' . $perpustakaan->judulDari('978-1') . "\n";
    echo 'Sisa eksemplar: ' . $perpustakaan->sisaEksemplar('978-1') . "\n";
});

$jalankanSkenario('2. ISBN buku tidak terdaftar', static function () use ($perpustakaan): void {
    $perpustakaan->pinjam('A001', '000-0');
});

$jalankanSkenario('3. Anggota tidak terdaftar', static function () use ($perpustakaan): void {
    $perpustakaan->pinjam('A999', '978-1');
});

$jalankanSkenario('4. Meminjam eksemplar terakhir', static function () use ($perpustakaan): void {
    $perpustakaan->pinjam('A001', '978-1');
    echo 'Berhasil meminjam: ' . $perpustakaan->judulDari('978-1') . "\n";
    echo 'Sisa eksemplar: ' . $perpustakaan->sisaEksemplar('978-1') . "\n";
});

$jalankanSkenario('5. Buku sudah tidak tersedia', static function () use ($perpustakaan): void {
    $perpustakaan->pinjam('A001', '978-1');
});

$jalankanSkenario('6. Peminjaman buku kedua', static function () use ($perpustakaan): void {
    $perpustakaan->pinjam('A001', '978-2');
    echo 'Berhasil meminjam: ' . $perpustakaan->judulDari('978-2') . "\n";
    echo "Total buku yang dipinjam anggota A001: 3\n";
});

$jalankanSkenario('7. Batas maksimum pinjaman terlampaui', static function () use ($perpustakaan): void {
    $perpustakaan->pinjam('A001', '978-3');
});

echo "=== DEMO SELESAI ===\n";
