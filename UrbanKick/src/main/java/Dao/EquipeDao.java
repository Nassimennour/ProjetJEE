package Dao;

import Entity.Equipe;
import Entity.Ligue;

import java.util.List;
import java.util.Optional;

public interface EquipeDao extends GenericDao<Equipe>{
    Optional<Equipe> findByNom(String nom);
    Optional<Equipe> findByPays(String pays);
    Optional<Equipe> findByVille(String ville);
    List<Equipe> findByLigueId(long idLigue);
    Optional<Equipe> findByNomAndLigue(String nom, long idLigue);
    boolean existsByNomAndLigue(String nom, long idLigue);

}
