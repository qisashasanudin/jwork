package qisashasanudin.jwork;

public class OngoingInvoiceAlreadyExistsException extends Exception {

    private Invoice invoice_error;

    public OngoingInvoiceAlreadyExistsException(Invoice invoice_input){
        super("Invoice Status: ");
        this.invoice_error = invoice_input;
    }

    public String getMessage() {
        return super.getMessage() + this.invoice_error.getInvoiceStatus() + " already exists.";
    }
}
