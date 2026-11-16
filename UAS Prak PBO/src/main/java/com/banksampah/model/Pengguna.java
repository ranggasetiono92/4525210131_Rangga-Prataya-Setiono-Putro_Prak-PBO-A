package com.banksampah.model;

/** Kelas induk (abstract) untuk semua pengguna sistem. */
public abstract class Pengguna {
    private final String id;
    private final String nama;

    protected Pengguna(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }

    public abstract String getPeran();
}
