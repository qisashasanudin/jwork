package qisashasanudin.jwork.exception;

/**
 * Praktikum OOP - Program "JWork" - Exception class InvoiceNotFoundException:
 * berfungsi untuk meneruskan exception dalam bentuk string apabila client ingin
 * meminta data invoice tertentu namun tidak ditemukan di dalam database.
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */
public class InvoiceNotFoundException extends Exception {
    // instance variables
    private int invoice_error;

    /**
     * Constructor 1untuk object dari exception class InvoiceNotFoundException
     * 
     * @param invoice_input
     */
    public InvoiceNotFoundException(int invoice_input) {
        super("Invoice ID: ");
        invoice_error = invoice_input;
    }

    /**
     * method toString, berfungsi untuk meneruskan pesan error dalam bentuk string
     */
    public String getMessage() {
        return super.getMessage() + invoice_error + " not found";
    }

}