package qisashasanudin.jwork.database.postgre;

import qisashasanudin.jwork.Bonus;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseBonusPostgre extends DatabaseConnectionPostgre {

    private static ArrayList<Bonus> BONUS_DATABASE = new ArrayList<>();

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
                referralCode = rs.getString("referralCode");
                extraFee = rs.getInt("extraFee");
                minTotalFee = rs.getInt("minTotalFee");
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
                referralCode = rs.getString("referralCode");
                extraFee = rs.getInt("extraFee");
                minTotalFee = rs.getInt("minTotalFee");
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

    public static Bonus getBonusByRefferalCode(String referralCode) {
        Connection c = connection();
        PreparedStatement stmt;
        Bonus bonus = null;

        int id;
        int extraFee;
        int minTotalFee;
        boolean active;

        try {
            String sql = "SELECT * FROM bonus WHERE referralCode=?;";
            stmt = c.prepareStatement(sql);
            stmt.setString(1, referralCode);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                referralCode = rs.getString("referralCode");
                extraFee = rs.getInt("extraFee");
                minTotalFee = rs.getInt("minTotalFee");
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

    public static Bonus addBonus(String referralCode, int extraFee, int minTotalFee, boolean active) {
        Connection c = connection();
        PreparedStatement stmt;
        int id = getLastId() + 1;
        Bonus bonus = null;
        try {
            bonus = new Bonus(id, referralCode, extraFee, minTotalFee, active);
            String sql = "INSERT INTO bonus (id, referralCode, extraFee, minTotalFee, active) VALUES (?,?,?,?,?) RETURNING id;";
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