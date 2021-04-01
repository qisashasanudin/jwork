/**
 * Praktikum OOP - Program "JWork"
 * class Invoice: berfungsi untuk meng-generate object yang merepresentasikan bukti pengiriman gaji
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
    private PaymentType paymentType;
    private InvoiceStatus invoiceStatus;

    /*
     * Constructor untuk object dari class Invoice
     */
    public Invoice(int id, int idJob, String date, int totalFee, Jobseeker jobseeker, PaymentType paymentType, InvoiceStatus invoiceStatus) {
        this.id = id;
        this.idJob = idJob;
        this.date = date;
        this.totalFee = totalFee;
        this.jobseeker = jobseeker;
        this.paymentType = paymentType;
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
     * method getPaymentType, berfungsi sebagai getter untuk mengambil value paymentType
     *
     * @return paymentType
     */
    public PaymentType getPaymentType() {
        return paymentType;
    }

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
     * method setPaymentType, berfungsi sebagai setter untuk mengisi value paymentType
     *
     * @param paymentType
     */
    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
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
    public void printData() {
        System.out.println("==================== INVOICE ====================");
        System.out.println("ID: " + id);
        System.out.println("ID Job: " + idJob);
        System.out.println("Date: " + date);
        System.out.println("Seeker: " + jobseeker.getName());
        System.out.println("Fee: " + totalFee);
        System.out.println("Status: " + invoiceStatus.toString());
    }
}
