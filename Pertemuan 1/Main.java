public class Main {
    public static void main (String[] args){
        Bus Mercy = new Bus("Mercy");

        // --> Perubahan Sah atau Operasi Sah
        Mercy.mesin = "2000cc";
        Mercy.aksi = "Kiri";
        Mercy.rem = "lancar";

        System.out.println("Merk Bus\t: " + Mercy.merk);
        System.out.println("Mesin Bus\t: " + Mercy.mesin);

        Mercy.jalan();
        Mercy.pengereman();

        // --> Perubahan tidak Sah atau operasi tidak sah pertama
        // Bus Volvo = new Bus("Volvo 115 SDB");

        // Volvp.mesin = "3000cc";
        // Volvo.aksi = "Kanan";
        // Volvo.rem = null;

        // System.out.println("Merk Bus\t: " + Volvo.merk);
        // System.out.println("Mesin Bus\t: " + Volvo.mesin);

        // Volvo.jalan();
        // Volvo.pengereman();

        // --> Perubahan tidak Sah atau operasi tidak sah kedua
        Bus Hino = new Bus("Hino 115 SDB");

        Hino.mesin = null;
        Hino.aksi = "maju";
        Hino.rem = "Lancar";

        System.out.println("Merk Bus\t: " + Hino.merk);
        System.out.println("Mesin Bus\t: " + Hino.mesin);

        Hino.pengereman();
        Hino.jalan();

    }
}