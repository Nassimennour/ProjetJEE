package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="Reponses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String contenu;
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;
    @ManyToOne
    @JoinColumn(name = "commentaire_id")
    private Commentaire commentaire;
    @ManyToOne
    @JoinColumn(name = "reponse_parent_id")
    private Reponse reponseParent;
    @OneToMany(mappedBy = "reponseParent", cascade = CascadeType.ALL)
    private List<Reponse> reponsesEnfants;
}