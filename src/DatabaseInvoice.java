import java.util.ArrayList;

public class DatabaseInvoice {
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
    private static int lastId;

    public static ArrayList<Invoice> getInvoiceDatabase() {
        return INVOICE_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

    public static Invoice getInvoiceById(int id) {
        Invoice temp = null;
        for (Invoice invoice : INVOICE_DATABASE) {
            if (id == invoice.getId()) {
                temp = invoice;
            } else {
                temp = null;
            }
        }
        return temp;
    }

    public static ArrayList<Invoice> getInvoiceByJobseeker(int jobseekerId) {
        ArrayList<Invoice> temp = null;
        for (Invoice invoice : INVOICE_DATABASE) {
            if (jobseekerId == invoice.getJobseeker().getId()) {
                if (temp == null) {
                    temp = new ArrayList<Invoice>();
                }
                temp.add(invoice);
            }
        }
        return temp;
    }

    public static boolean addInvoice(Invoice invoice) {
        if (invoice.getInvoiceStatus() == InvoiceStatus.Ongoing){
            invoice.setInvoiceStatus(InvoiceStatus.Finished);
        }
        INVOICE_DATABASE.add(invoice);
        lastId = invoice.getId();
        return true;
    }

    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus) {
        boolean temp = true;
        for (Invoice invoice : INVOICE_DATABASE) {
            if (id == invoice.getId() && invoice.getInvoiceStatus() == InvoiceStatus.Ongoing) {
                invoice.setInvoiceStatus(invoiceStatus);
                temp = true;
            } else {
                temp = false;
            }
        }
        return temp;
    }

    public static boolean removeInvoice(int id) {
        boolean temp = true;
        for (Invoice invoice : INVOICE_DATABASE) {
            if (id == invoice.getId()) {
                INVOICE_DATABASE.remove(invoice);
                temp = true;
            } else {
                temp = false;
            }
        }
        return temp;
    }

}