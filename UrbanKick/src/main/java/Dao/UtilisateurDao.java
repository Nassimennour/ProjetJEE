package Dao;

import Entity.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface UtilisateurDao extends GenericDao<Utilisateur>{
    Optional<Utilisateur> findByLogin(String login);
    Optional<Utilisateur> findByEmail(String email);
    Optional<Utilisateur> findByLoginAndPassword(String login, String password);
    List<Utilisateur> findByRole(String role);
}
