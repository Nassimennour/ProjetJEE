package Dao;

import Entity.Utilisateur;
import Util.App;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UtilisateurDaoImpl extends GenericDaoImpl<Utilisateur> implements UtilisateurDao{
    public UtilisateurDaoImpl() {
        super(Utilisateur.class);
    }

    @Override
    public Optional<Utilisateur> findByLogin(String login) {
        try (Session session = App.getSession()){
            Query<Utilisateur> query = session.createQuery("from Utilisateur where login = :login", Utilisateur.class);
            query.setParameter("login", login);
            return Optional.ofNullable(query.uniqueResult());
        }catch(Exception e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<Utilisateur> findByEmail(String email) {
        try (Session session = App.getSession()){
            Query<Utilisateur> query = session.createQuery("from Utilisateur where email = :email", Utilisateur.class);
            query.setParameter("email", email);
            return Optional.ofNullable(query.uniqueResult());
        }catch(Exception e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<Utilisateur> findByLoginAndPassword(String login, String password) {
        try (Session session = App.getSession()){
            Query<Utilisateur> query = session.createQuery("from Utilisateur where login = :login and password = :password", Utilisateur.class);
            query.setParameter("login", login);
            query.setParameter("password", password);
            return Optional.ofNullable(query.uniqueResult());
        }catch(Exception e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<Utilisateur> findByRole(String role) {
        try (Session session = App.getSession()){
            Query<Utilisateur> query = session.createQuery("from Utilisateur where role = :role", Utilisateur.class);
            query.setParameter("role", role);
            return query.getResultList();
        }catch(Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}