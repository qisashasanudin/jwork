package qisashasanudin.jwork.exception;

/**
 * Praktikum OOP - Program "JWork" - Exception class BonusNotFoundException:
 * berfungsi untuk meneruskan exception dalam bentuk string apabila client ingin
 * meminta data bonus tertentu namun tidak ditemukan di dalam database.
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */
public class BonusNotFoundException extends Exception {
    // instance variables
    private int referral_error;

    /**
     * Constructor 1untuk object dari exception class BonusNotFoundException
     * 
     * @param referral_input
     */
    public BonusNotFoundException(int referral_input) {
        super("Bonus ID: ");
        referral_error = referral_input;
    }

    /**
     * method toString, berfungsi untuk meneruskan pesan error dalam bentuk string
     */
    public String getMessage() {
        return super.getMessage() + referral_error + " not found";
    }

}