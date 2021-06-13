package qisashasanudin.jwork.database.postgre;

import qisashasanudin.jwork.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

public class DatabaseInvoicePostgre extends DatabaseConnectionPostgre {

    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<>();

    public static ArrayList<Invoice> getInvoiceDatabase() {
        INVOICE_DATABASE.clear();
        Connection c = connection();
        PreparedStatement stmt;
        Invoice invoice;

        int id = 0;

        Timestamp dateTS = null;
        Calendar date = Calendar.getInstance();
        int totalFee = 0;
        int jobseekerId = 0;
        InvoiceStatus INVOICE_STATUS;
        PaymentType PAYMENT_TYPE;
        int adminFee = 0;
        String referralCode = "";

        try {
            String sql = "SELECT * FROM invoice;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ArrayList<Job> jobs = new ArrayList<>();
                id = rs.getInt("id");
                Array jobIds = rs.getArray("job_ids");
                Integer[] int_jobIds = (Integer[]) jobIds.getArray();
                for (int i : int_jobIds) {
                    System.out.println(i);
                    jobs.add(DatabaseJobPostgre.getJobById(i));
                }

                dateTS = rs.getTimestamp("date");
                date.setTimeInMillis(dateTS.getTime());
                totalFee = rs.getInt("total_fee");
                jobseekerId = rs.getInt("jobseeker_id");
                INVOICE_STATUS = InvoiceStatus.fromString(rs.getString("invoice_status"));
                PAYMENT_TYPE = PaymentType.fromString(rs.getString("payment_type"));
                adminFee = rs.getInt("admin_fee");
                referralCode = rs.getString("referral_code");

                if (PAYMENT_TYPE.equals(PaymentType.BankPayment)) {
                    invoice = new BankPayment(id, jobs, DatabaseJobseekerPostgre.getJobseekerById(jobseekerId),
                            adminFee, totalFee, INVOICE_STATUS);
                    INVOICE_DATABASE.add(invoice);
                } else if (PAYMENT_TYPE.equals(PaymentType.EwalletPayment)) {
                    invoice = new EwalletPayment(id, jobs, DatabaseJobseekerPostgre.getJobseekerById(jobseekerId),
                            DatabaseBonusPostgre.getBonusByRefferalCode(referralCode), totalFee, INVOICE_STATUS);
                    INVOICE_DATABASE.add(invoice);
                }

            }
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return INVOICE_DATABASE;
    }

    public static int getLastId() {
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        try {
            String sql = "SELECT id FROM invoice;";
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

    public static Invoice getInvoiceById(int id) {
        Connection c = connection();
        PreparedStatement stmt;
        Invoice invoice = null;

        Timestamp dateTS = null;
        Calendar date = Calendar.getInstance();
        int totalFee = 0;
        int jobseekerId = 0;
        InvoiceStatus INVOICE_STATUS;
        PaymentType PAYMENT_TYPE;
        int adminFee = 0;
        String referralCode = "";

        try {
            String sql = "SELECT * FROM invoice WHERE id=?;";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ArrayList<Job> jobs = new ArrayList<>();
                id = rs.getInt("id");

                Array jobIds = rs.getArray("job_ids");
                Integer[] int_jobIds = (Integer[]) jobIds.getArray();
                for (int i : int_jobIds) {
                    jobs.add(DatabaseJobPostgre.getJobById(i));
                }

                dateTS = rs.getTimestamp("date");
                date.setTimeInMillis(dateTS.getTime());
                totalFee = rs.getInt("total_fee");
                jobseekerId = rs.getInt("jobseeker_id");
                INVOICE_STATUS = InvoiceStatus.fromString(rs.getString("invoice_status"));
                PAYMENT_TYPE = PaymentType.fromString(rs.getString("payment_type"));
                adminFee = rs.getInt("admin_fee");
                referralCode = rs.getString("referral_code");

                if (PAYMENT_TYPE.equals(PaymentType.BankPayment)) {
                    invoice = new BankPayment(id, jobs, DatabaseJobseekerPostgre.getJobseekerById(jobseekerId),
                            adminFee, totalFee, INVOICE_STATUS);
                } else if (PAYMENT_TYPE.equals(PaymentType.EwalletPayment)) {
                    invoice = new EwalletPayment(id, jobs, DatabaseJobseekerPostgre.getJobseekerById(jobseekerId),
                            DatabaseBonusPostgre.getBonusByRefferalCode(referralCode), totalFee, INVOICE_STATUS);

                }
            }
            stmt.close();
            c.close();
            return invoice;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoice;
    }

    public static ArrayList<Invoice> getInvoiceByJobseeker(int jobseekerId) {
        INVOICE_DATABASE.clear();
        Connection c = connection();
        PreparedStatement stmt;
        Invoice invoice;

        int id = 0;
        Timestamp dateTS = null;
        Calendar date = Calendar.getInstance();
        int totalFee = 0;
        InvoiceStatus INVOICE_STATUS;
        PaymentType PAYMENT_TYPE;
        int adminFee = 0;
        String referralCode = "";

        try {
            String sql = "SELECT * FROM invoice WHERE jobseeker_id=?;";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, jobseekerId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ArrayList<Job> jobs = new ArrayList<>();
                id = rs.getInt("id");

                Array jobIds = rs.getArray("job_ids");
                Integer[] int_jobIds = (Integer[]) jobIds.getArray();
                for (int i : int_jobIds) {
                    jobs.add(DatabaseJobPostgre.getJobById(i));
                }

                dateTS = rs.getTimestamp("date");
                date.setTimeInMillis(dateTS.getTime());
                totalFee = rs.getInt("total_fee");
                jobseekerId = rs.getInt("jobseeker_id");
                INVOICE_STATUS = InvoiceStatus.fromString(rs.getString("invoice_status"));
                PAYMENT_TYPE = PaymentType.fromString(rs.getString("payment_type"));
                adminFee = rs.getInt("admin_fee");
                referralCode = rs.getString("referral_code");

                if (PAYMENT_TYPE.equals(PaymentType.BankPayment)) {
                    invoice = new BankPayment(id, jobs, DatabaseJobseekerPostgre.getJobseekerById(jobseekerId),
                            adminFee, totalFee, INVOICE_STATUS);
                    INVOICE_DATABASE.add(invoice);
                } else if (PAYMENT_TYPE.equals(PaymentType.EwalletPayment)) {
                    invoice = new EwalletPayment(id, jobs, DatabaseJobseekerPostgre.getJobseekerById(jobseekerId),
                            DatabaseBonusPostgre.getBonusByRefferalCode(referralCode), totalFee, INVOICE_STATUS);
                    INVOICE_DATABASE.add(invoice);
                }
            }
            stmt.close();
            c.close();
            return INVOICE_DATABASE;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return INVOICE_DATABASE;
    }

    public static Invoice addInvoice(BankPayment invoice) {
        Connection c = connection();
        PreparedStatement stmt;
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        try {
            String sql = "INSERT INTO invoice (id, job_ids, date, total_fee, jobseeker_id, invoice_status, payment_type, admin_fee) VALUES (?,?,?,?,?,?,?,?) RETURNING id;";
            stmt = c.prepareStatement(sql);

            stmt.setInt(1, invoice.getId());

            ArrayList<Integer> temp1 = new ArrayList<>();
            for (Job job : invoice.getJobs()) {
                temp1.add(job.getId());
            }
            Array jobIds = c.createArrayOf("INTEGER", temp1.toArray());
            stmt.setArray(2, jobIds);

            stmt.setTimestamp(3, ts, invoice.getDate());
            stmt.setInt(4, invoice.getTotalFee());
            stmt.setInt(5, invoice.getJobseeker().getId());
            stmt.setString(6, invoice.getInvoiceStatus().toString());
            stmt.setString(7, invoice.getPaymentType().toString());
            stmt.setInt(8, invoice.getAdminFee());

            stmt.executeQuery();
            stmt.close();
            c.close();
            return invoice;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoice;
    }

    public static Invoice addInvoice(EwalletPayment invoice) {
        Connection c = connection();
        PreparedStatement stmt;
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        try {
            String sql = "INSERT INTO invoice (id, job_ids, date, total_fee, jobseeker_id, invoice_status, payment_type, referral_code) VALUES (?,?,?,?,?,?,?,?) RETURNING id;";
            stmt = c.prepareStatement(sql);

            stmt.setInt(1, invoice.getId());

            ArrayList<Integer> temp1 = new ArrayList<>();
            for (Job job : invoice.getJobs()) {
                temp1.add(job.getId());
            }
            Array jobIds = c.createArrayOf("INTEGER", temp1.toArray());
            stmt.setArray(2, jobIds);

            stmt.setTimestamp(3, ts, invoice.getDate());
            stmt.setInt(4, invoice.getTotalFee());
            stmt.setInt(5, invoice.getJobseeker().getId());
            stmt.setString(6, invoice.getInvoiceStatus().toString());
            stmt.setString(7, invoice.getPaymentType().toString());
            if(invoice.getBonus() != null){
                stmt.setString(8, invoice.getBonus().getReferralCode());
            }else{
                stmt.setString(8, null);
            }

            stmt.executeQuery();
            stmt.close();
            c.close();
            return invoice;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoice;
    }

    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            String sql = "UPDATE invoice SET invoice_status = ? WHERE id=?;";
            stmt = c.prepareStatement(sql);
            stmt.setString(1, invoiceStatus.toString());
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();
            c.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean removeInvoice(int id) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            String sql = "DELETE FROM invoice WHERE id=?;";
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