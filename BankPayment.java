/**
 * Praktikum OOP - Program "JWork"
 * class BankPayment: berfungsi untuk meng-generate object yang merepresentasikan pembayaran dengan transfer bank
 *
 * @author Qisas Tazkia Hasanudin
 * @version 03-04-2021
 */
public class BankPayment extends Invoice
{
    private static PaymentType PAYMENT_TYPE;
    private int adminFee;
    
    /**
     * Constructor untuk object dari class BankPayment
     */
    public BankPayment(int id, Job job, String date, Jobseeker jobseeker, InvoiceStatus status) {
        super(id, job, date, jobseeker, status);
    }
    
    public BankPayment(int id, Job job, String date, Jobseeker jobseeker, InvoiceStatus status, int adminFee) {
        super(id, job, date, jobseeker, status);
        this.adminFee = adminFee;
    }
    
    /**
     * method getPaymentType, berfungsi sebagai getter untuk mengambil value PAYMENT_TYPE.BankPayment
     *
     * @return PAYMENT_TYPE.BankPayment
     */
    public PaymentType getPaymentType() {
        return PAYMENT_TYPE.BankPayment;
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
        if (adminFee > 0){
            totalFee = getJob().getFee() - adminFee;
        }
        else{
            totalFee = getJob().getFee();
        }
    }
    
    /**
     * method printData, berfungsi untuk mencetak instance variable ke layar
     */
    public void printData(){
        setTotalFee();
        
        System.out.println("==================== INVOICE ====================");
        
        System.out.println("ID: " + getId());
        System.out.println("Job: " + getJob().getName());
        System.out.println("Date: " + getDate());
        System.out.println("Job Seeker: " + getJobseeker().getName());
        
        if (adminFee > 0){
            System.out.println("Admin Fee: " + adminFee);
        }
        
        System.out.println("Total Fee: " + getTotalFee());
        System.out.println("Status: " + getInvoiceStatus().toString());
        System.out.println("Payment: " + getPaymentType().toString());
    }
}
