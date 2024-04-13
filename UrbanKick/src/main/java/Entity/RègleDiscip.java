package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="RègleDisciplinaires")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RègleDiscip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    @Enumerated(EnumType.STRING)
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
