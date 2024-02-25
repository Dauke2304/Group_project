package com.army.controllers;

import com.army.models.Personal_info;
import com.army.models.Registration_info;
import com.army.repositories.interfaces.IPersonal_info_repository;
import com.army.repositories.interfaces.IRegistration_info_repository;

import java.util.List;

public class Registration_info_controller {
    private final IRegistration_info_repository rep;

    public Registration_info_controller(IRegistration_info_repository rep) {
        this.rep = rep;
    }
    public String to_register(String phone_number,String password) {
        Registration_info user = new Registration_info(phone_number,password);
        boolean created = rep.to_register(user);
        return (created ? "Successfully registrated!" : "Registration process was failed!");
    }
    public String getRegistration_info(int id) {
        Registration_info user = rep.getRegistration(id);
        return (user == null ? "User was not found!" : user.toString());
    }
    public boolean isRegistationID(int id) {
        Registration_info user = rep.getRegistration(id);
        return (user== null ? false : true);
    }
    public boolean isRegistationPhone_number(String phone) {
        Registration_info user = rep.getRegistrationByPhone(phone);
        return (user== null ? false : true);
    }
    public int ShowId(String phone){
        Registration_info user = rep.getRegistrationByPhone(phone);
        return user.getId();
    }
    public String getAllRegistrations() {
        List<Registration_info> users = rep.getAllRegistrations();

        StringBuilder answer = new StringBuilder();
        for (Registration_info user : users) {
            answer.append(user.toString()).append("\n");
        }
        return answer.toString();
    }
    public boolean Log_in(String phone, String password){
        Registration_info user = new Registration_info(phone,password);
        boolean logged_in = rep.Log_in(user);
        return logged_in;
    }
    public boolean check_to_admin(String phone, String password){
        Registration_info user = new Registration_info(phone,password);
        return user.isAdmin();
    }
}