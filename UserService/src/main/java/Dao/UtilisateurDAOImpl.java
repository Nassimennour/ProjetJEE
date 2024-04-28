package Dao;

import Entity.Utilisateur;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UtilisateurDAOImpl extends GenericDAOImpl<Utilisateur> implements UtilisateurDAO{
    public UtilisateurDAOImpl() {
        super(Utilisateur.class);
    }

    @Override
    public Optional<Utilisateur> findByLogin(String login) {
        return Optional.ofNullable(doInTransaction(session ->
                session.createQuery("from Utilisateur where login = :login", Utilisateur.class)
                        .setParameter("login", login)
                        .uniqueResult()));
    }

    @Override
    public Optional<Utilisateur> findByEmail(String email) {
        return Optional.ofNullable(doInTransaction(session ->
                session.createQuery("from Utilisateur where email = :email", Utilisateur.class)
                        .setParameter("email", email)
                        .uniqueResult()));
    }

    @Override
    public Optional<Utilisateur> findByLoginAndPassword(String login, String password) {
        return Optional.ofNullable(doInTransaction(session ->
                session.createQuery("from Utilisateur where login = :login and password = :password", Utilisateur.class)
                        .setParameter("login", login)
                        .setParameter("password", password)
                        .uniqueResult()));
    }

    @Override
    public List<Utilisateur> findByRole(String role) {
        List<Utilisateur> utilisateurs = doInTransaction(session ->
                session.createQuery("from Utilisateur where role = :role", Utilisateur.class)
                        .setParameter("role", role)
                        .list());
        return utilisateurs != null ? utilisateurs : Collections.emptyList();
    }

    @Override
    public List<Utilisateur> findBySexe(String sexe) {
        List<Utilisateur> utilisateurs = doInTransaction(session ->
                session.createQuery("from Utilisateur where sexe = :sexe", Utilisateur.class)
                        .setParameter("sexe", sexe)
                        .list());
        return utilisateurs != null ? utilisateurs : Collections.emptyList();
    }
}