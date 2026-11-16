package com.banksampah.exception;

public class SaldoTidakCukupException extends RuntimeException {
    private final long saldo;
    private final long dibutuhkan;

    public SaldoTidakCukupException(long saldo, long dibutuhkan) {
        super("Saldo Rp" + saldo + " tidak cukup, dibutuhkan Rp" + dibutuhkan);
        this.saldo = saldo;
        this.dibutuhkan = dibutuhkan;
    }

    public long getSaldo() { return saldo; }
    public long getDibutuhkan() { return dibutuhkan; }
}
