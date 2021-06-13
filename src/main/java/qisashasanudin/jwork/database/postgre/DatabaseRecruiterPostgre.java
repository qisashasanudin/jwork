package qisashasanudin.jwork.database.postgre;

import qisashasanudin.jwork.*;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseRecruiterPostgre extends DatabaseConnectionPostgre {

    private static ArrayList<Recruiter> RECRUITER_DATABASE = new ArrayList<>();

    public static ArrayList<Recruiter> getRecruiterDatabase() {
        RECRUITER_DATABASE.clear();
        Connection c = connection();
        PreparedStatement stmt;
        int id;
        String name;
        String email;
        String phoneNumber;
        String province;
        String city;
        String description;

        Recruiter recruiter = null;
        try {
            String sql = "SELECT * FROM recruiter;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                phoneNumber = rs.getString("phone_number");
                province = rs.getString("province");
                city = rs.getString("city");
                description = rs.getString("description");

                recruiter = new Recruiter(id, name, email, phoneNumber, new Location(province, city, description));
                RECRUITER_DATABASE.add(recruiter);
            }
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return RECRUITER_DATABASE;
    }

    public static int getLastId() {
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        try {
            String sql = "SELECT id FROM recruiter;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
            stmt.close();
            c.close();
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public static Recruiter getRecruiterById(int recruiterId) {
        Connection c = connection();
        PreparedStatement stmt;
        int id;
        String name;
        String email;
        String phoneNumber;
        String province;
        String city;
        String description;

        Recruiter recruiter = null;

        try {
            String sql = "SELECT * FROM recruiter WHERE id=?;";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, recruiterId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                phoneNumber = rs.getString("phone_number");
                province = rs.getString("province");
                city = rs.getString("city");
                description = rs.getString("description");
                recruiter = new Recruiter(id, name, email, phoneNumber, new Location(province, city, description));
            }
            stmt.close();
            c.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recruiter;
    }

    public static Recruiter addRecruiter(Recruiter recruiter) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            String sql = "INSERT INTO recruiter (id, name, email, phone_number, province, city, description) VALUES (?,?,?,?,?,?,?) RETURNING id;";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, recruiter.getId());
            stmt.setString(2, recruiter.getName());
            stmt.setString(3, recruiter.getEmail());
            stmt.setString(4, recruiter.getPhoneNumber());
            stmt.setString(6, recruiter.getLocation().getProvince());
            stmt.setString(5, recruiter.getLocation().getCity());
            stmt.setString(7, recruiter.getLocation().getDescription());
            stmt.executeQuery();
            stmt.close();
            c.close();
            return recruiter;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recruiter;
    }

    public static boolean removeRecruiter(int id) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            String sql = "DELETE FROM recruiter WHERE id=?;";
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