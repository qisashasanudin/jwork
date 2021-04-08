import java.util.GregorianCalendar;

public class JWork {

    public static void main(String[] args) {
        Location location1 = new Location("Jawa Barat", "Sukabumi", "RS Ridogalih");
        Recruiter recruiter1 = new Recruiter(1, "Qisas Hasanudin", "q.t.hasanudin@gmail.com", "0696969696", location1);
        
        Jobseeker jobseeker1 = new Jobseeker(1, "Andi", ".etd@ui.ac.id", "sedih123", new GregorianCalendar(2021, 3, 8));
        Jobseeker jobseeker2 = new Jobseeker(2, "Budi", "etd@ui.ac.id", "Sedih123", 2021, 4, 8);
        Jobseeker jobseeker3 = new Jobseeker(3, "Dodi", "et..d@ui.ac.id", "Sedih123");
        
        Bonus bonus1 = new Bonus(1, "BONUS69420", 500000, 5000000, true);
        
        Job job1 = new Job(1, "Designer", 5000000, JobCategory.FrontEnd, recruiter1);
        Job job2 = new Job(2, "Programmer", 6000000, JobCategory.FrontEnd, recruiter1);
        
        EwalletPayment invoice1 = new EwalletPayment(1, job1, "25 April 2021", jobseeker1, InvoiceStatus.Finished);
        EwalletPayment invoice2 = new EwalletPayment(2, job1, "25 April 2021", jobseeker2, bonus1, InvoiceStatus.Finished);
        EwalletPayment invoice3 = new EwalletPayment(3, job2, "25 April 2021", jobseeker3, bonus1, InvoiceStatus.Finished);
        
        BankPayment invoice4 = new BankPayment(4, job1, "25 April 2021", jobseeker1, InvoiceStatus.Finished);
        BankPayment invoice5 = new BankPayment(5, job2, "25 April 2021", jobseeker2, InvoiceStatus.Finished, 5000);
        
        // .out.println(recruiter1.getName());
        // recruiter1.setName("Hary Ridart");
        // System.out.println(recruiter1.getName());

        // System.out.println(job1.getName());

        // System.out.println(JobCategory.WebDeveloper.toString());
        // System.out.println(JobCategory.FrontEnd.toString());
        // System.out.println(JobCategory.BackEnd.toString());
        // System.out.println(JobCategory.UI.toString());
        // System.out.println(JobCategory.UX.toString());
        // System.out.println(JobCategory.Devops.toString());
        // System.out.println(JobCategory.DataScientist.toString());
        // System.out.println(JobCategory.DataAnalyst.toString());

        // System.out.println(PaymentType.BankPayment.toString());
        // System.out.println(PaymentType.EwalletPayment.toString());

        // job1.printData();
        
        // System.out.println(InvoiceStatus.Ongoing.toString());
        // System.out.println(InvoiceStatus.Finished.toString());
        // System.out.println(InvoiceStatus.Cancelled.toString());
        
        // invoice1.printData();
        // invoice2.printData();
        // invoice3.printData();
        
        //invoice4.printData();
        //invoice5.printData();
        System.out.println("==================== Jobseeker 1 ====================");
        System.out.println(jobseeker1);
        System.out.println("\n==================== Jobseeker 2 ====================");
        System.out.println(jobseeker2);
        System.out.println("\n==================== Jobseeker 3 ====================");
        System.out.println(jobseeker3);
        
        jobseeker1.setEmail("e.td@ui.ac.id");
        jobseeker1.setPassword("Sedih123"); 
        
        System.out.println("==================== Jobseeker 1 (new email & password )====================");
        System.out.println(jobseeker1);
    }
}