package Beans;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

public class CustomBean<T> {
    @PersistenceContext
    EntityManager em;

    public boolean addC(T t) {
        try {
            em.persist(t);
            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }

    }
}
