package Dao;

import Entity.Adresse;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public interface AdresseDAO extends GenericDAO<Adresse>{

}
