package marathonSoru2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import marathonSoru2.utils.HibernateUtil;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Urun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String urunAdi;
    private Integer fiyat;


    public Urun(String urunAdi, Integer fiyat) {
        this.urunAdi = urunAdi;
        this.fiyat = fiyat;
    }

}
