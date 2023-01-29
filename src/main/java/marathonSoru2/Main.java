package marathonSoru2;

import marathonSoru2.entity.Musteri;
import marathonSoru2.entity.Siparis;
import marathonSoru2.entity.SiparisKalemi;
import marathonSoru2.entity.Urun;
import marathonSoru2.service.MusteriService;
import marathonSoru2.service.SiparisService;


import java.util.Arrays;

public class Main {
    static SiparisService siparisService = new SiparisService();
    static MusteriService musteriService = new MusteriService();
    public static void main(String[] args) {

/*
        Musteri m1 = new Musteri("Ali","Kaya");
        Musteri m2 = new Musteri("Veli","Özkan");

        Urun u1 = new Urun("Iphone 11", 17000);
        Urun u2 = new Urun("SamsungS21", 18000);
        Urun u3 = new Urun("LG LED TV", 8500);
        Urun u4 = new Urun("Arçelik Süpürge", 2500);

        SiparisKalemi sk1 = new SiparisKalemi(u1,1);
        SiparisKalemi sk2 = new SiparisKalemi(u2, 2);
        Siparis s1 = new Siparis(m1, Arrays.asList(sk1,sk2));

        SiparisKalemi sk3 = new SiparisKalemi(u2,2);
        SiparisKalemi sk4 = new SiparisKalemi(u3, 1);
        Siparis s2 = new Siparis(m2, Arrays.asList(sk3,sk4));

        SiparisKalemi sk5 = new SiparisKalemi(u4,2);
        Siparis s3 = new Siparis(m1, Arrays.asList(sk5));

        Siparis s4 = new Siparis(m2, Arrays.asList(new SiparisKalemi(u1,1)));
        Siparis s5 = new Siparis(m2, Arrays.asList(new SiparisKalemi(u2,1)));

        siparisService.save(s1);
        siparisService.save(s2);
        siparisService.save(s3);
        siparisService.save(s4);
        siparisService.save(s5);
*/
       siparisService.getAll();
    //    musteriService.getAll();
    //      musteriService.getByMusteriId();
    //    musteriService.getMusteriD();

    }
}
