package Dao;

import Entity.Joueur;
import Util.App;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class JoueurDAOImpl extends GenericDAOImpl<Joueur> implements JoueurDAO {
    public JoueurDAOImpl() {
        super(Joueur.class);
    }

    @Override
    public Optional<Joueur> findByUtilisateurId(long utilisateurId) {
        return Optional.ofNullable(doInTransaction(session -> {
            Query<Joueur> query = session.createQuery("from Joueur where utilisateur.id = :utilisateurId", Joueur.class);
            query.setParameter("utilisateurId", utilisateurId);
            return query.uniqueResult();
        }));
    }

    @Override
    public List<Joueur> findByEquipeId(long equipeId) {
        List<Joueur> joueurs = doInTransaction(session -> {
            Query<Joueur> query = session.createQuery("from Joueur where equipeId = :equipeId", Joueur.class);
            query.setParameter("equipeId", equipeId);
            return query.list();
        });
        return joueurs != null ? joueurs : Collections.emptyList();
    }
}