package qisashasanudin.jwork.controller;

import qisashasanudin.jwork.*;
import org.springframework.web.bind.annotation.*;

import qisashasanudin.jwork.database.postgre.DatabaseBonusPostgre;
import qisashasanudin.jwork.database.postgre.DatabaseInvoicePostgre;
import qisashasanudin.jwork.database.postgre.DatabaseJobPostgre;
import qisashasanudin.jwork.database.postgre.DatabaseJobseekerPostgre;

import java.util.ArrayList;

/**
 * Praktikum OOP - Program "JWork" - class InvoiceController: berfungsi untuk
 * mengatur HTML query antara client dan server
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */
@RequestMapping("/invoice")
@RestController
public class InvoiceController {
    /**
     * method getAllInvoice, berfungsi sebagai getter untuk mengambil list berisi
     * semua objek yang berada di dalam database
     *
     * @return ArrayList<Invoice> INVOICE_DATABASE
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Invoice> getAllInvoice() {
        return (DatabaseInvoicePostgre.getInvoiceDatabase());
    }

    /**
     * method getInvoiceById, berfungsi sebagai getter untuk mengambil salah satu
     * objek menggunakan ID-nya
     *
     * @param id
     * @return Invoice result
     */
    @RequestMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable int id) {
        return DatabaseInvoicePostgre.getInvoiceById(id);
    }

    /**
     * method getInvoiceByJobseeker, berfungsi sebagai getter untuk mengambil salah
     * satu objek berdasarkan ID dari jobseeker yang memiliki invoice tersebut
     *
     * @param jobseekerId
     * @return ArrayList<Invoice> result
     */
    @RequestMapping("/jobseeker/{jobseekerId}")
    public ArrayList<Invoice> getInvoiceByJobseeker(@PathVariable int jobseekerId) {
        return DatabaseInvoicePostgre.getInvoiceByJobseeker(jobseekerId);
    }

    /**
     * method changeInvoiceStatus, berfungsi untuk mengubah status dari invoice
     *
     * @param id
     * @param invoiceStatus
     * @return Invoice
     */
    @RequestMapping(value = "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id, @RequestParam(value = "status") InvoiceStatus status) {
        boolean isSuccessful = DatabaseInvoicePostgre.changeInvoiceStatus(id, status);
        if (isSuccessful) {
            return DatabaseInvoicePostgre.getInvoiceById(id);
        }
        return null;
    }

    /**
     * method removeInvoice, berfungsi untuk menghapus salah satu objek berdasarkan
     * ID-nya
     *
     * @param id
     * @return Invoice
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean removeInvoice(@PathVariable int id) {
        return DatabaseInvoicePostgre.removeInvoice(id);
    }

    /**
     * method createBankPayment, berfungsi untuk menambah objek baru
     *
     * @param invoice
     * @return Invoice invoice
     */
    @RequestMapping(value = "/createBankPayment", method = RequestMethod.POST)
    public Invoice createBankPayment(@RequestParam(value = "jobIdList") ArrayList<Integer> jobIdList,
            @RequestParam(value = "jobseekerId") int jobseekerId,
            @RequestParam(value = "adminFee", required = false) Integer adminFee) {
        BankPayment invoice = null;
        ArrayList<Job> jobs = new ArrayList<>();

        for (var i = 0; i < jobIdList.size(); i++) {
            jobs.add(DatabaseJobPostgre.getJobById(jobIdList.get(i)));
        }

        if (adminFee == null) {
            invoice = new BankPayment(DatabaseInvoicePostgre.getLastId() + 1, jobs,
                    DatabaseJobseekerPostgre.getJobseekerById(jobseekerId));
        } else {
            invoice = new BankPayment(DatabaseInvoicePostgre.getLastId() + 1, jobs,
                    DatabaseJobseekerPostgre.getJobseekerById(jobseekerId), adminFee);
        }
        invoice.setTotalFee();

        DatabaseInvoicePostgre.addInvoice(invoice);

        return invoice;

    }

    /**
     * method createEWalletPayment, berfungsi untuk menambah objek baru
     *
     * @param invoice
     * @return Invoice invoice
     */
    @RequestMapping(value = "/createEWalletPayment", method = RequestMethod.POST)
    public Invoice createEWalletPayment(@RequestParam(value = "jobIdList") ArrayList<Integer> jobIdList,
            @RequestParam(value = "jobseekerId") int jobseekerId,
            @RequestParam(value = "referralCode", required = false) String referralCode) {
        EwalletPayment invoice = null;
        ArrayList<Job> jobs = new ArrayList<>();

        for (var i = 0; i < jobIdList.size(); i++) {
            jobs.add(DatabaseJobPostgre.getJobById(jobIdList.get(i)));
        }

        if (referralCode == null) {
            invoice = new EwalletPayment(DatabaseInvoicePostgre.getLastId() + 1, jobs,
                    DatabaseJobseekerPostgre.getJobseekerById(jobseekerId));
        } else {
            invoice = new EwalletPayment(DatabaseInvoicePostgre.getLastId() + 1, jobs,
                    DatabaseJobseekerPostgre.getJobseekerById(jobseekerId),
                    DatabaseBonusPostgre.getBonusByRefferalCode(referralCode));
        }
        invoice.setTotalFee();

        DatabaseInvoicePostgre.addInvoice(invoice);

        return invoice;
    }

}
