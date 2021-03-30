package core;

public class Prakerja implements Konfirmasi {
    private boolean isConfirm;

    /**
     * Inisialisasi awal Kartu Prakerja
     */
    public Prakerja() {
        this.isConfirm = false;
    }

    /**
     * Aksi yang dilakukan saat tombol ditekan
     */
    public void pressed() {
        if (!this.isConfirm) {
            this.isConfirm = true;
            System.out.println("\nBerhasil Gabung");
        } else
            System.out.println("\nSedang dievaluasi");
    }

    /**
     * Memberitahu apakah telah melakukan gabung ke Kartu Prakerja atau belum
     * 
     * @return boolean
     */
    public boolean isConfirm() {
        return this.isConfirm;
    }
}