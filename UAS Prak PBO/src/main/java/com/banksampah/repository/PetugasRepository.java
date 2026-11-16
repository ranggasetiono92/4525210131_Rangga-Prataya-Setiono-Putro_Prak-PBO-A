package com.banksampah.repository;

import com.banksampah.model.Petugas;
import java.util.Optional;

public interface PetugasRepository {
    Petugas save(Petugas petugas);
    Optional<Petugas> findById(String id);
}
