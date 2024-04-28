package Dao;

import Entity.Organisateur;
import java.util.Collections;
import java.util.List;

public class OrganisateurDAOImpl extends GenericDAOImpl<Organisateur> implements OrganisateurDAO {

    public OrganisateurDAOImpl() {
        super(Organisateur.class);
    }

    @Override
    public List<Organisateur> findByOrganisationName(String organisation) {
        List<Organisateur> organisateurs = doInTransaction(session ->
                session.createQuery("from Organisateur where organisationName = :organisation", Organisateur.class)
                        .setParameter("organisationName", organisation)
                        .list());
        return organisateurs != null ? organisateurs : Collections.emptyList();
    }
}