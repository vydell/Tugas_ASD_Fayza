class Tugas {
    String judul;
    int prioritas;
    int sisaHari;

    public Tugas(String judul, int sisaHari, int prioritas) {
        this.judul = judul;
        this.sisaHari = sisaHari;
        this.prioritas = prioritas;
    }

    @Override
    public String toString() {
        return String.format("Judul\t\t: %s\nSisa hari\t: %d\nSkala prioritas\t: %d", judul, sisaHari, prioritas);
    }
}