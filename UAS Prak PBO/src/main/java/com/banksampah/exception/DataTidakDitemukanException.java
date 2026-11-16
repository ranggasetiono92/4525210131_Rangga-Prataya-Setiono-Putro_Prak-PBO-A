package com.banksampah.exception;

public class DataTidakDitemukanException extends RuntimeException {
    private final String jenisData;
    private final String idDicari;

    public DataTidakDitemukanException(String jenisData, String idDicari) {
        super(jenisData + " dengan id '" + idDicari + "' tidak ditemukan");
        this.jenisData = jenisData;
        this.idDicari = idDicari;
    }

    public String getJenisData() { return jenisData; }
    public String getIdDicari() { return idDicari; }
}
