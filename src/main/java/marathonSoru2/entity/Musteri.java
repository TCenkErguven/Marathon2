package marathonSoru2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import marathonSoru2.repository.SiparisDao;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Musteri {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    private String isim;
    private String soyad;

    @OneToMany (mappedBy = "musteri",cascade = CascadeType.ALL)
    private List<Siparis> siparis;

    public Musteri(String isim, String soyad) {
        this.isim = isim;
        this.soyad = soyad;
    }

    public Musteri(String isim, String soyad, List<Siparis> siparis) {
        this.isim = isim;
        this.soyad = soyad;
        this.siparis = siparis;
    }
}
