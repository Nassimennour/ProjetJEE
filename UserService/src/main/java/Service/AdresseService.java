package Service;

import Entity.Adresse;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.List;
import java.util.Optional;

@Named
@RequestScoped
public interface AdresseService {
    void save(Adresse adresse);
    void update(Adresse adresse);
    void delete(Adresse adresse);
    boolean existsById(long id);
    Optional<Adresse> findById(long id);
    List<Adresse> findAll();
}
