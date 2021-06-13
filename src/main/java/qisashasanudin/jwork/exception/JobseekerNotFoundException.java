package qisashasanudin.jwork.exception;

/**
 * Praktikum OOP - Program "JWork" - Exception class JobseekerNotFoundException:
 * berfungsi untuk meneruskan exception dalam bentuk string apabila client ingin
 * meminta data jobseeker tertentu namun tidak ditemukan di dalam database.
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */
public class JobseekerNotFoundException extends Exception {
    // instance variables
    private int jobseeker_error;

    /**
     * Constructor 1untuk object dari exception class JobseekerNotFoundException
     * 
     * @param jobseeker_input
     */
    public JobseekerNotFoundException(int jobseeker_input) {
        super("Jobseeker ID: ");
        this.jobseeker_error = jobseeker_input;
    }

    /**
     * method toString, berfungsi untuk meneruskan pesan error dalam bentuk string
     */
    public String getMessage() {
        return super.getMessage() + jobseeker_error + " not found";
    }
}