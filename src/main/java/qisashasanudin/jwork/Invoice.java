package qisashasanudin.jwork;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;

/**
 * Praktikum OOP - Program "JWork" - class Invoice: berfungsi untuk
 * meng-generate object yang merepresentasikan bukti pengiriman gaji
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */

public abstract class Invoice {
    // instance variable
    private int id;
    private ArrayList<Job> jobs;
    private Calendar date;
    protected int totalFee;
    private Jobseeker jobseeker;
    private InvoiceStatus invoiceStatus;

    /**
     * Constructor 1 untuk object dari class Invoice
     * 
     * @param id
     * @param jobs
     * @param jobseeker
     */
    public Invoice(int id, ArrayList<Job> jobs, Jobseeker jobseeker) {
        this.id = id;
        this.jobs = jobs;
        this.date = Calendar.getInstance();
        this.jobseeker = jobseeker;
        this.invoiceStatus = InvoiceStatus.Ongoing;
    }

    /**
     * Constructor 2 untuk object dari class Invoice
     * 
     * @param id
     * @param jobs
     * @param jobseeker
     * @param totalFee
     * @param status
     */
    public Invoice(int id, ArrayList<Job> jobs, Jobseeker jobseeker, int totalFee, InvoiceStatus status) {
        this.id = id;
        this.jobs = jobs;
        this.date = Calendar.getInstance();
        this.jobseeker = jobseeker;
        this.totalFee = totalFee;
        this.invoiceStatus = status;
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
     * @return jobs
     */
    public ArrayList<Job> getJobs() {
        return jobs;
    }

    /**
     * method getDate, berfungsi sebagai getter untuk mengambil value date
     *
     * @return date
     */
    public Calendar getDate() {
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
     * method getPaymentType, berfungsi sebagai getter untuk mengambil value
     * paymentType
     *
     */
    public abstract PaymentType getPaymentType();

    /**
     * method getInvoiceStatus, berfungsi sebagai getter untuk mengambil value
     * invoiceStatus
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
     * @param jobs
     */
    public void setJobs(ArrayList<Job> jobs) {
        this.jobs = jobs;
    }

    /**
     * method setDate 1, berfungsi sebagai setter untuk mengisi value date
     *
     * @param date
     */
    public void setDate(Calendar date) {
        this.date = date;
    }

    /**
     * method setDate 2, berfungsi sebagai setter untuk mengisi value date
     *
     * @param year
     * @param month
     * @param dayOfMonth
     */
    public void setDate(int year, int month, int dayOfMonth) {
        this.date = new GregorianCalendar(year, month - 1, dayOfMonth);
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
     * method setInvoiceStatus, berfungsi sebagai setter untuk mengisi value
     * invoiceStatus
     *
     * @param invoiceStatus
     */
    public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }
}