package Dao;

import Entity.Organisateur;
import Util.App;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Optional;

public class OrganisateurDaoImpl extends GenericDaoImpl<Organisateur> implements OrganisateurDao{
    public OrganisateurDaoImpl() {
        super(Organisateur.class);
    }
    public Optional<Organisateur> findByOrganisationName(String organisationName){
        try (Session session = App.getSession()){
            Query<Organisateur> query = session.createQuery("from Organisateur where organisationName = :organisationName", Organisateur.class);
            query.setParameter("organisationName", organisationName);
            return Optional.ofNullable(query.uniqueResult());
        }catch(Exception e){
            e.printStackTrace();
            return Optional.empty();
        }
    }
}