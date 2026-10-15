package service;

import model.Buku;
import java.util.ArrayList;
/**
 * Kerangka lapisan layanan.
 * Pada sesi 7 cukup struktur dan tanda tangan method; isinya boleh minimal.
 * Lapisan ini akan diperdalam pada sesi 10 (exception) dan 12 (SOLID).
 *
 * TODO: sesuaikan seluruh isi berkas ini dengan class diagram Anda sendiri.
 *       Kelas dan method di sini hanya contoh awal.
 */
public class PerpustakaanService {

    // TODO 1: tentukan bagaimana layanan ini menyimpan koleksi dan anggota.
    //         Agregasi atau komposisi? Tuliskan alasannya di analisis.md,
    //         lalu wujudkan keputusan itu di sini.
    private ArrayList<Buku> bukuList = new ArrayList<>();
    // Sebutkan make jelas relasi apa

    public void tambahKoleksi(Buku buku) {
        // TODO 2
        this.bukuList.add(buku);
    }

    public Buku cariKoleksi(String nomorInduk) {
        // TODO 3
        for (Buku buku : this.bukuList) {
            if (buku.getNomorInduk().equals(nomorInduk)) {
                return buku;
            }
        }
        return null;
    }
    // TODO 4: terapkan aturan bisnis dari deskripsi-kebutuhan.md.
    //           Aturan lengkapnya akan disempurnakan pada sesi 10.
    //Contoh kerangka Logika:
    // 1. Cari Anggota berdasarkan nomorAnggota
    // 2. Cari Buku berdasarkan nomorInduk
    // 3. Cek apakah stok tersedia / tidak sedang dipinjam
    // 4. Kurangi stok atau ubah status peminjaman, sesuai kebutuhan

    public void pinjam(String nomorAnggota, String nomorInduk) {
        // TODO 4: terapkan aturan bisnis dari deskripsi-kebutuhan.md.
        //         Aturan lengkapnya akan disempurnakan pada sesi 10.
    }

    public void kembalikan(String nomorAnggota, String nomorInduk) {
        // TODO 5
    }
}
