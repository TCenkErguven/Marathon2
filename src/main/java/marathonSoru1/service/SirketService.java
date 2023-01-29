package marathonSoru1.service;

import marathonSoru1.entity.Calisan;
import marathonSoru1.entity.Sirket;
import marathonSoru1.util.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SirketService {
    DB db = new DB();
    Sirket sirket = null;
    List<Sirket> sirketList = new ArrayList<>();


    public static void main(String[] args) {
        SirketService sirketService = new SirketService();
        Sirket sirket1 = new Sirket(2,"F Şirketi","E patronu","lti"," Inşaat",22321);
   //     sirketService.create(sirket1);
   //     sirketService.deleteById(2);
   //     sirketService.update(sirket1);
        sirketService.read();
    }
    public void create(Sirket sirket){
        String sql = "insert into sirket(sirketismi,sirketsahibi,unvan,faaliyetalani,kurulusyili) values(?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setString(1,sirket.getSirketIsmi());
            preparedStatement.setString(2, sirket.getSirketSahibi());
            preparedStatement.setString(3, sirket.getUnvan());
            preparedStatement.setString(4,sirket.getFaaliyetAlani());
            preparedStatement.setInt(5,sirket.getKurulusYili());
            preparedStatement.executeUpdate();
            System.out.println(sirket.getSirketIsmi() + " veri tabanına eklenmiştir.");
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void read(){
        String sql = "select * from sirket";
        try {
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Integer id = rs.getInt("id");
                String sirketismi = rs.getString("sirketismi");
                String sirketsahibi = rs.getString("sirketsahibi");
                String unvan = rs.getString("unvan");
                String faaliyetalani = rs.getString("faaliyetalani");
                Integer kurulusyili = rs.getInt("kurulusyili");
                sirket = new Sirket(id,sirketismi,sirketsahibi,unvan,faaliyetalani,kurulusyili);
                sirketList.add(sirket);
            }
            if(sirketList.isEmpty()){
                System.out.println("Şirket is empty");
            }else {
                sirketList.forEach(item -> System.out.println(item));
            }
        }catch (Exception e){
            e.printStackTrace();
        }




    }

    public void update(Sirket sirket){
        String sql = "update sirket set sirketismi = ?, sirketsahibi = ?, unvan = ?, faaliyetalani = ?, kurulusyili = ? where id = ?";
        try{
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setString(1,sirket.getSirketIsmi());
            preparedStatement.setString(2, sirket.getSirketSahibi());
            preparedStatement.setString(3, sirket.getUnvan());
            preparedStatement.setString(4,sirket.getFaaliyetAlani());
            preparedStatement.setInt(5,sirket.getKurulusYili());
            preparedStatement.setInt(6,sirket.getId());
            preparedStatement.executeUpdate();
            System.out.println("Güncellme işlemi başarılı");
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteById(int sirketId){
        String sql = "delete from sirket where id = ?";
        try {
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setInt(1,sirketId);
            preparedStatement.executeUpdate();
            System.out.println("Silme işlemi başarılı");
       //     read();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
