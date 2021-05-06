public class FeeCalculator implements Runnable{
    private Invoice invoice;

    public FeeCalculator (Invoice invoice){
        this.invoice = invoice;
    }

    @Override
    public void run(){
        System.out.println("Calculating invoice id: " + invoice.getId());
        invoice.setTotalFee();
        System.out.println("Finished calculating invoice id: " + invoice.getId());
    }
}
