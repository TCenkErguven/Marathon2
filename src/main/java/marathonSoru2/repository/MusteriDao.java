package marathonSoru2.repository;

import marathonSoru2.entity.Musteri;
import marathonSoru2.entity.Siparis;
import marathonSoru2.entity.SiparisKalemi;
import marathonSoru2.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class MusteriDao {
    private Session session = null;
    public void getByMusteri(){
        List<Musteri> list = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Musteri");
            list = query.getResultList();
            System.out.println("s");
            for(Musteri i : list){
                Integer musteriId = i.getId();
                String musteriAd = i.getIsim() + " " + i.getSoyad();
                System.out.println("Müşteri id: " + musteriId + " Müşteri ad:" + musteriAd );
                for(Siparis y: i.getSiparis()){
                    System.out.println("Sipariş id: " + y.getId());
                    for(SiparisKalemi z: y.getSiparisKalemi()){
                        System.out.println("Ürün: " + z.getUrun().getUrunAdi() + " Fiyat: " + z.getUrun().getFiyat() + " Adet: " + z.getAdet());
                    }
                }
            }




        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getByMusteriId(){
        List<Object[]> list = null;
        try{
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "select m.id, sk.adet from siparis as s\n" +
                    "inner join siparis_sipariskalemi as ssk\n" +
                    "on s.id = ssk.Siparis_id\n" +
                    "inner join sipariskalemi as sk\n" +
                    "on ssk.siparisKalemi_id = sk.id\n" +
                    "inner join urun as u\n" +
                    "on u.id = sk.urun_id\n" +
                    "inner join musteri as m\n" +
                    "on m.id = s.musteri_id\n";
            list = entityManager.createNativeQuery(query).getResultList();
            for(Object[] item:list){
                System.out.println(
                        "Müşteri Id : " + item[0] + ", "
                                + "Sipariş sayısı : " + item[1]
                );
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void getAllMusteriD(){
        List<Object[]> list = null;
        try{
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "select m.isim,m.soyad,s.id from siparis as s\n" +
                    "inner join siparis_sipariskalemi as ssk\n" +
                    "on s.id = ssk.Siparis_id\n" +
                    "inner join sipariskalemi as sk\n" +
                    "on ssk.siparisKalemi_id = sk.id\n" +
                    "inner join urun as u\n" +
                    "on u.id = sk.urun_id\n" +
                    "inner join musteri as m\n" +
                    "on m.id = s.musteri_id\n" +
                    "\n";
            list = entityManager.createNativeQuery(query).getResultList();
            for(Object[] item:list){
                System.out.println(
                        "Müşteri Ad : " + item[0] + " "
                                + "Müşteri Soyad : " + item[1] + " "
                                + "Sipariş ID: " + item[2]
                );
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
