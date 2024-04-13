package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="Pronostics")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pronostic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;
    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;
    private int scoreEquipeDomicile;
    private int scoreEquipeExterieur;
}