package com.banksampah.pencairan;

import org.springframework.stereotype.Component;

@Component
public class PencairanEWallet implements MetodePencairan {
    private static final long BIAYA_ADMIN = 1000;

    @Override
    public String getNama() { return "ewallet"; }

    @Override
    public long hitungBiaya(long nominal) { return BIAYA_ADMIN; }
}
