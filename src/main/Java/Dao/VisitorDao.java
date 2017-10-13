package Dao;

import Entities.Activity;
import Entities.Visitor;
import Interfaces.ActivityI;
import Interfaces.VisitorI;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

public class VisitorDao  implements VisitorI {
    private EntityManager entityManager;
    @EJB
    ActivityI activityI;


    public VisitorDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public boolean add(Visitor visitor) {
        try {
            entityManager.persist(visitor);
            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }


    }

    @SuppressWarnings("unchecked")
    public Visitor getById(Visitor visitor) {
        try {
            List<Visitor> visitorList = entityManager.createNamedQuery("getVisitorById").setParameter("idNumber", visitor.getIdNumber()).getResultList();
            return visitorList.size() > 0 ? visitorList.get(0) : null;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean checkIn(Visitor visitor, Activity activity) {
        if (getById(visitor) != null) {
            try {
                entityManager.merge(visitor);
                activityI.add(activity);
                return true;
            } catch (PersistenceException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public List<Visitor> viewAll() {
        try {
            return entityManager.createNamedQuery("viewAllVisitors").getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean update(Visitor visitor) {
        try {
            entityManager.merge(visitor);
            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkOut(Visitor visitor, Activity activity) {
        return false;
    }
}
