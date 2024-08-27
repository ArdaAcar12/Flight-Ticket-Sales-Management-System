import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Yolcu> yolcular = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Başlangıçta bazı yolcular ekleyin (Örnek kodlar)
        Yolcular(yolcular);

        YolcuIslemleri islemler = new YolcuIslemleri(yolcular);

        while (true) {
            System.out.println("1: Yolcu Ekle");
            System.out.println("2: Yolcu Sil");
            System.out.println("3: Bilet Al");
            System.out.println("4: Bilet İptal Et");
            System.out.println("5: Yolcu Bilgilerini Getir");
            System.out.println("6: Check-in Yap");
            System.out.println("7: Uçağa Bin");
            System.out.println("8: Çıkış");
            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    islemler.yolcuEkle(scanner);
                    break;
                case 2:
                    islemler.yolcuSil(scanner);
                    break;
                case 3:
                    islemler.biletAl(scanner);
                    break;
                case 4:
                    islemler.biletIptalEt(scanner);
                    break;
                case 5:
                    islemler.yolcuBilgileriniGetir(scanner);
                    break;
                case 6:
                    islemler.checkInYap(scanner);
                    break;
                case 7:
                    islemler.ucagaBin(scanner);
                    break;
                case 8:
                    System.out.println("Çıkış yapılıyor...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    private static void Yolcular(ArrayList<Yolcu> yolcular) {
        ArrayList<BusinessYolcu> businessYolcu = new ArrayList<>();
        businessYolcu.add(new BusinessYolcu(1, "Ali", "Kaya", true));
        businessYolcu.get(0).biletAl(FirmaAdi.THY);

        businessYolcu.add(new BusinessYolcu(2, "Ece", "Yılmaz", true));
        businessYolcu.get(1).biletAl(FirmaAdi.PEGASUS);

        businessYolcu.add(new BusinessYolcu(3, "Dilek", "Ocak", true));
        businessYolcu.get(2).biletAl(FirmaAdi.ANADOLUJET);

        businessYolcu.add(new BusinessYolcu(4, "Ahmet", "Kart", true));
        businessYolcu.get(3).biletAl(FirmaAdi.ADJ);

        businessYolcu.add(new BusinessYolcu(5, "Hasan", "Yıldız", true));
        businessYolcu.get(4).biletAl(FirmaAdi.THY);

        ArrayList<EkonomiYolcu> ekonomiYolcu = new ArrayList<>();
        ekonomiYolcu.add(new EkonomiYolcu(6, "Ayşe", "Demir"));
        ekonomiYolcu.get(0).biletAl(FirmaAdi.PEGASUS);

        ekonomiYolcu.add(new EkonomiYolcu(7, "Fatma", "Kiraz"));
        ekonomiYolcu.get(1).biletAl(FirmaAdi.THY);

        ekonomiYolcu.add(new EkonomiYolcu(8, "Berk", "Sezer"));
        ekonomiYolcu.get(2).biletAl(FirmaAdi.ANADOLUJET);

        ekonomiYolcu.add(new EkonomiYolcu(9, "Mert", "Müldür"));
        ekonomiYolcu.get(3).biletAl(FirmaAdi.ADJ);

        ekonomiYolcu.add(new EkonomiYolcu(10, "Nilay", "Ceylan"));
        ekonomiYolcu.get(4).biletAl(FirmaAdi.PEGASUS);

        yolcular.addAll(ekonomiYolcu);
        yolcular.addAll(businessYolcu);
    }
}
