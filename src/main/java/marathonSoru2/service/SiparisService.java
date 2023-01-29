package marathonSoru2.service;

import marathonSoru2.entity.Siparis;
import marathonSoru2.entity.SiparisKalemi;
import marathonSoru2.repository.SiparisDao;

import java.util.List;

public class SiparisService {
    SiparisDao siparisRepository = new SiparisDao();
    public void save(Siparis siparis){
        try{
            siparisRepository.save(siparis);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getAll(){
        try{
            siparisRepository.getAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public void update(Siparis siparis){
        try{
            siparisRepository.update(siparis);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try {
            siparisRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
