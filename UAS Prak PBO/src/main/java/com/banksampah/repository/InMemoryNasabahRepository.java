package com.banksampah.repository;

import com.banksampah.model.Nasabah;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryNasabahRepository implements NasabahRepository {
    private final Map<String, Nasabah> data = new ConcurrentHashMap<>();

    @Override
    public Nasabah save(Nasabah nasabah) {
        data.put(nasabah.getId(), nasabah);
        return nasabah;
    }

    @Override
    public Optional<Nasabah> findById(String id) {
        return Optional.ofNullable(data.get(id));
    }

    @Override
    public List<Nasabah> findAll() {
        return data.values().stream().sorted(Comparator.comparing(Nasabah::getId)).toList();
    }
}
