package com.banksampah.model;

import com.banksampah.exception.BeratTidakValidException;

/** Enum berperilaku: menghitung nilai tukar sampah, termasuk bonus untuk setoran besar. */
public enum JenisSampah {
    PLASTIK(3000),
    KERTAS(1500),
    KACA(1000),
    LOGAM(8000),
    ELEKTRONIK(12000);

    public static final double BATAS_BONUS_KG = 10.0;
    public static final double PERSEN_BONUS = 0.05;

    private final long hargaPerKg;

    JenisSampah(long hargaPerKg) {
        this.hargaPerKg = hargaPerKg;
    }

    public long getHargaPerKg() { return hargaPerKg; }

    public boolean berhakBonus(double beratKg) {
        return beratKg >= BATAS_BONUS_KG;
    }

    public long hitungNilai(double beratKg) {
        if (beratKg <= 0) {
            throw new BeratTidakValidException(beratKg);
        }
        double nilai = hargaPerKg * beratKg;
        if (berhakBonus(beratKg)) {
            nilai += nilai * PERSEN_BONUS;
        }
        return Math.round(nilai);
    }
}
