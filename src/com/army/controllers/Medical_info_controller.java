package com.army.controllers;

import com.army.models.Medical_info;
import com.army.models.Personal_info;
import com.army.repositories.interfaces.IMedical_info_Repository;

import java.util.List;


public class Medical_info_controller {
    private final IMedical_info_Repository rep;

    public Medical_info_controller(IMedical_info_Repository rep) {
        this.rep =rep;
    }
    public String createMedical_info(int id, double height, double weight, double vision) {
        Medical_info med = new Medical_info(id,height,weight,vision);
        boolean created = rep.createMedical_info(med);
        return (created ? "Medical information of candidate was added!" : "Medical information addition was failed!");
    }
    public String getMedical_info(int id){
        Medical_info med= rep.getMedical_info(id);
        return (med== null ? "Medical information by this ID was not found!" : med.toString());
    }
    public String getAllmedical_info() {
        List<Medical_info>meds = rep.getAllmedical_info();

        StringBuilder answer = new StringBuilder();
        for (Medical_info med : meds) {
            answer.append(med.toString()).append("\n");
        }
        return answer.toString();
    }

}
