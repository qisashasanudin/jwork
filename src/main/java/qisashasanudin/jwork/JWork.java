package qisashasanudin.jwork;

import java.sql.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import qisashasanudin.jwork.database.postgre.DatabaseConnectionPostgre;
import qisashasanudin.jwork.database.postgre.DatabaseJobPostgre;
import qisashasanudin.jwork.database.postgre.DatabaseRecruiterPostgre;

@SpringBootApplication
public class JWork {

        public static void main(String[] args) {
                // TODO: buat JavaDoc

                Location loc1 = new Location("Jawa Barat", "Sukabumi", "Cikole");
                // Location loc2 = new Location("DKI Jakarta", "Jakarta Selatan", "Kemang");
                // Location loc3 = new Location("Jawa Barat", "Depok", "Kukusan");

                Connection c = null;
                Statement stmt = null;
                String sql = "";
                try {
                        c = DatabaseConnectionPostgre.connection();
                        stmt = c.createStatement();

                        sql = sql + "CREATE TABLE IF NOT EXISTS bonus (";
                        sql = sql + "id                 INT PRIMARY KEY NOT NULL, ";
                        sql = sql + "referral_code      VARCHAR(50) UNIQUE NOT NULL, ";
                        sql = sql + "extra_fee          INT NOT NULL, ";
                        sql = sql + "min_total_fee      INT NOT NULL, ";
                        sql = sql + "active             BOOLEAN NOT NULL";
                        sql = sql + ");";

                        sql = sql + "CREATE TABLE IF NOT EXISTS jobseeker (";
                        sql = sql + "id                 INT PRIMARY KEY NOT NULL, ";
                        sql = sql + "name               VARCHAR(50) NOT NULL, ";
                        sql = sql + "email              VARCHAR(50) NOT NULL, ";
                        sql = sql + "password           VARCHAR(50) NOT NULL, ";
                        sql = sql + "join_date          TIMESTAMP NOT NULL";
                        sql = sql + ");";

                        sql = sql + "CREATE TABLE IF NOT EXISTS recruiter (";
                        sql = sql + "id                 INT PRIMARY KEY NOT NULL, ";
                        sql = sql + "name               VARCHAR(50) NOT NULL, ";
                        sql = sql + "email              VARCHAR(50) NOT NULL, ";
                        sql = sql + "phone_number       VARCHAR(50), ";
                        sql = sql + "province           VARCHAR(50), ";
                        sql = sql + "city               VARCHAR(50), ";
                        sql = sql + "description        VARCHAR(50)";
                        sql = sql + ");";

                        sql = sql + "CREATE TABLE IF NOT EXISTS job (";
                        sql = sql + "id                 INT PRIMARY KEY NOT NULL, ";
                        sql = sql + "name               VARCHAR(50) NOT NULL, ";
                        sql = sql + "fee                VARCHAR(50) NOT NULL, ";
                        sql = sql + "category           VARCHAR(50) NOT NULL, ";
                        sql = sql + "recruiter_id       INT REFERENCES recruiter(id) NOT NULL";
                        sql = sql + ");";

                        sql = sql + "CREATE TABLE IF NOT EXISTS invoice (";
                        sql = sql + "id                 INT PRIMARY KEY NOT NULL, ";
                        sql = sql + "job_ids            INTEGER[] NOT NULL, ";
                        sql = sql + "date               TIMESTAMP NOT NULL, ";
                        sql = sql + "total_fee          INT NOT NULL, ";
                        sql = sql + "jobseeker_id       INT REFERENCES jobseeker(id) NOT NULL, ";
                        sql = sql + "invoice_status     VARCHAR(50) NOT NULL, ";
                        sql = sql + "payment_type       VARCHAR(50) NOT NULL, ";
                        sql = sql + "admin_fee          INT, ";
                        sql = sql + "referral_code      VARCHAR(50) REFERENCES bonus(referral_code)";
                        sql = sql + ");";

                        stmt.executeUpdate(sql);
                        stmt.close();
                        c.close();
                } catch (SQLException e) {
                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
                        System.exit(0);
                }

//                Recruiter recruiter1 = new Recruiter(DatabaseRecruiterPostgre.getLastId()+1, "Hary", "hary@ui.ac.id",
//                                "081234567890", loc1);
//                DatabaseRecruiterPostgre.addRecruiter(recruiter1);
//
//                Job job1 = new Job(DatabaseJobPostgre.getLastId()+1, "Mobile Developer", 7000000, JobCategory.FrontEnd,
//                                DatabaseRecruiterPostgre.getRecruiterById(1));
//                DatabaseJobPostgre.addJob(job1);
//
//                Job job2 = new Job(DatabaseJobPostgre.getLastId()+1, "Data Analyst", 8000000, JobCategory.BackEnd,
//                                DatabaseRecruiterPostgre.getRecruiterById(1));
//                DatabaseJobPostgre.addJob(job2);

                SpringApplication.run(JWork.class, args);
        }
}
