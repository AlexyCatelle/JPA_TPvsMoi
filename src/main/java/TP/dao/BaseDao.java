package TP.dao;

import TP.util.DatabaseManager;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class BaseDao<T> {

    protected final EntityManager em;
    protected final Class<T> tClass;

    public BaseDao(Class<T> tClass) {
        this.em = DatabaseManager.getEntityManager();
        this.tClass = tClass;
    }

    public T save (T element){
        try{
            em.getTransaction().begin();
            em.persist(element);
            em.getTransaction().commit();
            return element;
        }catch (Exception e){
            em.getTransaction().rollback();
            return null;
        }
    }

    public T get (long id){
        return em.find(tClass,id);
    }

    public boolean delete (long id){
        try{
            T elementFound = get(id);
            if(elementFound != null){
                em.getTransaction().begin();
                em.remove(elementFound);
                em.getTransaction().commit();
                return true;
            }
            return false;
        }catch (Exception e){
            em.getTransaction().rollback();
            return false;
        }
    }


    public abstract List<T> get ();

    public abstract T update (T element , long id);


}