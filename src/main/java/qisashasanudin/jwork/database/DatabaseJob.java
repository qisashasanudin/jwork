package qisashasanudin.jwork.database;

import qisashasanudin.jwork.Job;
import qisashasanudin.jwork.JobCategory;
import qisashasanudin.jwork.exception.JobNotFoundException;

import java.util.ArrayList;

/**
 * Praktikum OOP - Program "JWork" class DatabaseJob: berfungsi untuk
 * meng-generate object yang berisi list Job yang ada
 *
 * @author Qisas Tazkia Hasanudin
 * @version 18-03-2021
 */

public class DatabaseJob {
    // instance variable
    private static int lastId = 0;
    private static ArrayList<Job> JOB_DATABASE = new ArrayList<>();

    /**
     * method getJobDatabase, berfungsi sebagai getter untuk mengambil value
     * JOB_DATABASE
     *
     * @return JOB_DATABASE
     */
    public static ArrayList<Job> getJobDatabase() {
        return JOB_DATABASE;
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
     * method getJobById, berfungsi sebagai getter untuk mengambil value Job
     *
     * @return lastId
     */

    public static Job getJobById(int id) throws JobNotFoundException {
        Job result = null;
        for (Job element : JOB_DATABASE) {
            if (element.getId() == id) {
                result = element;
                return result;
            }
        }
        if (result == null){
            throw new JobNotFoundException(id);
        }

        return result;
    }

    /**
     * method getJobByRecruiter, berfungsi sebagai getter untuk mengambil value Job
     *
     * @return Job
     */
    public static ArrayList<Job> getJobByRecruiter(int recruiterId) {
        ArrayList<Job> result = null;

        for (Job element : JOB_DATABASE) {
            if (element.getRecruiter().getId() == recruiterId) {
                if (result == null) {
                    result = new ArrayList<Job>();
                }
                result.add(element);
            }
        }
        return result;
    }

    /**
     * method getJobByCategory, berfungsi sebagai getter untuk mengambil value Job
     *
     * @return Job
     */
    public static ArrayList<Job> getJobByCategory(JobCategory category) {
        ArrayList<Job> result = null;

        for (Job element : JOB_DATABASE) {
            if (element.getCategory() == category) {
                if (result == null) {
                    result = new ArrayList<Job>();
                }
                result.add(element);
            }
        }
        return result;
    }

    /**
     * method addJob, berfungsi untuk menambah Job baru
     *
     * @param job
     */
    public static boolean addJob(Job job) {
        JOB_DATABASE.add(job);
        lastId = job.getId();
        return true;
    }

    /**
     * method removeJob, berfungsi untuk menghapus Job yang sudah ada
     *
     * @param id
     */
    public static boolean removeJob(int id) throws JobNotFoundException {
        boolean status = false;
        for (Job element : JOB_DATABASE) {
            if (element.getId() == id) {
                JOB_DATABASE.remove(element);
                status = true;
                break;
            }
        }
        if (!status){
            throw new JobNotFoundException(id);
        }

        return status;
    }

}
