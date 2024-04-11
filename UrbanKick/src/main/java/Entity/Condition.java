package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Conditions")
public class Condition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private Critère critère;
    private int valeurCritère;
    private int périodeValid;
    @ManyToMany(mappedBy = "conditions")
    private List<RègleDiscip> règles;
}