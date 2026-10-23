package model;

public interface Terasip {
    String nomorRak();
    String lokasiLantai();
    
    default String ringkasanArsip() {
        return "Rak: " + nomorRak() + ", Lantai: " + lokasiLantai();
    }
}