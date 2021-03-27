
/**
 * Enumeration class InvoiceStatus - mengenumerasi semua jenis status invoice
 *
 * @author Qisas Tazkia Hasanudin
 * @version 27-03-2021
 */
public enum InvoiceStatus
{
    Ongoing("Ongoing"), 
    Finished("Finished"),
    Cancelled("Cancelled");
    
    private final String status;
    
    private InvoiceStatus(String status){
        this.status = status;        
    }
    
    public String toString(){
        return status;
    }
}
