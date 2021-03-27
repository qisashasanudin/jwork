public class JWork {

    public static void main(String[] args) {
        Location location1 = new Location("Jawa Barat", "Sukabumi", "RS Ridogalih");
        Recruiter recruiter1 = new Recruiter(1, "Qisas Hasanudin", "q.t.hasanudin@gmail.com", "0696969696", location1);
        Job job1 = new Job(2, "Developer", 5000000, JobCategory.FrontEnd, recruiter1);
        Jobseeker jobseeker1 = new Jobseeker(2, "Andi", "andi@gmail.com", "sedih123", "27/03/2021");
        Invoice invoice1 = new Invoice(3, job1.getId(), "27/03/2021", job1.getFee(), jobseeker1, PaymentType.BankPayment, InvoiceStatus.Finished);

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
        
        invoice1.printData();
    }
}