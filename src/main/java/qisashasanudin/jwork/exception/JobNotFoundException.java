package qisashasanudin.jwork.exception;

/**
 * Praktikum OOP - Program "JWork" - Exception class JobNotFoundException:
 * berfungsi untuk meneruskan exception dalam bentuk string apabila client ingin
 * meminta data job tertentu namun tidak ditemukan di dalam database.
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */
public class JobNotFoundException extends Exception {
    // instance variables
    private int job_error;

    /**
     * Constructor 1untuk object dari exception class JobNotFoundException
     * 
     * @param job_input
     */
    public JobNotFoundException(int job_input) {
        super("Job ID: ");
        this.job_error = job_input;
    }

    /**
     * method toString, berfungsi untuk meneruskan pesan error dalam bentuk string
     */
    public String getMessage() {
        return super.getMessage() + job_error + " not found";
    }
}