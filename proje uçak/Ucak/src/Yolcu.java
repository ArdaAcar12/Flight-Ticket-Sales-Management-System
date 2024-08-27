import java.util.HashMap;
import java.util.Random;

public abstract class Yolcu {
    protected int id;
    protected String ad;
    protected String soyad;
    protected int koltukNo;
    protected boolean checkIn;
    protected final int BASEFIYAT = 100;
    protected HashMap<FirmaAdi, Integer> biletler;

    public Yolcu(int id, String ad, String soyad) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.koltukNo = new Random().nextInt(100) + 1;
        this.checkIn = false;
        this.biletler = new HashMap<>();
    }

    public abstract void biletAl(FirmaAdi firmaAdi);
    public abstract void yolcuBilgileriniGetir();
    public void checkInYap() {
        if (!checkIn) {
            checkIn = true;
            System.out.println(ad + " " + soyad + " için check-in yapıldı.");
        } else {
            System.out.println(ad + " " + soyad + " için zaten check-in yapılmış.");
        }
    }

    public void ucagaBin() {
        if (checkIn) {
            System.out.println(ad + " " + soyad + " uçağa binebilir. Koltuk No: " + koltukNo);
        } else {
            System.out.println(ad + " " + soyad + " uçağa binemez, çünkü check-in yapılmamış.");
        }
    }
}
