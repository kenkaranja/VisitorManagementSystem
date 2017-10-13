package Interfaces;

import Entities.Receptionist;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ReceptionistI {
    boolean add(Receptionist receptionist);

    Receptionist getById(Receptionist receptionist);

    List<Receptionist> viewAll();


}
