package com.banksampah.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Komposisi: Setoran membuat dan memiliki ItemSetoran; item tidak hidup tanpa Setoran. */
public class Setoran {
    private final String id;
    private final String nasabahId;
    private final String petugasId;
    private final LocalDateTime tanggal = LocalDateTime.now();
    private final List<ItemSetoran> items = new ArrayList<>();

    public Setoran(String id, String nasabahId, String petugasId) {
        this.id = id;
        this.nasabahId = nasabahId;
        this.petugasId = petugasId;
    }

    public void tambahItem(JenisSampah jenis, double beratKg) {
        items.add(new ItemSetoran(jenis, beratKg));
    }

    public String getId() { return id; }
    public String getNasabahId() { return nasabahId; }
    public String getPetugasId() { return petugasId; }
    public LocalDateTime getTanggal() { return tanggal; }
    public List<ItemSetoran> getItems() { return Collections.unmodifiableList(items); }

    public long getTotalNilai() {
        return items.stream().mapToLong(ItemSetoran::getNilai).sum();
    }

    public double getTotalBeratKg() {
        return items.stream().mapToDouble(ItemSetoran::getBeratKg).sum();
    }
}
