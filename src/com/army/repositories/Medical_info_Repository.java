package com.army.repositories;

import com.army.models.Medical_info;
import com.army.repositories.interfaces.IMedical_info_Repository;
import com.army.database.postgresql_idb;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Medical_info_Repository implements IMedical_info_Repository {
    private final postgresql_idb db;

    public Medical_info_Repository(postgresql_idb db) {
        this.db = db;
    }

    @Override
    public boolean createMedical_info(Medical_info med) {
        Connection cn = null;
        try {
            cn = db.getConnection();
            String sql = "INSERT INTO medical_info(id, height, weight, vision, fit_to_army) VALUES (?,?,?,?,?)";
            PreparedStatement st = cn.prepareStatement(sql);

            st.setInt(1, med.getId());
            st.setDouble(2, med.getHeight());
            st.setDouble(3, med.getWeight());
            st.setDouble(4, med.getVision());
            st.setBoolean(5, med.isFit_to_army());

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
    public Medical_info getMedical_info(int id) {
        Connection cn = null;

        try {
            cn = db.getConnection();
            String sql = "SELECT id, height, weight, vision, fit_to_army FROM medical_info WHERE id=?";
            PreparedStatement st = cn.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Medical_info(
                        rs.getInt("id"),
                        rs.getDouble("height"),
                        rs.getDouble("weight"),
                        rs.getDouble("vision"),
                        rs.getBoolean("fit_to_army")
                );
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
    @Override
    public  List<Medical_info> getAllmedical_info(){
        Connection cn= null;

        try {
            cn = db.getConnection();
            String sql = "SELECT id,height,weight,vision,fit_to_army FROM medical_info";
            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Medical_info> meds = new LinkedList<>();
            while (rs.next()) {
                Medical_info med = new Medical_info(
                        rs.getInt("id"),
                        rs.getDouble("height"),
                        rs.getDouble("weight"),
                        rs.getDouble("vision"),
                        rs.getBoolean("fit_to_army"));
                meds.add(med);
            }

            return meds;
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
