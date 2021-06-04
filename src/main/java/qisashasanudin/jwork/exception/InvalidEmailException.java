package qisashasanudin.jwork.exception;

public class InvalidEmailException extends Exception {

    private String email;

    public InvalidEmailException(String email_input){
        super("Jobseeker Email: ");
        this.email = email_input;
    }

    public String getMessage() {
        return super.getMessage() + email + " is invalid.";
    }
}