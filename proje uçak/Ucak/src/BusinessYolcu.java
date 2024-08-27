public class BusinessYolcu extends Yolcu {
    private final int BUSINNESFIYAT = 200;
    private final int BUSINNESVIPFIYAT = 150;
    private boolean isVip;

    public BusinessYolcu(int id, String ad, String soyad, boolean isVip) {
        super(id, ad.toLowerCase(), soyad.toLowerCase());
        this.isVip = isVip;
    }

    @Override
    public void biletAl(FirmaAdi firmaAdi) {
        firmaAdi = FirmaAdi.valueOf(firmaAdi.name().toUpperCase());
        int fiyat = BASEFIYAT + BUSINNESFIYAT;
        if (isVip) {
            fiyat += BUSINNESVIPFIYAT;
        }
        biletler.put(firmaAdi, fiyat);
        System.out.println(ad + " " + soyad + " için " + firmaAdi + " firmasından bilet alındı. Fiyat: " + fiyat);
    }

    @Override
    public void yolcuBilgileriniGetir() {
        System.out.println("Yolcu: " + ad + " " + soyad + " (Business - VIP: " + (isVip ? "Evet" : "Hayır") + ")");
        for (FirmaAdi firma : biletler.keySet()) {
            System.out.println(firma + " firmasından alınan bilet fiyatı: " + biletler.get(firma));
        }
    }
}