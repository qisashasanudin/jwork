package qisashasanudin.jwork.database.postgre;

import qisashasanudin.jwork.Jobseeker;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseJobseekerPostgre extends DatabaseConnectionPostgre {

    private static ArrayList<Jobseeker> JOBSEEKER_DATABASE = new ArrayList<>();

    public static ArrayList<Jobseeker> getJobseekerDatabase() {

        JOBSEEKER_DATABASE.clear();
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        String name = null;
        String email = null;
        String password = null;
        Jobseeker jobseeker = null;
        try {
            String sql = "SELECT * FROM jobseeker;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                password = rs.getString("password");
                jobseeker = new Jobseeker(id, name, email, password);
                JOBSEEKER_DATABASE.add(jobseeker);
            }
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return JOBSEEKER_DATABASE;
    }

    public static Jobseeker addJobseeker(String name, String email, String password) {
        Connection c = connection();
        PreparedStatement stmt;
        Jobseeker jobseeker = null;
        try {
            String sql = "INSERT INTO jobseeker (name, email, password) VALUES (?,?,?) RETURNING id;";
            stmt = c.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            ResultSet rs = stmt.executeQuery();
            int id = 1;
            while (rs.next()) {
                id = rs.getInt(1);
            }
            jobseeker = new Jobseeker(id, name, email, password);
            stmt.close();
            c.close();
            return jobseeker;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jobseeker;
    }

    public static int getLastId() {
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        try {
            String sql = "SELECT id FROM jobseeker;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
            stmt.close();
            c.close();
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public static Jobseeker getJobseeker(int jobseekerId) {
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        String name = null;
        String email = null;
        String password = null;
        Jobseeker jobseeker = null;
        try {
            String sql = "SELECT * FROM jobseeker WHERE id=?;";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, jobseekerId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                password = rs.getString("password");
            }
            stmt.close();
            c.close();
            jobseeker = new Jobseeker(id, name, email, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobseeker;
    }

    public static Jobseeker getJobseeker(String email_new, String password_new) {
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        String name = null;
        String email = null;
        String password = null;
        Jobseeker jobseeker = null;
        try {
            String sql = "SELECT id, name, email, password, joindate FROM jobseeker WHERE email=? AND password=?;";
            stmt = c.prepareStatement(sql);
            stmt.setString(1, email_new);
            stmt.setString(2, password_new);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                password = rs.getString("password");
            }
            stmt.close();
            c.close();
            jobseeker = new Jobseeker(id, name, email, password);
            return jobseeker;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobseeker;
    }

    public static boolean removeJobseeker(int id) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            String sql = "DELETE FROM jobseeker WHERE id=?;";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            c.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}