package controller;

import database.Koneksi; // Mengarah ke package database yang benar
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Peminjaman;

public class PeminjamanController {
    
    // 1. FUNGSI MEMUAT DATA KE TABEL GUI
    public void tampilData(JTable tabel) {
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        model.setRowCount(0); // Reset baris tabel sebelum dimuat ulang
        
        String sql = "SELECT * FROM peminjaman"; 
        
        try {
            Connection con = Koneksi.getKoneksi();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                // Mengambil data dari database dengan nama kolom yang disesuaikan
                Object[] row = {
                    rs.getString("nim"),            
                    rs.getString("id_buku"),         
                    rs.getString("tanggal_pinjam") // <-- SUDAH DISESUAIKAN (Pakai 'tanggal_pinjam')
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal memuat data ke tabel!\nDetail: " + e.getMessage(), "Error Tabel", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // 2. FUNGSI MENYIMPAN DATA KE DATABASE
    public void simpanTransaksi(Peminjaman pmj) {
        // Query SQL disesuaikan dengan nama kolom database asli Anda yaitu 'tanggal_pinjam'
        String sql = "INSERT INTO peminjaman (nim, id_buku, tanggal_pinjam) VALUES (?, ?, ?)";
        
        try {
            Connection con = Koneksi.getKoneksi();
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, pmj.getNim());
            ps.setString(2, pmj.getIdBuku());
            ps.setString(3, pmj.getTanggal());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Transaksi Berhasil Disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Menyimpan Data!\nDetail: " + e.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
    }
}