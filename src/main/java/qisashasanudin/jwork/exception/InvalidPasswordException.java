package qisashasanudin.jwork.exception;

public class InvalidPasswordException extends Exception {

    public InvalidPasswordException(){
        super("Jobseeker Password");
    }

    public String getMessage() {
        return super.getMessage() + " is invalid.";
    }
}