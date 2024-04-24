package Dao;

import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenericDAOImpl<T> implements GenericDAO<T>{
    private Class<T> type;

    public GenericDAOImpl(Class<T> type){
        this.type = type;
    }

    @Override
    public void save(T t){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSession()){
            transaction = session.beginTransaction();
            session.save(t);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Optional<T> findById(long id){
        Transaction transaction = null;
        T t = null;
        try(Session session = HibernateUtil.getSession()){
            transaction = session.beginTransaction();
            t = session.get(type, id);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return Optional.ofNullable(t);
    }

    @Override
    public List<T> findAll(){
        Transaction transaction = null;
        List<T> t = null;
        try(Session session = HibernateUtil.getSession()){
            transaction = session.beginTransaction();
            t = session.createQuery("from "+type.getName()).list();
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        if(t == null){
            return new ArrayList<T>();
        }
        return t;
    }
    @Override
    public void update(T t){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSession()){
            transaction = session.beginTransaction();
            session.update(t);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    @Override
    public void delete(T t){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSession()){
            transaction = session.beginTransaction();
            session.delete(t);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
