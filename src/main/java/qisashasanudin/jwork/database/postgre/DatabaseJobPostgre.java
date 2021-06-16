package qisashasanudin.jwork.database.postgre;

import qisashasanudin.jwork.Job;
import qisashasanudin.jwork.JobCategory;
import qisashasanudin.jwork.Recruiter;

import java.sql.*;
import java.util.ArrayList;

/**
 * Praktikum OOP - Program "JWork" - class DatabaseJobPostgre: berfungsi untuk
 * meng-generate dan mengakses database berisi list Job yang ada
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */
public class DatabaseJobPostgre extends DatabaseConnectionPostgre {
    // instance variable
    private static ArrayList<Job> JOB_DATABASE = new ArrayList<>();

    /**
     * method getJobDatabase, berfungsi sebagai getter untuk mengambil list berisi
     * semua objek yang berada di dalam database
     *
     * @return ArrayList<Job> JOB_DATABASE
     */
    public static ArrayList<Job> getJobDatabase() {
        JOB_DATABASE.clear();
        Connection c = connection();
        PreparedStatement stmt;
        Job job;

        int id;
        String name;
        Recruiter recruiter;
        int fee;
        JobCategory category;

        try {
            String sql = "SELECT * FROM job;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                int recruiterId = rs.getInt("recruiter_id");
                recruiter = DatabaseRecruiterPostgre.getRecruiterById(recruiterId);
                fee = rs.getInt("fee");
                category = JobCategory.fromString(rs.getString("category"));
                job = new Job(id, name, fee, category, recruiter);

                JOB_DATABASE.add(job);
            }
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return JOB_DATABASE;
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
            String sql = "SELECT id FROM job;";
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
     * method getJobById, berfungsi sebagai getter untuk mengambil salah satu objek
     * menggunakan ID-nya
     *
     * @param id
     * @return Job job
     */
    public static Job getJobById(int id) {
        Connection c = connection();
        PreparedStatement stmt;
        Job job = null;

        String name;
        Recruiter recruiter;
        int fee;
        JobCategory category;

        try {
            String sql = "SELECT * FROM job WHERE id=?;";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                int recruiterId = rs.getInt("recruiter_id");
                recruiter = DatabaseRecruiterPostgre.getRecruiterById(recruiterId);
                fee = rs.getInt("fee");
                category = JobCategory.fromString(rs.getString("category"));
                job = new Job(id, name, fee, category, recruiter);
            }
            stmt.close();
            c.close();
            return job;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return job;
    }

    /**
     * method getJobByRecruiter, berfungsi sebagai getter untuk mengambil salah satu
     * objek berdasarkan ID dari recruiter yang membuat Job tersebut
     *
     * @param jobseekerId
     * @return ArrayList<Job> jobs
     */
    public static ArrayList<Job> getJobByRecruiter(int recruiterId) {
        Connection c = connection();
        PreparedStatement stmt;
        ArrayList<Job> jobs = new ArrayList<>();

        Job job = null;
        int id;
        String name;
        Recruiter recruiter;
        int fee;
        JobCategory category;

        try {
            String sql = "SELECT * FROM job WHERE recruiterId=?;";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, recruiterId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                recruiterId = rs.getInt("recruiter_id");
                recruiter = DatabaseRecruiterPostgre.getRecruiterById(recruiterId);
                fee = rs.getInt("fee");
                category = JobCategory.fromString(rs.getString("category"));

                job = new Job(id, name, fee, category, recruiter);
                jobs.add(job);
            }
            stmt.close();
            c.close();
            return jobs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobs;
    }

    /**
     * method getJobByRecruiter, berfungsi sebagai getter untuk mengambil salah satu
     * job berdasarkan kategorinya
     *
     * @param category
     * @return ArrayList<Job> jobs
     */
    public static ArrayList<Job> getJobByCategory(JobCategory category) {
        Connection c = connection();
        PreparedStatement stmt;
        ArrayList<Job> jobs = new ArrayList<>();

        Job job = null;
        int id;
        String name;
        Recruiter recruiter;

        int fee;

        try {
            String sql = "SELECT * FROM job WHERE category=?;";
            stmt = c.prepareStatement(sql);
            stmt.setString(1, category.toString());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                int recruiterId = rs.getInt("recruiter_id");
                recruiter = DatabaseRecruiterPostgre.getRecruiterById(recruiterId);
                fee = rs.getInt("fee");
                category = JobCategory.fromString(rs.getString("category"));

                job = new Job(id, name, fee, category, recruiter);
                jobs.add(job);
            }
            stmt.close();
            c.close();
            return jobs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobs;
    }

    /**
     * method addJob, berfungsi untuk menambah objek baru
     *
     * @param job
     * @return Job job
     */
    public static Job addJob(Job job) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            String sql = "INSERT INTO job (id, name, fee, category, recruiter_id) VALUES (?,?,?,?,?) RETURNING id;";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, job.getId());
            stmt.setString(2, job.getName());
            stmt.setInt(3, job.getFee());
            stmt.setString(4, job.getCategory().toString());
            stmt.setInt(5, job.getRecruiter().getId());
            stmt.executeQuery();
            stmt.close();
            c.close();
            return job;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return job;
    }

    /**
     * method removeJob, berfungsi untuk menghapus salah satu objek berdasarkan
     * ID-nya
     *
     * @param id
     * @return boolean
     */
    public static boolean removeJob(int id) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            String sql = "DELETE FROM job WHERE id=?;";
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