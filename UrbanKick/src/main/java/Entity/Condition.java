package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Conditions")
@Data
@AllArgsConstructor
@NoArgsConstructor
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