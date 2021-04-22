import java.util.ArrayList;

/**
 * Praktikum OOP - Program "JWork" class DatabaseBonusr: berfungsi untuk
 * meng-generate object yang berisi list Bonus yang ada
 *
 * @author Qisas Tazkia Hasanudin
 * @version 18-03-2021
 */

public class DatabaseBonus {
    // instance variable
    private static int lastId = 0;
    private static ArrayList<Bonus> BONUS_DATABASE = new ArrayList<Bonus>();

    /**
     * method getBonusDatabase, berfungsi sebagai getter untuk mengambil value
     * BONUS_DATABASE
     *
     * @return BONUS_DATABASE
     */
    public static ArrayList<Bonus> getBonusDatabase() {
        return BONUS_DATABASE;
    }

    /**
     * method getLastId, berfungsi sebagai getter untuk mengambil value lastId
     *
     * @return lastId
     */
    public static int getLastId() {
        return lastId;
    }

    /**
     * method getBonusById, berfungsi sebagai getter untuk mengambil value Bonus
     *
     * @return result
     */
    public static Bonus getBonusById(int id) {
        Bonus result = null;
        for (Bonus bonus : BONUS_DATABASE) {
            if (id == bonus.getId()) {
                result = bonus;
            }
        }
        return result;
    }

    /**
     * method getBonusByRefferalCode, berfungsi sebagai getter untuk mengambil value
     * Bonus
     *
     * @return result
     */
    public static Bonus getBonusByRefferalCode(String refferalCode) {
        Bonus result = null;
        for (Bonus bonus : BONUS_DATABASE) {
            if (refferalCode.equals(bonus.getReferralCode())) {
                result = bonus;
            }
        }
        return result;
    }

    /**
     * method addBonus, berfungsi untuk menambah bonus baru
     *
     * @param bonus
     */
    public static boolean addBonus(Bonus bonus) {
        for (Bonus element : BONUS_DATABASE) {
            if (element.getReferralCode() == bonus.getReferralCode()) {
                return false;
            }
        }

        BONUS_DATABASE.add(bonus);
        lastId = bonus.getId();
        return true;
    }

    public static boolean activateBonus(int id) {
        boolean result = false;
        for (Bonus bonus : BONUS_DATABASE) {
            if (id == bonus.getId()) {
                bonus.setActive(true);
                result = true;
            }
        }
        return result;
    }

    public static boolean deactivateBonus(int id) {
        boolean result = false;
        for (Bonus bonus : BONUS_DATABASE) {
            if (id == bonus.getId()) {
                bonus.setActive(false);
                result = true;
            }
        }
        return result;
    }

    public static boolean removeBonus(int id) {
        for (Bonus bonus : BONUS_DATABASE) {
            if (bonus.getId() == id) {
                BONUS_DATABASE.remove(bonus);
                return true;
            }
        }
        return false;
    }
}