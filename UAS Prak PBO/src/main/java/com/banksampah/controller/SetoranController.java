package com.banksampah.controller;

import com.banksampah.model.JenisSampah;
import com.banksampah.model.Setoran;
import com.banksampah.service.SetoranService;
import com.banksampah.service.SetoranService.ItemRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SetoranController {
    public record SetoranRequest(String nasabahId, String petugasId, List<ItemRequest> items) {}

    private final SetoranService setoranService;

    public SetoranController(SetoranService setoranService) {
        this.setoranService = setoranService;
    }

    @PostMapping("/setoran")
    @ResponseStatus(HttpStatus.CREATED)
    public Setoran catat(@RequestBody SetoranRequest req) {
        return setoranService.catat(req.nasabahId(), req.petugasId(), req.items());
    }

    @GetMapping("/setoran")
    public List<Setoran> riwayat(@RequestParam(required = false) String nasabahId) {
        return setoranService.riwayat(nasabahId);
    }

    @GetMapping("/jenis-sampah")
    public List<Map<String, Object>> jenisSampah() {
        return Arrays.stream(JenisSampah.values())
                .map(j -> Map.<String, Object>of("jenis", j.name(), "hargaPerKg", j.getHargaPerKg()))
                .toList();
    }
}
