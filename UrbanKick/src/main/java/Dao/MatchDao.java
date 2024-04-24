package Dao;

import Entity.Match;
import Entity.Resultat;

import java.time.LocalDateTime;
import java.util.List;

public interface MatchDao extends GenericDao<Match>{
    List<Match> findByLigueId(long idLigue);
    List<Match> findByEquipeId(long idEquipe);
    List<Match> findByTourId(long idTour);
    List<Match> findByLigueIdAndEquipeId(long idLigue, long idEquipe);

    List<Match> findByEquipeDomicileId(long idEquipe);
    List<Match> findByEquipeExterieurId(long idEquipe);
    List<Match> findByDateRange(LocalDateTime start, LocalDateTime end);
    List<Match> findByHommeDuMatchId(long idJoueur);
    List<Match> findByTeams(long idEquipe1, long idEquipe2);
    List<Match> findByJoueurTitulaireId(long idJoueur);
    List<Match> findByJoueurId(long idJoueur);
}