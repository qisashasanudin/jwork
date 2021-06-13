package qisashasanudin.jwork.controller;

import qisashasanudin.jwork.*;
import org.springframework.web.bind.annotation.*;
import qisashasanudin.jwork.database.postgre.DatabaseBonusPostgre;

import java.util.ArrayList;

@RequestMapping("/bonus")
@RestController
public class BonusController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Bonus> getAllBonus() {
        return (DatabaseBonusPostgre.getBonusDatabase());
    }

    @RequestMapping(value = "/{referralCode}", method = RequestMethod.GET)
    public Bonus getBonusByReferralCode(@PathVariable String referralCode) {
        return (DatabaseBonusPostgre.getBonusByRefferalCode(referralCode));
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Bonus addBonus(@RequestParam(value = "referralCode") String referralCode,
            @RequestParam(value = "extraFee") int extraFee, @RequestParam(value = "minTotalFee") int minTotalFee,
            @RequestParam(value = "active") boolean active) {
        int id = DatabaseBonusPostgre.getLastId() + 1;
        Bonus bonus = new Bonus(id, referralCode, extraFee, minTotalFee, active);
        return DatabaseBonusPostgre.addBonus(bonus);
    }

}