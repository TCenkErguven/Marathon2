package marathonSoru2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class SiparisKalemi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    private Urun urun;

    private Integer adet;

    public SiparisKalemi(Urun urun, Integer adet) {
        this.urun = urun;
        this.adet = adet;

    }


}
