/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HYPE AMD
 */

public class Buku implements Cetak {
    private int id;
    private String judul;
    private String penulis;
    private int tahun;
    private int stok;

    // Constructor overloading
    public Buku() {
    }
    public Buku(int id, String judul, String penulis, int tahun, int stok) {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.tahun = tahun;
        this.stok = stok;
    }
    public Buku(String judul, String penulis) {
        this.judul = judul;
        this.penulis = penulis;
        this.stok = 1;
    }
    
    // Getter dan Setter
    public int getId() 
        {return id;}
    public void setId(int id) 
        {this.id = id;}
    public String getJudul() 
        {return judul;}
    public void setJudul(String judul) {
        if (judul != null && !judul.trim().isEmpty()) 
            {this.judul = judul;}}
    public String getPenulis() {
        return penulis;}
    public void setPenulis(String penulis) {
        this.penulis = penulis;}
    public int getTahun() {
        return tahun;}
    public void setTahun(int tahun) {
        this.tahun = tahun;}
    public int getStok() {
        return stok;}
    public void setStok(int stok) {
        if (stok >= 0) {
            this.stok = stok;
        } else {
            System.out.println("Stok tidak boleh negatif!");
        }
    }
    
    // Method tambahan
    public void kurangiStok(int jumlah) {
        if (stok >= jumlah) {
            stok -= jumlah;
        } else {
            System.out.println("Stok tidak mencukupi");
        }
    }
    public void tambahStok(int jumlah) {
        if (jumlah >= 0) {
            stok += jumlah;
        } else {
            System.out.println("Jumlah tidak boleh negatif");
        }
    }

    // Implementasi interface
    @Override
    public void cetakData() {
        System.out.println("ID Buku : " + id);
        System.out.println("Judul   : " + judul);
        System.out.println("Penulis : " + penulis);
        System.out.println("Tahun   : " + tahun);
        System.out.println("Stok    : " + stok);
    }
    // Method info buku
    public void infoBuku() {
        System.out.println("Judul   : " + judul);
        System.out.println("Penulis : " + penulis);
        System.out.println("Tahun   : " + tahun);
        System.out.println("Stok    : " + stok);
    }
}

