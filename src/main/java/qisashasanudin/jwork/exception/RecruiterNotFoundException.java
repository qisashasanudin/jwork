package qisashasanudin.jwork.exception;

/**
 * Praktikum OOP - Program "JWork" - Exception class RecruiterNotFoundException:
 * berfungsi untuk meneruskan exception dalam bentuk string apabila client ingin
 * meminta data recruiter tertentu namun tidak ditemukan di dalam database.
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */
public class RecruiterNotFoundException extends Exception {
    // instance variables
    private int recruiter_error;

    /**
     * Constructor 1untuk object dari exception class RecruiterNotFoundException
     * 
     * @param recruiter_input
     */
    public RecruiterNotFoundException(int recruiter_input) {
        super("Recruiter ID: ");
        this.recruiter_error = recruiter_input;
    }

    /**
     * method toString, berfungsi untuk meneruskan pesan error dalam bentuk string
     */
    public String getMessage() {
        return super.getMessage() + recruiter_error + " Not Found";
    }
}