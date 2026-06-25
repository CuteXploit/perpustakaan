/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.Koneksi;
import model.Buku; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class BukuController {
    private Connection conn;
    
    // Constructor
    public BukuController() {
        conn = Koneksi.getKoneksi();
    }
    
    // 1. Method untuk menambah data buku (INSERT) - PERBAIKAN TASK 2 (JOptionPane Exception)
    public void tambahBuku(Buku buku) {
        String sql = "INSERT INTO buku (id, judul, penulis, tahun, stok) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, buku.getId());
            pst.setString(2, buku.getJudul());
            pst.setString(3, buku.getPenulis());
            pst.setInt(4, buku.getTahun());
            pst.setInt(5, buku.getStok());
            pst.executeUpdate();
            System.out.println("LOG INSERT: Berhasil menyimpan buku -> " + buku.getJudul());
        } catch (SQLException e) {
            // PERBAIKAN TASK 2: Memberikan pop-up informatif ke user jika database error
            javax.swing.JOptionPane.showMessageDialog(null, 
                "Gagal menyimpan data ke database, periksa koneksi XAMPP Anda!\nError: " + e.getMessage());
        }
    }

    // 2. Method untuk menampilkan data dari database (SELECT)
    public void tampilkanSemuaBuku() {
        String sql = "SELECT * FROM buku"; 
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            System.out.println("\n=== DAFTAR SEMUA BUKU DI DATABASE ===");
            while (rs.next()) {
                int id = rs.getInt("id");
                String judul = rs.getString("judul");
                String penulis = rs.getString("penulis");
                int tahun = rs.getInt("tahun");
                int stok = rs.getInt("stok");
                System.out.println("ID: " + id + " | Judul: " + judul + " | Penulis: " + penulis + " | Tahun: " + tahun + " | Stok: " + stok);
            }
            System.out.println("=====================================\n");
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Gagal menampilkan data! Periksa koneksi XAMPP Anda.");
        }
    }

    // 3. Method untuk mengubah data (UPDATE) stok berdasarkan ID Buku
    public void updateStok(int idBuku, int stokBaru) {
        String sql = "UPDATE buku SET stok = ? WHERE id = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, stokBaru); 
            pst.setInt(2, idBuku);   
            pst.executeUpdate(); 
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Gagal mengupdate stok! Periksa koneksi XAMPP Anda.");
        }
    }

    // 4. Method untuk hapus data buku (DELETE)
    public void hapusBuku(int idBuku) {
        String sql = "DELETE FROM buku WHERE id = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, idBuku); 
            pst.executeUpdate(); 
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Gagal menghapus data! Periksa koneksi XAMPP Anda.");
        }
    }

    // 5. Model untuk JTable Buku
    public DefaultTableModel getModelBuku() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Judul");
        model.addColumn("Penulis");
        model.addColumn("Tahun");
        model.addColumn("Stok");

        String sql = "SELECT * FROM buku";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("judul"),
                    rs.getString("penulis"),
                    rs.getInt("tahun"),
                    rs.getInt("stok")
                });
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengambil data tabel: " + e.getMessage());
        }
        return model;
    }

    // =========================================================================
    // BARIS TAMBAHAN BARU UNTUK FITUR PEMINJAMAN (TASK 3 INTEGRASI RELASIONAL)
    // =========================================================================

    // Fungsi Tambahan 1: Mengambil jumlah stok buku berdasarkan ID untuk Validasi Task 3 [cite: 19]
    public int cekStokBuku(int id) {
        int stok = 0;
        String sql = "SELECT stok FROM buku WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                stok = rs.getInt("stok");
            }
        } catch (SQLException e) {
            System.out.println("Gagal cek stok: " + e.getMessage());
        }
        return stok;
    }

    // Fungsi Tambahan 2: Menyimpan data transaksi peminjaman baru ke database
    public void simpanPeminjaman(String nim, int idBuku, String tanggal) {
        String sql = "INSERT INTO peminjaman (nim, id_buku, tanggal_pinjam, status) VALUES (?, ?, ?, 'Dipinjam')";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nim);
            ps.setInt(2, idBuku);
            ps.setString(3, tanggal);
            ps.executeUpdate();
        } catch (SQLException e) {
            // PERBAIKAN TASK 2: Menangkap SQLException dengan pesan informatif [cite: 16]
            javax.swing.JOptionPane.showMessageDialog(null, 
                "Gagal menyimpan transaksi peminjaman, periksa koneksi XAMPP Anda!");
        }
    }

    // Fungsi Tambahan 3: Mengambil data peminjaman untuk dimasukkan ke jTable1 kamu
    public DefaultTableModel getModelPeminjaman() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID PINJAM");
        model.addColumn("NIM MAHASISWA");
        model.addColumn("ID BUKU");
        model.addColumn("TANGGAL PINJAM");

        // Ganti 'peminjaman' sesuai dengan nama tabel database peminjamanmu
        String sql = "SELECT * FROM peminjaman"; 
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"), // sesuaikan nama kolom id_peminjaman di DB kamu
                    rs.getString("nim"),
                    rs.getInt("id_buku"),
                    rs.getString("tanggal_pinjam")
                });
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengambil data tabel peminjaman: " + e.getMessage());
        }
        return model;
    }
}