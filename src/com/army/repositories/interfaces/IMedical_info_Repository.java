package com.army.repositories.interfaces;


import com.army.models.Medical_info;

import java.util.List;

public interface IMedical_info_Repository {
    boolean createMedical_info(Medical_info med);
    /*
    Creates new object and inserts his field's information to the database, returns boolean value depending on failure of function
     */
    Medical_info getMedical_info(int id);
    /*
    Takes information from database and returns value in form of object and fills fields of this object by information from database
     */
    List<Medical_info> getAllmedical_info();
    /*
    Read all information from database and creates object of this class type for every row of database and contains it all in arraylist and returns it
     */
}

