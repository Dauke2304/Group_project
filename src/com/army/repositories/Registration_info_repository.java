package com.army.repositories;

import com.army.database.postgresql_idb;
import com.army.models.Personal_info;
import com.army.models.Registration_info;
import com.army.repositories.interfaces.IRegistration_info_repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Registration_info_repository implements IRegistration_info_repository {
    private final postgresql_idb db;
    public Registration_info_repository(postgresql_idb db) {
        this.db = db;
    }

    @Override
    public boolean to_register(Registration_info user) {
        try (Connection cn = db.getConnection();
             PreparedStatement st = cn.prepareStatement(
                     "INSERT INTO registration_info(phone_number, password, admin) VALUES (?, ?, ?) RETURNING id")) {

            st.setString(1, user.getPhone_number());
            st.setString(2, user.getPassword());
            st.setBoolean(3, user.isAdmin());

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    user.setId(rs.getInt("id"));
                    return true;
                }
            }
        } catch (SQLException e) {
            // Handle the exception appropriately, log or throw a custom exception
            System.out.println("SQL error: " + e.getMessage());
        }
        return false;
    }

    @Override
    public Registration_info getRegistration(int id) {
        try (Connection cn = db.getConnection();
             PreparedStatement st = cn.prepareStatement(
                     "SELECT id, phone_number, password, admin FROM registration_info WHERE id=?"))
        {

            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return new Registration_info(
                            rs.getInt("id"),
                            rs.getString("phone_number"),
                            rs.getString("password"),
                            rs.getBoolean("admin"));
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Registration_info> getAllRegistrations() {
        try (Connection cn = db.getConnection();
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery("SELECT id, phone_number, password, admin FROM registration_info")) {

            List<Registration_info> users = new LinkedList<>();
            while (rs.next()) {
                Registration_info user = new Registration_info(
                        rs.getInt("id"),
                        rs.getString("phone_number"),
                        rs.getString("password"),
                        rs.getBoolean("admin"));
                users.add(user);
            }

            return users;
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        }
        return null;
    }
    @Override
    public boolean Log_in(Registration_info user) {
        try (Connection cn = db.getConnection();
             PreparedStatement st = cn.prepareStatement("SELECT password FROM registration_info WHERE phone_number=?")) {

            st.setString(1, user.getPhone_number());

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    String storedPassword = rs.getString("password");

                    if (storedPassword != null && storedPassword.equals(user.getPassword())) {
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error during login: "+ e.getMessage());
        }
        return false;
    }
    @Override
    public Registration_info getRegistrationByPhone(String phone) {
        try (Connection cn = db.getConnection();
             PreparedStatement st = cn.prepareStatement(
                     "SELECT id, phone_number, password, admin FROM registration_info WHERE phone_number=?"))
        {

            st.setString(1, phone);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return new Registration_info(
                            rs.getInt("id"),
                            rs.getString("phone_number"),
                            rs.getString("password"),
                            rs.getBoolean("admin"));
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        }
        return null;
    }


}
