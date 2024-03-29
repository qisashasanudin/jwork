package qisashasanudin.jwork;

/**
 * Praktikum OOP - Program "JWork" - class Recruiter: berfungsi untuk
 * meng-generate object yang merepresentasikan sebuah pekerjaan
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */

public class Job {
    // instance variable
    private int id;
    private String name;
    private Recruiter recruiter;
    private int fee;
    private JobCategory category;

    /**
     * Constructor untuk object dari class Job
     */
    public Job(int id, String name, int fee, JobCategory category, Recruiter recruiter) {
        this.id = id;
        this.name = name;
        this.fee = fee;
        this.category = category;
        this.recruiter = recruiter;
    }

    /**
     * method getId, berfungsi sebagai getter untuk mengambil value id
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * method getName, berfungsi sebagai getter untuk mengambil value name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * method getFee, berfungsi sebagai getter untuk mengambil value fee
     *
     * @return fee
     */
    public int getFee() {
        return fee;
    }

    /**
     * method getCategory, berfungsi sebagai getter untuk mengambil value category
     *
     * @return category
     */
    public JobCategory getCategory() {
        return category;
    }

    /**
     * method getRecruiter, berfungsi sebagai getter untuk mengambil value recruiter
     *
     * @return recruiter
     */
    public Recruiter getRecruiter() {
        return recruiter;
    }

    /**
     * method setId, berfungsi sebagai setter untuk mengisi value id
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * method setName, berfungsi sebagai setter untuk mengisi value name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method setFee, berfungsi sebagai setter untuk mengisi value fee
     *
     * @param fee
     */
    public void setFee(int fee) {
        this.fee = fee;
    }

    /**
     * method setCategory, berfungsi sebagai setter untuk mengisi value category
     *
     * @param category
     */
    public void setCategory(JobCategory category) {
        this.category = category;
    }

    /**
     * method setRecruiter, berfungsi sebagai setter untuk mengisi value recruiter
     *
     * @param recruiter
     */
    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    /**
     * method toString, berfungsi untuk mencetak instance variable ke layar
     */
    public String toString() {
        return ("Id = " + getId() + "\nNama = " + getName() + "\nRecruiter = " + getRecruiter() + "\nCity = "
                + getRecruiter().getLocation().getCity() + "\nFee = " + getFee() + "\nCategory = " + getCategory());
    }
}
