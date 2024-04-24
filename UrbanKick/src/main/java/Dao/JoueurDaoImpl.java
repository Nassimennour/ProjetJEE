package Dao;

import Entity.Joueur;
import Util.App;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JoueurDaoImpl extends GenericDaoImpl<Joueur> implements JoueurDao {
    public JoueurDaoImpl() {
        super(Joueur.class);
    }

    @Override
    public List<Joueur> findByEquipeId(long equipeId) {
        try (Session session = App.getSession()) {
            Query<Joueur> query = session.createQuery("from Joueur where equipe.id = :equipeId", Joueur.class);
            query.setParameter("equipeId", equipeId);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Optional<Joueur> findByUtilisateurId(long utilisateurId) {
        try (Session session = App.getSession()) {
            Query<Joueur> query = session.createQuery("from Joueur where utilisateur.id = :utilisateurId", Joueur.class);
            query.setParameter("utilisateurId", utilisateurId);
            return Optional.ofNullable(query.uniqueResult());
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}