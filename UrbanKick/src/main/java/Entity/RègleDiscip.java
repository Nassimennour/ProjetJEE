package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="RègleDisciplinaires")
public class RègleDiscip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "regle_id")
    private long id;
    private String description;
    private TypeSanction typeSanction;
    private double montantAmende;
    private int nbreMatchSuspension;
    @ManyToMany
    @JoinTable(
        name = "regle_conditions",
        joinColumns = @JoinColumn(name = "regle_id"),
        inverseJoinColumns = @JoinColumn(name = "condition_id")
    )
    private List<Condition> conditions;
}
