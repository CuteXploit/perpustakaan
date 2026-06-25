/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database; // <--- INI SUDAH DIPERBAIKI (Sesuai nama foldermu)

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane; 

public class Koneksi {
    private static Connection koneksi;

    public static Connection getKoneksi() {
        try {
            // Jika koneksi belum ada atau sudah tertutup, buat koneksi baru
            if (koneksi == null || koneksi.isClosed()) {
                String url = "jdbc:mysql://127.0.0.1:3306/perpustakaanmini";
                String user = "root";
                String password = ""; 
                
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, user, password);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Gagal terhubung ke Database!\nPastikan Apache & MySQL di XAMPP sudah aktif.\n\nDetail Eror: " + e.getMessage(), 
                "Error Koneksi", 
                JOptionPane.ERROR_MESSAGE);
        }
        return koneksi;
    }
}