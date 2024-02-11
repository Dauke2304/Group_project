//information about each functions below written in the interface where this class implements
package com.army.repositories;

import com.army.database.postgresql_idb;
import com.army.models.Personal_info;
import com.army.repositories.interfaces.IPersonal_info_repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
public class Personal_info_Repository implements IPersonal_info_repository {
    private final postgresql_idb db;

    public Personal_info_Repository(postgresql_idb db) {
        this.db = db;
    }
    @Override
    public boolean createPerson(Personal_info person){
        Connection cn = null;
        try {
            cn = db.getConnection();
            String sql = "INSERT INTO personal_info(name,surname,age) VALUES (?,?,?)";
            PreparedStatement st = cn.prepareStatement(sql);

            st.setString(1, person.getName());
            st.setString(2, person.getSurname());
            st.setInt(3, person.getAge());

            st.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        } finally {
            try {
                if (cn != null)
                    cn.close();
            } catch (SQLException e) {
                System.out.println("SQL error: " + e.getMessage());
            }
        }
        return false;
    }
    @Override
    public Personal_info getPerson(int id) {
        Connection cn = null;

        try {
            cn = db.getConnection();
            String sql = "SELECT id,name,surname,age FROM personal_info WHERE id=?";
            PreparedStatement st = cn.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Personal_info(rs.getInt("id"), rs.getString("name"), rs.getString("surname"), rs.getInt("age"));
            }
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        } finally {
            try {
                if (cn != null)
                    cn.close();
            } catch (SQLException e) {
                System.out.println("SQL error: " + e.getMessage());
            }
        }

        return null;
    }

    public List<Personal_info> getAllpersons(){
        Connection cn= null;

        try {
            cn = db.getConnection();
            String sql = "SELECT id,name,surname,age FROM personal_info";
            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Personal_info> users = new LinkedList<>();
            while (rs.next()) {
                Personal_info user = new Personal_info(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getInt("age"));
                users.add(user);
            }

            return users;
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        } finally {
            try {
                if (cn != null)
                    cn.close();
            } catch (SQLException e) {
                System.out.println("SQL error: " + e.getMessage());
            }
        }
        return null;
    }
}
