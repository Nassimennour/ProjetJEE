package Dao;

import Entity.Organisateur;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public interface OrganisateurDAO extends GenericDAO<Organisateur> {
    List<Organisateur> findByOrganisationName(String organisation);
}