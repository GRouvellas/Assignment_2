package grouv.repository;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

public class HibernateUtil<E> {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    
    //creates a session for every connection to the DataBase
    protected Session getSession() {
        session = sessionFactory.getCurrentSession();
        return session;
    }
    
    //Methods for CRUD operations
    protected List<E> findAll(String query){
        getSession();
        Query myQuery = session.createNamedQuery(query);
        List<E> list = myQuery.getResultList();
        return list;
    }
    
    protected E save(E entity){
        session = getSession();
        session.saveOrUpdate(entity);
        return entity;
    }
    
    protected E find(Class<E> type, int id){
        session = getSession();
        E e = session.find(type, id);
        return e;
    }
    
    public void delete(Class<E> type, int id){
        session = getSession();
        E e = session.find(type, id);
        session.remove(e);
    }
    
    
}