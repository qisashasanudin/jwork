import java.util.ArrayList;

public class JWork {

        public static void main(String[] args) {
                Location location1 = new Location("Jawa Barat", "Depok", "Universitas Indonesia");

                DatabaseRecruiter.addRecruiter(new Recruiter(1, "Qisas Hasanudin", "q.t.hasanudin@gmail.com",
                                "0696969696", location1));
                boolean result;

                result = DatabaseJobseeker.addJobseeker(new Jobseeker(1, "Qisas", "qisas.tazkia@ui.ac.id", "password"));
                System.out.println(result);
                result = DatabaseJobseeker.addJobseeker(new Jobseeker(2, "Qisas", "qisas.tazkia@ui.ac.id", "Sedih123"));
                System.out.println(result);
                result = DatabaseJobseeker.addJobseeker(new Jobseeker(2, "Hary", "hary.ridart@ui.ac.id", "Sedih123"));
                System.out.println(result);
                DatabaseBonus.addBonus(new Bonus(1, "BONUS", 500000, 6000000, false));
                DatabaseBonus.addBonus(new Bonus(2, "BONUS", 200000, 5000000, true));

                System.out.println("\n==================== Bonus ====================");
                System.out.println("\n===== Bonus1 =====");
                System.out.println(DatabaseBonus.getBonusById(1));
                System.out.println("\n===== Bonus2 =====");
                System.out.println(DatabaseBonus.getBonusById(2));

                ArrayList<Job> job1 = new ArrayList<Job>();
                job1.add(new Job(1, "Designer", 5000000, JobCategory.FrontEnd, DatabaseRecruiter.getRecruiterById(1)));
                ArrayList<Job> job2 = new ArrayList<Job>();
                job2.add(new Job(2, "Programmer", 6000000, JobCategory.BackEnd, DatabaseRecruiter.getRecruiterById(1)));

                DatabaseInvoice.addInvoice(new BankPayment(1, job1, DatabaseJobseeker.getJobseekerById(1), 6500));
                DatabaseInvoice.getInvoiceByJobseeker(1).get(DatabaseInvoice.getInvoiceByJobseeker(1).size() - 1)
                                .setTotalFee();

                DatabaseInvoice.addInvoice(new EwalletPayment(1, job1, DatabaseJobseeker.getJobseekerById(1),
                                DatabaseBonus.getBonusById(1)));
                DatabaseInvoice.getInvoiceByJobseeker(1).get(DatabaseInvoice.getInvoiceByJobseeker(1).size() - 1)
                                .setTotalFee();

                System.out.println("\n==================== Invoice ====================");
                System.out.println(DatabaseInvoice.getInvoiceDatabase());

                DatabaseInvoice.getInvoiceByJobseeker(1).forEach(e -> e.setInvoiceStatus(InvoiceStatus.Finished));

                System.out.println("\n==================== Invoice ====================");
                System.out.println(DatabaseInvoice.getInvoiceDatabase());

                DatabaseInvoice.addInvoice(new EwalletPayment(2, job1, DatabaseJobseeker.getJobseekerById(2),
                                DatabaseBonus.getBonusById(1)));
                DatabaseBonus.getBonusById(1).setActive(true);
                DatabaseInvoice.getInvoiceDatabase().forEach(e -> e.setTotalFee());

                System.out.println("\n==================== Invoice ====================");
                System.out.println(DatabaseInvoice.getInvoiceDatabase());

                // System.out.println("\n==================== Jobseeker ====================");
                // System.out.println("\n===== Jobseeker1 =====");
                // System.out.println(DatabaseJobseeker.getJobseekerById(1));
                // System.out.println("\n===== Jobseeker2 =====");
                // System.out.println(DatabaseJobseeker.getJobseekerById(2));
                // System.out.println("\n===== Jobseeker3 =====");
                // System.out.println(DatabaseJobseeker.getJobseekerById(3));

                // DatabaseJob.addJob(new Job(1, "Designer", 5000000, JobCategory.FrontEnd,
                // DatabaseRecruiter.getRecruiterById(1)));
                // DatabaseJob.addJob(new Job(2, "Designer", 5000000, JobCategory.FrontEnd,
                // DatabaseRecruiter.getRecruiterById(1)));
                // DatabaseJob.addJob(new Job(3, "Programmer", 6000000, JobCategory.BackEnd,
                // DatabaseRecruiter.getRecruiterById(1)));

                // System.out.println("\n==================== Job ====================");
                // System.out.println("\n===== FrontEnd =====");
                // System.out.println(DatabaseJob.getJobByCategory(JobCategory.FrontEnd));
                // System.out.println("\n===== BackEnd =====");
                // System.out.println(DatabaseJob.getJobByCategory(JobCategory.BackEnd));

                // EwalletPayment invoice1 = new EwalletPayment(1, job1, jobseeker1);
                // EwalletPayment invoice2 = new EwalletPayment(2, job1, jobseeker2, bonus1);
                // EwalletPayment invoice3 = new EwalletPayment(3, job2, jobseeker3, bonus1);

                // BankPayment invoice4 = new BankPayment(4, job1, jobseeker1);
                // BankPayment invoice5 = new BankPayment(5, job2, jobseeker2, 5000);

                // invoice1.setTotalFee();
                // invoice2.setTotalFee();
                // invoice3.setTotalFee();
                // invoice4.setTotalFee();
                // invoice5.setTotalFee();

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

                // invoice4.printData();
                // invoice5.printData();
                // System.out.println("==================== Jobseeker 1 ====================");
                // System.out.println(jobseeker1);
                // System.out.println("\n==================== Jobseeker 2
                // ====================");
                // System.out.println(jobseeker2);
                // System.out.println("\n==================== Jobseeker 3
                // ====================");
                // System.out.println(jobseeker3);

                // jobseeker1.setEmail("e.td@ui.ac.id");
                // jobseeker1.setPassword("Sedih123");

                // System.out.println("==================== Jobseeker 1 (new email & password
                // )====================");
                // System.out.println(jobseeker1);

                // System.out.println("\n==================== E-Wallet ====================");
                // System.out.println(invoice1);
                // System.out.println("\n==================== Bank ====================");
                // System.out.println(invoice5);
        }
}