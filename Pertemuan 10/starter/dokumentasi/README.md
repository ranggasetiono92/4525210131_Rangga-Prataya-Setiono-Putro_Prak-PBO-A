# LAPORAN PRAKTIKUM PEMROGRAMAN BERBASIS OBJEK

| Informasi Praktikan | Keterangan |
| :--- | :--- |
| **Nama** | Rangga Prataya Setiono Putro |
| **NPM** | 4525210131 |
| **Kelas** | A |
| **Mata Kuliah** | Pemrograman Berbasis Objek (PBO) |
| **Pertemuan** | [Pertemuan 10] |
| **Tanggal** | [8 November 2026] |

---

## 1. Implementasi Java

**Penjelasan Kode:**
> Pada pertemuan ini, sistem perpustakaan dikembangkan dengan menerapkan
> *exception handling* dan pemrograman defensif. Pada kondisi *before*, file
> `LibraryServiceKotor.java` menggunakan empat tingkat `if` bersarang. Jika
> peminjaman gagal, method hanya mengembalikan `false`, sehingga pemanggil tidak
> mengetahui penyebabnya. Empat exception domain juga masih berupa kerangka
> TODO. Pada kondisi *after*, exception menyimpan data penyebab dan pesan yang
> jelas, method `pinjam()` pada `LibraryService.java` menggunakan *guard clause*,
> serta `App.java` menjalankan demo keberhasilan dan kegagalan peminjaman.
> `LibraryServiceKotor.java` tetap dipertahankan untuk menunjukkan perbandingan
> sebelum dan sesudah refactoring.

**Ringkasan Perbedaan Before dan After (Java):**

| Aspek | Before | After |
| :--- | :--- | :--- |
| Hierarki exception | `PerpustakaanException` sudah menjadi induk `RuntimeException`, turunannya belum lengkap | Empat exception membawa data penyebab melalui atribut dan getter |
| Lokasi package exception | File berada di `java/exception/` meskipun package bernama lengkap | File berada di `java/id/ac/univpancasila/perpustakaan/exception/` |
| `LibraryServiceKotor` | Empat tingkat `if`; kegagalan hanya menghasilkan `false` | Tetap disimpan sebagai bahan pembanding |
| `LibraryService` | Belum ada | Implementasi baru dengan *guard clause* dan exception domain |
| Program utama | Belum ada kelas `main()` | `App.java` menjalankan tujuh skenario demo |

### 1.1. File: `PerpustakaanException.java`

> **Perbedaan:** Pada starter, kelas abstrak ini sudah diturunkan dari
> `RuntimeException` dan menyediakan constructor pesan serta penyebab. TODO-nya
> meminta praktikan memilih exception *checked* atau *unchecked* dan menjelaskan
> alasan pilihan di `skenario-uji.md`. Pada hasil akhir, pilihan
> `RuntimeException` dipertahankan karena kegagalan tersebut merupakan
> pelanggaran aturan domain perpustakaan; alasannya juga ditulis pada dokumen
> skenario uji.

**Cuplikan kode Before (starter Pertemuan 10):**

```java
public abstract class PerpustakaanException extends RuntimeException {
    protected PerpustakaanException(String pesan) {
        super(pesan);
    }

    protected PerpustakaanException(String pesan, Throwable penyebab) {
        super(pesan, penyebab);
    }
}
```

**Cuplikan kode After (hasil Pertemuan 10):**

```java
public abstract class PerpustakaanException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    protected PerpustakaanException(String pesan) {
        super(pesan);
    }

    protected PerpustakaanException(String pesan, Throwable penyebab) {
        super(pesan, penyebab);
    }
}
```

### 1.2. File: `BukuTidakDitemukanException.java`

> **Perbedaan:** Pada kondisi *before*, atribut ISBN, pesan yang menyebut ISBN,
> penyimpanan ISBN, dan getter `getIsbn()` masih berupa TODO. Pada kondisi
> *after*, exception menyimpan ISBN dalam atribut `final`, menyediakan getter,
> serta menampilkan pesan seperti `Buku dengan ISBN 000-0 tidak ditemukan`.

**Cuplikan kode Before (starter Pertemuan 10):**

```java
public class BukuTidakDitemukanException extends PerpustakaanException {
    public BukuTidakDitemukanException(String isbn) {
        super("TODO 2 belum dikerjakan");
    }
}
```

**Cuplikan kode After (hasil Pertemuan 10):**

```java
private final String isbn;

public BukuTidakDitemukanException(String isbn) {
    super("Buku dengan ISBN " + isbn + " tidak ditemukan");
    this.isbn = isbn;
}

public String getIsbn() {
    return isbn;
}
```

### 1.3. File: `AnggotaTidakDitemukanException.java`

> **Perbedaan:** Pada kondisi *before*, class hanya memiliki constructor dengan
> pesan TODO. Pada kondisi *after*, exception menyimpan ID anggota sebagai
> atribut `final`, menyediakan getter `getIdAnggota()`, dan membuat pesan yang
> menyebut ID anggota yang tidak terdaftar.

**Cuplikan kode Before (starter Pertemuan 10):**

```java
public AnggotaTidakDitemukanException(String idAnggota) {
    super("TODO belum dikerjakan");
}
```

**Cuplikan kode After (hasil Pertemuan 10):**

```java
private final String idAnggota;

public AnggotaTidakDitemukanException(String idAnggota) {
    super("Anggota dengan ID " + idAnggota + " tidak ditemukan");
    this.idAnggota = idAnggota;
}

public String getIdAnggota() {
    return idAnggota;
}
```

### 1.4. File: `BukuSedangDipinjamException.java`

> **Perbedaan:** Pada kondisi *before*, constructor menerima ISBN dan judul,
> tetapi belum menggunakannya. Pada kondisi *after*, kedua nilai disimpan
> sebagai atribut `final`, tersedia melalui getter `getIsbn()` dan
> `getJudul()`, serta disertakan dalam pesan exception saat stok buku habis.

**Cuplikan kode Before (starter Pertemuan 10):**

```java
public BukuSedangDipinjamException(String isbn, String judul) {
    super("TODO belum dikerjakan");
}
```

**Cuplikan kode After (hasil Pertemuan 10):**

```java
private final String isbn;
private final String judul;

public BukuSedangDipinjamException(String isbn, String judul) {
    super("Buku \"" + judul + "\" dengan ISBN " + isbn + " sedang dipinjam");
    this.isbn = isbn;
    this.judul = judul;
}
```

### 1.5. File: `BatasPinjamTerlampauiException.java`

> **Perbedaan:** Pada kondisi *before*, constructor menerima ID anggota dan
> batas maksimum tetapi masih menghasilkan pesan TODO. Pada kondisi *after*,
> kedua nilai disimpan sebagai atribut `final`, disediakan getter
> `getIdAnggota()` dan `getBatas()`, serta digunakan dalam pesan yang menjelaskan
> batas peminjaman.

**Cuplikan kode Before (starter Pertemuan 10):**

```java
public BatasPinjamTerlampauiException(String idAnggota, int batas) {
    super("TODO belum dikerjakan");
}
```

**Cuplikan kode After (hasil Pertemuan 10):**

```java
private final String idAnggota;
private final int batas;

public BatasPinjamTerlampauiException(String idAnggota, int batas) {
    super("Anggota " + idAnggota
            + " telah mencapai batas pinjam maksimum (" + batas + " buku)");
    this.idAnggota = idAnggota;
    this.batas = batas;
}
```

### 1.6. File: `LibraryServiceKotor.java` dan `LibraryService.java`

> **Perbedaan:** `LibraryServiceKotor.java` adalah file starter dan tetap
> dipertahankan tanpa mengganti perannya sebagai bahan sebelum refactoring.
> Method `pinjam()` versi awal memeriksa anggota, buku, stok, dan batas pinjaman
> dengan empat tingkat `if`; setiap kegagalan hanya mengembalikan `false`.
> `LibraryService.java` merupakan file baru. Versi ini memeriksa kegagalan
> terlebih dahulu dengan *guard clause* dan melempar exception yang sesuai.
> Stok dan jumlah pinjaman hanya berubah setelah semua pemeriksaan berhasil.

**Cuplikan kode Before (`LibraryServiceKotor.java`):**

```java
if (pinjaman.containsKey(idAnggota)) {
    if (stok.containsKey(isbn)) {
        if (stok.get(isbn) > 0) {
            if (pinjaman.get(idAnggota) < BATAS_PINJAM) {
                stok.merge(isbn, -1, Integer::sum);
                pinjaman.merge(idAnggota, 1, Integer::sum);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    } else {
        return false;
    }
} else {
    return false;
}
```

**Cuplikan kode After (`LibraryService.java`):**

```java
if (!pinjaman.containsKey(idAnggota)) {
    throw new AnggotaTidakDitemukanException(idAnggota);
}
if (!stok.containsKey(isbn)) {
    throw new BukuTidakDitemukanException(isbn);
}
if (stok.get(isbn) <= 0) {
    throw new BukuSedangDipinjamException(isbn, judul.get(isbn));
}
if (pinjaman.get(idAnggota) >= BATAS_PINJAM) {
    throw new BatasPinjamTerlampauiException(idAnggota, BATAS_PINJAM);
}

stok.merge(isbn, -1, Integer::sum);
pinjaman.merge(idAnggota, 1, Integer::sum);
return true;
```

### 1.7. File: `App.java` *(file baru)*

> **Perbedaan:** File ini tidak ada pada starter Pertemuan 10. `App.java`
> menyediakan method `main()` sebagai titik masuk program dan menjalankan tujuh
> skenario: peminjaman berhasil, ISBN tidak ditemukan, anggota tidak ditemukan,
> meminjam eksemplar terakhir, stok habis, peminjaman buku berikutnya, dan batas
> maksimum terlampaui. Satu blok `catch (PerpustakaanException e)` menangani
> kegagalan domain dan menampilkan data spesifik exception melalui getter.

**Cara Menjalankan Program:**

Jalankan perintah berikut dari folder `starter\java` di PowerShell:

```powershell
New-Item -ItemType Directory -Force bin | Out-Null
javac -d bin (Get-ChildItem -Recurse -Filter *.java | ForEach-Object FullName)
if ($?) { java -cp bin App }
```

**Cuplikan kode Before:** Tidak ada; `App.java` merupakan file baru pada hasil
Pertemuan 10.

**Cuplikan kode After (`App.java`):**

```java
private static void jalankanSkenario(String judul, Runnable aksi) {
    System.out.println(judul);
    try {
        aksi.run();
    } catch (PerpustakaanException e) {
        System.out.println("Gagal: " + e.getMessage());
        if (e instanceof BukuTidakDitemukanException) {
            System.out.println("ISBN: "
                    + ((BukuTidakDitemukanException) e).getIsbn());
        } else if (e instanceof AnggotaTidakDitemukanException) {
            System.out.println("ID anggota: "
                    + ((AnggotaTidakDitemukanException) e).getIdAnggota());
        }
    }
}
```

### Output

**Output Program:**

```text
=== DEMO SISTEM PERPUSTAKAAN ===
Anggota terdaftar: A001
Batas pinjam: 3 buku

1. Peminjaman buku berhasil
Berhasil meminjam: Pemrograman Java
Sisa eksemplar: 1

2. ISBN buku tidak terdaftar
Gagal: Buku dengan ISBN 000-0 tidak ditemukan
ISBN: 000-0

3. Anggota tidak terdaftar
Gagal: Anggota dengan ID A999 tidak ditemukan
ID anggota: A999

4. Meminjam eksemplar terakhir
Berhasil meminjam: Pemrograman Java
Sisa eksemplar: 0

5. Buku sudah tidak tersedia
Gagal: Buku "Pemrograman Java" dengan ISBN 978-1 sedang dipinjam
ISBN: 978-1, judul: Pemrograman Java

6. Peminjaman kedua buku lain
Berhasil meminjam: Dasar-Dasar PBO
Total buku yang dipinjam anggota A001: 3

7. Batas maksimum pinjaman terlampaui
Gagal: Anggota A001 telah mencapai batas pinjam maksimum (3 buku)
ID anggota: A001, batas maksimum: 3

=== DEMO SELESAI ===
```

---

## 2. Implementasi PHP

**Penjelasan Kode:**
> Pada PHP, file starter `exceptions.php` berisi empat exception turunan yang
> constructor dan data penyebabnya masih berupa TODO. `LibraryServiceKotor.php`
> memiliki empat tingkat `if` bersarang dan hanya mengembalikan `false` ketika
> peminjaman gagal. Pada kondisi *after*, exception menggunakan *constructor
> property promotion* dengan properti `readonly`, `LibraryService.php`
> menerapkan *guard clause*, dan `App.php` menjalankan skenario demo.

**Ringkasan Perbedaan Before dan After (PHP):**

| Aspek | Before | After |
| :--- | :--- | :--- |
| Exception domain | `exceptions.php` berisi TODO untuk data, pesan, dan getter | Empat exception menyimpan data `readonly` dan menyediakan getter |
| `LibraryServiceKotor.php` | Empat tingkat `if`; kegagalan mengembalikan `false` | Tetap disimpan sebagai bahan pembanding |
| `LibraryService.php` | Belum ada | Implementasi baru dengan *guard clause* dan exception domain |
| Program utama | Belum ada file demo | `App.php` menjalankan tujuh skenario demo |

### 2.1. File: `exceptions.php`

> **Perbedaan:** Pada kondisi *before*, `PerpustakaanException` sudah menjadi
> turunan `RuntimeException`, tetapi empat exception khusus masih berisi TODO.
> Pada kondisi *after*, setiap constructor memakai *property promotion* untuk
> menyimpan data sebagai properti `readonly`. Getter tersedia untuk ISBN, ID
> anggota, judul buku, dan batas maksimum. Pesan exception juga dibuat spesifik
> agar penyebab kegagalan dapat dipahami.

**Cuplikan kode Before (starter `exceptions.php`):**

```php
public function __construct(string $isbn)
{
    parent::__construct('TODO 1 belum dikerjakan');
}

// Getter getIsbn() belum tersedia.
```

**Cuplikan kode After (`exceptions.php`):**

```php
public function __construct(private readonly string $isbn)
{
    parent::__construct("Buku dengan ISBN {$isbn} tidak ditemukan");
}

public function getIsbn(): string
{
    return $this->isbn;
}
```

### 2.2. File: `LibraryServiceKotor.php` dan `LibraryService.php`

> **Perbedaan:** `LibraryServiceKotor.php` adalah bahan refactoring dari starter
> dan dipertahankan. Method `pinjam()` pada file awal menggunakan empat
> pemeriksaan `if` bersarang dan mengembalikan `false` tanpa alasan terperinci.
> `LibraryService.php` merupakan hasil refactoring baru: kondisi gagal
> diperiksa terlebih dahulu, exception domain dilempar, dan stok baru dikurangi
> setelah peminjaman valid.

**Cuplikan kode Before (`LibraryServiceKotor.php`):**

```php
if (array_key_exists($idAnggota, $this->pinjaman)) {
    if (array_key_exists($isbn, $this->stok)) {
        if ($this->stok[$isbn] > 0) {
            if ($this->pinjaman[$idAnggota] < self::BATAS_PINJAM) {
                $this->stok[$isbn]--;
                $this->pinjaman[$idAnggota]++;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    } else {
        return false;
    }
} else {
    return false;
}
```

**Cuplikan kode After (`LibraryService.php`):**

```php
if (!array_key_exists($idAnggota, $this->pinjaman)) {
    throw new AnggotaTidakDitemukanException($idAnggota);
}
if (!array_key_exists($isbn, $this->stok)) {
    throw new BukuTidakDitemukanException($isbn);
}
if ($this->stok[$isbn] <= 0) {
    throw new BukuSedangDipinjamException($isbn, $this->judul[$isbn]);
}
if ($this->pinjaman[$idAnggota] >= self::BATAS_PINJAM) {
    throw new BatasPinjamTerlampauiException($idAnggota, self::BATAS_PINJAM);
}

$this->stok[$isbn]--;
$this->pinjaman[$idAnggota]++;
return true;
```

### 2.3. File: `App.php` *(file baru)*

> **Perbedaan:** File ini tidak ada pada starter PHP Pertemuan 10. `App.php`
> mendaftarkan anggota, menambahkan koleksi buku, lalu menjalankan tujuh
> skenario. Satu blok `catch (PerpustakaanException $exception)` menampilkan
> pesan dan mengambil data khusus melalui getter exception.

**Cara Menjalankan Program:**

Jalankan dari folder `starter` di PowerShell:

```powershell
php .\php\App.php
```

**Cuplikan kode Before:** Tidak ada; `App.php` merupakan file baru pada hasil
Pertemuan 10.

**Cuplikan kode After (`App.php`):**

```php
$jalankanSkenario = static function (string $judul, callable $aksi): void {
    echo $judul . "\n";

    try {
        $aksi();
    } catch (PerpustakaanException $exception) {
        echo 'Gagal: ' . $exception->getMessage() . "\n";
        if ($exception instanceof BukuTidakDitemukanException) {
            echo 'ISBN: ' . $exception->getIsbn() . "\n";
        } elseif ($exception instanceof AnggotaTidakDitemukanException) {
            echo 'ID anggota: ' . $exception->getIdAnggota() . "\n";
        }
    }
};
```

### Output

**Output Program:**

```text
=== DEMO SISTEM PERPUSTAKAAN ===
Anggota terdaftar: A001
Batas pinjam: 3 buku

1. Peminjaman buku berhasil
Berhasil meminjam: Pemrograman PHP
Sisa eksemplar: 1

2. ISBN buku tidak terdaftar
Gagal: Buku dengan ISBN 000-0 tidak ditemukan
ISBN: 000-0

3. Anggota tidak terdaftar
Gagal: Anggota dengan ID A999 tidak ditemukan
ID anggota: A999

4. Meminjam eksemplar terakhir
Berhasil meminjam: Pemrograman PHP
Sisa eksemplar: 0

5. Buku sudah tidak tersedia
Gagal: Buku "Pemrograman PHP" dengan ISBN 978-1 sedang dipinjam
ISBN: 978-1, judul: Pemrograman PHP

6. Peminjaman buku kedua
Berhasil meminjam: Dasar-Dasar PBO
Total buku yang dipinjam anggota A001: 3

7. Batas maksimum pinjaman terlampaui
Gagal: Anggota A001 telah mencapai batas pinjam maksimum (3 buku)
ID anggota: A001, batas maksimum: 3

=== DEMO SELESAI ===
```

---

## 3. File: `skenario-uji.md`

> **Perbedaan:** File starter menyediakan tabel kosong dengan sepuluh baris
> skenario dan tiga pertanyaan refleksi. Pada kondisi *after*, jawaban tentang
> pilihan `RuntimeException` sudah ditambahkan. Tabel sepuluh skenario, jawaban
> tentang kesalahan pengguna dan pemrogram, serta refleksi mengenai `catch`
> kosong belum dilengkapi.

Demo `App.java` pada Java dan PHP telah menjalankan tujuh skenario peminjaman.
Pengujian terpisah juga memeriksa data exception dan memastikan stok tidak
berubah ketika pinjaman gagal. Namun, tabel di
[`skenario-uji.md`](../skenario-uji.md) masih perlu diisi berdasarkan pengujian
yang dilakukan praktikan.

---

## 4. Kesimpulan

> Praktikum Pertemuan 10 memperlihatkan perubahan dari method peminjaman
> bersarang yang hanya mengembalikan `false` menjadi *guard clause* yang
> melempar exception domain dengan alasan dan data yang spesifik. Exception
> yang membawa data memudahkan lapisan pemanggil menangani kegagalan tanpa
> mengurai teks pesan, dan validasi sebelum perubahan stok mencegah data
> peminjaman berubah saat operasi gagal. Perbandingan ini diterapkan pada
> Java dan PHP, sementara file `LibraryServiceKotor` tetap tersedia sebagai
> kondisi *before* untuk demonstrasi.
