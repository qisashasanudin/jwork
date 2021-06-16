package qisashasanudin.jwork.database.postgre;

import qisashasanudin.jwork.Bonus;

import java.sql.*;
import java.util.ArrayList;

/**
 * Praktikum OOP - Program "JWork" - class DatabaseBonusPostgre: berfungsi untuk
 * meng-generate dan mengakses database berisi list Bonus yang ada
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */

public class DatabaseBonusPostgre extends DatabaseConnectionPostgre {
    // instance variable
    private static ArrayList<Bonus> BONUS_DATABASE = new ArrayList<>();

    /**
     * method getBonusDatabase, berfungsi sebagai getter untuk mengambil list berisi
     * semua objek yang berada di dalam database
     *
     * @return ArrayList<Bonus> BONUS_DATABASE
     */
    public static ArrayList<Bonus> getBonusDatabase() {
        BONUS_DATABASE.clear();
        Connection c = connection();
        PreparedStatement stmt;
        Bonus bonus;

        int id;
        String referralCode;
        int extraFee;
        int minTotalFee;
        boolean active;

        try {
            String sql = "SELECT * FROM bonus;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                referralCode = rs.getString("referral_code");
                extraFee = rs.getInt("extra_fee");
                minTotalFee = rs.getInt("min_total_fee");
                active = rs.getBoolean("active");
                bonus = new Bonus(id, referralCode, extraFee, minTotalFee, active);
                BONUS_DATABASE.add(bonus);
            }
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return BONUS_DATABASE;
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
            String sql = "SELECT id FROM bonus;";
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
     * method getBonusById, berfungsi sebagai getter untuk mengambil salah satu
     * objek menggunakan ID-nya
     *
     * @param id
     * @return Bonus result
     */
    public static Bonus getBonusById(int id) {
        Connection c = connection();
        PreparedStatement stmt;
        Bonus bonus = null;

        String referralCode;
        int extraFee;
        int minTotalFee;
        boolean active;

        try {
            String sql = "SELECT * FROM bonus WHERE id=?;";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                referralCode = rs.getString("referral_code");
                extraFee = rs.getInt("extra_fee");
                minTotalFee = rs.getInt("min_total_fee");
                active = rs.getBoolean("active");
                bonus = new Bonus(id, referralCode, extraFee, minTotalFee, active);
            }
            stmt.close();
            c.close();
            return bonus;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bonus;
    }

    /**
     * method getBonusByRefferalCode, berfungsi sebagai getter untuk mengambil salah
     * satu objek menggunakan referral code yang diterapkan padanya
     *
     * @param referralCode
     * @return Bonus result
     */
    public static Bonus getBonusByRefferalCode(String referralCode) {
        Connection c = connection();
        PreparedStatement stmt;
        Bonus bonus = null;

        int id;
        int extraFee;
        int minTotalFee;
        boolean active;

        try {
            String sql = "SELECT * FROM bonus WHERE referral_code=?;";
            stmt = c.prepareStatement(sql);
            stmt.setString(1, referralCode);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                referralCode = rs.getString("referral_code");
                extraFee = rs.getInt("extra_fee");
                minTotalFee = rs.getInt("min_total_fee");
                active = rs.getBoolean("active");
                bonus = new Bonus(id, referralCode, extraFee, minTotalFee, active);
            }
            stmt.close();
            c.close();
            return bonus;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bonus;
    }

    /**
     * method addBonus, berfungsi untuk menambah objek baru
     *
     * @param bonus
     * @return Bonus bonus
     */
    public static Bonus addBonus(Bonus bonus) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            String sql = "INSERT INTO bonus (id, referral_code, extra_fee, min_total_fee, active) VALUES (?,?,?,?,?) RETURNING id;";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, bonus.getId());
            stmt.setString(2, bonus.getReferralCode());
            stmt.setInt(3, bonus.getExtraFee());
            stmt.setInt(4, bonus.getMinTotalFee());
            stmt.setBoolean(5, bonus.getActive());
            stmt.executeQuery();
            stmt.close();
            c.close();
            return bonus;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bonus;
    }

    /**
     * method activateBonus, berfungsi untuk mengubah status dari bonus menjadi
     * aktif
     *
     * @param id
     * @return boolean
     */
    public static boolean activateBonus(int id) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            String sql = "UPDATE bonus SET active = TRUE WHERE id=?;";
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
     * method deactivateBonus, berfungsi untuk mengubah status dari bonus menjadi
     * tidak aktif
     *
     * @param id
     * @return boolean
     */
    public static boolean deactivateBonus(int id) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            String sql = "UPDATE bonus SET active = FALSE WHERE id=?;";
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
     * method removeBonus, berfungsi untuk menghapus salah satu objek berdasarkan
     * ID-nya
     *
     * @param id
     * @return boolean
     */
    public static boolean removeBonus(int id) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            String sql = "DELETE FROM bonus WHERE id=?;";
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