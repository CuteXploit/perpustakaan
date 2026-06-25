/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HYPE AMD
 */
public class Admin extends User {
private String level;

public Admin (int id, String nama, String level) {
    super(id, nama);
    this.level = level;
}
public String getLevel() { return level; }
public void setLevel (String level) { this.level = level; }

@Override
public void tampilRole() {
    System.out.println("Roles: Admin, level: " + level);
}
}
