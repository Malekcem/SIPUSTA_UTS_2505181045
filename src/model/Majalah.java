package model;

public class Majalah extends Koleksi implements Terasip {
    private int edisi;
    private String bulanTerbit;
    private String nomorRak;
    private boolean edisiTerbaru; 

    public Majalah(String kodeKoleksi, String judul, int tahunTerbit, int edisi, String bulanTerbit, String nomorRak, boolean edisiTerbaru) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.edisi = edisi;
        this.bulanTerbit = bulanTerbit;
        this.nomorRak = nomorRak;
        this.edisiTerbaru = edisiTerbaru;
    }

    @Override
    public boolean isLayakPinjam() {
     
        return !edisiTerbaru;
    }

    @Override
    public String nomorRak() {
        return nomorRak;
    }

    @Override
    public String lokasiLantai() {
        return "Lantai 2 (Area Majalah & Periodikal)";
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + ", Edisi: " + edisi + " (" + bulanTerbit + "), " + ringkasanArsip() + ", Layak Pinjam: " + isLayakPinjam();
    }
}