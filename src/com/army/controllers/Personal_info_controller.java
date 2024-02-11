package com.army.controllers;

import com.army.models.Personal_info;
import com.army.repositories.interfaces.IPersonal_info_repository;

import java.util.List;

public class Personal_info_controller {
    private final IPersonal_info_repository rep;

    public Personal_info_controller(IPersonal_info_repository rep) {
    this.rep =rep;
    }
    public String createPerson(String name,String surname, int age) {
    Personal_info person = new Personal_info(name,surname,age);
    boolean created = rep.createPerson(person);
    return (created ? "Person was added!" : "Person addition was failed!");
    }
    public String getPerson(int id) {
        Personal_info person = rep.getPerson(id);

        return (person == null ? "Person was not found!" : person.toString());
    }
    public boolean isPersonID(int id) {
        Personal_info person = rep.getPerson(id);
        return (person == null ? false : true);
    }
    public String getAllpersons() {
        List<Personal_info> persons = rep.getAllpersons();

        StringBuilder answer = new StringBuilder();
        for (Personal_info person : persons) {
            answer.append(person.toString()).append("\n");
        }
        return answer.toString();
    }

}
