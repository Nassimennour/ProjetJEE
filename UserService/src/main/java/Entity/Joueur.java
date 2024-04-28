package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table(name="Joueurs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Joueur{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;
    @Enumerated(EnumType.STRING)
    private Position poste;
    @Min(0) @Max(99)
    @Column(name = "numero_maillot")
    private int numero;
    @Column(name = "equipe_id")
    private long equipeId;

    // Replace with identifiers

}