package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Tours")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "ligue_id")
    private Ligue ligue;
    @Enumerated(EnumType.STRING)
    private TypeTour typeTour;
    @OneToMany(mappedBy = "tour")
    private List<Match> matches;
}
