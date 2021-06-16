package qisashasanudin.jwork.database.legacy;

import qisashasanudin.jwork.Job;
import qisashasanudin.jwork.JobCategory;
import qisashasanudin.jwork.exception.JobNotFoundException;

import java.util.ArrayList;

/**
 * Praktikum OOP - Program "JWork" class DatabaseJob: berfungsi untuk
 * meng-generate object yang berisi list Job yang ada
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */

public class DatabaseJob {
    // instance variable
    private static int lastId = 0;
    private static ArrayList<Job> JOB_DATABASE = new ArrayList<>();

    /**
     * method getJobDatabase, berfungsi sebagai getter untuk mengambil value
     * JOB_DATABASE
     *
     * @return ArrayList<Job> JOB_DATABASE
     */
    public static ArrayList<Job> getJobDatabase() {
        return JOB_DATABASE;
    }

    /**
     * method getLastId, berfungsi sebagai getter untuk mengambil value lastId
     *
     * @return int lastId
     */
    public static int getLastId() {
        return lastId;
    }

    /**
     * method getJobById, berfungsi sebagai getter untuk mengambil value Job
     *
     * @param id
     * @throws JobNotFoundException
     * @return Job job
     */

    public static Job getJobById(int id) throws JobNotFoundException {
        for (Job element : JOB_DATABASE) {
            if (element.getId() == id) {
                return element;
            }
        }
        throw new JobNotFoundException(id);
    }

    /**
     * method getJobByRecruiter, berfungsi sebagai getter untuk mengambil value Job
     *
     * @param recruiterId
     * @return ArrayList<Job> jobs
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
     * @param category
     * @return ArrayList<Job> jobs
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
     * @return boolean
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
     * @throws JobNotFoundException
     * @return boolean
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
        if (!status) {
            throw new JobNotFoundException(id);
        }

        return status;
    }

}
