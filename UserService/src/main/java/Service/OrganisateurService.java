package Service;


import Entity.Organisateur;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.List;
import java.util.Optional;

@Named
@RequestScoped
public interface OrganisateurService {
    Optional<Organisateur> findById(long id);
    List<Organisateur> findAll();
    void save(Organisateur organisateur);
    void update(Organisateur organisateur);
    void delete(Organisateur organisateur);
    boolean existsById(long id);
    List<Organisateur> findByOrganisationName(String organisation);

}
