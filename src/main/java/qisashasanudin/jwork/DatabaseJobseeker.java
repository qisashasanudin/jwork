package qisashasanudin.jwork;

import java.util.ArrayList;

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

    public static boolean addJobseeker(Jobseeker jobseeker) throws EmailAlreadyExistsException {
        for (Jobseeker element : JOBSEEKER_DATABASE) {
            if (element.getEmail() == jobseeker.getEmail()) {
                throw new EmailAlreadyExistsException(jobseeker);
            }
        }
        JOBSEEKER_DATABASE.add(jobseeker);
        lastId = jobseeker.getId();
        return true;
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

    public static Jobseeker getJobseekerLogin(String email, String password){
        for (Jobseeker jobseeker : JOBSEEKER_DATABASE) {
            if (jobseeker.getEmail().equals(email) && jobseeker.getPassword().equals(password)) {
                return jobseeker;
            }
        }
        return null;
    }
}
