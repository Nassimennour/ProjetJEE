package Dao;

import Entity.Equipe;
import Util.App;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class EquipeDaoImpl extends GenericDaoImpl<Equipe> implements EquipeDao{
    public EquipeDaoImpl() {
        super(Equipe.class);
    }

    @Override
    public Optional<Equipe> findByNom(String nom) {
        try (Session session = App.getSession()){
            Query<Equipe> query = session.createQuery("from Equipe where nom = :nom", Equipe.class);
            query.setParameter("nom", nom);
            return Optional.ofNullable(query.uniqueResult());
        }catch(Exception e){
            e.printStackTrace();
            return Optional.empty();
        }
    }
    @Override
    public Optional<Equipe> findByPays(String pays) {
        try (Session session = App.getSession()){
            Query<Equipe> query = session.createQuery("from Equipe where pays = :pays", Equipe.class);
            query.setParameter("pays", pays);
            return Optional.ofNullable(query.uniqueResult());
        }catch(Exception e){
            e.printStackTrace();
            return Optional.empty();
        }
    }
    @Override
    public Optional<Equipe> findByVille(String ville) {
        try (Session session = App.getSession()){
            Query<Equipe> query = session.createQuery("from Equipe where ville = :ville", Equipe.class);
            query.setParameter("ville", ville);
            return Optional.ofNullable(query.uniqueResult());
        }catch(Exception e){
            e.printStackTrace();
            return Optional.empty();
        }
    }
    @Override
    public Optional<Equipe> findByNomAndLigue(String nom, long idLigue) {
        try (Session session = App.getSession()){
            Query<Equipe> query = session.createQuery("from Equipe where nom = :nom and ligue.id = :idLigue", Equipe.class);
            query.setParameter("nom", nom);
            query.setParameter("idLigue", idLigue);
            return Optional.ofNullable(query.uniqueResult());
        }catch(Exception e){
            e.printStackTrace();
            return Optional.empty();
        }
    }
    @Override
    public boolean existsByNomAndLigue(String nom, long idLigue) {
        try (Session session = App.getSession()){
            Query<Equipe> query = session.createQuery("from Equipe where nom = :nom and ligue.id = :idLigue", Equipe.class);
            query.setParameter("nom", nom);
            query.setParameter("idLigue", idLigue);
            return query.uniqueResult() != null;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Equipe> findByLigueId(long idLigue) {
        try (Session session = App.getSession()){
            Query<Equipe> query = session.createQuery("from Equipe where ligue.id = :idLigue", Equipe.class);
            query.setParameter("idLigue", idLigue);
            return query.list();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
