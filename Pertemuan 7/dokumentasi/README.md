# LAPORAN PRAKTIKUM PEMROGRAMAN BERBASIS OBJEK

| Informasi Praktikan | Keterangan |
| :--- | :--- |
| **Nama** | Rangga Prataya Setiono Putro |
| **NPM** | 4525210131 |
| **Kelas** | A |
| **Mata Kuliah** | Pemrograman Berbasis Objek (PBO) |
| **Pertemuan** | [Pertemuan 7] |
| **Tanggal** | [15 Oktober 2026] |

---

## 1. Implementasi Java
**Penjelasan Kode:**
> Rangkaian kode Java di atas mendemonstrasikan perbedaan mendasar antara dua bentuk hubungan antar-objek dalam Pemrograman Berorientasi Objek, yaitu **Komposisi** dan **Agregasi**, melalui pemodelan sistem perpustakaan dan akademik. Kelas `Buku` menerapkan hubungan **komposisi** mutlak dengan kelas bagian bersarang `Bab`, di mana objek bab sepenuhnya diciptakan di dalam kelas induk melalui method `tambahBab()` dan tidak dapat berdiri sendiri atau dibuat dari luar karena konstruktornya bersifat privat. Sebaliknya, kelas `Jurusan` menerapkan hubungan **agregasi** dengan kelas `Mahasiswa`, di mana objek mahasiswa diciptakan secara mandiri di luar jurusan dan kemudian didaftarkan atau dilepaskan melalui method `daftarkan()` dan `keluarkan()`, sehingga mahasiswa tetap dapat eksis meskipun relasinya dengan jurusan telah berakhir. Selain itu, keamanan data pada relasi komposisi dijaga secara ketat menggunakan metode `List.copyOf()` pada *getter* untuk mencegah modifikasi koleksi internal dari luar, sementara lapisan layanan `PerpustakaanService` bertindak sebagai pengelola koleksi buku secara terpusat untuk mendukung operasi bisnis seperti pencarian, peminjaman, dan pengembalian.

### 1.1. File: `Buku.java`

**Bukti Eksekusi (Screenshot):**
* **Before** *(Kondisi awal / Kesalahan kompilasi)*:
![alt text](image-8.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![alt text](image.png)

### 1.2. File: `Jurusan.java`

**Bukti Eksekusi (Screenshot):**
* **Before** *(Kondisi awal / Kesalahan kompilasi)*:
![alt text](image-9.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![alt text](image-1.png)

### 1.3. File: `PerpustakaanService.java`
>Berdasarkan berkas PerpustakaanService.java, relasi yang terjalin antara kelas PerpustakaanService dan kelas Buku adalah hubungan Agregasi.   Berikut adalah penjelasan rinci mengenai bentuk dan alasan di balik relasi tersebut:
* Penerimaan Objek dari Luar: 
Objek Buku tidak diciptakan secara internal di dalam kelas PerpustakaanService, melainkan diterima dari luar melalui parameter method tambahKoleksi(Buku buku) dan kemudian disimpan ke dalam struktur koleksi ArrayList.   
* Siklus Hidup yang Independen: Karena menerapkan pola agregasi, apabila kelas layanan PerpustakaanService ini dihentikan atau dihapus, objek Buku yang dikelola di dalamnya akan tetap hidup dan dapat eksis secara mandiri di luar sistem layanan tersebut.
* Peran Pengelolaan: Kelas ini bertindak sebagai lapisan layanan (service layer) yang mengoordinasikan kumpulan buku secara terpusat, memfasilitasi pencarian koleksi berdasarkan nomor induk (cariKoleksi), serta menangani aturan bisnis operasional perpustakaan seperti peminjaman dan pengembalian

**Bukti Eksekusi (Screenshot):**
* **Before** *(Kondisi awal / Kesalahan kompilasi)*:
![alt text](image-10.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![alt text](image-2.png)

### 1.4. File: `Main.java`

**Bukti Eksekusi (Screenshot):**
* **Before** *(Kondisi awal / Kesalahan kompilasi)*:
![alt text](image-11.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![alt text](image-3.png)

### Output
**Output Program:**
![alt text](image-4.png)
---

## 2. Implementasi PHP
**Penjelasan Kode:**
> Rangkaian kode PHP di atas mendemonstrasikan perbedaan implementasi relasi antar-objek—yaitu **Komposisi** dan **Agregasi**—melalui pemodelan sistem perpustakaan dan akademik. Pada relasi **Komposisi**, kelas `Buku` memiliki hubungan erat dengan kelas `Bab`, di mana objek bagian (`Bab`) hanya dapat diciptakan secara internal di dalam kelas induk melalui method `tambahBab()` dengan parameter atribut dasar, serta menggunakan properti `readonly` untuk memastikan data di dalamnya aman dari perubahan. Sebaliknya, pada relasi **Agregasi**, kelas `Jurusan` menaungi objek `Mahasiswa` yang dikelola secara longgar, di mana objek mahasiswa diciptakan secara mandiri di luar jurusan lalu dimasukkan atau dilepaskan melalui method `daftarkan()` dan `keluarkan()`, sehingga objek mahasiswa tersebut tetap dapat hidup dan eksis meskipun relasinya dengan jurusan telah berakhir. Program utama (`main.php`) kemudian mengeksekusi dan membuktikan kedua konsep tersebut secara nyata, mulai dari pencatatan rekapitulasi buku beserta bab-babnya hingga simulasi perpindahan mahasiswa dari suatu jurusan.

### 2.1. File: `relasi.php`

**Bukti Eksekusi (Screenshot):**
* **Before** *(Kondisi awal / Galat logika)*:
![alt text](image-12.png)
* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![alt text](image-5.png)


### 2.2. File: `main.php`

**Bukti Eksekusi (Screenshot):**
* **Before** *(Kondisi awal / Galat logika)*:
![alt text](image-13.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![alt text](image-6.png)


### Output
**Output Program:**
![alt text](image-7.png)
---

## 3. Kesimpulan    
>Kesimpulan dari perbandingan implementasi kode program berbasis Java dan PHP pada sesi ini adalah bahwa kedua bahasa tersebut berhasil menerapkan konsep relasi antar-objek—yaitu **Komposisi** dan **Agregasi**—dengan pendekatan karakteristik sintaksis masing-masing. Pada relasi komposisi, kelas `Buku` dan `Bab` menunjukkan keterikatan yang sangat erat di mana objek bagian sepenuhnya diciptakan dan dikendalikan oleh kelas induk, di mana Java memperkuat batasan ini melalui penggunaan *nested class* privat sementara PHP menjaganya melalui disiplin konvensi dan properti `readonly`. Sebaliknya, pada relasi agregasi seperti antara `Jurusan` dan `Mahasiswa`, objek bagian diterima langsung dari luar dan memiliki siklus hidup yang independen sehingga tetap dapat eksis meskipun relasinya dengan kelas induk telah dilepaskan. Selain itu, pengelolaan koleksi secara terpusat melalui lapisan layanan seperti `PerpustakaanService` semakin menegaskan bagaimana struktur arsitektur berorientasi objek dapat merancang sistem yang aman, modular, dan konsisten di kedua platform bahasa pemrograman.