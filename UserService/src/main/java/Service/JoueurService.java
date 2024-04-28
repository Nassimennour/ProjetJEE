package Service;

import Entity.Joueur;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.List;
import java.util.Optional;

@Named
@RequestScoped
public interface JoueurService {
    void save(Joueur joueur);
    void update(Joueur joueur);
    void delete(Joueur joueur);
    boolean existsById(long id);
    Optional<Joueur> findById(long id);
    Optional<Joueur> findByUtilisateurId(long id);
    List<Joueur> findAll();
    List<Joueur> findByEquipeId(long id);
}
