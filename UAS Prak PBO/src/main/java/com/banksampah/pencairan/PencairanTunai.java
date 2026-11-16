package com.banksampah.pencairan;

import org.springframework.stereotype.Component;

@Component
public class PencairanTunai implements MetodePencairan {
    @Override
    public String getNama() { return "tunai"; }

    @Override
    public long hitungBiaya(long nominal) { return 0; }
}
