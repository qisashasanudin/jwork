package qisashasanudin.jwork;

/**
 * Praktikum OOP - Program "JWork" - class FeeCalculator: berfungsi untuk
 * melakukan kalkulasi terhadap gaji yang akan diterima karyawan, yaitu dengan
 * cara memanggil method setTotalFee
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */

public class FeeCalculator implements Runnable {
    // instance variable
    private Invoice invoice;

    /**
     * Constructor 1 untuk object dari class FeeCalculator
     * 
     * @param invoice
     */
    public FeeCalculator(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public void run() {
        System.out.println("\nCalculating invoice id: " + invoice.getId());
        invoice.setTotalFee();
        System.out.println("\nFinished calculating invoice id: " + invoice.getId());
    }
}
