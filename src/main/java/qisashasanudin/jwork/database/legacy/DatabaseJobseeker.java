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
 * Praktikum OOP - Program "JWork" - class DatabaseJobseeker: berfungsi untuk
 * meng-generate dan mengakses database berisi list Jobseeker yang ada
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */

public class DatabaseJobseeker {
    // instance variable
    private static int lastId = 0;
    private static ArrayList<Jobseeker> JOBSEEKER_DATABASE = new ArrayList<Jobseeker>();

    /**
     * method getJobseekerDatabase, berfungsi sebagai getter untuk mengambil list
     * berisi semua objek yang berada di dalam database
     *
     * @return ArrayList<Jobseeker> JOBSEEKER_DATABASE
     */
    public static ArrayList<Jobseeker> getJobseekerDatabase() {
        return JOBSEEKER_DATABASE;
    }

    /**
     * method getLastId, berfungsi sebagai getter untuk mengambil id dari objek yang
     * terakhir kali ditambahkan ke database
     *
     * @return int lastId
     */
    public static int getLastId() {
        return lastId;
    }

    /**
     * method getJobseekerById, berfungsi sebagai getter untuk mengambil salah satu
     * objek menggunakan ID-nya
     *
     * @param jobseekerId
     * @throws JobseekerNotFoundException
     * @return Jobseeker jobseeeker
     */
    public static Jobseeker getJobseekerById(int id) throws JobseekerNotFoundException {
        for (Jobseeker jobseeker : JOBSEEKER_DATABASE) {
            if (jobseeker.getId() == id) {
                return jobseeker;
            }
        }

        throw new JobseekerNotFoundException(id);

    }

    /**
     * method addJobseeker, berfungsi untuk menambah objek baru
     *
     * @param jobseeker
     * @throws EmailAlreadyExistsException
     * @throws InvalidEmailException
     * @throws InvalidPasswordException
     * @return Jobseeker jobseeker
     */
    public static boolean addJobseeker(Jobseeker jobseeker)
            throws EmailAlreadyExistsException, InvalidEmailException, InvalidPasswordException {
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
        } else if (!passwordMatcher.matches()) {
            throw new InvalidPasswordException();
        } else {
            JOBSEEKER_DATABASE.add(jobseeker);
            lastId = jobseeker.getId();
            return true;
        }
    }

    /**
     * method removeJobseeker, berfungsi untuk menghapus salah satu objek
     * berdasarkan ID-nya
     *
     * @param id
     * @throws JobseekerNotFoundException
     * @return boolean
     */
    public static boolean removeJobseeker(int id) throws JobseekerNotFoundException {
        boolean status = false;
        for (Jobseeker jobseeker : JOBSEEKER_DATABASE) {
            if (jobseeker.getId() == id) {
                JOBSEEKER_DATABASE.remove(jobseeker);
                return true;
            }
        }
        if (!status) {
            throw new JobseekerNotFoundException(id);
        }

        return status;
    }

    /**
     * method getJobseekerLogin, berfungsi sebagai getter untuk mengambil salah satu
     * objek menggunakan email dan password-nya
     *
     * @param email_new
     * @param password_new
     * @throws InvalidEmailException
     * @throws InvalidPasswordException
     * @return Jobseeker jobseeker
     */
    public static Jobseeker getJobseekerLogin(String email, String password)
            throws InvalidEmailException, InvalidPasswordException {

        String emailRegex = "\\A[a-z0-9!#$%&'*+/=?^_‘{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_‘{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\z";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailMatcher = emailPattern.matcher(email);

        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";
        Pattern passwordPattern = Pattern.compile(passwordRegex);
        Matcher passwordMatcher = passwordPattern.matcher(password);

        if (!emailMatcher.matches()) {
            throw new InvalidEmailException(email);
        } else if (!passwordMatcher.matches()) {
            throw new InvalidPasswordException();
        } else {
            for (Jobseeker jobseeker : JOBSEEKER_DATABASE) {
                if (jobseeker.getEmail().equals(email) && jobseeker.getPassword().equals(password)) {
                    return jobseeker;
                }
            }
        }

        return null;
    }
}
