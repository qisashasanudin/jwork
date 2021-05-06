import java.util.ArrayList;

/**
 * Praktikum OOP - Program "JWork" class DatabaseRecruiter: berfungsi untuk
 * meng-generate object yang berisi list recruiter yang ada
 *
 * @author Qisas Tazkia Hasanudin
 * @version 18-03-2021
 */

public class DatabaseRecruiter {
    // instance variable
    private static int lastId = 0;
    private static ArrayList<Recruiter> RECRUITER_DATABASE = new ArrayList<>();

    /**
     * method getRecruiterDatabase, berfungsi sebagai getter untuk mengambil value
     * RECRUITER_DATABASE
     *
     * @return RECRUITER_DATABASE
     */
    public static ArrayList<Recruiter> getRecruiterDatabase() {
        return RECRUITER_DATABASE;
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
     * method getRecruiterById, berfungsi sebagai getter untuk mengambil value
     * recruiter
     *
     * @return lastId
     */

    public static Recruiter getRecruiterById(int id) throws RecruiterNotFoundException {
        Recruiter result = null;

        try{
            for (Recruiter element : RECRUITER_DATABASE) {
                if (element.getId() == id) {
                    result = element;
                    return result;
                }
            }
        }
        catch (Exception e){
            throw new RecruiterNotFoundException(id);
        }
        return result;
    }

    /**
     * method addRecruiter, berfungsi untuk menambah recruiter baru
     *
     * @param recruiter
     */
    public static boolean addRecruiter(Recruiter recruiter) {
        RECRUITER_DATABASE.add(recruiter);
        lastId = recruiter.getId();
        return true;
    }

    /**
     * method removeRecruiter, berfungsi untuk menghapus recruiter yang sudah ada
     *
     * @param id
     */
    public static boolean removeRecruiter(int id) throws RecruiterNotFoundException {
        boolean status = false;
        for (Recruiter element : RECRUITER_DATABASE) {
            if (element.getId() == id) {
                RECRUITER_DATABASE.remove(element);
                return true;
            }
        }
        if (!status){
            throw new RecruiterNotFoundException(id);
        }

        return status;
    }

}
