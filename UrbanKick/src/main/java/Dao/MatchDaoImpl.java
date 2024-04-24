package Dao;

import Entity.Joueur;
import Entity.Match;
import Util.App;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class MatchDaoImpl extends GenericDaoImpl<Match> implements MatchDao{
    public MatchDaoImpl() {
        super(Match.class);
    }

    @Override
    public List<Match> findByLigueId(long idLigue){
        try(Session session = App.getSession()){
            return session.createQuery("SELECT m FROM Match m WHERE m.tour.ligue.id = :idLigue", Match.class)
                    .setParameter("idLigue", idLigue)
                    .getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    @Override
    public List<Match> findByEquipeId(long idEquipe){
        try(Session session = App.getSession()){
            return session.createQuery("SELECT m FROM Match m WHERE m.equipeDomicile.id = :idEquipe OR m.equipeExterieur.id = :idEquipe", Match.class)
                    .setParameter("idEquipe", idEquipe)
                    .getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    @Override
    public List<Match> findByTourId(long idTour){
        try(Session session = App.getSession()){
            return session.createQuery("SELECT m FROM Match m WHERE m.tour.id = :idTour", Match.class)
                    .setParameter("idTour", idTour)
                    .getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    @Override
    public List<Match> findByEquipeDomicileId(long idEquipe){
        try(Session session = App.getSession()){
            return session.createQuery("SELECT m FROM Match m WHERE m.equipeDomicile.id = :idEquipe", Match.class)
                    .setParameter("idEquipe", idEquipe)
                    .getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    @Override
    public List<Match> findByEquipeExterieurId(long idEquipe){
        try(Session session = App.getSession()){
            return session.createQuery("SELECT m FROM Match m WHERE m.equipeExterieur.id = :idEquipe", Match.class)
                    .setParameter("idEquipe", idEquipe)
                    .getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    @Override
    public List<Match> findByDateRange(LocalDateTime start, LocalDateTime end){
        try(Session session = App.getSession()){
            return session.createQuery("SELECT m FROM Match m WHERE m.date BETWEEN :start AND :end", Match.class)
                    .setParameter("start", start)
                    .setParameter("end", end)
                    .getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    @Override
    public List<Match> findByHommeDuMatchId(long idJoueur){
        try(Session session = App.getSession()){
            return session.createQuery("SELECT m FROM Match m WHERE m.hommeDuMatch.id = :idJoueur", Match.class)
                    .setParameter("idJoueur", idJoueur)
                    .getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    @Override
    public List<Match> findByJoueurTitulaireId(long idJoueur) {
        try (Session session = App.getSession()){
            Joueur joueur = session.get(Joueur.class, idJoueur);
            Query<Match> query = session.createQuery("select m from Match m join m.compositions c where :joueur member of c.joueursTitulaires", Match.class);
            query.setParameter("joueur", joueur);
            return query.list();
        }catch(Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    @Override
    public List<Match> findByJoueurId(long idJoueur) {
        try (Session session = App.getSession()){
            Joueur joueur = session.get(Joueur.class, idJoueur);
            Query<Match> query = session.createQuery("select m from Match m join m.compositions c where :joueur member of c.joueursTitulaires or :joueur member of c.joueursRemplacants", Match.class);
            query.setParameter("joueur", joueur);
            return query.list();
        }catch(Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<Match> findByTeams(long idEquipe1, long idEquipe2) {
        try (Session session = App.getSession()){
            return session.createQuery("SELECT m FROM Match m WHERE (m.equipeDomicile.id = :idEquipe1 AND m.equipeExterieur.id = :idEquipe2) OR (m.equipeDomicile.id = :idEquipe2 AND m.equipeExterieur.id = :idEquipe1)", Match.class)
                    .setParameter("idEquipe1", idEquipe1)
                    .setParameter("idEquipe2", idEquipe2)
                    .getResultList();
        } catch(Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<Match> findByLigueIdAndEquipeId(long idLigue, long idEquipe) {
        try (Session session = App.getSession()){
            return session.createQuery("SELECT m FROM Match m WHERE m.ligue.id = :idLigue AND (m.equipeDomicile.id = :idEquipe OR m.equipeExterieur.id = :idEquipe)", Match.class)
                    .setParameter("idLigue", idLigue)
                    .setParameter("idEquipe", idEquipe)
                    .getResultList();
        } catch(Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
