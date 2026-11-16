package com.banksampah.model;

public class ItemSetoran {
    private final JenisSampah jenis;
    private final double beratKg;
    private final long nilai;

    public ItemSetoran(JenisSampah jenis, double beratKg) {
        this.jenis = jenis;
        this.beratKg = beratKg;
        this.nilai = jenis.hitungNilai(beratKg);
    }

    public JenisSampah getJenis() { return jenis; }
    public double getBeratKg() { return beratKg; }
    public long getNilai() { return nilai; }
}
