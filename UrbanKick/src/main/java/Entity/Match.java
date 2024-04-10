package Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Match {
    @Id
    private int id;
    private LocalDateTime date;
    private String lieu;
    private Resultat resultat;
}
