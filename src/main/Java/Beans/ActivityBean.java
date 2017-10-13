package Beans;

import Entities.Activity;
import Interfaces.ActivityI;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.List;

@Local
@Stateless
public class ActivityBean implements ActivityI {
    @PersistenceContext
    private EntityManager em;

    public boolean add(Activity activity) {
        try {
            em.persist(activity);
            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }


    @SuppressWarnings("unchecked")
    public Activity getById(Activity activity) {
        try {
            List<Activity> activityList = em.createNamedQuery("getActivityById").setParameter("visit", activity.getVisitor()).getResultList();
            return activityList.size() > 0 ? activityList.get(0) : null;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        }
    }
}
