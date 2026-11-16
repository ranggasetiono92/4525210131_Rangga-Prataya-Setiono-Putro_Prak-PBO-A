package com.banksampah.config;

import com.banksampah.model.JenisSampah;
import com.banksampah.model.Nasabah;
import com.banksampah.model.Petugas;
import com.banksampah.repository.NasabahRepository;
import com.banksampah.repository.PetugasRepository;
import com.banksampah.service.SetoranService;
import com.banksampah.service.SetoranService.ItemRequest;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/** Mengisi data dummy buatan sendiri saat aplikasi dijalankan. */
@Component
public class DataSeeder implements CommandLineRunner {
    private final NasabahRepository nasabahRepository;
    private final PetugasRepository petugasRepository;
    private final SetoranService setoranService;

    public DataSeeder(NasabahRepository nasabahRepository,
                      PetugasRepository petugasRepository,
                      SetoranService setoranService) {
        this.nasabahRepository = nasabahRepository;
        this.petugasRepository = petugasRepository;
        this.setoranService = setoranService;
    }

    @Override
    public void run(String... args) {
        petugasRepository.save(new Petugas("PTG-001", "Bu Sari", "PAGI"));
        petugasRepository.save(new Petugas("PTG-002", "Pak Joko", "SORE"));

        nasabahRepository.save(new Nasabah("NSB-001", "Andi Pratama"));
        nasabahRepository.save(new Nasabah("NSB-002", "Budi Santoso"));
        nasabahRepository.save(new Nasabah("NSB-003", "Citra Lestari"));

        setoranService.catat("NSB-001", "PTG-001", List.of(
                new ItemRequest(JenisSampah.PLASTIK, 5),
                new ItemRequest(JenisSampah.KERTAS, 3)));
        setoranService.catat("NSB-002", "PTG-002", List.of(
                new ItemRequest(JenisSampah.LOGAM, 12)));
    }
}
