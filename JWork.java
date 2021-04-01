public class JWork {

    public static void main(String[] args) {
        Location location1 = new Location("Jawa Barat", "Sukabumi", "RS Ridogalih");
        Recruiter recruiter1 = new Recruiter(1, "Qisas Hasanudin", "q.t.hasanudin@gmail.com", "0696969696", location1);
        
        Jobseeker jobseeker1 = new Jobseeker(1, "Andi", "andi@gmail.com", "sedih123", "27/03/2021");
        Jobseeker jobseeker2 = new Jobseeker(2, "Budi", "budi@gmail.com", "sedih123", "27/03/2021");
        Jobseeker jobseeker3 = new Jobseeker(3, "Dodi", "dodi@gmail.com", "sedih123", "27/03/2021");
        
        Bonus bonus1 = new Bonus(1, "BONUS69420", 500000, 5000000, true);
        
        Job job1 = new Job(1, "Designer", 5000000, JobCategory.FrontEnd, recruiter1);
        Job job2 = new Job(2, "Programmer", 6000000, JobCategory.FrontEnd, recruiter1);
        
        EwalletPayment invoice1 = new EwalletPayment(1, job1, "25 April 2021", jobseeker1, InvoiceStatus.Finished);
        EwalletPayment invoice2 = new EwalletPayment(2, job1, "25 April 2021", jobseeker2, bonus1, InvoiceStatus.Finished);
        EwalletPayment invoice3 = new EwalletPayment(3, job2, "25 April 2021", jobseeker3, bonus1, InvoiceStatus.Finished);
        
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
        
        invoice1.setTotalFee();
        invoice2.setTotalFee();
        invoice3.setTotalFee();
        invoice1.printData();
        invoice2.printData();
        invoice3.printData();
    }
}