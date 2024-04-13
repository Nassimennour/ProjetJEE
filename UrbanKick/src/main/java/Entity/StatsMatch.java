package Entity;

import javax.persistence.*;

@Entity
@Table(name="StatsMatchs")
public class StatsMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int possessionD;
    private int possessionE;
    private int butsD;
    private int butsE;
    private int tirsD;
    private int cartonsJD;
    private int cartonsRD;
    private int tirsE;
    private int cartonsJE;
    private int cartonsRE;
    @OneToOne
    @JoinColumn(name = "match_id")
    private Match match;

}