import java.util.*;

public class YolcuIslemleri {
    private final ArrayList<Yolcu> yolcular;
    private final Set<String> yolcuSet = new HashSet<>();
    private final Set<Integer> idSet = new HashSet<>();

    public YolcuIslemleri(ArrayList<Yolcu> yolcular) {
        this.yolcular = yolcular;
        for (Yolcu y : yolcular) {
            yolcuSet.add(y.ad.toLowerCase() + " " + y.soyad.toLowerCase());
            idSet.add(y.id);
        }
    }

    public void yolcuEkle(Scanner scanner) {
        System.out.println("Yolcu Tipi Seçin: 1-Business 2-Ekonomi");
        int tip = scanner.nextInt();
        System.out.println("Yolcu ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Boşluğu temizlemek için
        System.out.println("Yolcu Adı: ");
        String ad = scanner.nextLine().toLowerCase();
        System.out.println("Yolcu Soyadı: ");
        String soyad = scanner.nextLine().toLowerCase();

        String fullName = ad + " " + soyad;


        if (yolcuSet.contains(fullName)) {
            System.out.println("Yolcu zaten mevcut: " + fullName);
            return;
        }


        if (idSet.contains(id)) {
            System.out.println("ID zaten mevcut: " + id);
            return;
        }

        Yolcu yeniYolcu;
        if (tip == 1) {
            System.out.println("VIP mi? (true/false)");
            boolean isVip = scanner.nextBoolean();
            yeniYolcu = new BusinessYolcu(id, ad, soyad, isVip);
        } else {
            yeniYolcu = new EkonomiYolcu(id, ad, soyad);
        }

        yolcular.add(yeniYolcu);
        yolcuSet.add(fullName);
        idSet.add(id);
        System.out.println("Yolcu eklendi!");
    }

    public void yolcuSil(Scanner scanner) {
        System.out.println("Silmek istediğiniz yolcu ID'sini girin: ");
        int id = scanner.nextInt();
        Yolcu yolcu = yolcular.stream().filter(y -> y.id == id).findFirst().orElse(null);

        if (yolcu != null) {
            yolcular.remove(yolcu);
            yolcuSet.remove(yolcu.ad.toLowerCase() + " " + yolcu.soyad.toLowerCase());
            idSet.remove(yolcu.id);
            System.out.println("Yolcu silindi!");
        } else {
            System.out.println("Yolcu bulunamadı!");
        }
    }

    public void biletAl(Scanner scanner) {
        System.out.println("Bilet almak istediğiniz yolcu ID'sini girin: ");
        int id = scanner.nextInt();
        Yolcu yolcu = yolcular.stream().filter(y -> y.id == id).findFirst().orElse(null);

        if (yolcu != null) {
            System.out.println("Firma Adını Seçin: 1-THY 2-ADJ 3-PGS");
            int firmaSecim = scanner.nextInt();
            FirmaAdi firma = FirmaAdi.values()[firmaSecim - 1];
            yolcu.biletAl(firma);
        } else {
            System.out.println("Yolcu bulunamadı!");
        }
    }

    public void biletIptalEt(Scanner scanner) {
        System.out.println("Biletini iptal etmek istediğiniz yolcu ID'sini girin: ");
        int id = scanner.nextInt();
        Yolcu yolcu = yolcular.stream().filter(y -> y.id == id).findFirst().orElse(null);

        if (yolcu != null) {
            System.out.println("Hangi firmadan bilet iptal etmek istersiniz?");
            yolcu.biletler.keySet().forEach(firma -> System.out.println(firma));
            scanner.nextLine();
            String firmaAdi = scanner.nextLine().toUpperCase();
            FirmaAdi firma = FirmaAdi.valueOf(firmaAdi);
            yolcu.biletler.remove(firma);
            System.out.println("Bilet iptal edildi!");
        } else {
            System.out.println("Yolcu bulunamadı!");
        }
    }

    public void yolcuBilgileriniGetir(Scanner scanner) {
        System.out.println("Bilgilerini görmek istediğiniz yolcu ID'sini girin: ");
        int id = scanner.nextInt();
        Yolcu yolcu = yolcular.stream().filter(y -> y.id == id).findFirst().orElse(null);

        if (yolcu != null) {
            yolcu.yolcuBilgileriniGetir();
        } else {
            System.out.println("Yolcu bulunamadı!");
        }
    }

    public void checkInYap(Scanner scanner) {
        System.out.println("Check-in yapmak istediğiniz yolcu ID'sini girin: ");
        int id = scanner.nextInt();
        Yolcu yolcu = yolcular.stream().filter(y -> y.id == id).findFirst().orElse(null);

        if (yolcu != null) {
            yolcu.checkInYap();
        } else {
            System.out.println("Yolcu bulunamadı!");
        }
    }

    public void ucagaBin(Scanner scanner) {
        System.out.println("Uçağa binmek istediğiniz yolcu ID'sini girin: ");
        int id = scanner.nextInt();
        Yolcu yolcu = yolcular.stream().filter(y -> y.id == id).findFirst().orElse(null);

        if (yolcu != null) {
            yolcu.ucagaBin();
        } else {
            System.out.println("Yolcu bulunamadı!");
        }
    }
}