package Dao;

import Util.App;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenericDaoImpl<T> implements GenericDao<T> {
    private Class<T> type;

    public GenericDaoImpl(Class<T> type) {
        this.type = type;
    }

    @Override
    public void save(T t) {
        Transaction transaction = null;
        try (Session session = App.getSession()) {
            transaction = session.beginTransaction();
            session.save(t);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void update(T t) {
        Transaction transaction = null;
        try (Session session = App.getSession()) {
            transaction = session.beginTransaction();
            session.update(t);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(T t) {
        Transaction transaction = null;
        try (Session session = App.getSession()) {
            transaction = session.beginTransaction();
            session.delete(t);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Optional<T> findById(long id) {
        try (Session session = App.getSession()) {
            return Optional.ofNullable(session.get(type, id));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<T> findAll() {
        try (Session session = App.getSession()) {
            Query<T> query = session.createQuery("from " + type.getName(), type);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}