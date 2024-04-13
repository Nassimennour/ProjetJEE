package Entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="Utilisateurs")
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 2, max = 50)
    private String nom;

    @NotNull
    @Size(min = 2, max = 50)
    private String prenom;

    @Enumerated(EnumType.STRING)
    private Sexe sexe;

    @NotNull
    @Email
    private String email;

    @NotNull
    private Date dateNaissance;

    @NotNull
    private String Nationalite;

    @NotNull
    @Size(min = 8)
    private String password;

    private String photo;

    @NotNull
    private String login;

    private String role;

    @OneToOne(mappedBy = "utilisateur")
    private Adresse adresse;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<Jaime> jaimes;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<Commentaire> commentaires;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<Reponse> reponses;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<Pronostic> pronostics;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }
}