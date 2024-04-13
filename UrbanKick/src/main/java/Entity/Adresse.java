package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="adresses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String rue;
    private String ville;
    private int codePostal;
    private String pays;
    @OneToOne(mappedBy = "adresse")
    private Utilisateur utilisateur;
}
