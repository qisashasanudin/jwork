package qisashasanudin.jwork;

/**
 * Praktikum OOP - Program "JWork" - Enumeration class InvoiceStatus -
 * mengenumerasi semua jenis status invoice
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */
public enum InvoiceStatus {
    /**
     * Semua enumerasi yang ada
     */
    Ongoing("Ongoing"), Finished("Finished"), Cancelled("Cancelled");

    private final String text;

    /**
     * Constructor untuk enumerator InvoiceStatus
     * 
     * @param text
     */
    private InvoiceStatus(String text) {
        this.text = text;
    }

    /**
     * method toString, berfungsi untuk mengembalikan enumerasi dalam bentuk string
     * 
     * @return text
     */
    public String toString() {
        return text;
    }

    /**
     * method fromString, berfungsi untuk mengembalikan enumerasi dalam bentuk objek
     * 
     * @param input
     */
    public static InvoiceStatus fromString(String input) {
        for (InvoiceStatus element : InvoiceStatus.values()) {
            if (element.text.equalsIgnoreCase(input)) {
                return element;
            }
        }
        return null;
    }
}
