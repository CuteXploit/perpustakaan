<!-- 1. BANNER/HERO IMAGE -->
<p align="center">
  <img src="https://img.icons8.com/fluency/96/000000/books.png" alt="Library Icon"/>
  <!-- Ganti link di atas dengan gambar banner favoritmu. Cari di Google Images dengan kata kunci "digital library banner" atau "code banner", lalu upload ke repo-mu dan ganti link-nya -->
</p>

# 📖 Aplikasi Perpustakaan Digital

> Sebuah aplikasi desktop sederhana untuk mengelola data buku perpustakaan, dibangun dengan **Java** dan **NetBeans**.

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/)
[![NetBeans](https://img.shields.io/badge/NetBeans-1B6AC6?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white)](https://netbeans.apache.org/)
[![Status](https://img.shields.io/badge/Status-Berjalan-brightgreen?style=for-the-badge)]()

---

## ✨ Fitur Utama
*   **Manajemen Buku:** Lihat daftar buku yang tersedia.
*   **Informasi Detail:** Menampilkan ID, Judul, Penulis, Tahun Terbit, dan Stok buku.
*   **Koneksi Database:** Terhubung dengan database untuk menyimpan data secara permanen (Status: `Database Connected`).

---

## 🖼️ Tampilan Aplikasi

<!-- 2. SCREENSHOT APLIKASI -->
<p align="center">
  <img src="https://raw.githubusercontent.com/CuteXploit/perpustakaan/refs/heads/main/Screenshot%202026-06-26%20194436.png" alt="Screenshot Aplikasi" width="90%">
</p>

*Tampilan utama aplikasi yang menampilkan daftar buku beserta stoknya.*

---

## 🗺️ Alur Program (Flowchart)

<!-- 3. FLOWCHART -->
<p align="center">
  <img src="https://raw.githubusercontent.com/CuteXploit/perpustakaan/refs/heads/main/deepseek_mermaid_20260626_8be893.png" alt="Flowchart Aplikasi Perpustakaan" width="80%">
</p>

*Berikut adalah alur program saat aplikasi dijalankan hingga menampilkan data buku.*

### 📝 Keterangan Flowchart:
| Simbol | Keterangan |
|---|---|
| 🟢 **Mulai / Selesai** | Awal dan akhir dari program |
| 🔵 **Proses** | Aktivitas yang dilakukan oleh aplikasi |
| 🟡 **Percabangan (Decision)** | Keputusan apakah koneksi database berhasil atau tidak |
| 🔴 **Error** | Menampilkan pesan jika database gagal terhubung |

---

## 🛠️ Panduan Instalasi & Menjalankan Aplikasi

### 📋 Prasyarat
Pastikan kamu sudah menginstal:
- **Java JDK** (versi 8 atau lebih baru) - [Download](https://www.oracle.com/java/technologies/downloads/)
- **Apache NetBeans IDE** - [Download](https://netbeans.apache.org/download/index.html)
- **Database** (MySQL / SQLite sesuai konfigurasi)

---

### 📥 Langkah 1: Clone atau Download Repositori

**Cara 1: Menggunakan Git**
```bash
git clone https://github.com/CuteXploit/perpustakaan.git
