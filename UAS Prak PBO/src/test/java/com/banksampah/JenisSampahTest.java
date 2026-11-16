package com.banksampah;

import static org.junit.jupiter.api.Assertions.*;

import com.banksampah.exception.BeratTidakValidException;
import com.banksampah.model.JenisSampah;
import org.junit.jupiter.api.Test;

class JenisSampahTest {

    @Test
    void hitungNilaiTanpaBonus() {
        assertEquals(6000, JenisSampah.PLASTIK.hitungNilai(2));
    }

    @Test
    void hitungNilaiDenganBonusDiAtasBatas() {
        assertEquals(31500, JenisSampah.PLASTIK.hitungNilai(10));
    }

    @Test
    void beratNolMelemparException() {
        BeratTidakValidException e = assertThrows(BeratTidakValidException.class,
                () -> JenisSampah.KACA.hitungNilai(0));
        assertEquals(0.0, e.getBerat());
    }
}
