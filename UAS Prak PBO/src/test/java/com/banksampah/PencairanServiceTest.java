package com.banksampah;

import static org.junit.jupiter.api.Assertions.*;

import com.banksampah.exception.DataTidakDitemukanException;
import com.banksampah.exception.SaldoTidakCukupException;
import com.banksampah.model.Nasabah;
import com.banksampah.pencairan.PencairanEWallet;
import com.banksampah.pencairan.PencairanTunai;
import com.banksampah.repository.InMemoryNasabahRepository;
import com.banksampah.repository.NasabahRepository;
import com.banksampah.service.PencairanService;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PencairanServiceTest {
    private NasabahRepository repo;
    private PencairanService service;

    @BeforeEach
    void setUp() {
        repo = new InMemoryNasabahRepository();
        Nasabah n = new Nasabah("NSB-001", "Andi");
        n.tambahSaldo(50000);
        repo.save(n);
        service = new PencairanService(repo, List.of(new PencairanTunai(), new PencairanEWallet()));
    }

    @Test
    void pencairanTunaiTanpaBiaya() {
        assertEquals(30000, service.cairkan("NSB-001", 20000, "tunai").getSaldo());
    }

    @Test
    void pencairanEWalletDikenakanBiayaAdmin() {
        assertEquals(29000, service.cairkan("NSB-001", 20000, "ewallet").getSaldo());
    }

    @Test
    void saldoTidakCukupMembawaDataSaldo() {
        SaldoTidakCukupException e = assertThrows(SaldoTidakCukupException.class,
                () -> service.cairkan("NSB-001", 60000, "tunai"));
        assertEquals(50000, e.getSaldo());
        assertEquals(60000, e.getDibutuhkan());
    }

    @Test
    void metodeTidakDikenalMelemparException() {
        assertThrows(DataTidakDitemukanException.class,
                () -> service.cairkan("NSB-001", 10000, "kripto"));
    }
}
