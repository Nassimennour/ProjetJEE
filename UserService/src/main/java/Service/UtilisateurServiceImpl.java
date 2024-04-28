package Service;

import Dao.UtilisateurDAO;
import Entity.Utilisateur;
import jakarta.inject.Inject;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class UtilisateurServiceImpl implements UtilisateurService {
    private final UtilisateurDAO utilisateurDAO;

    @Inject
    public UtilisateurServiceImpl(UtilisateurDAO utilisateurDAO) {
        this.utilisateurDAO = utilisateurDAO;
    }

    @Override
    public Optional<Utilisateur> findById(long id) {
        return utilisateurDAO.findById(id);
    }
    @Override
    public List<Utilisateur> findAll() {
        return utilisateurDAO.findAll();
    }

    @Override
    public Optional<Utilisateur> findByLogin(String login) {
        return utilisateurDAO.findByLogin(login);
    }

    @Override
    public Optional<Utilisateur> findByEmail(String email) {
        return utilisateurDAO.findByEmail(email);
    }

    @Override
    public Optional<Utilisateur> findByLoginAndPassword(String login, String password) {
        return utilisateurDAO.findByLoginAndPassword(login, password);
    }

    @Override
    public List<Utilisateur> findByRole(String role) {
        return utilisateurDAO.findByRole(role);
    }

    @Override
    public List<Utilisateur> findBySexe(String sexe) {
        return utilisateurDAO.findBySexe(sexe);
    }

    @Transactional
    @Override
    public void save(Utilisateur user) {
        utilisateurDAO.save(user);
    }

    @Transactional
    @Override
    public void update(Utilisateur user) {
        utilisateurDAO.update(user);
    }

    @Transactional
    @Override
    public void delete(Utilisateur user) {
        utilisateurDAO.delete(user);
    }
    @Override
    public boolean existsById(long id) {
        return utilisateurDAO.existsById(id);
    }
}