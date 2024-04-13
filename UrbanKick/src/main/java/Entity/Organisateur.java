package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Organisateurs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organisateur extends Utilisateur {
    @Column(name="organisation")
    private String organisationName;
    private int experience;
    @OneToMany(mappedBy = "organisateur")
    private List<Ligue> ligues;
}