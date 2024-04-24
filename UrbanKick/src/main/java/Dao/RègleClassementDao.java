package Dao;

import Entity.RègleClassement;

import java.util.Optional;

public interface RègleClassementDao extends GenericDao<RègleClassement> {
    Optional<RègleClassement> findByLigueId(long idLigue);
}