package qisashasanudin.jwork.exception;

/**
 * Praktikum OOP - Program "JWork" - Exception class InvalidEmailException:
 * berfungsi untuk meneruskan exception dalam bentuk string apabila email yang
 * dimasukkan oleh client tidak memenuhi syarat.
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */
public class InvalidEmailException extends Exception {
    // instance variables
    private String email;

    /**
     * Constructor 1untuk object dari exception class InvalidEmailException
     * 
     * @param email_input
     */
    public InvalidEmailException(String email_input) {
        super("Jobseeker Email: ");
        this.email = email_input;
    }

    /**
     * method toString, berfungsi untuk meneruskan pesan error dalam bentuk string
     */
    public String getMessage() {
        return super.getMessage() + email + " is invalid.";
    }
}