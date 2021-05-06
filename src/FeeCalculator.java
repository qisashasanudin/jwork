public class FeeCalculator implements Runnable{
    private Invoice invoice;

    public FeeCalculator (Invoice invoice){
        this.invoice = invoice;
    }

    @Override
    public void run(){
        System.out.println("\nCalculating invoice id: " + invoice.getId());
        invoice.setTotalFee();
        System.out.println("\nFinished calculating invoice id: " + invoice.getId());
    }
}
