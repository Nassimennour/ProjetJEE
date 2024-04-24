package Dao;

import Entity.Organisateur;

import java.util.Optional;

public interface OrganisateurDao extends GenericDao<Organisateur>{
    Optional<Organisateur> findByOrganisationName(String organisationName);
}
