package Dao;

import Entity.Ligue;

import java.util.Optional;

public interface LigueDao extends GenericDao<Ligue>{
    Optional<Ligue> findByNom(String nom);

}
