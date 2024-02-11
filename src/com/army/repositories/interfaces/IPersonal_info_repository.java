package com.army.repositories.interfaces;

import com.army.models.Personal_info;

import java.util.List;

public interface IPersonal_info_repository {
    boolean createPerson(Personal_info person);
    /*
    Creates new object and inserts his field's information to the database, returns boolean value depending on failure of function
     */
    Personal_info getPerson(int id);
    /*
   Takes information from database and returns value in form of object and fills fields of this object by information from database
    */
    List<Personal_info> getAllpersons();
    /*
    Read all information from database and creates object of this class type for every row of database and contains it all in arraylist and returns it
     */
}
