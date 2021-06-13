package qisashasanudin.jwork.exception;

import qisashasanudin.jwork.Bonus;

/**
 * Praktikum OOP - Program "JWork" - Exception class
 * ReferralCodeAlreadyExistsException: berfungsi untuk meneruskan exception
 * dalam bentuk string apabila apabila sebuah bonus akan ditambahkan ke database
 * namun sudah ada bonus lain dengan referral code yang sama.
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */
public class ReferralCodeAlreadyExistsException extends Exception {
    // instance variables
    private Bonus referral_error;

    /**
     * Constructor 1untuk object dari exception class
     * ReferralCodeAlreadyExistsException
     * 
     * @param referral_input
     */
    public ReferralCodeAlreadyExistsException(Bonus referral_input) {
        super("Referral Code: ");
        this.referral_error = referral_input;
    }

    /**
     * method toString, berfungsi untuk meneruskan pesan error dalam bentuk string
     */
    @Override
    public String getMessage() {
        return super.getMessage() + referral_error.getReferralCode() + " already exists.";
    }
}