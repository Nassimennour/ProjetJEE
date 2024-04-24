package Dao;

import Entity.RègleClassement;
import Util.App;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Optional;

public class RègleClassementDaoImpl extends GenericDaoImpl<RègleClassement> implements RègleClassementDao {
    public RègleClassementDaoImpl() {
        super(RègleClassement.class);
    }

    @Override
    public Optional<RègleClassement> findByLigueId(long idLigue) {
        try (Session session = App.getSession()){
            Query<RègleClassement> query = session.createQuery("SELECT r FROM RègleClassement r WHERE r.ligue.id = :idLigue", RègleClassement.class);
            query.setParameter("idLigue", idLigue);
            return Optional.ofNullable(query.uniqueResult());
        } catch(Exception e){
            e.printStackTrace();
            return Optional.empty();
        }
    }
}