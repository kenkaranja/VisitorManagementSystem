package Interfaces;

import Entities.Activity;
import Entities.Visitor;

import javax.ejb.Local;
import java.util.List;

@Local
public interface VisitorI {
    boolean add(Visitor visitor);

    boolean checkIn(Visitor visitor, Activity activity);

    Visitor getById(Visitor visitor);

    List<Visitor> viewAll();

    boolean update(Visitor visitor);

    boolean checkOut(Visitor visitor, Activity activity);
}
