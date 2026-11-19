package id.ac.univpancasila.perpustakaan.exception;

/** Exception yang membawa ID anggota dan batas maksimum peminjaman. */
public class BatasPinjamTerlampauiException extends PerpustakaanException {

    private static final long serialVersionUID = 1L;

    private final String idAnggota;
    private final int batas;

    public BatasPinjamTerlampauiException(String idAnggota, int batas) {
        super("Anggota " + idAnggota + " telah mencapai batas pinjam maksimum (" + batas + " buku)");
        this.idAnggota = idAnggota;
        this.batas = batas;
    }

    public String getIdAnggota() {
        return idAnggota;
    }

    public int getBatas() {
        return batas;
    }
}
