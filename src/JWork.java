import java.util.ArrayList;

public class JWork extends Thread {
        public static void main(String[] args) {
                JWork thread = new JWork();
                thread.start();

                try{
                        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Hary", "hary.ridart@ui.ac.id", "Sedih123"));
                        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Qisas", "qisas.tazkia@ui.ac.id", "Sedih123"));
                        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Qisas", "qisas.tazkia@ui.ac.id", "password"));
                        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Ridart", "ridart69@ui.ac.id", "Sedih123"));
                } catch (EmailAlreadyExistsException e){
                        System.out.println(e.getMessage());
                }
                try {
                        DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId()+1, "BONUS1", 3000, 10000, true));
                        DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId()+1, "BONUS1", 15000, 50000, true));
                } catch (ReferralCodeAlreadyExistsException e) {
                        System.out.println(e.getMessage());
                }
                try {
                        DatabaseJobseeker.removeJobseeker(11);
                } catch (JobseekerNotFoundException e) {
                        System.out.println(e.getMessage());
                }
                try {
                        DatabaseRecruiter.removeRecruiter(12);
                } catch (RecruiterNotFoundException e) {
                        System.out.println(e.getMessage());
                }
                try {
                        DatabaseJob.getJobById(13);
                } catch (JobNotFoundException e) {
                        System.out.println(e.getMessage());
                }
                try {
                        DatabaseBonus.getBonusById(14);
                } catch (BonusNotFoundException bonusNotFound) {
                        System.out.println(bonusNotFound.getMessage());
                }

                System.out.println("\n ========== Jobseeker ==========");
                System.out.println(DatabaseJobseeker.getJobseekerDatabase());
                System.out.println("\n ========== Bonus ==========");
                System.out.println(DatabaseBonus.getBonusDatabase());

                Location location1 = new Location("Jawa Barat", "Depok", "Universitas Indonesia");
                DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "Qisas Hasanudin", "q.t.hasanudin@gmail.com","0696969696", location1));
                ArrayList<Job> job1 = new ArrayList<>();

                try {
                        job1.add(new Job(1, "Designer", 5000000, JobCategory.FrontEnd, DatabaseRecruiter.getRecruiterById(1)));
                } catch (RecruiterNotFoundException e) {
                        System.out.println(e.getMessage());
                }

                try {
                        DatabaseInvoice.addInvoice(new BankPayment(DatabaseInvoice.getLastId()+1, job1, DatabaseJobseeker.getJobseekerById(1), 6500));
                } catch (JobseekerNotFoundException e) {
                        System.out.println(e.getMessage());
                }

                for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase()){
                        new Thread(new FeeCalculator(invoice)).start();
                }
        }
}