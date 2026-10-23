package Layanan;

import model.Koleksi;
import java.util.Comparator;

public class UrutLayakLaluJudul implements Comparator<Koleksi> {

    @Override
    public int compare(Koleksi k1, Koleksi k2) {
       
        Boolean layak1 = k1.isLayakPinjam();
        Boolean layak2 = k2.isLayakPinjam();
        int hasilLayak = layak2.compareTo(layak1); 

        if (hasilLayak != 0) {
            return hasilLayak;
        }
       
        return k1.getJudul().compareTo(k2.getJudul());
    }
}