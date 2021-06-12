package qisashasanudin.jwork.exception;

import qisashasanudin.jwork.Invoice;

public class OngoingInvoiceAlreadyExistsException extends Exception {

    private Invoice invoice_error;

    public OngoingInvoiceAlreadyExistsException(Invoice invoice_input){
        super("Invoice Status: ");
        this.invoice_error = invoice_input;
    }

    public String getMessage() {
        return super.getMessage() + this.invoice_error.getInvoiceStatus() + " for jobseeker: " + invoice_error.getJobseeker().getName() + " already exists.";
    }
}