package com.banksampah.model;

import com.banksampah.exception.SaldoTidakCukupException;

public class Nasabah extends Pengguna {
    private long saldo;

    public Nasabah(String id, String nama) {
        super(id, nama);
    }

    public long getSaldo() { return saldo; }

    public void tambahSaldo(long jumlah) {
        this.saldo += jumlah;
    }

    public void kurangiSaldo(long jumlah) {
        if (jumlah > saldo) {
            throw new SaldoTidakCukupException(saldo, jumlah);
        }
        this.saldo -= jumlah;
    }

    @Override
    public String getPeran() { return "NASABAH"; }
}
