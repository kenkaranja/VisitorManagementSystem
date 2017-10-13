package Beans;

import Entities.AuditTrail;
import Interfaces.AuditTrailI;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Local
@Stateless
public class AuditTrailBean implements AuditTrailI {
    @PersistenceContext
    EntityManager em;

    public boolean recordTrail(AuditTrail auditTrail) {
        try {
            em.persist(auditTrail);
            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }
}
