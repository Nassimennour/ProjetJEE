package Dao;

import Entity.Utilisateur;

import java.util.List;
import java.util.Optional;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
@Named
@RequestScoped
public interface UtilisateurDAO extends GenericDAO<Utilisateur>{
    Optional<Utilisateur> findByLogin(String login);
    Optional<Utilisateur> findByEmail(String email);
    Optional<Utilisateur> findByLoginAndPassword(String login, String password);
    List<Utilisateur> findByRole(String role);
    List<Utilisateur> findBySexe(String sexe);

}
