class Bus{
    // Properties / Field
    public String rem;
    public String mesin;
    public String aksi;
    public String merk;

    Bus(String merk) {
        this.merk = merk;
    }

    // Methods + Invarian
    public void jalan() {
        if (mesin == null) { // --> Invarian 1 = jika tidak ada roda tidak jalan
            throw new IllegalArgumentException();
        } else if (aksi == "Kiri") {
            System.out.println("Bus Belok ke kiri\n");
        } else if (aksi == "Kanan") {
            System.out.println("Bus Belok Kanan\n");
        } else {
            System.out.println("Bus Melaju");
        }
        
    }

    public void pengereman() {
        if(rem == null || rem == "blong"){ // --> Invarian 2 = jika rem null atau blong maka tidak sah
            throw new IllegalArgumentException();
        } else {
            System.out.println("Bus Mengerem\n");
        }
    }
}