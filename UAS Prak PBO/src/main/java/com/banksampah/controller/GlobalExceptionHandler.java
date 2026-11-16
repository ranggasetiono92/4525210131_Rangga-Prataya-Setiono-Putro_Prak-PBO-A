package com.banksampah.controller;

import com.banksampah.exception.BeratTidakValidException;
import com.banksampah.exception.DataTidakDitemukanException;
import com.banksampah.exception.SaldoTidakCukupException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataTidakDitemukanException.class)
    public ResponseEntity<Map<String, Object>> tidakDitemukan(DataTidakDitemukanException e) {
        return respon(HttpStatus.NOT_FOUND, e.getMessage(),
                Map.of("jenisData", e.getJenisData(), "idDicari", e.getIdDicari()));
    }

    @ExceptionHandler(SaldoTidakCukupException.class)
    public ResponseEntity<Map<String, Object>> saldoKurang(SaldoTidakCukupException e) {
        return respon(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage(),
                Map.of("saldo", e.getSaldo(), "dibutuhkan", e.getDibutuhkan()));
    }

    @ExceptionHandler(BeratTidakValidException.class)
    public ResponseEntity<Map<String, Object>> beratSalah(BeratTidakValidException e) {
        return respon(HttpStatus.BAD_REQUEST, e.getMessage(), Map.of("berat", e.getBerat()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> inputSalah(IllegalArgumentException e) {
        return respon(HttpStatus.BAD_REQUEST, e.getMessage(), Map.of());
    }

    private ResponseEntity<Map<String, Object>> respon(HttpStatus status, String pesan, Map<String, Object> detail) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status", status.value());
        body.put("pesan", pesan);
        body.put("detail", detail);
        return ResponseEntity.status(status).body(body);
    }
}
