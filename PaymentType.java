
/**
 * Enumeration class PaymentType - mengenumerasi semua jenis pembayaran
 *
 * @author Qisas Tazkia Hasanudin
 * @version 25-03-2021
 */
public enum PaymentType
{
    BankPayment("Bank Payment"), 
    EwalletPayment("E-Wallet Payment");
    
    private final String label;
    
    private PaymentType(String label){
        this.label = label;        
    }
    
    public String toString(){
        return label;
    }
}
