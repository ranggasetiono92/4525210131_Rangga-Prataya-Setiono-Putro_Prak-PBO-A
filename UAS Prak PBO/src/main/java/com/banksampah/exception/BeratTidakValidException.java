package com.banksampah.exception;

public class BeratTidakValidException extends RuntimeException {
    private final double berat;

    public BeratTidakValidException(double berat) {
        super("Berat sampah harus lebih dari 0 kg, diterima: " + berat);
        this.berat = berat;
    }

    public double getBerat() { return berat; }
}
