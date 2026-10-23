package eksepsi;

public class KoleksiSedangDipinjamException extends PustakaException {
    public KoleksiSedangDipinjamException() {
        super("Maaf, koleksi buku atau majalah ini sedang dalam status perbaikan atau tidak tersedia untuk dipinjam saat ini.");
    }
}