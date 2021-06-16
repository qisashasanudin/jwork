package qisashasanudin.jwork.database.legacy;

import qisashasanudin.jwork.Bonus;
import qisashasanudin.jwork.exception.BonusNotFoundException;
import qisashasanudin.jwork.exception.ReferralCodeAlreadyExistsException;

import java.util.ArrayList;

/**
 * Praktikum OOP - Program "JWork" - class DatabaseBonus: berfungsi untuk
 * meng-generate dan mengakses database berisi list Bonus yang ada
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */

public class DatabaseBonus {
    // instance variable
    private static int lastId = 0;
    private static ArrayList<Bonus> BONUS_DATABASE = new ArrayList<Bonus>();

    /**
     * method getBonusDatabase, berfungsi sebagai getter untuk mengambil list berisi
     * semua objek yang berada di dalam database
     *
     * @return ArrayList<Bonus> BONUS_DATABASE
     */
    public static ArrayList<Bonus> getBonusDatabase() {
        return BONUS_DATABASE;
    }

    /**
     * method getLastId, berfungsi sebagai getter untuk mengambil id dari objek yang
     * terakhir kali ditambahkan ke database
     *
     * @return int lastId
     */
    public static int getLastId() {
        return lastId;
    }

    /**
     * method getBonusById, berfungsi sebagai getter untuk mengambil salah satu
     * objek menggunakan ID-nya
     *
     * @param id
     * @throws BonusNotFoundException
     * @return Bonus result
     */
    public static Bonus getBonusById(int id) throws BonusNotFoundException {
        for (Bonus bonus : BONUS_DATABASE) {
            if (id == bonus.getId()) {
                return bonus;
            }
        }
        throw new BonusNotFoundException(id);
    }

    /**
     * method getBonusByRefferalCode, berfungsi sebagai getter untuk mengambil salah
     * satu objek menggunakan referral code yang diterapkan padanya
     *
     * @param referralCode
     * @return Bonus result
     */
    public static Bonus getBonusByRefferalCode(String referralCode) {
        for (Bonus bonus : BONUS_DATABASE) {
            if (referralCode.equals(bonus.getReferralCode())) {
                return bonus;
            }
        }
        return null;
    }

    /**
     * method addBonus, berfungsi untuk menambah objek baru
     *
     * @param bonus
     * @throws ReferralCodeAlreadyExistsException
     * @return Bonus bonus
     */
    public static boolean addBonus(Bonus bonus) throws ReferralCodeAlreadyExistsException {
        for (Bonus element : BONUS_DATABASE) {
            if (element.getReferralCode() == bonus.getReferralCode()) {
                throw new ReferralCodeAlreadyExistsException(bonus);
            }
        }
        BONUS_DATABASE.add(bonus);
        lastId = bonus.getId();
        return true;
    }

    /**
     * method activateBonus, berfungsi untuk mengubah status dari bonus menjadi
     * aktif
     *
     * @param id
     * @return boolean
     */
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

    /**
     * method deactivateBonus, berfungsi untuk mengubah status dari bonus menjadi
     * tidak aktif
     *
     * @param id
     * @return boolean
     */
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

    /**
     * method removeBonus, berfungsi untuk menghapus salah satu objek berdasarkan
     * ID-nya
     *
     * @param id
     * @throws BonusNotFoundException
     * @return boolean
     */
    public static boolean removeBonus(int id) throws BonusNotFoundException {
        try {
            for (Bonus bonus : BONUS_DATABASE) {
                if (bonus.getId() == id) {
                    BONUS_DATABASE.remove(bonus);
                    return true;
                }
            }
        } catch (Exception e) {
            throw new BonusNotFoundException(id);
        }
        return false;
    }
}