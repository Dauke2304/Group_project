package com.army.models;

public class Personal_info extends ID{
    private String name;
    private String surname;
    private int age;

    public Personal_info(String name, String surname, int age){
        setName(name);
        setAge(age);
        setSurname(surname);
    }
    public Personal_info(int id, String name, String surname, int age){
        super(id);
        setName(name);
        setAge(age);
        setSurname(surname);
    }

    @Override
    public String toString() {
        return "Candidate №" +getId()+
                " Name: " + name + 
                " Surname: " + surname  +
                " Age: " + age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
