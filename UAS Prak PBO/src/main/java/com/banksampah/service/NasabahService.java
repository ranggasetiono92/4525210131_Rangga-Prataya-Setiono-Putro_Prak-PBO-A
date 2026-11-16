package com.banksampah.service;

import com.banksampah.exception.DataTidakDitemukanException;
import com.banksampah.model.Nasabah;
import com.banksampah.repository.NasabahRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class NasabahService {
    private final NasabahRepository nasabahRepository;

    public NasabahService(NasabahRepository nasabahRepository) {
        this.nasabahRepository = nasabahRepository;
    }

    public Nasabah daftar(String nama) {
        String id = String.format("NSB-%03d", nasabahRepository.findAll().size() + 1);
        return nasabahRepository.save(new Nasabah(id, nama));
    }

    public Nasabah cariById(String id) {
        return nasabahRepository.findById(id)
                .orElseThrow(() -> new DataTidakDitemukanException("Nasabah", id));
    }

    public List<Nasabah> semua() {
        return nasabahRepository.findAll();
    }
}
