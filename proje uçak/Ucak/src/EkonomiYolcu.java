public class EkonomiYolcu extends Yolcu {
    private final int EKONOMIFIYAT = 100;

    public EkonomiYolcu(int id, String ad, String soyad) {
        super(id, ad.toLowerCase(), soyad.toLowerCase());
    }

    @Override
    public void biletAl(FirmaAdi firmaAdi) {
        int fiyat = BASEFIYAT + EKONOMIFIYAT;
        firmaAdi = FirmaAdi.valueOf(firmaAdi.name().toUpperCase());
        if (biletler.containsKey(firmaAdi)) {
            System.out.println(ad + " " + soyad + " için " + firmaAdi + " firmasından bilet fiyatı güncellendi.");
        } else {
            biletler.put(firmaAdi, fiyat);
            System.out.println(ad + " " + soyad + " için " + firmaAdi + " firmasından bilet alındı. Fiyat: " + fiyat);
        }
    }

    @Override
    public void yolcuBilgileriniGetir() {
        System.out.println("Yolcu: " + ad + " " + soyad + " (Ekonomi)");
        for (FirmaAdi firma : biletler.keySet()) {
            System.out.println(firma + " firmasından alınan bilet fiyatı: " + biletler.get(firma));
        }
    }
}
