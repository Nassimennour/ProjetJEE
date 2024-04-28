package Service;

import Dao.OrganisateurDAOImpl;
import Entity.Organisateur;
import jakarta.inject.Inject;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class OrganisateurServiceImpl implements OrganisateurService{

    private OrganisateurDAOImpl organisateurDAO;

    @Inject
    public  OrganisateurServiceImpl(OrganisateurDAOImpl organisateurDAO){
        this.organisateurDAO = organisateurDAO;
    }
    @Override
    public Optional<Organisateur> findById(long id) {
        return organisateurDAO.findById(id);
    }

    @Override
    public List<Organisateur> findAll() {
        return organisateurDAO.findAll();
    }

    @Transactional
    @Override
    public void save(Organisateur organisateur) {
        organisateurDAO.save(organisateur);
    }

    @Transactional
    @Override
    public void update(Organisateur organisateur) {
        organisateurDAO.update(organisateur);
    }

    @Transactional
    @Override
    public void delete(Organisateur organisateur) {
        organisateurDAO.delete(organisateur);
    }

    @Override
    public boolean existsById(long id) {
        return organisateurDAO.existsById(id);
    }

    @Override
    public List<Organisateur> findByOrganisationName(String organisation) {
        return organisateurDAO.findByOrganisationName(organisation);
    }
}
