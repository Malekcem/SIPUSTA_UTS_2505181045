package model;

public class BerkasDigital extends Koleksi {
    private double ukuranMB;
    private String tautanUnduh;

    public BerkasDigital(String kodeKoleksi, String judul, int tahunTerbit, double ukuranMB, String tautanUnduh) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.ukuranMB = ukuranMB;
        this.tautanUnduh = tautanUnduh;
    }

    @Override
    public boolean isLayakPinjam() {
      
        return true;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + ", Ukuran: " + ukuranMB + "MB, Link: " + tautanUnduh + ", Layak Pinjam: " + isLayakPinjam();
    }
}