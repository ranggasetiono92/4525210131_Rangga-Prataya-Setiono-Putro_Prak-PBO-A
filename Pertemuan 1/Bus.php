<?php

class Bus
{
    // Properties / Field
    public $rem;
    public $mesin;
    public $aksi;
    public $merk;

    // Constructor
    public function __construct($merk)
    {
        $this->merk = $merk;
    }

    // Method + Invariant 1
    public function jalan()
    {
        // Invariant 1:
        // Mesin tidak boleh null
        if ($this->mesin === null) {
            throw new InvalidArgumentException(
                "Bus tidak dapat berjalan karena mesin tidak ada."
            );
        } elseif ($this->aksi === "Kiri") {
            echo "Bus Belok ke kiri\n\n";
        } elseif ($this->aksi === "Kanan") {
            echo "Bus Belok ke kanan\n\n";
        } else {
            echo "Bus Melaju\n\n";
        }
    }

    // Method + Invariant 2
    public function pengereman()
    {
        // Invariant 2:
        // Rem tidak boleh null atau blong
        if ($this->rem === null || $this->rem === "blong") {
            throw new InvalidArgumentException(
                "Bus tidak dapat mengerem karena rem bermasalah."
            );
        } else {
            echo "Bus Mengerem\n\n";
        }
    }
}