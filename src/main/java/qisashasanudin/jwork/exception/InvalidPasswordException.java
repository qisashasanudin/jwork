package qisashasanudin.jwork.exception;

/**
 * Praktikum OOP - Program "JWork" - Exception class InvalidPasswordException:
 * berfungsi untuk meneruskan exception dalam bentuk string apabila password
 * yang dimasukkan oleh client tidak memenuhi syarat.
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */
public class InvalidPasswordException extends Exception {

    /**
     * Constructor 1untuk object dari exception class InvalidPasswordException
     */
    public InvalidPasswordException() {
        super("Jobseeker Password");
    }

    /**
     * method toString, berfungsi untuk meneruskan pesan error dalam bentuk string
     */
    public String getMessage() {
        return super.getMessage() + " is invalid.";
    }
}