package Dao;

import Entity.Adresse;
import Util.App;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class AdresseDaoImpl extends GenericDaoImpl<Adresse> implements AdresseDao{
    public AdresseDaoImpl() {
        super(Adresse.class);
    }
    @Override
    public List<Adresse> findByPays(String pays){
        try (Session session = App.getSession()){
            return session.createQuery("SELECT a FROM Adresse a WHERE a.pays = :pays", Adresse.class)
                    .setParameter("pays", pays)
                    .getResultList();

        }catch(Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    @Override
    public List<Adresse> findByVille(String ville){
        try (Session session = App.getSession()){
            return session.createQuery("SELECT a FROM Adresse a WHERE a.ville = :ville", Adresse.class)
                    .setParameter("ville", ville)
                    .getResultList();

        }catch(Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
