package model;

public abstract class Koleksi {
    private String kodeKoleksi;
    private String judul;
    private int tahunTerbit;

    public Koleksi(String kodeKoleksi, String judul, int tahunTerbit) {
        this.kodeKoleksi = kodeKoleksi;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    public String getKodeKoleksi() { return kodeKoleksi; }
    public String getJudul() { return judul; }
    public int getTahunTerbit() { return tahunTerbit; }

    public abstract boolean isLayakPinjam();

    public String deskripsi() {
        return "Kode: " + kodeKoleksi + ", Judul: " + judul + ", Tahun: " + tahunTerbit;
    }
}