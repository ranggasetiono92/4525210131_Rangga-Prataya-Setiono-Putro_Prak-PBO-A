# LAPORAN PRAKTIKUM PEMROGRAMAN BERBASIS OBJEK

| Informasi Praktikan | Keterangan |
| :--- | :--- |
| **Nama** | Rangga Prataya Setiono Putro |
| **NPM** | 4525210131 |
| **Kelas** | A |
| **Mata Kuliah** | Pemrograman Berbasis Objek (PBO) |
| **Pertemuan** | [Pertemuan 9] |
| **Tanggal** | [31 Oktober 2026] |

---

## 1. Implementasi Java
**Penjelasan Kode:**
> Pada pertemuan ini proyek perpustakaan dari pertemuan 7 dikembangkan menjadi proyek Java yang terstruktur dan dikelola menggunakan **Maven**. Perbedaan paling mendasar terlihat pada struktur kodenya: pada kondisi *before*, kelas-kelas berada pada *package* sederhana (`model` dan `service`), `Main.java` berada di *default package*, dan proses kompilasi dilakukan manual melalui `javac`. Pada kondisi *after*, seluruh kelas dipindahkan ke *package* bernama lengkap `id.ac.univpancasila.perpustakaan` (dengan subpaket `model`, `service`, dan `util`), dan dependensi eksternal dikelola melalui `pom.xml` sehingga library dapat diunduh dan dipakai secara otomatis. Dependensi yang digunakan adalah **Datafaker** (`net.datafaker.Faker`) untuk membangkitkan nama mahasiswa secara acak pada `Main.java`. Selain itu ditambahkan kelas baru `Anggota` yang **mewarisi** (`extends`) kelas `Jurusan`, berisi data keanggotaan perpustakaan berupa kode anggota, tanggal mulai menjadi anggota (`LocalDateTime`), serta method `checkMasaKeanggotaan()` yang menyatakan keanggotaan tidak valid bila telah lebih dari 3 tahun. Relasi **komposisi** (`Buku` dan `Bab`) dan **agregasi** (`Jurusan` dan `Mahasiswa`) dari pertemuan sebelumnya tetap dipertahankan tanpa perubahan logika.

**Ringkasan Perbedaan Before dan After (Java):**

| Aspek | Before | After |
| :--- | :--- | :--- |
| Struktur package | `model`, `service`, `Main` di *default package* | `id.ac.univpancasila.perpustakaan.model`, `.service`, `.util` |
| Build | Kompilasi manual dengan `javac` | Maven (`pom.xml`) |
| Dependensi eksternal | Tidak ada | Datafaker (`net.datafaker.Faker`) |
| Kelas baru | - | `Anggota` (turunan `Jurusan`), `Format` (kerangka kosong di `util`) |
| `PerpustakaanService` | `pinjam()` dan `kembalikan()` mencetak pesan | Isi method dikosongkan (hanya kerangka TODO), atribut `buku` diganti nama menjadi `bukuList` |
| `Main` | Demo komposisi, agregasi, perpustakaan (2 buku) | Ditambah Datafaker, bagian keanggotaan, dan hanya 1 buku pada perpustakaan |

### 1.1. File: `Buku.java`
> **Perbedaan:** Logika kelas tidak berubah (komposisi tetap dijaga lewat constructor `Bab` yang privat dan `List.copyOf()` pada `getBab()`). Perubahan hanya pada deklarasi *package*, dari `model` menjadi `id.ac.univpancasila.perpustakaan.model`.

**Bukti Eksekusi (Screenshot):**
* **Before** *(Kondisi awal / Kesalahan kompilasi)*:
![alt text](image-24.png)
![alt text](image-25.png)
![alt text](image-26.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![alt text](image.png)
![alt text](image-1.png)
![alt text](image-2.png)

### 1.2. File: `Jurusan.java`
> **Perbedaan:** Sama seperti `Buku.java`, relasi agregasi dengan `Mahasiswa` tidak berubah dan hanya *package*-nya yang disesuaikan. Namun pada kondisi *after*, kelas ini menjadi kelas induk bagi `Anggota`, sehingga method `daftarkan()`, `keluarkan()`, dan `getNama()` ikut diwariskan.

**Bukti Eksekusi (Screenshot):**
* **Before** *(Kondisi awal / Kesalahan kompilasi)*:
![alt text](image-28.png)
![alt text](image-29.png)


* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![alt text](image-3.png)
![alt text](image-4.png)
![alt text](image-5.png)
![alt text](image-6.png)

### 1.3. File: `Anggota.java` *(file baru)*
> **Perbedaan:** Kelas ini tidak ada pada kondisi *before*. `Anggota` mewarisi `Jurusan` dan menambahkan atribut `kodeAnggota`, `anggotaSejak`, dan `anggotaPerpus`. Method `daftarkan(Mahasiswa, LocalDateTime)` merupakan *overload* dari `daftarkan(Mahasiswa)` milik `Jurusan`, sedangkan `checkMasaKeanggotaan()` membandingkan waktu sekarang dengan `anggotaSejak.plusYears(3)`. Method `getKeanggotaan()` mencetak nama anggota, jurusan, kode anggota, dan tanggal mulai keanggotaan dengan format `dd-MM-yyyy`.

**Bukti Eksekusi (Screenshot):**
* **Before** *(Kondisi awal)*: Tidak ada (file baru)
* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![alt text](image-7.png)
![alt text](image-8.png)

### 1.4. File: `PerpustakaanService.java`
> **Perbedaan:** Relasi antara `PerpustakaanService` dan `Buku` tetap berupa **agregasi**, karena objek `Buku` diterima dari luar melalui `tambahKoleksi(Buku buku)` dan disimpan dalam `ArrayList`. Pada kondisi *before*, `pinjam()` dan `kembalikan()` mencetak pesan transaksi ke layar. Pada kondisi *after*, isi kedua method tersebut dikosongkan dan hanya menyisakan kerangka beserta komentar TODO untuk disempurnakan pada pertemuan berikutnya. Atribut penyimpan koleksi juga diganti namanya dari `buku` menjadi `bukuList` agar lebih jelas dibedakan dari parameter `buku`.

**Bukti Eksekusi (Screenshot):**
* **Before** *(Kondisi awal / Kesalahan kompilasi)*:
![alt text](image-X.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![alt text](image-9.png)
![alt text](image-10.png)

### 1.5. File: `Format.java` *(file baru)*
> **Perbedaan:** Kelas utilitas di *package* `util` yang baru ditambahkan sebagai kerangka dan belum berisi implementasi.

**Bukti Eksekusi (Screenshot):**
* **Before** *(Kondisi awal)*: Tidak ada (file baru)
* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![alt text](image-11.png)

### 1.6. File: `pom.xml` *(file baru)*
> **Perbedaan:** Berkas konfigurasi Maven yang menggantikan kompilasi manual. Berkas ini mendeklarasikan dependensi Datafaker sehingga dapat diunduh otomatis dan digunakan pada `Main.java`.

**Bukti Eksekusi (Screenshot):**
* **Before** *(Kondisi awal)*: Tidak ada (file baru)
* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![alt text](image-12.png)
![alt text](image-13.png)

### 1.7. File: `Main.java`
> **Perbedaan:** Pada kondisi *after*, `Main` berada di dalam *package* `id.ac.univpancasila.perpustakaan` dan mengimpor seluruh kelas dari `model.*` dan `service.*`. Perubahan isinya: (1) `Faker` dari Datafaker dipakai untuk membuat mahasiswa ketiga (`mhs2`) dengan nama acak, (2) perpustakaan hanya diisi satu buku, dan (3) ditambahkan bagian **Keanggotaan Perpustakaan Teknik** yang membuat objek `Anggota`, mendaftarkan `mhs2` beserta waktu sekarang, menampilkan data keanggotaan, lalu mencetak status masa keanggotaan.

**Bukti Eksekusi (Screenshot):**
* **Before** *(Kondisi awal / Kesalahan kompilasi)*:
![alt text](image-30.png)
![alt text](image-31.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![alt text](image-14.png)
![alt text](image-15.png)
![alt text](image-16.png)

### Output
**Output Program:**
![alt text](image-17.png)
---

## 2. Implementasi PHP
**Penjelasan Kode:**
> Pada sisi PHP, pertemuan ini memperkenalkan **Composer** sebagai pengelola dependensi sekaligus *autoloader* berstandar **PSR-4**. Pada kondisi *before*, seluruh kelas (`Bab`, `Buku`, `Mahasiswa`, `Jurusan`) ditulis dalam satu berkas `relasi.php` dan dimuat oleh `main.php` melalui `require_once`. Pada kondisi *after*, kelas-kelas tersebut dipecah menjadi berkas-berkas terpisah di dalam folder `src/` dengan *namespace* `Perpustakaan\Model` dan `Perpustakaan\Service`, sesuai pemetaan `"Perpustakaan\\": "src/"` pada `composer.json`. Seluruh `require_once` digantikan oleh satu baris `require __DIR__ . '/vendor/autoload.php'`. Dependensi eksternal yang dipakai adalah **Carbon** (`nesbot/carbon`) untuk pengelolaan tanggal pada kelas baru `Anggota`, dan versi paketnya dikunci pada `composer.lock`. Seperti pada Java, kelas `Anggota` mewarisi `Jurusan` dan menyediakan pengecekan masa keanggotaan selama 3 tahun. Karena PHP tidak mendukung *method overloading*, method pendaftaran anggota diberi nama berbeda yaitu `daftarkanAnggota()`.

**Ringkasan Perbedaan Before dan After (PHP):**

| Aspek | Before | After |
| :--- | :--- | :--- |
| Struktur berkas | Satu berkas `relasi.php` berisi semua kelas | Dipecah di `src/Model` dan `src/Service` |
| Pemuatan kelas | `require_once` manual | Autoload Composer (`vendor/autoload.php`) |
| Namespace | Tidak ada | `Perpustakaan\Model`, `Perpustakaan\Service` |
| Dependensi eksternal | Tidak ada | Carbon (`nesbot/carbon` ^3.15) |
| Penamaan getter `Bab` | `getnomor()`, `getjudul()` | `getNomor()`, `getJudul()` |
| Kelas baru | - | `Anggota`, `PerpustakaanService`, `Format` (kosong) |
| `Main` | Demo komposisi dan agregasi | Ditambah bagian perpustakaan dan keanggotaan |

### 2.1. File: `relasi.php` → dipecah menjadi `Buku.php`, `Mahasiswa.php`, `Jurusan.php`
> **Perbedaan:** Berkas `relasi.php` tidak lagi digunakan pada kondisi *after*. Isinya dipindahkan ke `src/Model/Buku.php` (berisi `Bab` dan `Buku`), `src/Model/Mahasiswa.php`, dan `src/Model/Jurusan.php`, masing-masing dengan deklarasi `namespace Perpustakaan\Model;`. Logika komposisi (`Bab` hanya dibuat di dalam `Buku::tambahBab()`) dan agregasi (`Jurusan::daftarkan()` menerima objek `Mahasiswa` dari luar) tidak berubah. Perubahan lainnya adalah penamaan getter menjadi *camelCase*, penambahan `getNama()` dan `getKode()` pada `Jurusan`, serta penghapusan `declare(strict_types=1)`.

**Bukti Eksekusi (Screenshot):**
* **Before** *(Kondisi awal / Galat logika)*:
![alt text](image-32.png)
![alt text](image-33.png)
![alt text](image-34.png)
![alt text](image-35.png)
![alt text](image-36.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*: Tidak ada (file baru)

### 2.2. File: `Anggota.php` *(file baru)*
> **Perbedaan:** Kelas ini tidak ada pada kondisi *before*. `Anggota` mewarisi `Jurusan` dan memakai **Carbon** untuk menyimpan tanggal mulai keanggotaan (`anggotaSejak`), menghitung batas 3 tahun melalui `copy()->addYears(3)`, dan memformat tanggal dengan `format('d-m-Y')`. Method `checkMasaKeanggotaan()` menerima tanggal sekarang sebagai parameter.

**Bukti Eksekusi (Screenshot):**
* **Before** *(Kondisi awal)*: Tidak ada (file baru)
* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![alt text](image-18.png)

### 2.3. File: `PerpustakaanService.php` dan `Format.php` *(file baru)*
> **Perbedaan:** `PerpustakaanService` pada PHP menyimpan koleksi `Buku` yang diterima dari luar (agregasi), menyediakan `tambahKoleksi()` dan `cariKoleksi()`, serta `pinjam()` dan `kembalikan()` yang mencetak pesan transaksi. `Format.php` baru berupa berkas kosong sebagai kerangka di folder `Util`.

**Bukti Eksekusi (Screenshot):**
* **Before** *(Kondisi awal)*: Tidak ada (file baru)
* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![alt text](image-19.png)

### 2.4. File: `composer.json` dan `composer.lock` *(file baru)*
> **Perbedaan:** `composer.json` memetakan *namespace* `Perpustakaan\` ke folder `src/` (autoload PSR-4) dan mendeklarasikan dependensi `nesbot/carbon` versi `^3.15`. `composer.lock` mengunci versi paket yang terpasang agar hasil instalasi konsisten di perangkat lain.

**Bukti Eksekusi (Screenshot):**
* **Before** *(Kondisi awal)*: Tidak ada (file baru)
* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![alt text](image-20.png)

### 2.5. File: `main.php`
> **Perbedaan:** Pada kondisi *after*, `require_once __DIR__ . '/relasi.php'` diganti dengan `require __DIR__ . '/vendor/autoload.php'`, dan setiap kelas dipanggil melalui pernyataan `use` sesuai *namespace*-nya. Isi program ditambah dua bagian baru: **Perpustakaan Teknik** (menambah koleksi, mencari buku, meminjam, dan mengembalikan) serta **Keanggotaan Perpustakaan Teknik** (membuat `Anggota` dengan tanggal dari `Carbon::now()`, menampilkan data keanggotaan, dan mencetak status masa keanggotaan).

**Bukti Eksekusi (Screenshot):**
* **Before** *(Kondisi awal / Galat logika)*:
![alt text](image-37.png)

* **After** *(Kondisi akhir / Eksekusi berhasil)*:
![alt text](image-21.png)
![alt text](image-22.png)

### Output
**Output Program:**
![alt text](image-23.png)
---

## 3. Kesimpulan
> Kesimpulan dari pertemuan ini adalah bahwa pengelolaan dependensi dan struktur proyek yang rapi membuat kode berorientasi objek lebih mudah dikembangkan, baik pada Java maupun PHP. Pada Java, penggunaan **Maven** dan *package* bernama lengkap menggantikan kompilasi manual dan memungkinkan library eksternal seperti **Datafaker** dipakai hanya dengan mendeklarasikannya pada `pom.xml`. Pada PHP, **Composer** dengan *autoload* **PSR-4** menghapus kebutuhan `require_once` satu per satu dan memungkinkan library **Carbon** dipakai dengan versi yang terkunci pada `composer.lock`. Relasi komposisi pada `Buku` dan `Bab` serta agregasi pada `Jurusan` dan `Mahasiswa` tetap konsisten sebelum dan sesudah perubahan, sedangkan penambahan kelas `Anggota` yang mewarisi `Jurusan` memperlihatkan penerapan pewarisan dalam menambah fitur keanggotaan berbatas waktu 3 tahun. Perbedaan kedua bahasa juga tampak jelas: Java dapat melakukan *overload* method `daftarkan()`, sedangkan PHP harus memakai nama berbeda (`daftarkanAnggota()`), dan Java menyediakan `LocalDateTime` bawaan sementara PHP memanfaatkan Carbon dari luar.