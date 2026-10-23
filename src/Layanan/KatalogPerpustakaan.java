package Layanan;

import model.Koleksi;
import model.BukuCetak;
import eksepsi.PustakaException;
import eksepsi.KoleksiSedangDipinjamException;
import eksepsi.KoleksiTidakLayakException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KatalogPerpustakaan {
    
    private List<Koleksi> daftarKoleksi = new ArrayList<>();

    public void tambahKoleksi(Koleksi k) {
        daftarKoleksi.add(k);
    }

    public List<Koleksi> getDaftarKoleksi() {
        return daftarKoleksi;
    }

   
    public void cetakStatus() {
        System.out.println("=== STATUS KATALOG PERPUSTAKAAN ===");
        for (Koleksi k : daftarKoleksi) {
            System.out.println(k.deskripsi()); 
        }
    }

   
    public void urut(Comparator<Koleksi> comparator) {
        daftarKoleksi.sort(comparator);
    }

   
    public void pinjam(Koleksi k) throws PustakaException {
        if (k instanceof BukuCetak && ((BukuCetak) k).isSedangDiperbaiki()) {
            throw new KoleksiSedangDipinjamException();
        }
        if (!k.isLayakPinjam()) {
            throw new KoleksiTidakLayakException();
        }
        System.out.println("Berhasil meminjam koleksi: " + k.getJudul());
    }
}