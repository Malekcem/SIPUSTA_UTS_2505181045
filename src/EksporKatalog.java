import model.*;
import Layanan.*;
import eksepsi.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EksporKatalog {
    public static void main(String[] args) {
        KatalogPerpustakaan katalog = new KatalogPerpustakaan();

        // Menambahkan data sampel
        katalog.tambahKoleksi(new BukuCetak("B001", "Pemrograman Java", 2023, 350, "R-01", false));
        katalog.tambahKoleksi(new Majalah("M001", "Tech Nusantara", 2026, 45, "Juni", "R-10", true)); 
        katalog.tambahKoleksi(new BerkasDigital("D001", "E-Book Algoritma", 2025, 15.5, "https://polmed.ac.id/download/algo"));
        katalog.tambahKoleksi(new BukuCetak("B002", "Basis Data Lanjut", 2021, 280, "R-02", true)); 

        // 1. Uji cetak status polimorfik
        katalog.cetakStatus();

        // 2. Uji pengurutan menggunakan UrutLayakLaluJudul
        System.out.println("\n=== SETELAH DIURUTKAN (Layak Dulu, Lalu Judul) ===");
        katalog.urut(new UrutLayakLaluJudul());
        katalog.cetakStatus();

        // 3. Uji Exception pada method pinjam
        System.out.println("\n=== PENGUJIAN PEMINJAMAN ===");
        for (Koleksi k : katalog.getDaftarKoleksi()) {
            try {
                katalog.pinjam(k);
            } catch (PustakaException e) {
                System.out.println("GAGAL PINJAM [" + k.getJudul() + "]: " + e.getMessage());
            }
        }

        // 4. Menuliskan seluruh koleksi ke berkas teks katalog.txt dengan try-with-resources
        String namaFile = "katalog.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(namaFile))) {
            writer.printf("%-10s | %-25s | %-12s | %-15s%n", "KODE", "JUDUL", "TAHUN", "LAYAK PINJAM");
            writer.println("------------------------------------------------------------------");
            for (Koleksi k : katalog.getDaftarKoleksi()) {
                writer.printf("%-10s | %-25s | %-12d | %-15s%n", 
                        k.getKodeKoleksi(), 
                        k.getJudul(), 
                        k.getTahunTerbit(), 
                        k.isLayakPinjam() ? "Ya" : "Tidak");
            }
            System.out.println("\n[INFO] Katalog berhasil diekspor secara rapi ke file " + namaFile);
        } catch (IOException e) {
            System.err.println("Terjadi kesalahan saat menulis file: " + e.getMessage());
        }
    }
}