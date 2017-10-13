package Beans;

import Dao.VisitorDao;
import Entities.Activity;
import Entities.Visitor;
import Interfaces.ActivityI;
import Interfaces.VisitorI;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Local
@Stateless
@Path("/visitorBean")
public class VisitorBean extends CustomBean<Visitor> implements VisitorI {
    @PersistenceContext
    private EntityManager em;

    @EJB
    private ActivityI activityI;


    public boolean add(Visitor visitor) {
        return this.addC(visitor);
    }

    public boolean checkIn(Visitor visitor, Activity activity) {
        VisitorDao visitorDao = new VisitorDao(em);
        return visitorDao.checkIn(visitor, activity);
    }

    public Visitor getById(Visitor visitor) {
        VisitorDao visitor1 = new VisitorDao(em);
        return visitor1.getById(visitor);
    }

    @Path("/viewAllVisitors")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Visitor> viewAll() {
        VisitorDao visitorDao = new VisitorDao(em);
        return visitorDao.viewAll();
    }

    public boolean update(Visitor visitor) {
        try {
            em.merge(visitor);
            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkOut(Visitor visitor, Activity activity) {
        if (getById(visitor) != null) {
            try {
                em.merge(visitor);
                activityI.add(activity);
                return true;
            } catch (PersistenceException e) {
                e.printStackTrace();
                return false;
            }

        }
        return false;
    }


}
