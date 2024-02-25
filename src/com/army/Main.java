package com.army;

import com.army.controllers.Medical_info_controller;
import com.army.controllers.Personal_info_controller;
import com.army.controllers.Registration_info_controller;
import com.army.database.postgresql_db;
import com.army.database.postgresql_idb;
import com.army.repositories.Medical_info_Repository;
import com.army.repositories.Personal_info_Repository;
import com.army.repositories.Registration_info_repository;
import com.army.repositories.interfaces.IMedical_info_Repository;
import com.army.repositories.interfaces.IPersonal_info_repository;
import com.army.repositories.interfaces.IRegistration_info_repository;

public class Main {
    public static void main(String[] args) {
        postgresql_idb db = new postgresql_db();
        IPersonal_info_repository prep = new Personal_info_Repository(db);
        Personal_info_controller pcontroller = new Personal_info_controller(prep);
        IMedical_info_Repository mrep =new Medical_info_Repository(db);
        Medical_info_controller mcontroller = new Medical_info_controller(mrep);
        IRegistration_info_repository rrep = new Registration_info_repository(db);
        Registration_info_controller rcontroller = new Registration_info_controller(rrep);
        MainFunctions app = new MainFunctions(pcontroller,mcontroller,rcontroller);
        app.start();
    }
}