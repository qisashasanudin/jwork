package qisashasanudin.jwork.exception;

import qisashasanudin.jwork.Invoice;

/**
 * Praktikum OOP - Program "JWork" - Exception class
 * OngoingInvoiceAlreadyExistsException: berfungsi untuk meneruskan exception
 * dalam bentuk string apabila apabila client ingin memasukkan data invoice ke
 * dalam database namun client tersebut masih memiliki invoice dengan status
 * "Ongoing".
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */
public class OngoingInvoiceAlreadyExistsException extends Exception {
    // instance variables
    private Invoice invoice_error;

    /**
     * Constructor 1untuk object dari exception class
     * OngoingInvoiceAlreadyExistsException
     * 
     * @param invoice_input
     */
    public OngoingInvoiceAlreadyExistsException(Invoice invoice_input) {
        super("Invoice Status: ");
        this.invoice_error = invoice_input;
    }

    /**
     * method toString, berfungsi untuk meneruskan pesan error dalam bentuk string
     */
    public String getMessage() {
        return super.getMessage() + this.invoice_error.getInvoiceStatus() + " for jobseeker: "
                + invoice_error.getJobseeker().getName() + " already exists.";
    }
}
