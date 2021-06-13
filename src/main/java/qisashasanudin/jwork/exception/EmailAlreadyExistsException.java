package qisashasanudin.jwork.exception;

import qisashasanudin.jwork.Jobseeker;

/**
 * Praktikum OOP - Program "JWork" - Exception class
 * EmailAlreadyExistsException: berfungsi untuk meneruskan exception dalam
 * bentuk string apabila email yang ingin digunakan oleh client sudah digunakan
 * oleh client lain.
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */
public class EmailAlreadyExistsException extends Exception {
    // instance variables
    private Jobseeker jobseeker_error;

    /**
     * Constructor 1untuk object dari exception class EmailAlreadyExistsException
     * 
     * @param jobseeker_input
     */
    public EmailAlreadyExistsException(Jobseeker jobseeker_input) {
        super("Jobseeker Email: ");
        this.jobseeker_error = jobseeker_input;
    }

    /**
     * method toString, berfungsi untuk meneruskan pesan error dalam bentuk string
     */
    public String getMessage() {
        return super.getMessage() + jobseeker_error.getEmail() + " already exists.";
    }
}
