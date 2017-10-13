package Beans;

import Entities.Host;
import Interfaces.HostI;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Local
@Stateless
public class HostBean extends CustomBean implements HostI {
    @PersistenceContext
    EntityManager em;

    public boolean add(Host host) {
        return addC(host);
    }

    public boolean logIn(Host host) {
        return false;
    }
}
