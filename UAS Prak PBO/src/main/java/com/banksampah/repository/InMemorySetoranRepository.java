package com.banksampah.repository;

import com.banksampah.model.Setoran;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Repository;

@Repository
public class InMemorySetoranRepository implements SetoranRepository {
    private final List<Setoran> data = new CopyOnWriteArrayList<>();

    @Override
    public Setoran save(Setoran setoran) {
        data.add(setoran);
        return setoran;
    }

    @Override
    public List<Setoran> findAll() {
        return List.copyOf(data);
    }

    @Override
    public List<Setoran> findByNasabahId(String nasabahId) {
        return data.stream().filter(s -> s.getNasabahId().equals(nasabahId)).toList();
    }
}
