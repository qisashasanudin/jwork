package qisashasanudin.jwork.controller;

import qisashasanudin.jwork.*;
import org.springframework.web.bind.annotation.*;
import qisashasanudin.jwork.database.postgre.DatabaseBonusPostgre;

import java.util.ArrayList;

/**
 * Praktikum OOP - Program "JWork" - class BonusController: berfungsi untuk
 * mengatur HTML query antara client dan server
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */
@RequestMapping("/bonus")
@RestController
public class BonusController {

    /**
     * method getAllBonus, berfungsi sebagai getter untuk mengambil list berisi
     * semua objek yang berada di dalam database
     *
     * @return ArrayList<Bonus> BONUS_DATABASE
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Bonus> getAllBonus() {
        return (DatabaseBonusPostgre.getBonusDatabase());
    }

    /**
     * method getBonusByRefferalCode, berfungsi sebagai getter untuk mengambil salah
     * satu objek menggunakan referral code yang diterapkan padanya
     *
     * @param referralCode
     * @return Bonus result
     */
    @RequestMapping(value = "/{referralCode}", method = RequestMethod.GET)
    public Bonus getBonusByReferralCode(@PathVariable String referralCode) {
        return (DatabaseBonusPostgre.getBonusByRefferalCode(referralCode));
    }

    /**
     * method addBonus, berfungsi untuk menambah objek baru
     *
     * @param bonus
     * @return Bonus bonus
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Bonus addBonus(@RequestParam(value = "referralCode") String referralCode,
            @RequestParam(value = "extraFee") int extraFee, @RequestParam(value = "minTotalFee") int minTotalFee,
            @RequestParam(value = "active") boolean active) {
        int id = DatabaseBonusPostgre.getLastId() + 1;
        Bonus bonus = new Bonus(id, referralCode, extraFee, minTotalFee, active);
        return DatabaseBonusPostgre.addBonus(bonus);
    }

}