package qisashasanudin.jwork.database.postgre;

import qisashasanudin.jwork.Jobseeker;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Calendar;

public class DatabaseJobseekerPostgre extends DatabaseConnectionPostgre {

    private static ArrayList<Jobseeker> JOBSEEKER_DATABASE = new ArrayList<>();

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

    public static ArrayList<Jobseeker> getJobseekerDatabase() {
        JOBSEEKER_DATABASE.clear();
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        String name = null;
        String email = null;
        String password = null;
        Timestamp joinDateTS = null;
        Calendar joinDate = Calendar.getInstance();
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
                joinDateTS = rs.getTimestamp("joindate");
                joinDate.setTimeInMillis(joinDateTS.getTime());
                jobseeker = new Jobseeker(id, name, email, password, joinDate);
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
        int id = getLastId();
        Jobseeker jobseeker = null;
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        try {
            jobseeker = new Jobseeker(id, name, email, password);
            String sql = "INSERT INTO jobseeker (id, name, email, password, joindate) VALUES (?,?,?,?,?) RETURNING id;";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, jobseeker.getId());
            stmt.setString(2, jobseeker.getName());
            stmt.setString(3, jobseeker.getEmail());
            stmt.setString(4, jobseeker.getPassword());
            stmt.setTimestamp(5, ts, jobseeker.getJoinDate());
            ResultSet rs = stmt.executeQuery();
            stmt.close();
            c.close();
            return jobseeker;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jobseeker;
    }

    public static Jobseeker getJobseekerById(int jobseekerId) {
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        String name = null;
        String email = null;
        String password = null;
        Timestamp joinDateTS = null;
        Calendar joinDate = Calendar.getInstance();
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
                joinDateTS = rs.getTimestamp("joindate");
                joinDate.setTimeInMillis(joinDateTS.getTime());
            }
            stmt.close();
            c.close();
            jobseeker = new Jobseeker(id, name, email, password, joinDate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobseeker;
    }

    public static Jobseeker getJobseekerLogin(String email_new, String password_new) {
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        String name = null;
        String email = null;
        String password = null;
        Timestamp joinDateTS = null;
        Calendar joinDate = Calendar.getInstance();
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
                joinDateTS = rs.getTimestamp("joindate");
                joinDate.setTimeInMillis(joinDateTS.getTime());
            }
            stmt.close();
            c.close();
            jobseeker = new Jobseeker(id, name, email, password, joinDate);
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