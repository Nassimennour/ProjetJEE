package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="Commentaires")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String contenu;
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;
    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;
    @ManyToOne
    @JoinColumn(name = "joueur_id")
    private Joueur joueur;
    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;
    @OneToMany(mappedBy = "commentaire")
    private List<Jaime> jaimes;
    @OneToMany(mappedBy = "commentaire")
    private List<Reponse> reponses;
}