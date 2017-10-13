package Interfaces;

import Entities.Activity;

import javax.ejb.Local;

@Local
public interface ActivityI {
    boolean add(Activity activity);

    Activity getById(Activity activity);
}
