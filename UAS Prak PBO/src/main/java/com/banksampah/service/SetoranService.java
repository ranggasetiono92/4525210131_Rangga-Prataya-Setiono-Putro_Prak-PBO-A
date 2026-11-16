package com.banksampah.service;

import com.banksampah.exception.DataTidakDitemukanException;
import com.banksampah.model.JenisSampah;
import com.banksampah.model.Nasabah;
import com.banksampah.model.Setoran;
import com.banksampah.repository.NasabahRepository;
import com.banksampah.repository.PetugasRepository;
import com.banksampah.repository.SetoranRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SetoranService {
    public record ItemRequest(JenisSampah jenis, double beratKg) {}

    private final NasabahRepository nasabahRepository;
    private final PetugasRepository petugasRepository;
    private final SetoranRepository setoranRepository;

    public SetoranService(NasabahRepository nasabahRepository,
                          PetugasRepository petugasRepository,
                          SetoranRepository setoranRepository) {
        this.nasabahRepository = nasabahRepository;
        this.petugasRepository = petugasRepository;
        this.setoranRepository = setoranRepository;
    }

    public Setoran catat(String nasabahId, String petugasId, List<ItemRequest> items) {
        Nasabah nasabah = nasabahRepository.findById(nasabahId)
                .orElseThrow(() -> new DataTidakDitemukanException("Nasabah", nasabahId));
        petugasRepository.findById(petugasId)
                .orElseThrow(() -> new DataTidakDitemukanException("Petugas", petugasId));

        String id = String.format("STR-%03d", setoranRepository.findAll().size() + 1);
        Setoran setoran = new Setoran(id, nasabahId, petugasId);
        for (ItemRequest item : items) {
            setoran.tambahItem(item.jenis(), item.beratKg());
        }

        nasabah.tambahSaldo(setoran.getTotalNilai());
        nasabahRepository.save(nasabah);
        return setoranRepository.save(setoran);
    }

    public List<Setoran> riwayat(String nasabahId) {
        return nasabahId == null ? setoranRepository.findAll()
                                 : setoranRepository.findByNasabahId(nasabahId);
    }
}
