package Service;

import Dao.JoueurDAOImpl;
import Entity.Joueur;
import jakarta.inject.Inject;

import javax.transaction.Transactional;
import java.util.Optional;

public class JoueurServiceImpl implements JoueurService{

    private JoueurDAOImpl joueurDAO;

    @Inject
    public JoueurServiceImpl(JoueurDAOImpl joueurDAO){
        this.joueurDAO = joueurDAO;
    }

    @Transactional
    @Override
    public void save(Joueur joueur) {
        joueurDAO.save(joueur);
    }

    @Transactional
    @Override
    public void update(Joueur joueur) {
        joueurDAO.update(joueur);
    }

    @Transactional
    @Override
    public void delete(Joueur joueur) {
        joueurDAO.delete(joueur);
    }

    @Override
    public boolean existsById(long id) {
        return joueurDAO.existsById(id);
    }

    @Override
    public Optional<Joueur> findById(long id) {
        return joueurDAO.findById(id);
    }

    @Override
    public Optional<Joueur> findByUtilisateurId(long id) {
        return joueurDAO.findByUtilisateurId(id);
    }

    @Override
    public java.util.List<Joueur> findAll() {
        return joueurDAO.findAll();
    }

    @Override
    public java.util.List<Joueur> findByEquipeId(long id) {
        return joueurDAO.findByEquipeId(id);
    }




}
