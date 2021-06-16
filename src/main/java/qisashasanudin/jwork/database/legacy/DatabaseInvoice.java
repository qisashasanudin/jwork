package qisashasanudin.jwork.database.legacy;

import qisashasanudin.jwork.Invoice;
import qisashasanudin.jwork.exception.InvoiceNotFoundException;
import qisashasanudin.jwork.InvoiceStatus;
import qisashasanudin.jwork.exception.OngoingInvoiceAlreadyExistsException;

import java.util.ArrayList;

/**
 * Praktikum OOP - Program "JWork" - class DatabaseInvoice: berfungsi untuk
 * meng-generate dan mengakses database berisi list Invoice yang ada
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */
public class DatabaseInvoice {
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
    private static int lastId;

    /**
     * method getInvoiceDatabase, berfungsi sebagai getter untuk mengambil list
     * berisi semua objek yang berada di dalam database
     *
     * @return ArrayList<Invoice> INVOICE_DATABASE
     */
    public static ArrayList<Invoice> getInvoiceDatabase() {
        return INVOICE_DATABASE;
    }

    /**
     * method getLastId, berfungsi sebagai getter untuk mengambil id dari objek yang
     * terakhir kali ditambahkan ke database
     *
     * @return int lastId
     */
    public static int getLastId() {
        return lastId;
    }

    /**
     * method getInvoiceById, berfungsi sebagai getter untuk mengambil salah satu
     * objek menggunakan ID-nya
     *
     * @param id
     * @throws InvoiceNotFoundException
     * @return Invoice result
     */
    public static Invoice getInvoiceById(int id) throws InvoiceNotFoundException {
        Invoice result = null;
        for (Invoice invoice : INVOICE_DATABASE) {
            if (id == invoice.getId()) {
                result = invoice;
            } else {
                result = null;
            }
        }
        if (result == null) {
            throw new InvoiceNotFoundException(id);
        }

        return result;
    }

    /**
     * method getInvoiceByJobseeker, berfungsi sebagai getter untuk mengambil salah
     * satu objek berdasarkan ID dari jobseeker yang memiliki invoice tersebut
     *
     * @param jobseekerId
     * @return ArrayList<Invoice> result
     */
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

    /**
     * method addInvoice, berfungsi untuk menambah objek baru
     *
     * @param invoice
     * @throws OngoingInvoiceAlreadyExistsException
     * @return Invoice invoice
     */
    public static boolean addInvoice(Invoice invoice) throws OngoingInvoiceAlreadyExistsException {
        for (Invoice element : INVOICE_DATABASE) {
            if (element.getInvoiceStatus() == InvoiceStatus.Ongoing
                    && element.getJobseeker().getId() == invoice.getJobseeker().getId()) {
                throw new OngoingInvoiceAlreadyExistsException(invoice);
            }
        }
        INVOICE_DATABASE.add(invoice);
        lastId = invoice.getId();
        return true;
    }

    /**
     * method changeInvoiceStatus, berfungsi untuk mengubah status dari invoice
     *
     * @param id
     * @param invoiceStatus
     * @return boolean
     */
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

    /**
     * method removeInvoice, berfungsi untuk menghapus salah satu objek berdasarkan
     * ID-nya
     *
     * @param id
     * @throws InvoiceNotFoundException
     * @return boolean
     */
    public static boolean removeInvoice(int id) throws InvoiceNotFoundException {
        boolean status = false;
        for (Invoice invoice : INVOICE_DATABASE) {
            if (id == invoice.getId()) {
                INVOICE_DATABASE.remove(invoice);
                status = true;
            } else {
                status = false;
            }
        }
        if (!status) {
            throw new InvoiceNotFoundException(id);
        }

        return status;
    }

}