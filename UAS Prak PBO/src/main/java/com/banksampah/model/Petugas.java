package com.banksampah.model;

public class Petugas extends Pengguna {
    private final String shift;

    public Petugas(String id, String nama, String shift) {
        super(id, nama);
        this.shift = shift;
    }

    public String getShift() { return shift; }

    @Override
    public String getPeran() { return "PETUGAS"; }
}
