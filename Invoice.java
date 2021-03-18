/**
 * Praktikum OOP - Program "JWork"
 *
 * @author Qisas Tazkia Hasanudin
 * @version 18-03-2021
 */

public class Invoice {
    // instance variable
    private int id;
    private int idJob;
    private String date;
    private int totalFee;
    private Jobseeker jobseeker;

    /*
     * Constructor untuk object dari class Invoice
     */
    public Invoice(int id, int idJob, String date, int totalFee, Jobseeker jobseeker) {
        this.id = id;
        this.idJob = idJob;
        this.date = date;
        this.totalFee = totalFee;
        this.jobseeker = jobseeker;
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
     * method getIdJob, berfungsi sebagai getter untuk mengambil value idJob
     *
     * @return idJob
     */
    public int getIdJob() {
        return idJob;
    }

    /**
     * method getDate, berfungsi sebagai getter untuk mengambil value date
     *
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * method getTotalFee, berfungsi sebagai getter untuk mengambil value totalFee
     *
     * @return totalFee
     */
    public int getTotalFee() {
        return totalFee;
    }

    /**
     * method getJobseeker, berfungsi sebagai getter untuk mengambil value jobseeker
     *
     * @return jobseeker
     */
    public Jobseeker getJobseeker() {
        return jobseeker;
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
     * method setIdJob, berfungsi sebagai setter untuk mengisi value idJob
     *
     * @param idJob
     */
    public void setIdJob(int idJob) {
        this.idJob = idJob;
    }

    /**
     * method setDate, berfungsi sebagai setter untuk mengisi value date
     *
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * method setTotalFee, berfungsi sebagai setter untuk mengisi value totalFee
     *
     * @param totalFee
     */
    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    /**
     * method setJobseeker, berfungsi sebagai setter untuk mengisi value jobseeker
     *
     * @param jobseeker
     */
    public void setJobseeker(Jobseeker jobseeker) {
        this.jobseeker = jobseeker;
    }

    /**
     * method printData, berfungsi untuk mencetak instance variable ke layar
     */
    public void printData() {

    }
}
