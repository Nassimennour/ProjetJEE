package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name="Classements")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;
    @ManyToOne
    @JoinColumn(name = "ligue_id")
    private Ligue ligue;
    @PositiveOrZero
    private int nbrePoints;
    @PositiveOrZero
    private int position;
    @PositiveOrZero
    private int nbreMatchsJoues;
    @PositiveOrZero
    private int nbreMatchsGagnes;
    @PositiveOrZero
    private int nbreMatchsNuls;
    @PositiveOrZero
    private int nbreMatchsPerdus;
    @PositiveOrZero
    private int nbreButsMarques;
    @PositiveOrZero
    private int nbreButsEncaisses;
    private int diffButs;
    @PositiveOrZero
    private int nbreCartonsJaunes;
    @PositiveOrZero
    private int nbreCartonsRouges;
}