package Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Stades")
public class Stade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String name;
    private String location;
    private int capacity;
    private String surface;
    private String image;
}