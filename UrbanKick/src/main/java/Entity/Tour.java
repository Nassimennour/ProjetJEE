package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Tours")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private TypeTour typeTour;
    @OneToMany(mappedBy = "tour")
    private List<Match> matches;
}
