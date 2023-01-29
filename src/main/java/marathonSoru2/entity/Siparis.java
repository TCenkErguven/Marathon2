package marathonSoru2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import marathonSoru2.utils.HibernateUtil;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Siparis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne (cascade = CascadeType.ALL)
    private Musteri musteri;

    @OneToMany (cascade = CascadeType.ALL)
    private List<SiparisKalemi> siparisKalemi;

    public Siparis(Musteri musteri, List<SiparisKalemi> siparisKalemi) {
        this.musteri = musteri;
        this.siparisKalemi = siparisKalemi;
    }

    public Siparis(Integer id, Musteri musteri, List<SiparisKalemi> siparisKalemi) {
        this.id = id;
        this.musteri = musteri;
        this.siparisKalemi = siparisKalemi;
    }

    public Siparis(List<SiparisKalemi> siparisKalemi) {
        this.siparisKalemi = siparisKalemi;
    }
}
