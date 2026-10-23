package eksepsi;

public class KoleksiTidakLayakException extends PustakaException {
    public KoleksiTidakLayakException() {
        super("Maaf, koleksi ini dikategorikan sebagai edisi terbaru sehingga belum boleh dipinjam keluar.");
    }
}