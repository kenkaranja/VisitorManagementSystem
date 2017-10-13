package Beans;

import Entities.AuditTrail;
import Entities.Host;
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

@Login(Login.login.HOST)
public class HostLoginBean implements LoginI {
    @PersistenceContext
    EntityManager em;
    @Inject
    private Event<AuditTrailEvent> event;

    @SuppressWarnings("unchecked")
    public boolean login(String username, String password) {
        AuditTrail auditTrail = new AuditTrail();
        AuditTrailEvent auditTrailEvent = new AuditTrailEvent();

        try {
            List<Host> hostList = em.createNamedQuery("LoginHost").setParameter("username", username).setParameter("password", password).getResultList();
            auditTrail.setUsername(username);
            auditTrail.setUserType("Host");
            auditTrail.setDetail("Login");
            auditTrail.setDate(new Date());
            auditTrailEvent.setAuditTrail(auditTrail);
            event.fire(auditTrailEvent);
            return hostList.size() > 0;

        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }
}
