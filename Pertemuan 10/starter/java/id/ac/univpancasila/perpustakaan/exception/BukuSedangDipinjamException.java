package id.ac.univpancasila.perpustakaan.exception;

/** Exception buku tidak tersedia yang membawa ISBN dan judul buku. */
public class BukuSedangDipinjamException extends PerpustakaanException {

    private static final long serialVersionUID = 1L;

    private final String isbn;
    private final String judul;

    public BukuSedangDipinjamException(String isbn, String judul) {
        super("Buku \"" + judul + "\" dengan ISBN " + isbn + " sedang dipinjam");
        this.isbn = isbn;
        this.judul = judul;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getJudul() {
        return judul;
    }
}
