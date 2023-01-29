package marathonSoru2.service;

import marathonSoru2.repository.MusteriDao;

public class MusteriService {
    MusteriDao musteriDao = new MusteriDao();
    public void getAll(){
        try{
            musteriDao.getByMusteri();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getByMusteriId(){
        try{
            musteriDao.getByMusteriId();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getMusteriD(){
        try{
            musteriDao.getAllMusteriD();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
