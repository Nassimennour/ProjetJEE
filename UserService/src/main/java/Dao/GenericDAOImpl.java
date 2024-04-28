package Dao;

import Util.App;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class GenericDAOImpl<T> implements GenericDAO<T> {

    private Class<T> type;

    public GenericDAOImpl(Class<T> type) {
        this.type = type;
    }

    protected <R> R doInTransaction(Function<Session, R> command) {
        Transaction transaction = null;
        R result = null;
        try (Session session = App.getSession()) {
            transaction = session.beginTransaction();
            result = command.apply(session);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void save(T t) {
        doInTransaction(session -> {
            session.save(t);
            return null;
        });
    }

    @Override
    public void update(T t) {
        doInTransaction(session -> {
            session.update(t);
            return null;
        });
    }

    @Override
    public void delete(T t) {
        doInTransaction(session -> {
            session.delete(t);
            return null;
        });
    }

    @Override
    public Optional<T> findById(long id) {
        return Optional.ofNullable(doInTransaction(session -> session.get(type, id)));
    }

    @Override
    public List<T> findAll() {
        List<T> results = doInTransaction(session -> session.createQuery("from " + type.getName(), type).list());
        return results != null ? results : Collections.emptyList();
    }

    @Override
    public boolean existsById(long id) {
        return findById(id).isPresent();
    }
}