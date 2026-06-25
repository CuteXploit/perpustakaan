/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controller.BukuController;
import model.Buku;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("=== TEST KONEKSI DATABASE ===");
        System.out.println("Menghubungi MySQL...\n");
        
        BukuController controller = new BukuController();
        System.out.println();
        
        // 1. Menyiapkan 5 Data Buku
        System.out.println("--- Menyiapkan Data Buku ---");
        Buku buku1 = new Buku(101, "Struktur Data dengan Java", "Rinaldi Munir", 2020, 15);
        Buku buku2 = new Buku(102, "Pemrograman Berorientasi Objek", "Rosa A.S.", 2021, 10);
        Buku buku3 = new Buku(103, "Pengantar Sistem Informasi", "Jogiyanto", 2019, 25);
        Buku buku4 = new Buku(104, "Data Mining untuk Pemula", "Kusrini", 2023, 8);
        Buku buku5 = new Buku(105, "Logika dan Algoritma", "Abdul Kadir", 2022, 20);
        
        // 2. Proses Insert ke Database
        System.out.println("\n--- Proses Insert ke Database ---");
        controller.tambahBuku(buku1);
        controller.tambahBuku(buku2);
        controller.tambahBuku(buku3);
        controller.tambahBuku(buku4);
        controller.tambahBuku(buku5);
        
        // 3. Tampilkan Data Awal sebelum diubah/dihapus
        System.out.println("\n=== TAMPILAN SEMUA DATA BUKU ===");
        controller.tampilkanSemuaBuku();
        
        // ============================================================
        // LANGKAH 1.5 - PROSES UPDATE DATA BUKU
        // ============================================================
        System.out.println("=== PROGRAM UJI COBA UPDATE DATA ===\n");
        System.out.println("Menjalankan proses update data...");
        // Skenario: Mengubah stok buku dengan ID 101 menjadi 99 buah
        controller.updateStok(101, 99);
        
        System.out.println("\nMenampilkan data setelah proses update:");
        controller.tampilkanSemuaBuku();
        
        // ============================================================
        // LANGKAH 1.6 - PROSES MENGHAPUS DATA BUKU
        // ============================================================
        System.out.println("\n=== PROSES MENGHAPUS DATA BUKU ===");
        System.out.println("Menjalankan proses hapus data...");
        // Skenario: Menghapus buku dengan ID 102
        controller.hapusBuku(102);        
        
        System.out.println("\nMenampilkan data setelah proses hapus:");
        controller.tampilkanSemuaBuku();
        
        System.out.println("=== PROGRAM SELESAI ===");
    }
}