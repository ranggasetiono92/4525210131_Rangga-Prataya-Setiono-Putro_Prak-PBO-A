package com.banksampah;

import static org.junit.jupiter.api.Assertions.*;

import com.banksampah.exception.DataTidakDitemukanException;
import com.banksampah.model.JenisSampah;
import com.banksampah.model.Nasabah;
import com.banksampah.model.Petugas;
import com.banksampah.model.Setoran;
import com.banksampah.repository.*;
import com.banksampah.service.SetoranService;
import com.banksampah.service.SetoranService.ItemRequest;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetoranServiceTest {
    private NasabahRepository nasabahRepo;
    private SetoranService service;

    @BeforeEach
    void setUp() {
        nasabahRepo = new InMemoryNasabahRepository();
        PetugasRepository petugasRepo = new InMemoryPetugasRepository();
        nasabahRepo.save(new Nasabah("NSB-001", "Andi"));
        petugasRepo.save(new Petugas("PTG-001", "Sari", "PAGI"));
        service = new SetoranService(nasabahRepo, petugasRepo, new InMemorySetoranRepository());
    }

    @Test
    void setoranMenambahSaldoNasabah() {
        service.catat("NSB-001", "PTG-001", List.of(
                new ItemRequest(JenisSampah.PLASTIK, 2),
                new ItemRequest(JenisSampah.LOGAM, 1)));
        assertEquals(14000, nasabahRepo.findById("NSB-001").orElseThrow().getSaldo());
    }

    @Test
    void setoranMenyimpanItemSebagaiKomposisi() {
        Setoran s = service.catat("NSB-001", "PTG-001", List.of(
                new ItemRequest(JenisSampah.KERTAS, 4),
                new ItemRequest(JenisSampah.KACA, 2)));
        assertEquals(2, s.getItems().size());
        assertEquals(6.0, s.getTotalBeratKg());
        assertEquals(8000, s.getTotalNilai());
    }

    @Test
    void nasabahTidakDitemukanMelemparException() {
        DataTidakDitemukanException e = assertThrows(DataTidakDitemukanException.class,
                () -> service.catat("NSB-999", "PTG-001", List.of(new ItemRequest(JenisSampah.KACA, 1))));
        assertEquals("NSB-999", e.getIdDicari());
    }
}
