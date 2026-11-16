package com.banksampah.repository;

import com.banksampah.model.Nasabah;
import java.util.List;
import java.util.Optional;

public interface NasabahRepository {
    Nasabah save(Nasabah nasabah);
    Optional<Nasabah> findById(String id);
    List<Nasabah> findAll();
}
