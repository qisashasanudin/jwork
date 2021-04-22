import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Praktikum OOP - Program "JWork" class EwalletPayment: berfungsi untuk
 * meng-generate object yang merepresentasikan pembayaran dengan E-Wallet
 *
 * @author Qisas Tazkia Hasanudin
 * @version 01-04-2021
 */
public class EwalletPayment extends Invoice {
    private static final PaymentType PAYMENT_TYPE = PaymentType.EwalletPayment;
    private Bonus bonus;

    /**
     * Constructor untuk object dari class EwalletPayment
     */
    public EwalletPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker) {
        super(id, jobs, jobseeker);
    }

    public EwalletPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker, Bonus bonus) {
        super(id, jobs, jobseeker);
        this.bonus = bonus;
    }

    /**
     * method getPaymentType, berfungsi sebagai getter untuk mengambil value
     * PAYMENT_TYPE.EwalletPayment
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
    public void setTotalFee() {
        ArrayList<Job> jobs = getJobs();

        for (Job job : jobs) {
            int fee = job.getFee();

            if ((bonus != null) && (bonus.getActive() == true) && (fee > bonus.getMinTotalFee())) {
                super.totalFee += fee + bonus.getExtraFee();
            } else {
                super.totalFee += fee;
            }
        }
    }

    /**
     * method toString, berfungsi untuk mencetak instance variable ke layar
     */

    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
        String date = dateFormat.format(getDate().getTime());
        String res = "";
        for (Job job : getJobs()) {
            if ((bonus != null) && (bonus.getActive() == true) && (job.getFee() > bonus.getMinTotalFee())) {
                res.concat("\nId = " + getId() + "\nJob = " + job.getName() + "\nDate = " + date + "\nJob Seeker = "
                        + getJobseeker().getName() + "\nReferral Code = " + bonus.getReferralCode() + "\nTotal Fee = "
                        + getTotalFee() + "\nStatus = " + getInvoiceStatus() + "\nPayment = " + PAYMENT_TYPE);
            } else {
                res.concat("\nId = " + getId() + "\nJob = " + job.getName() + "\nDate = " + date + "\nJob Seeker = "
                        + getJobseeker().getName() + "\nTotal Fee = " + getTotalFee() + "\nStatus = "
                        + getInvoiceStatus() + "\nPayment = " + PAYMENT_TYPE);
            }
        }
        return res;
    }
}
