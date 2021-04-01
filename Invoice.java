/**
 * Praktikum OOP - Program "JWork"
 * class Invoice: berfungsi untuk meng-generate object yang merepresentasikan bukti pengiriman gaji
 *
 * @author Qisas Tazkia Hasanudin
 * @version 18-03-2021
 */

public abstract class Invoice {
    // instance variable
    private int id;
    private Job job;
    private String date;
    protected int totalFee;
    private Jobseeker jobseeker;
    private InvoiceStatus invoiceStatus;

    /**
     * Constructor untuk object dari class Invoice
     */
    public Invoice(int id, Job job, String date, Jobseeker jobseeker, InvoiceStatus invoiceStatus) {
        this.id = id;
        this.job = job;
        this.date = date;
        this.jobseeker = jobseeker;
        this.invoiceStatus = invoiceStatus;
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
     * method getJob, berfungsi sebagai getter untuk mengambil value job
     *
     * @return job
     */
    public Job getJob() {
        return job;
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
     * method getPaymentType, berfungsi sebagai getter untuk mengambil value paymentType
     *
     */
    public abstract PaymentType getPaymentType();

    /**
     * method getInvoiceStatus, berfungsi sebagai getter untuk mengambil value invoiceStatus
     *
     * @return invoiceStatus
     */
    public InvoiceStatus getInvoiceStatus() {
        return invoiceStatus;
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
     * method setJob, berfungsi sebagai setter untuk mengisi value job
     *
     * @param job
     */
    public void setJob(Job job) {
        this.job = job;
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
     */
    public abstract void setTotalFee();

    /**
     * method setJobseeker, berfungsi sebagai setter untuk mengisi value jobseeker
     *
     * @param jobseeker
     */
    public void setJobseeker(Jobseeker jobseeker) {
        this.jobseeker = jobseeker;
    }

    /**
     * method setInvoiceStatus, berfungsi sebagai setter untuk mengisi value invoiceStatus
     *
     * @param invoiceStatus
     */
    public void setInvoiceStatus(InvoiceStatus status) {
        this.invoiceStatus = invoiceStatus;
    }

    /**
     * method printData, berfungsi untuk mencetak instance variable ke layar
     */
    public abstract void printData();
}