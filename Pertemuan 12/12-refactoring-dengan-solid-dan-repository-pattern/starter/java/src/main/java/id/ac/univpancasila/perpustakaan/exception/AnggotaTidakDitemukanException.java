package id.ac.univpancasila.perpustakaan.exception;

/** Exception yang membawa ID anggota yang tidak terdaftar. */
public class AnggotaTidakDitemukanException extends PerpustakaanException {

    private static final long serialVersionUID = 1L;

    private final String idAnggota;

    public AnggotaTidakDitemukanException(String idAnggota) {
        super("Anggota dengan ID " + idAnggota + " tidak ditemukan");
        this.idAnggota = idAnggota;
    }

    public String getIdAnggota() {
        return idAnggota;
    }
}
