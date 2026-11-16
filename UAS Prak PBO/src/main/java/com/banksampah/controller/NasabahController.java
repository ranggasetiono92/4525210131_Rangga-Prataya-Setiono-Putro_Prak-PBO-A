package com.banksampah.controller;

import com.banksampah.model.Nasabah;
import com.banksampah.service.NasabahService;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nasabah")
public class NasabahController {
    private final NasabahService nasabahService;

    public NasabahController(NasabahService nasabahService) {
        this.nasabahService = nasabahService;
    }

    @GetMapping
    public List<Nasabah> semua() { return nasabahService.semua(); }

    @GetMapping("/{id}")
    public Nasabah detail(@PathVariable String id) { return nasabahService.cariById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Nasabah daftar(@RequestBody Map<String, String> body) {
        return nasabahService.daftar(body.get("nama"));
    }
}
