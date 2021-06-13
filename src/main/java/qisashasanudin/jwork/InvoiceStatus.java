package qisashasanudin.jwork;

/**
 * Enumeration class InvoiceStatus - mengenumerasi semua jenis status invoice
 *
 * @author Qisas Tazkia Hasanudin
 * @version 27-03-2021
 */
public enum InvoiceStatus {
    Ongoing("Ongoing"), Finished("Finished"), Cancelled("Cancelled");

    private final String status;

    /**
     * Constructor untuk enumerator InvoiceStatus
     */
    private InvoiceStatus(String status) {
        this.status = status;
    }

    /**
     * method toString, berfungsi untuk mengembalikan status dalam bentuk string
     */
    public String toString() {
        return status;
    }

    /**
     * method fromString, berfungsi untuk mengembalikan status dalam bentuk objek
     */
    public static InvoiceStatus fromString(String input) {
        for (InvoiceStatus element : InvoiceStatus.values()) {
            if (element.status.equalsIgnoreCase(input)) {
                return element;
            }
        }
        return null;
    }
}
