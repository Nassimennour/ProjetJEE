package Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Utilisateur {
    @Id
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String photo;
    private String login;
    private String role;
}
