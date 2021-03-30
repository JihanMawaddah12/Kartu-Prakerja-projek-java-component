package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class Akun implements Autentikasi {
    private Konfirmasi confirm;
    private String nama, email, password, pekerjaan;
    private boolean isValid;

    /**
     * Inisialisasi email dan password untuk digunakan login
     * 
     * @param email    email pengguna
     * @param password password akun prakerja
     */
    public Akun(String email, String password) {
        this.email = email;
        this.password = password;
        this.isValid = false;
    }

    /**
     * Aksi yang dilakukan saat tombol gabung ditekan
     * 
     */
    public void confirmationPressed() {
        if (this.confirm != null)
            this.confirm.pressed();
        else
            System.out.println("\nMasukkan Akun...");
    }

    /**
     * Untuk melakukan login
     * 
     */
    public void login() {
        try {
            if (this.isValid)
                System.out.println("\nAkun Kamu sudah masuk..");
            else if (this.validation()) {
                System.out.println("\nBerhasil Masuk..");
                this.isValid = true;
                this.confirm = new Prakerja();
            } else
                System.out.println("\nEmail atau Password tidak sesuai... ");
        } catch (Exception e) {
            System.out.println("\nData tidak terdeteksi...");
        }
    }

    /**
     * Validasi untuk mengecek apakah akun yang ingin login terdaftar di database
     */
    private boolean validation() throws Exception {
        File file = new File("db/Akun.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        while ((line = br.readLine()) != null) {
            String[] identity = line.split(":");
            if (identity[0].equals(this.email) && identity[1].equals(this.password)) {
                this.nama = identity[2];
                this.pekerjaan = identity[3];
                return true;
            }
        }
        return false;
    }

    /**
     * Untuk melakukan logout
     */
    public void logout() {
        if (this.isValid) {
            this.confirm = null;
            System.out.println("\nBerhasil keluar...");
        } else
            System.out.println("\nKamu Belum Masuk...");
        this.isValid = false;
    }

    /**
     * Menampilkan identitas pengguna yang telah login
     */
    public void getIdentity() {
        if (this.isValid) {
            System.out.println("\nNama\t\t: " + this.nama);
            System.out.println("Email\t\t: " + this.email);
            if (this.confirm.isConfirm())
                System.out.println("Status\t\t: Sudah Gabung");
            else
                System.out.println("Status\t\t: Belum Gabung");
            System.out.println("Pekerjaan\t: " + this.pekerjaan);
        } else
            System.out.println("\nMasukkan Akun...");
    }
}