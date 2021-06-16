package qisashasanudin.jwork.database.postgre;

import qisashasanudin.jwork.Jobseeker;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Praktikum OOP - Program "JWork" - class DatabaseJobseekerPostgre: berfungsi
 * untuk meng-generate dan mengakses database berisi list Jobseeker yang ada
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */
public class DatabaseJobseekerPostgre extends DatabaseConnectionPostgre {
    // instance variable
    private static ArrayList<Jobseeker> JOBSEEKER_DATABASE = new ArrayList<>();

    /**
     * method getJobseekerDatabase, berfungsi sebagai getter untuk mengambil list
     * berisi semua objek yang berada di dalam database
     *
     * @return ArrayList<Jobseeker> JOBSEEKER_DATABASE
     */
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
                joinDateTS = rs.getTimestamp("join_date");
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

    /**
     * method getLastId, berfungsi sebagai getter untuk mengambil id dari objek yang
     * terakhir kali ditambahkan ke database
     *
     * @return int lastId
     */
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    /**
     * method getJobseekerById, berfungsi sebagai getter untuk mengambil salah satu
     * objek menggunakan ID-nya
     *
     * @param jobseekerId
     * @return Jobseeker jobseeeker
     */
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
                joinDateTS = rs.getTimestamp("join_date");
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

    /**
     * method addJobseeker, berfungsi untuk menambah objek baru
     *
     * @param jobseeker
     * @return Jobseeker jobseeker
     */
    public static Jobseeker addJobseeker(Jobseeker jobseeker) {
        Connection c = connection();
        PreparedStatement stmt;
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        try {
            String sql = "INSERT INTO jobseeker (id, name, email, password, join_date) VALUES (?,?,?,?,?) RETURNING id;";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, jobseeker.getId());
            stmt.setString(2, jobseeker.getName());
            stmt.setString(3, jobseeker.getEmail());
            stmt.setString(4, jobseeker.getPassword());
            stmt.setTimestamp(5, ts, jobseeker.getJoinDate());
            stmt.executeQuery();
            stmt.close();
            c.close();
            return jobseeker;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobseeker;
    }

    /**
     * method removeJobseeker, berfungsi untuk menghapus salah satu objek
     * berdasarkan ID-nya
     *
     * @param id
     * @return boolean
     */
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

    /**
     * method getJobseekerLogin, berfungsi sebagai getter untuk mengambil salah satu
     * objek menggunakan email dan password-nya
     *
     * @param email_new
     * @param password_new
     * @return Jobseeker jobseeker
     */
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
            String sql = "SELECT * FROM jobseeker WHERE email=? AND password=?;";
            stmt = c.prepareStatement(sql);
            stmt.setString(1, email_new);
            stmt.setString(2, password_new);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                password = rs.getString("password");
                joinDateTS = rs.getTimestamp("join_date");
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

}