package qisashasanudin.jwork.database.legacy;

import qisashasanudin.jwork.Recruiter;
import qisashasanudin.jwork.exception.RecruiterNotFoundException;

import java.util.ArrayList;

/**
 * Praktikum OOP - Program "JWork" - class DatabaseRecruiter: berfungsi untuk
 * meng-generate dan mengakses database berisi Recruiter Jobseeker yang ada
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */
public class DatabaseRecruiter {
    // instance variable
    private static int lastId = 0;
    private static ArrayList<Recruiter> RECRUITER_DATABASE = new ArrayList<>();

    /**
     * method getRecruiterDatabase, berfungsi sebagai getter untuk mengambil list
     * berisi semua objek yang berada di dalam database
     *
     * @return ArrayList<Recruiter> RECRUITER_DATABASE
     */
    public static ArrayList<Recruiter> getRecruiterDatabase() {
        return RECRUITER_DATABASE;
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
     * method getRecruiterById, berfungsi sebagai getter untuk mengambil salah satu
     * objek menggunakan ID-nya
     *
     * @param id
     * @throws RecruiterNotFoundException
     * @return Recruiter recruiter
     */

    public static Recruiter getRecruiterById(int id) throws RecruiterNotFoundException {
        Recruiter result = null;

        try {
            for (Recruiter element : RECRUITER_DATABASE) {
                if (element.getId() == id) {
                    result = element;
                    return result;
                }
            }
        } catch (Exception e) {
            throw new RecruiterNotFoundException(id);
        }
        return result;
    }

    /**
     * method addRecruiter, berfungsi untuk menambah objek baru
     *
     * @param jobseeker
     * @return Recruiter recruiter
     */
    public static boolean addRecruiter(Recruiter recruiter) {
        RECRUITER_DATABASE.add(recruiter);
        lastId = recruiter.getId();
        return true;
    }

    /**
     * method removeRecruiter, berfungsi untuk menghapus salah satu objek
     * berdasarkan ID-nya
     *
     * @param id
     * @throws RecruiterNotFoundException
     * @return boolean
     */
    public static boolean removeRecruiter(int id) throws RecruiterNotFoundException {
        boolean status = false;
        for (Recruiter element : RECRUITER_DATABASE) {
            if (element.getId() == id) {
                RECRUITER_DATABASE.remove(element);
                return true;
            }
        }
        if (!status) {
            throw new RecruiterNotFoundException(id);
        }

        return status;
    }

}
