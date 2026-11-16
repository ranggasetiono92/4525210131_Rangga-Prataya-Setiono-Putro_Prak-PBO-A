package com.banksampah.service;

import com.banksampah.exception.DataTidakDitemukanException;
import com.banksampah.model.Nasabah;
import com.banksampah.pencairan.MetodePencairan;
import com.banksampah.repository.NasabahRepository;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class PencairanService {
    private final NasabahRepository nasabahRepository;
    private final Map<String, MetodePencairan> metodeTersedia;

    public PencairanService(NasabahRepository nasabahRepository, List<MetodePencairan> metode) {
        this.nasabahRepository = nasabahRepository;
        this.metodeTersedia = metode.stream()
                .collect(Collectors.toMap(m -> m.getNama().toLowerCase(), Function.identity()));
    }

    public Nasabah cairkan(String nasabahId, long nominal, String namaMetode) {
        if (nominal <= 0) {
            throw new IllegalArgumentException("Nominal pencairan harus lebih dari 0");
        }
        Nasabah nasabah = nasabahRepository.findById(nasabahId)
                .orElseThrow(() -> new DataTidakDitemukanException("Nasabah", nasabahId));
        MetodePencairan metode = metodeTersedia.get(namaMetode.toLowerCase());
        if (metode == null) {
            throw new DataTidakDitemukanException("Metode pencairan", namaMetode);
        }
        nasabah.kurangiSaldo(nominal + metode.hitungBiaya(nominal));
        return nasabahRepository.save(nasabah);
    }
}
