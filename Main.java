import core.*;

/**
 * Implementasi Kartu Prakerja
 */
public class Main {
    /**
     * pengetesan jalan Kartu Prakerja
     * 
     * @param args parameter standar untuk command line
     */
    public static void main(String args[]) {
        Akun a = new Akun("nahdarizky51@gmail.com", "nahda123");
        a.login();
        a.getIdentity();
        a.confirmationPressed();
        a.getIdentity();
        a.logout();
    }
}