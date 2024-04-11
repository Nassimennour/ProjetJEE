package Entity;

import javax.persistence.*;

@Entity
@Table(name="adresses")
public class Adresse {
    @Id
    @Column(name = "adresse_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String rue;
    private String ville;
    private String codePostal;
    private String pays;
    @OneToOne(mappedBy = "adresse")
    private Utilisateur utilisateur;
}
