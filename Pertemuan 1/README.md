# Tugas 1 — Class `Bus` (Java & PHP)
**Nama   :** [Nama Anda]
**NPM    :** [NPM Anda]

## Domain
**Bus** — merepresentasikan sebuah Bus dengan atribut yang ada di dalam Bus tersebut seperti (rem, mesin, merk) serta atribut aktivitas (aksi/gerak Bus).

## Struktur Class

| Field    | Tipe     | Keterangan                                              |
|----------|----------|----------------------------------------------------------|
| `merk`   | `String` | Wajib diisi lewat constructor                             |
| `mesin`  | `String` | Kondisi mesin bus, wajib ada agar bus bisa berjalan       |
| `rem`    | `String` | Kondisi rem bus, tidak boleh kosong atau "blong"          |
| `aksi`   | `String` | Arah gerak bus saat ini (mis. "Kiri", "Kanan")            |

**Method:**
- `jalan()` — menampilkan aktivitas jalannya bus tersebut (lurus/belok kiri/belok kanan)
- `pengereman()` — menampilkan aktivitas hasil dari pengereman bus tersebut

## Invarian & Alasan

1. **`mesin` tidak boleh `null` saat `jalan()` dipanggil.**
   Alasan: method `jalan()` merepresentasikan aktivitas bus melaju atau berbelok. Tanpa mesin, bus tidak mungkin bisa bergerak. Pelanggaran akan melempar `IllegalArgumentException` (Java) / `InvalidArgumentException` (PHP).

2. **`rem` tidak boleh `null` atau bernilai `"blong"` saat `pengereman()` dipanggil.**
   Alasan: method `pengereman()` merepresentasikan aktivitas bus mengerem. Jika rem tidak ada atau dalam kondisi blong, pengereman tidak bisa dilakukan secara aman. Pelanggaran akan melempar `IllegalArgumentException` (Java) / `InvalidArgumentException` (PHP).

### Struktur Berkas
```Struktur Folder
PBO/ **(Root Folder)**
├── Tugas1/
    ├── img/
    ├── src/
    |    ├── Bus.java   # Definisi class (Java)
    |    ├── Main.java  # Program utama (Java)
    |    ├── Bus.php    # Definisi class (PHP)
    |    ├── index.php  # Program utama (PHP)
    └── README.md
```

## Cara Menjalankan

### Java
```Powershell
javac Bus.java Main.java
java Main
```

### PHP
```Powershell
php index.php
```

## Deklarasi Penggunaan AI
Asisten AI (Claude, Anthropic) digunakan untuk membantu menyusun struktur
dan format dokumen README.md ini, berdasarkan ketentuan tugas dan kode
program yang telah dibuat sebelumnya. AI tidak digunakan untuk menulis
kode Java/PHP pada tugas ini.