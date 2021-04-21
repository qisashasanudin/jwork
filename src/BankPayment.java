import java.text.SimpleDateFormat;

/**
 * Praktikum OOP - Program "JWork"
 * class BankPayment: berfungsi untuk meng-generate object yang merepresentasikan pembayaran dengan transfer bank
 *
 * @author Qisas Tazkia Hasanudin
 * @version 03-04-2021
 */
public class BankPayment extends Invoice
{
    private static final PaymentType PAYMENT_TYPE = PaymentType.BankPayment;
    private int adminFee;
    
    /**
     * Constructor untuk object dari class BankPayment
     */
    public BankPayment(int id, Job job, Jobseeker jobseeker, InvoiceStatus invoiceStatus) {
        super(id, job, jobseeker, invoiceStatus);
    }
    
    public BankPayment(int id, Job job, Jobseeker jobseeker, InvoiceStatus invoiceStatus, int adminFee) {
        super(id, job, jobseeker, invoiceStatus);
        this.adminFee = adminFee;
    }
    
    /**
     * method getPaymentType, berfungsi sebagai getter untuk mengambil value PAYMENT_TYPE.BankPayment
     *
     * @return PAYMENT_TYPE.BankPayment
     */
    public PaymentType getPaymentType() {
        return PAYMENT_TYPE;
    }
    
    /**
     * method getAdminFee, berfungsi sebagai getter untuk mengambil value adminFee
     *
     * @return adminFee
     */
    public int getAdminFee() {
        return adminFee;
    }
    
    /**
     * method setAdminFee, berfungsi sebagai setter untuk mengisi value adminFee
     *
     * @param adminFee
     */
    public void setAdminFee(int adminFee) {
        this.adminFee = adminFee;
    }
    
    /**
     * method setTotalFee, berfungsi sebagai setter untuk mengisi value totalFee
     *
     */
    public void setTotalFee(){
        if (adminFee != 0){
            totalFee = getJob().getFee() - adminFee;
        }
        else{
            totalFee = getJob().getFee();
        }
    }
    
    /**
     * method toString, berfungsi untuk mencetak instance variable ke layar
     */
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
        String date = dateFormat.format(getDate().getTime());
        
        if (adminFee != 0){
            return ("Id = " + getId() + "\nJob = " + getJob().getName() + "\nDate = " + date + "\nJob Seeker = "
                + getJobseeker().getName() + "\nAdmin Fee = " + adminFee + "\nTotal Fee = " + getTotalFee() + "\nStatus = " + getInvoiceStatus() + "\nPayment = " + PAYMENT_TYPE);
        }else{
            return ("Id = " + getId() + "\nJob = " + getJob().getName() + "\nDate = " + date + "\nJob Seeker = "
                + getJobseeker().getName()+ "\nTotal Fee = " + getTotalFee() + "\nStatus = " + getInvoiceStatus() + "\nPayment = " + PAYMENT_TYPE);
        }
    }
}
