package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="Penalties")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Penalty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "joueur_id")
    private Joueur joueur;
    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;
    private boolean marque;
    private int ordre;
}