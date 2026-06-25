/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HYPE AMD
 */
public class Anggota extends User {
    private String nim;
    private String jurusan;
    private int poin = 0;

    public Anggota(int id, String nama, String nim, String jurusan) {
        super(id, nama);
        this.nim = nim;
        this.jurusan = jurusan;
    }
    public String getNim() {
        return nim;
    }
    public void setNim(String nim) {
        this.nim = nim;
    }
    public String getJurusan() {
        return jurusan;
    }
    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
    public int getPoin() {
        return poin;
    }
    public void setPoin(int poin) {
        this.poin = poin;
    }
    @Override
    public void tampilRole() {
        System.out.println("Role: Anggota");
        System.out.println("NIM      : " + nim);
        System.out.println("Jurusan  : " + jurusan);
        System.out.println("Poin     : " + poin);
    }
}