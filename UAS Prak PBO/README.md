# Bank Sampah API

Tugas Besar Praktikum PBO A - REST API backend murni (Spring Boot, tanpa UI).
Nasabah menyetor sampah, saldo bertambah sesuai jenis dan berat, lalu saldo dapat dicairkan.

## Kebutuhan
- Java 25+
- Maven 3.9+

## Menjalankan
```bash
mvn test            # 10 unit test
mvn spring-boot:run # server di http://localhost:8080
```
Data dummy (3 nasabah, 2 petugas, 2 setoran) dibuat otomatis saat aplikasi mulai. Data disimpan in-memory.

## Endpoint
| Method | URL | Keterangan |
|---|---|---|
| GET | /api/jenis-sampah | Daftar jenis dan harga per kg |
| GET | /api/nasabah | Semua nasabah |
| GET | /api/nasabah/{id} | Detail nasabah |
| POST | /api/nasabah | Daftar nasabah `{"nama":"..."}` |
| POST | /api/setoran | Catat setoran |
| GET | /api/setoran?nasabahId=NSB-001 | Riwayat setoran |
| POST | /api/pencairan | Cairkan saldo (metode: `tunai` / `ewallet`) |

### Contoh
```bash
curl -X POST localhost:8080/api/setoran -H "Content-Type: application/json" \
 -d '{"nasabahId":"NSB-003","petugasId":"PTG-001","items":[{"jenis":"PLASTIK","beratKg":2.5},{"jenis":"KACA","beratKg":4}]}'

curl -X POST localhost:8080/api/pencairan -H "Content-Type: application/json" \
 -d '{"nasabahId":"NSB-001","nominal":10000,"metode":"ewallet"}'
```
Bonus 5% untuk satu item dengan berat >= 10 kg. E-wallet dikenai biaya admin Rp1.000.

## Pemenuhan syarat
| Syarat | Implementasi |
|---|---|
| >= 8 class | Model, Service, Repository, Controller, dll. |
| Inheritance | `Pengguna` -> `Nasabah`, `Petugas` |
| Composition | `Setoran` memiliki `ItemSetoran` |
| Interface | `MetodePencairan` oleh `PencairanTunai` dan `PencairanEWallet` |
| Enum berperilaku | `JenisSampah.hitungNilai()` |
| Custom exception | `DataTidakDitemukanException`, `SaldoTidakCukupException`, `BeratTidakValidException` |
| Repository + constructor DI | Interface `*Repository` + implementasi `InMemory*` |
| Unit test | 10 test di `src/test` |
| Diagram | `docs/class-diagram.puml`, `docs/sequence-setoran.puml` |

## Pembagian tugas
- Anggota 1: ...
- Anggota 2: ...
