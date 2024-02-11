package com.army.repositories.interfaces;

import com.army.models.Personal_info;

import java.util.List;

public interface IPersonal_info_repository {
    boolean createPerson(Personal_info person);
    Personal_info getPerson(int id);
    List<Personal_info> getAllpersons();
}
