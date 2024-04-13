package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.Default;

import javax.persistence.*;

@Entity
@Table(name="RèglesClassement")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RègleClassement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int nbrePointsVictoire = 3;
    private int nbrePointsNul = 1;
    private int nbrePointsDefaite = 0;
    @OneToOne
    @JoinColumn(name = "ligue_id")
    private Ligue ligue;
}
