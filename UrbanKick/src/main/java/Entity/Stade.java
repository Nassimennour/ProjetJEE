package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Stades")
@Data
@AllArgsConstructor
@NoArgsConstructor
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