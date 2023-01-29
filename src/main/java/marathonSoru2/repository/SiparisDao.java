package marathonSoru2.repository;

import marathonSoru2.entity.Siparis;
import marathonSoru2.entity.SiparisKalemi;
import marathonSoru2.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.List;

public class SiparisDao {

    private Session session = null;
    public void save(Siparis siparis){
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(siparis);
            session.getTransaction().commit();
            System.out.println(siparis.getId() + " nolu sipariş kaydedilmiştir.");
            session.close();
       }catch (Exception e){
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void getAll(){
        List<Siparis> list = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Siparis");
            list = query.getResultList();
            for(Siparis i : list){
                Integer total = 0;
                int siparisId = i.getId();
                int musteriId = i.getMusteri().getId();
                String musteiAd = i.getMusteri().getIsim() + " " + i.getMusteri().getSoyad();
                System.out.println("Sipariş ID: " + siparisId + " Musteri: " + musteiAd + " Musteri ID: " + musteriId);
                for(SiparisKalemi y: i.getSiparisKalemi()){
                    System.out.println("Ürün: " + y.getUrun().getUrunAdi() + " Fiyat: " + y.getUrun().getFiyat() + " Adet sayısı : " + y.getAdet());
                    total += (y.getUrun().getFiyat()) * (y.getAdet());
                }
                System.out.println("Sipariş Toplam :" + total);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public void update(Siparis siparis){
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(siparis);
            session.getTransaction().commit();
        }catch (Exception e){
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
            }
        }
    }

    public void deleteById(int id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            Siparis siparis = session.load(Siparis.class,id);
            session.delete(siparis);
            session.getTransaction().commit();
        }catch (Exception e){
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
            }
        }
    }
}
