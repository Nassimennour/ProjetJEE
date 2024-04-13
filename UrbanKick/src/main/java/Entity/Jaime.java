package Entity;

import javax.persistence.*;

@Entity
@Table(name="Jaimes")
public class Jaime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;
    @ManyToOne
    @JoinColumn(name = "commentaire_id")
    private Commentaire commentaire;
}
