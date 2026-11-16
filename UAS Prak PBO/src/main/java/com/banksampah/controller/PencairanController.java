package com.banksampah.controller;

import com.banksampah.model.Nasabah;
import com.banksampah.service.PencairanService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pencairan")
public class PencairanController {
    public record PencairanRequest(String nasabahId, long nominal, String metode) {}

    private final PencairanService pencairanService;

    public PencairanController(PencairanService pencairanService) {
        this.pencairanService = pencairanService;
    }

    @PostMapping
    public Nasabah cairkan(@RequestBody PencairanRequest req) {
        return pencairanService.cairkan(req.nasabahId(), req.nominal(), req.metode());
    }
}
