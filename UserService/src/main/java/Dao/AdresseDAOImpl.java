package Dao;

import Entity.Adresse;
import jakarta.inject.Inject;

public class AdresseDAOImpl extends GenericDAOImpl<Adresse> implements AdresseDAO{
    @Inject
    public AdresseDAOImpl() {
        super(Adresse.class);
    }



}
