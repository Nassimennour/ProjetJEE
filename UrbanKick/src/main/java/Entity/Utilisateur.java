package Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Utilisateurs")
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "utilisateur_id")
    private long id;
    private String nom;
    private String prenom;
    @Enumerated(EnumType.STRING)
    private Sexe sexe;
    private String email;
    private Date dateNaissance;
    private String Nationalite;
    private String password;
    private String photo;
    private String login;
    private String role;
    @OneToOne
    private Adresse adresse;
}
