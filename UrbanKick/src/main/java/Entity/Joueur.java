package Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Joueurs")
public class Joueur extends Utilisateur {
    @Enumerated(EnumType.STRING)
    private Position poste;
    @Column(name = "numero_maillot")
    private int numero;
    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;
    @OneToMany(mappedBy = "hommeDuMatch")
    private List<Match> matchesAsHommeDuMatch;
    @OneToMany(mappedBy = "capitaineExterieur")
    private List<Match> matchesasCapitaineDomicile;
    @OneToMany(mappedBy = "capitaineDomicile")
    private List<Match> matchesAsCapitaineExterieur;


}