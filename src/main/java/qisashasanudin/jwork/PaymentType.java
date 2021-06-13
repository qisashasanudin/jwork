package qisashasanudin.jwork;

/**
 * Enumeration class PaymentType - mengenumerasi semua jenis pembayaran
 *
 * @author Qisas Tazkia Hasanudin
 * @version 25-03-2021
 */
public enum PaymentType {
    BankPayment("Bank Payment"), EwalletPayment("E-Wallet Payment");

    private final String type;

    /**
     * Constructor untuk enumerator PaymentType
     */
    private PaymentType(String type) {
        this.type = type;
    }

    /**
     * method toString, berfungsi untuk mengembalikan type dalam bentuk string
     */
    public String toString() {
        return type;
    }

    /**
     * method fromString, berfungsi untuk mengembalikan type dalam bentuk objek
     */
    public static PaymentType fromString(String input) {
        for (PaymentType element : PaymentType.values()) {
            if (element.type.equalsIgnoreCase(input)) {
                return element;
            }
        }
        return null;
    }
}
