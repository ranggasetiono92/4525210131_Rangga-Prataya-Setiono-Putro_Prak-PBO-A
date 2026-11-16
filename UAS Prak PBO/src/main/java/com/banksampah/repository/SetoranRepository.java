package com.banksampah.repository;

import com.banksampah.model.Setoran;
import java.util.List;

public interface SetoranRepository {
    Setoran save(Setoran setoran);
    List<Setoran> findAll();
    List<Setoran> findByNasabahId(String nasabahId);
}
