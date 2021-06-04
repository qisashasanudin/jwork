package qisashasanudin.jwork.controller;

import qisashasanudin.jwork.*;
import org.springframework.web.bind.annotation.*;
import qisashasanudin.jwork.database.DatabaseBonus;
import qisashasanudin.jwork.exception.ReferralCodeAlreadyExistsException;

import java.util.ArrayList;

@RequestMapping("/bonus")
@RestController
public class BonusController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Bonus> getAllBonus(){
        return(DatabaseBonus.getBonusDatabase());
    }

    @RequestMapping(value = "/{referralCode}", method = RequestMethod.GET)
    public Bonus getBonusByReferralCode(@PathVariable String referralCode){
        return(DatabaseBonus.getBonusByRefferalCode(referralCode));
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Bonus addBonus(
            @RequestParam(value="referralCode") String referralCode,
            @RequestParam(value="extraFee") int extraFee,
            @RequestParam(value="minTotalFee") int minTotalFee,
            @RequestParam(value="active") boolean active
    ) {
        Bonus bonus = new Bonus(DatabaseBonus.getLastId() + 1, referralCode, extraFee, minTotalFee, active);
        try{
            DatabaseBonus.addBonus(bonus);
        }
        catch(ReferralCodeAlreadyExistsException e){
            System.out.println(e.getMessage());
            return null;
        }
        return bonus;
    }

}