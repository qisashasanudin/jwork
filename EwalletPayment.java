/**
 * Praktikum OOP - Program "JWork"
 * class EwalletPayment: berfungsi untuk meng-generate object yang merepresentasikan pembayaran dengan E-Wallet
 *
 * @author Qisas Tazkia Hasanudin
 * @version 01-04-2021
 */
public class EwalletPayment extends Invoice
{
    private static final PaymentType PAYMENT_TYPE = PaymentType.EwalletPayment;
    private Bonus bonus;
    
    /**
     * Constructor untuk object dari class EwalletPayment
     */
    public EwalletPayment(int id, Job job, String date, Jobseeker jobseeker, InvoiceStatus invoiceStatus) {
        super(id, job, date, jobseeker, invoiceStatus);
    }
    
    public EwalletPayment(int id, Job job, String date, Jobseeker jobseeker, Bonus bonus, InvoiceStatus invoiceStatus) {
        super(id, job, date, jobseeker, invoiceStatus);
        this.bonus = bonus;
    }
    
    /**
     * method getPaymentType, berfungsi sebagai getter untuk mengambil value PAYMENT_TYPE.EwalletPayment
     *
     * @return PAYMENT_TYPE.EwalletPayment
     */
    public PaymentType getPaymentType() {
        return PAYMENT_TYPE;
    }
    
    /**
     * method getBonus, berfungsi sebagai getter untuk mengambil value bonus
     *
     * @return bonus
     */
    public Bonus getBonus() {
        return bonus;
    }
    
    /**
     * method setBonus, berfungsi sebagai setter untuk mengisi value bonus
     *
     * @param bonus
     */
    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }
    
    /**
     * method setTotalFee, berfungsi sebagai setter untuk mengisi value totalFee
     *
     */
    public void setTotalFee(){
        if ((bonus != null) && (bonus.getActive() == true) && (getJob().getFee() > bonus.getMinTotalFee())){
            totalFee = getJob().getFee() + bonus.getExtraFee();
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
        
        if ((bonus != null) && (bonus.getActive() == true) && (getJob().getFee() > bonus.getMinTotalFee())){
            System.out.println("Referral Code:" + bonus.getReferralCode());
        }
        
        System.out.println("Total Fee: " + getTotalFee());
        System.out.println("Status: " + getInvoiceStatus());
        System.out.println("Payment: " + PAYMENT_TYPE);
    }
}
