package qisashasanudin.jwork;

/**
 * Praktikum OOP - Program "JWork" - Enumeration class PaymentType -
 * mengenumerasi semua jenis pembayaran
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */
public enum PaymentType {
    /**
     * Semua enumerasi yang ada
     */
    BankPayment("Bank Payment"), EwalletPayment("E-Wallet Payment");

    private final String text;

    /**
     * Constructor untuk enumerator PaymentType
     * 
     * @param text
     */
    private PaymentType(String text) {
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
    public static PaymentType fromString(String input) {
        for (PaymentType element : PaymentType.values()) {
            if (element.text.equalsIgnoreCase(input)) {
                return element;
            }
        }
        return null;
    }
}
