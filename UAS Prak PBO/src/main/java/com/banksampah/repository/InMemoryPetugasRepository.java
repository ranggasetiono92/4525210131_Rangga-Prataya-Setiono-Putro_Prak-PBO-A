package com.banksampah.repository;

import com.banksampah.model.Petugas;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryPetugasRepository implements PetugasRepository {
    private final Map<String, Petugas> data = new ConcurrentHashMap<>();

    @Override
    public Petugas save(Petugas petugas) {
        data.put(petugas.getId(), petugas);
        return petugas;
    }

    @Override
    public Optional<Petugas> findById(String id) {
        return Optional.ofNullable(data.get(id));
    }
}
