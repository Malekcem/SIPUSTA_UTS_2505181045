package model;

public class BukuCetak extends Koleksi implements Terasip {
    private int jumlahHalaman;
    private String nomorRak;
    private boolean sedangDiperbaiki; 

    public BukuCetak(String kodeKoleksi, String judul, int tahunTerbit, int jumlahHalaman, String nomorRak, boolean sedangDiperbaiki) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.jumlahHalaman = jumlahHalaman;
        this.nomorRak = nomorRak;
        this.sedangDiperbaiki = sedangDiperbaiki;
    }

    public boolean isSedangDiperbaiki() { return sedangDiperbaiki; }

    @Override
    public boolean isLayakPinjam() {
        
        return !sedangDiperbaiki;
    }

    @Override
    public String nomorRak() {
        return nomorRak;
    }

    @Override
    public String lokasiLantai() {
        return "Lantai 1 (Area Buku Cetak)";
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + ", Halaman: " + jumlahHalaman + ", " + ringkasanArsip() + ", Layak Pinjam: " + isLayakPinjam();
    }
}