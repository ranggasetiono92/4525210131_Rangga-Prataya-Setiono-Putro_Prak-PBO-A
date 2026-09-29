<?php

require_once "Bus.php";

// ========================================
// Perubahan Sah / Operasi Sah
// ========================================

$Mercy = new Bus("Mercy");

$Mercy->mesin = "2000cc";
$Mercy->aksi = "Kiri";
$Mercy->rem = "lancar";

echo "Merk Bus\t: " . $Mercy->merk . "\n";
echo "Mesin Bus\t: " . $Mercy->mesin . "\n";

$Mercy->jalan();
$Mercy->pengereman();


// ========================================
// Perubahan Tidak Sah / Operasi Tidak Sah 1
// Mesin = null
// ========================================

$Hino = new Bus("Hino 115 SDB");

$Hino->mesin = null;
$Hino->aksi = "maju";
$Hino->rem = "Lancar";

echo "Merk Bus\t: " . $Hino->merk . "\n";
echo "Mesin Bus\t: " . $Hino->mesin . "\n";

try {
    $Hino->jalan();
} catch (InvalidArgumentException $e) {
    echo "Operasi ditolak: " . $e->getMessage() . "\n\n";
}


// ========================================
// Perubahan Tidak Sah / Operasi Tidak Sah 2
// Rem = null
// ========================================

$Volvo = new Bus("Volvo 115 SDB");

$Volvo->mesin = "3000cc";
$Volvo->aksi = "Kanan";
$Volvo->rem = null;

echo "Merk Bus\t: " . $Volvo->merk . "\n";
echo "Mesin Bus\t: " . $Volvo->mesin . "\n";

try {
    $Volvo->pengereman();
} catch (InvalidArgumentException $e) {
    echo "Operasi ditolak: " . $e->getMessage() . "\n\n";
}