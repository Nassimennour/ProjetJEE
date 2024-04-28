package Service;

import Dao.AdresseDAOImpl;
import Entity.Adresse;
import jakarta.inject.Inject;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class AdresseServiceImpl implements AdresseService {
    private AdresseDAOImpl adresseDAO;
    @Inject
    public AdresseServiceImpl(AdresseDAOImpl adresseDAO){
        this.adresseDAO = adresseDAO;
    }

    @Transactional
    @Override
    public void save(Adresse adresse) {
        adresseDAO.save(adresse);
    }

    @Transactional
    @Override
    public void update(Adresse adresse) {
        adresseDAO.update(adresse);
    }

    @Transactional
    @Override
    public void delete(Adresse adresse) {
        adresseDAO.delete(adresse);
    }

    @Override
    public boolean existsById(long id) {
        return adresseDAO.existsById(id);
    }

    @Override
    public Optional<Adresse> findById(long id) {
        return adresseDAO.findById(id);
    }

    @Override
    public List<Adresse> findAll() {
        return adresseDAO.findAll();
    }
}
