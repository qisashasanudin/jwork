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
    public static Jobseeker getJobseekerById(int id) {
        Jobseeker result = null;

        for (int i = 0; i < JOBSEEKER_DATABASE.size(); i++) {
            if (id == JOBSEEKER_DATABASE.get(i).getId()) {
                result = JOBSEEKER_DATABASE.get(i);
            }
        }
        return result;
    }

    /**
     * method addJobseeker, berfungsi untuk menambah Jobseeker baru
     *
     * @param Jobseeker
     */
    public static boolean addJobseeker(Jobseeker jobseeker) {
        for (Jobseeker element : JOBSEEKER_DATABASE) {
            if (element.getEmail() == jobseeker.getEmail()) {
                return false;
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
    public static boolean removeJobseeker(int id) {
        boolean status = false;
        for (Jobseeker element : JOBSEEKER_DATABASE) {
            if (element.getId() == id) {
                JOBSEEKER_DATABASE.remove(element);
                status = true;
                break;
            }
        }
        return status;
    }

}
