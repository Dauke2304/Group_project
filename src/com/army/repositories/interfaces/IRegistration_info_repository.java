package com.army.repositories.interfaces;

import com.army.models.Personal_info;
import com.army.models.Registration_info;

import java.util.List;

public interface IRegistration_info_repository {
    boolean to_register(Registration_info user);
    /*
    Creates new object and inserts his field's information to the database, returns boolean value depending on failure of function
     */
    Registration_info getRegistration(int id);
    /*
   Takes information from database and returns value in form of object and fills fields of this object by information from database
    */
    List<Registration_info> getAllRegistrations();
    /*
    Read all information from database and creates object of this class type for every row of database and contains it all in arraylist and returns it
     */
    boolean Log_in(Registration_info user);
    public Registration_info getRegistrationByPhone(String phone);
}
