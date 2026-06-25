/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HYPE AMD
 */
public class Peminjaman {
    private String nim;
    private String idBuku;
    private String tanggal;

    public Peminjaman(String nim, String idBuku, String tanggal) {
        this.nim = nim;
        this.idBuku = idBuku;
        this.tanggal = tanggal;
    }

    // Getter dan Setter
    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }

    public String getIdBuku() { return idBuku; }
    public void setIdBuku(String idBuku) { this.idBuku = idBuku; }

    public String getTanggal() { return tanggal; }
    public void setTanggal(String tanggal) { this.tanggal = tanggal; }
}