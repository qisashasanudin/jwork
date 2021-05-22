package qisashasanudin.jwork.controller;

import qisashasanudin.jwork.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RequestMapping("/invoice")
@RestController
public class InvoiceController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Invoice> getAllInvoice() {
        return (DatabaseInvoice.getInvoiceDatabase());
    }

    @RequestMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable int id) {
        Invoice invoice = null;
        try {
            invoice = DatabaseInvoice.getInvoiceById(id);
        } catch (InvoiceNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return invoice;
    }

    @RequestMapping("/jobseeker/{jobseekerId}")
    public ArrayList<Invoice> getInvoiceByJobseeker(@PathVariable int jobseekerId) {
        ArrayList<Invoice> invoices = null;
        invoices = DatabaseInvoice.getInvoiceByJobseeker(jobseekerId);
        return invoices;
    }

    @RequestMapping(value = "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id, @RequestParam(value = "status") InvoiceStatus status) {
        Invoice invoice = null;
        try {
            invoice = DatabaseInvoice.getInvoiceById(id);
            invoice.setInvoiceStatus(status);
            return invoice;
        } catch (InvoiceNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean removeInvoice(@PathVariable int id) {
        boolean result = false;
        try {
            DatabaseInvoice.removeInvoice(id);
            result = true;
        } catch (InvoiceNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/createBankPayment", method = RequestMethod.POST)
    public Invoice createBankPayment(
            @RequestParam(value = "jobIdList") ArrayList<Integer> jobIdList,
            @RequestParam(value = "jobseekerId") int jobseekerId,
            @RequestParam(value = "adminFee", required = false) Integer adminFee
    ) {
        Invoice invoice = null;
        ArrayList<Job> jobs = new ArrayList<>();

        for (var i = 0; i < jobIdList.size(); i++) {
            try {
                jobs.add(DatabaseJob.getJobById(jobIdList.get(i)));
            } catch (JobNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            if(adminFee == null){
                invoice = new BankPayment(DatabaseInvoice.getLastId() + 1, jobs,
                        DatabaseJobseeker.getJobseekerById(jobseekerId));
            }else {
                invoice = new BankPayment(DatabaseInvoice.getLastId() + 1, jobs,
                        DatabaseJobseeker.getJobseekerById(jobseekerId), adminFee);
            }
            invoice.setTotalFee();
        } catch (JobseekerNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabaseInvoice.addInvoice(invoice);
        } catch (OngoingInvoiceAlreadyExistsException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return invoice;

    }

    @RequestMapping(value = "/createEWalletPayment", method = RequestMethod.POST)
    public Invoice createEWalletPayment(
            @RequestParam(value = "jobIdList") ArrayList<Integer> jobIdList,
            @RequestParam(value = "jobseekerId") int jobseekerId,
            @RequestParam(value = "referralCode", required = false) String referralCode
    ) {
        Invoice invoice = null;
        ArrayList<Job> jobs = new ArrayList<>();

        for (var i = 0; i < jobIdList.size(); i++) {
            try {
                jobs.add(DatabaseJob.getJobById(jobIdList.get(i)));
            } catch (JobNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            if(referralCode == null){
                invoice = new EwalletPayment(DatabaseInvoice.getLastId() + 1, jobs,
                        DatabaseJobseeker.getJobseekerById(jobseekerId));
            }else{
                invoice = new EwalletPayment(DatabaseInvoice.getLastId() + 1, jobs,
                        DatabaseJobseeker.getJobseekerById(jobseekerId),
                        DatabaseBonus.getBonusByRefferalCode(referralCode));
            }
            invoice.setTotalFee();
        } catch (JobseekerNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabaseInvoice.addInvoice(invoice);
        } catch (OngoingInvoiceAlreadyExistsException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return invoice;
    }

}
