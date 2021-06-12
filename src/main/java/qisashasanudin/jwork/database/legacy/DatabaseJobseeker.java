package qisashasanudin.jwork.database.legacy;

import qisashasanudin.jwork.*;
import qisashasanudin.jwork.exception.EmailAlreadyExistsException;
import qisashasanudin.jwork.exception.InvalidEmailException;
import qisashasanudin.jwork.exception.InvalidPasswordException;
import qisashasanudin.jwork.exception.JobseekerNotFoundException;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Praktikum OOP - Program "JWork" class DatabaseJobseeker: berfungsi untuk
 * meng-generate object yang berisi list Jobseeker yang ada
 *
 * @author Qisas Tazkia Hasanudin
 * @version 18-03-2021
 */

public class DatabaseJobseeker {
    // instance variable
    private static int lastId = 0;
    private static ArrayList<Jobseeker> JOBSEEKER_DATABASE = new ArrayList<Jobseeker>();

    /**
     * method getJobseekerDatabase, berfungsi sebagai getter untuk mengambil value
     * JOBSEEKER_DATABASE
     *
     * @return JOBSEEKER_DATABASE
     */
    public static ArrayList<Jobseeker> getJobseekerDatabase() {
        return JOBSEEKER_DATABASE;
    }

    /**
     * method getLastId, berfungsi sebagai getter untuk mengambil value lastId
     *
     * @return lastId
     */
    public static int getLastId() {
        return lastId;
    }

    /**
     * method getJobseekerById, berfungsi sebagai getter untuk mengambil value
     * Jobseeker
     *
     * @return lastId
     */
    public static Jobseeker getJobseekerById(int id) throws JobseekerNotFoundException {
        Jobseeker result = null;
        for (Jobseeker jobseeker : JOBSEEKER_DATABASE) {
            if (jobseeker.getId() == id) {
                result = jobseeker;
                return result;
            }
        }
        if (result == null){
            throw new JobseekerNotFoundException(id);
        }

        return result;
    }

    /**
     * method addJobseeker, berfungsi untuk menambah Jobseeker baru
     *
     * @param jobseeker
     */

    public static boolean addJobseeker(Jobseeker jobseeker) throws EmailAlreadyExistsException, InvalidEmailException, InvalidPasswordException {
        for (Jobseeker element : JOBSEEKER_DATABASE) {
            if (element.getEmail() == jobseeker.getEmail()) {
                throw new EmailAlreadyExistsException(jobseeker);
            }
        }

        String emailRegex = "\\A[a-z0-9!#$%&'*+/=?^_‘{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_‘{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\z";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailMatcher = emailPattern.matcher(jobseeker.getEmail());

        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";
        Pattern passwordPattern = Pattern.compile(passwordRegex);
        Matcher passwordMatcher = passwordPattern.matcher(jobseeker.getPassword());

        if (!emailMatcher.matches()) {
            throw new InvalidEmailException(jobseeker.getEmail());
        }else if(!passwordMatcher.matches()){
            throw new InvalidPasswordException();
        }else{
            JOBSEEKER_DATABASE.add(jobseeker);
            lastId = jobseeker.getId();
            return true;
        }
    }

    /**
     * method removeJobseeker, berfungsi untuk menghapus Jobseeker yang sudah ada
     *
     * @param id
     */
    public static boolean removeJobseeker(int id) throws JobseekerNotFoundException {
        boolean status = false;
        for (Jobseeker jobseeker : JOBSEEKER_DATABASE) {
            if (jobseeker.getId() == id) {
                JOBSEEKER_DATABASE.remove(jobseeker);
                return true;
            }
        }
        if (!status){
            throw new JobseekerNotFoundException(id);
        }

        return status;
    }

    public static Jobseeker getJobseekerLogin(String email, String password) throws InvalidEmailException, InvalidPasswordException {

        String emailRegex = "\\A[a-z0-9!#$%&'*+/=?^_‘{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_‘{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\z";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailMatcher = emailPattern.matcher(email);

        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";
        Pattern passwordPattern = Pattern.compile(passwordRegex);
        Matcher passwordMatcher = passwordPattern.matcher(password);

        if (!emailMatcher.matches()) {
            throw new InvalidEmailException(email);
        }else if(!passwordMatcher.matches()){
            throw new InvalidPasswordException();
        }else{
            for (Jobseeker jobseeker : JOBSEEKER_DATABASE) {
                if (jobseeker.getEmail().equals(email) && jobseeker.getPassword().equals(password)) {
                    return jobseeker;
                }
            }
        }

        return null;
    }
}
