# LAPORAN PRAKTIKUM PEMROGRAMAN BERBASIS OBJEK

| Informasi Praktikan | Keterangan |
| :--- | :--- |
| **Nama** | Rangga Prataya Setiono Putro |
| **NPM** | 4525210131 |
| **Kelas** | A |
| **Mata Kuliah** | Pemrograman Berbasis Objek (PBO) |
| **Pertemuan** | [Pertemuan 6] |
| **Tanggal** | [8 Oktober 2026] |

---

## 1. Implementasi Java
**Penjelasan Kode:**
> Rangkaian kode Java di atas menerapkan konsep Pemrograman Berorientasi Objek (OOP) tingkat lanjut yang mencakup penggunaan kelas abstrak (`Kendaraan`), tipe data terenumerasi (`TipeBahanBakar`), serta beberapa *interface* spesifik (`Movable` dan `Fuelable`) untuk mendefinisikan kontrak perilaku objek secara terpisah. Kelas abstrak `Kendaraan` berfungsi sebagai fondasi dasar yang mencakup atribut umum serta method penghitungan umur kendaraan, sementara kelas turunan seperti `Mobil` mewarisi karakteristik tersebut sekaligus mengimplementasikan kontrak *interface* yang relevan sesuai dengan kemampuannya masing-masing (misalnya penerapan *Interface Segregation Principle* di mana hanya objek tertentu yang memerlukan bahan bakar). Selain itu, penggunaan *enum* `TipeBahanBakar` tidak hanya berfungsi sebagai pembatas nilai konstan yang aman dari kesalahan data, tetapi juga dilengkapi dengan method perilaku mandiri untuk menghitung biaya pengisian dan pengecekan sifat ramah lingkungan, yang kemudian dikoordinasikan secara fleksibel melalui program utama (*Main*) berbasis polimorfisme kontrak *interface*.

### 1.1. File: `Fuelable.java`

**Bukti Eksekusi (Screenshot):**
* **Before** *(Kondisi awal / Kesalahan kompilasi)*:
![alt text](image.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![alt text](image-1.png)

### 1.2. File: `Kendaraan.java`

**Bukti Eksekusi (Screenshot):**
* **Before** *(Kondisi awal / Kesalahan kompilasi)*:
![alt text](image-2.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![alt text](image-3.png)


### 1.3. File: `Main.java`

**Bukti Eksekusi (Screenshot):**
* **Before** *(Kondisi awal / Kesalahan kompilasi)*:
![alt text](image-4.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![alt text](image-5.png)

### 1.4. File: `Mobil.java`

**Bukti Eksekusi (Screenshot):**
* **Before** *(Kondisi awal / Kesalahan kompilasi)*:
![alt text](image-6.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![alt text](image-7.png)

### 1.5. File: `Movable.java`

**Bukti Eksekusi (Screenshot):**
* **Before** *(Kondisi awal / Kesalahan kompilasi)*:
![alt text](image-8.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![alt text](image-9.png)

### 1.6. File: `TipeBahanBakar.java`

**Bukti Eksekusi (Screenshot):**
* **Before** *(Kondisi awal / Kesalahan kompilasi)*:
![alt text](image-10.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![alt text](image-11.png)

### 1.7. File: `Sepeda.java`
**Penjelasan Kode:**
> Penambahan kelas `Sepeda` ke dalam sistem kendaraan bertujuan untuk memodelkan jenis moda transportasi roda dua yang dapat bergerak namun tidak memerlukan bahan bakar atau sistem pengisian energi eksternal. Dengan mewarisi kelas abstrak `Kendaraan` serta mengimplementasikan *interface* `Movable` secara mandiri tanpa ikut mengimplementasikan `Fuelable`, kelas ini menerapkan prinsip *Interface Segregation Principle* secara nyata, di mana objek hanya terikat pada kontrak perilaku yang benar-benar sesuai dengan karakteristik aslinya. Hal ini juga membuktikan fleksibilitas perancangan sistem berbasis polimorfisme kontrak, di mana objek kendaraan non-berbahan bakar dapat dimasukkan ke dalam pemrosesan gerak umum tanpa memicu kesalahan kompilasi pada fungsi-fungsi spesifik bahan bakar.
* **Penambahan** *(Kondisi akhir / Eksekusi berhasil)*:
![alt text](image-13.png)

### Output
**Output Program:**
![alt text](image-14.png)

---

## 2. Implementasi PHP
**Penjelasan Kode:**
> Kumpulan kode PHP di atas mengimplementasikan konsep Pemrograman Berorientasi Objek (OOP) tingkat lanjut yang mencakup penggunaan *interface* sebagai kontrak perilaku (`Movable` dan `Fuelable`), kelas abstrak (`Kendaraan`) sebagai fondasi bersama, *Backed Enum* dengan metode perilaku mandiri (`TipeBahanBakar`), serta *Trait* (`Loggable`) untuk mendukung penggunaan ulang kode secara horizontal lintas kelas yang tidak bersaudara. Melalui penerapan *Interface Segregation Principle*, objek seperti `Mobil` dan `Sepeda` dapat mengimplementasikan kontrak yang relevan secara selektif—di mana mobil memerlukan bahan bakar dan fitur logging, sementara sepeda hanya terikat pada kontrak gerak. Selain itu, program utama mendemonstrasikan fleksibilitas polimorfisme berbasis kontrak serta pemanfaatan *trait* pada entitas non-kendaraan seperti kelas `Pesanan`, sehingga struktur kode menjadi sangat modular, bersih, dan mudah dikelola.

### 2.1. File: `abstraksi.php`

**Bukti Eksekusi (Screenshot):**
* **Before** *(Kondisi awal / Galat logika)*:
![alt text](image-15.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![alt text](image-16.png)


### 2.2. File: `main.php`

**Bukti Eksekusi (Screenshot):**
* **Before** *(Kondisi awal / Galat logika)*:
![alt text](image-17.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![alt text](mainphp.png)


### Output
**Output Program:**
![alt text](image-19.png)

---

## 3. Kesimpulan    
>Kesimpulan dari keseluruhan implementasi program berbasis Java dan PHP yang telah dibahas adalah bahwa pemodelan sistem ini berhasil menerapkan konsep Pemrograman Berorientasi Objek (OOP) tingkat lanjut seperti kelas abstrak, *interface*, tipe data terenumerasi (*enum*), serta penggunaan *trait* pada PHP. Melalui penerapan *Interface Segregation Principle*, kelas-kelas seperti `Mobil` dan `Sepeda` dapat memisahkan kontrak perilaku secara fleksibel—di mana objek yang dapat bergerak belum tentu memerlukan bahan bakar—sehingga struktur hierarki kode menjadi sangat modular dan terhindar dari pemaksaan implementasi yang tidak relevan. Selain itu, pemanfaatan *enum* yang memiliki perilaku mandiri serta penggunaan fitur berbagi kode horizontal seperti *trait* semakin memperkuat skalabilitas, keamanan data, dan keterbacaan sistem secara keseluruhan.