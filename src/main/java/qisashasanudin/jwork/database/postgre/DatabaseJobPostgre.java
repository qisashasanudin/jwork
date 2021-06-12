package qisashasanudin.jwork.database.postgre;

import qisashasanudin.jwork.Job;
import qisashasanudin.jwork.JobCategory;
import qisashasanudin.jwork.Recruiter;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseJobPostgre extends DatabaseConnectionPostgre {

    private static ArrayList<Job> JOB_DATABASE = new ArrayList<>();

    public static ArrayList<Job> getJobDatabase() {
        JOB_DATABASE.clear();
        Connection c = connection();
        PreparedStatement stmt;
        Job job;

        int id;
        String name;
        Recruiter recruiter;
        int recruiterId;
        int fee;
        JobCategory category;

        try {
            String sql = "SELECT * FROM job;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                recruiterId = rs.getInt("recruiterId");
                fee = rs.getInt("fee");
                category = JobCategory.valueOf(rs.getString("category"));
                recruiter = DatabaseRecruiterPostgre.getRecruiterById(recruiterId);
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

    public static Job getJobById(int id) {
        Connection c = connection();
        PreparedStatement stmt;
        Job job = null;

        String name;
        Recruiter recruiter;
        int recruiterId;
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
                recruiterId = rs.getInt("recruiterId");
                fee = rs.getInt("fee");
                category = JobCategory.valueOf(rs.getString("category"));
                recruiter = DatabaseRecruiterPostgre.getRecruiterById(recruiterId);
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
                recruiterId = rs.getInt("recruiterId");
                fee = rs.getInt("fee");
                category = JobCategory.valueOf(rs.getString("category"));
                recruiter = DatabaseRecruiterPostgre.getRecruiterById(recruiterId);
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

    public static ArrayList<Job> getJobByCategory(JobCategory category) {
        Connection c = connection();
        PreparedStatement stmt;
        ArrayList<Job> jobs = new ArrayList<>();

        Job job = null;
        int id;
        String name;
        Recruiter recruiter;
        int recruiterId;
        int fee;

        try {
            String sql = "SELECT * FROM job WHERE category=?;";
            stmt = c.prepareStatement(sql);
            stmt.setString(1, category.toString());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                recruiterId = rs.getInt("recruiterId");
                fee = rs.getInt("fee");
                category = JobCategory.valueOf(rs.getString("category"));
                recruiter = DatabaseRecruiterPostgre.getRecruiterById(recruiterId);
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

    public static Job addJob(String name, int fee, JobCategory category, Recruiter recruiter) {
        Connection c = connection();
        PreparedStatement stmt;
        int id = getLastId() + 1;
        Job job = null;
        try {
            job = new Job(id, name, fee, category, recruiter);
            String sql = "INSERT INTO job (id, name, fee, category, recruiter) VALUES (?,?,?,?,?) RETURNING id;";
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