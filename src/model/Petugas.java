/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HYPE AMD
 */
public class Petugas extends User {
    private String bagian;

    public Petugas(int id, String nama, String bagian) {
        super(id, nama);
        this.bagian = bagian;
    }

    public String getBagian() {
        return bagian;
    }

    public void setBagian(String bagian) {
        this.bagian = bagian;
    }

    @Override
    public void tampilRole() {
        System.out.println("Role: Petugas, Bagian: " + bagian);
    }
}
