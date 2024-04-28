package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name="Organisateurs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organisateur extends Utilisateur {
    @Column(name="organisation")
    private String organisationName;
    @Column(name="annees_expérience")
    private int experience;
    @Column(name="site_web")
    @Pattern(regexp = "^(http[s]?:\\/\\/(www\\.)?)?([\\w-]+\\.)+[\\w-]{2,4}$", message = "Invalid website URL")
    private String website;


}