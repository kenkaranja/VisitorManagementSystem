package Beans;

import Entities.AuditTrail;
import Entities.Receptionist;
import Events.AuditTrailEvent;
import Interfaces.LoginI;
import Qualifier.Login;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.Date;
import java.util.List;

@Login(Login.login.RECEPTIONIST)
public class ReceptionistLoginBean implements LoginI {
    @PersistenceContext
    EntityManager em;

    @Inject
    private Event<AuditTrailEvent> event;

    @SuppressWarnings("unchecked")
    public boolean login(String username, String password) {
        AuditTrail auditTrail = new AuditTrail();
        AuditTrailEvent evente = new AuditTrailEvent();
        try {
            List<Receptionist> receptionistList = em.createNamedQuery("loginReceptionist").setParameter("username", username).setParameter("password", password).getResultList();
            auditTrail.setUsername(username);
            auditTrail.setUserType("Receptionist");
            auditTrail.setDetail("Login");
            auditTrail.setDate(new Date());
            evente.setAuditTrail(auditTrail);
            event.fire(evente);
            return receptionistList.size() > 0;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }
}
