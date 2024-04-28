package Service;

import Entity.Utilisateur;

import java.util.List;
import java.util.Optional;



public interface UtilisateurService {
        Optional<Utilisateur> findById(long id);
        List<Utilisateur> findAll();
        Optional<Utilisateur> findByLogin(String login);
        Optional<Utilisateur> findByEmail(String email);
        Optional<Utilisateur> findByLoginAndPassword(String login, String password);
        List<Utilisateur> findByRole(String role);
        List<Utilisateur> findBySexe(String sexe);
        void save(Utilisateur user);
        void update(Utilisateur user);
        void delete(Utilisateur user);
        boolean existsById(long id);


}
