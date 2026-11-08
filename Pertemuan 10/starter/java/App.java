import id.ac.univpancasila.perpustakaan.exception.AnggotaTidakDitemukanException;
import id.ac.univpancasila.perpustakaan.exception.BatasPinjamTerlampauiException;
import id.ac.univpancasila.perpustakaan.exception.BukuSedangDipinjamException;
import id.ac.univpancasila.perpustakaan.exception.BukuTidakDitemukanException;
import id.ac.univpancasila.perpustakaan.exception.PerpustakaanException;

public class App {

    public static void main(String[] args) {
        LibraryService perpustakaan = new LibraryService();
        perpustakaan.daftarkanAnggota("A001");
        perpustakaan.tambahBuku("978-1", "Pemrograman Java", 2);
        perpustakaan.tambahBuku("978-2", "Dasar-Dasar PBO", 1);
        perpustakaan.tambahBuku("978-3", "Struktur Data", 1);

        System.out.println("=== DEMO SISTEM PERPUSTAKAAN ===");
        System.out.println("Anggota terdaftar: A001");
        System.out.println("Batas pinjam: " + LibraryService.BATAS_PINJAM + " buku");
        System.out.println();

        jalankanSkenario("1. Peminjaman buku berhasil", () -> {
            perpustakaan.pinjam("A001", "978-1");
            System.out.println("Berhasil meminjam: " + perpustakaan.judulDari("978-1"));
            System.out.println("Sisa eksemplar: " + perpustakaan.sisaEksemplar("978-1"));
        });

        jalankanSkenario("2. ISBN buku tidak terdaftar",
                () -> perpustakaan.pinjam("A001", "000-0"));

        jalankanSkenario("3. Anggota tidak terdaftar",
                () -> perpustakaan.pinjam("A999", "978-1"));

        jalankanSkenario("4. Meminjam eksemplar terakhir",
                () -> {
                    perpustakaan.pinjam("A001", "978-1");
                    System.out.println("Berhasil meminjam: " + perpustakaan.judulDari("978-1"));
                    System.out.println("Sisa eksemplar: " + perpustakaan.sisaEksemplar("978-1"));
                });

        jalankanSkenario("5. Buku sudah tidak tersedia",
                () -> perpustakaan.pinjam("A001", "978-1"));

        jalankanSkenario("6. Peminjaman kedua buku lain",
                () -> {
                    perpustakaan.pinjam("A001", "978-2");
                    System.out.println("Berhasil meminjam: " + perpustakaan.judulDari("978-2"));
                    System.out.println("Total buku yang dipinjam anggota A001: 3");
                });

        jalankanSkenario("7. Batas maksimum pinjaman terlampaui",
                () -> perpustakaan.pinjam("A001", "978-3"));

        System.out.println();
        System.out.println("=== DEMO SELESAI ===");
    }

    private static void jalankanSkenario(String judul, Runnable aksi) {
        System.out.println(judul);
        try {
            aksi.run();
        } catch (PerpustakaanException e) {
            System.out.println("Gagal: " + e.getMessage());
            if (e instanceof BukuTidakDitemukanException) {
                System.out.println("ISBN: " + ((BukuTidakDitemukanException) e).getIsbn());
            } else if (e instanceof AnggotaTidakDitemukanException) {
                System.out.println("ID anggota: " + ((AnggotaTidakDitemukanException) e).getIdAnggota());
            } else if (e instanceof BukuSedangDipinjamException) {
                BukuSedangDipinjamException exception = (BukuSedangDipinjamException) e;
                System.out.println("ISBN: " + exception.getIsbn() + ", judul: " + exception.getJudul());
            } else if (e instanceof BatasPinjamTerlampauiException) {
                BatasPinjamTerlampauiException exception = (BatasPinjamTerlampauiException) e;
                System.out.println("ID anggota: " + exception.getIdAnggota()
                        + ", batas maksimum: " + exception.getBatas());
            }
        }
        System.out.println();
    }
}
