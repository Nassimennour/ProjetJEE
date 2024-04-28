package Entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="Utilisateurs")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @Column(unique = true)
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
    @Column(unique = true)
    private String login;

    private String role;
    @Column(name = "joueur_id")
    private Long joueurId;

    @OneToOne
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;





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