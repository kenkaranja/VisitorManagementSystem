package Beans;

import Entities.Receptionist;
import Interfaces.ReceptionistI;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.List;

@Local
@Stateless
public class ReceptionistBean implements ReceptionistI {
    @PersistenceContext
    EntityManager em;

    public boolean add(Receptionist receptionist) {
        try {
            em.persist(receptionist);
            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public Receptionist getById(Receptionist receptionist) {
        try {
            List<Receptionist> receptionistList = em.createNamedQuery("getReceptionistById").setParameter("workid", receptionist.getWorkId()).getResultList();
            return receptionistList.size() > 0 ? receptionistList.get(0) : null;
        } catch (PersistenceException p) {
            p.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Receptionist> viewAll() {
        try {
            return em.createNamedQuery("viewAllReceiptionist").getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        }
    }

}
