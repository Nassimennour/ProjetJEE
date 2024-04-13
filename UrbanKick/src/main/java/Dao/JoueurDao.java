package Dao;

import Entity.Joueur;

import java.util.List;
import java.util.Optional;

public interface JoueurDao extends GenericDao<Joueur> {
    List<Joueur> findByEquipeId(long equipeId);
    Optional<Joueur> findByUtilisateurId(long utilisateurId);
}