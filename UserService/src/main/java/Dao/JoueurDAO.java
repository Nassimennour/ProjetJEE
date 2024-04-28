package Dao;

import Entity.Joueur;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.List;
import java.util.Optional;

@Named
@RequestScoped
public interface JoueurDAO extends GenericDAO<Joueur>{
    // ADD SOME USEFUL METHODS
    Optional<Joueur> findByUtilisateurId(long utilisateurId);
    List<Joueur> findByEquipeId(long equipeId);

}
