package com.army.repositories.interfaces;


import com.army.models.Medical_info;

import java.util.List;

public interface IMedical_info_Repository {
    boolean createMedical_info(Medical_info med);

    Medical_info getMedical_info(int id);
    List<Medical_info> getAllmedical_info();
}

