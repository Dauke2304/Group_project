package com.army.models;

public class Registration_info extends ID {
    private String phone_number;
    private String password;
    private boolean admin;

    public Registration_info() {
    }

    public Registration_info(String phone_number, String password) {
        this.phone_number = phone_number;
        this.password = password;
        this.admin = isDefaultAdmin(phone_number, password);
    }

    public Registration_info(int id, String phone_number, String password, boolean admin) {
        super(id);
        this.phone_number = phone_number;
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Registration_info{" +
                "phone_number='" + phone_number + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                '}';
    }

    public boolean isDefaultAdmin(String phone_number, String password) {
        return phone_number.equals("7077405280") && password.equals("did12321");
    }
}