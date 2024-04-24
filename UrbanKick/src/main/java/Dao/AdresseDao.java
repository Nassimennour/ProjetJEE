package Dao;

import Entity.Adresse;

import java.util.List;

public interface AdresseDao extends GenericDao<Adresse>{
    List<Adresse> findByPays(String pays);
    List<Adresse> findByVille(String ville);

}
