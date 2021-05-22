package qisashasanudin.jwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JWork {

        public static void main(String[] args) {
                Location loc1 = new Location("Jawa Barat", "Depok", "Kukusan");
                Location loc2 = new Location("DKI Jakarta", "Jakarta Selatan", "Kemang");
                Location loc3 = new Location("Jawa Barat", "Sukabumi", "Cikole");

                DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "Qisas", "q.t.hasanudin@gmail.com", "087815710719", loc1));
                DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "Tazkia", "qisas.tazkia@ui.ac.id", "081234567890", loc2));
                DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "Hasanudin", "udin.watcher@gmail.com", "086969696969", loc3));

                try{
                        DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Mobile Developer", 8000000, JobCategory.FrontEnd, DatabaseRecruiter.getRecruiterById(1)));
                }catch (RecruiterNotFoundException e){
                        System.out.println(e.getMessage());
                }

                try{
                        DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Web Developer", 8000000, JobCategory.FrontEnd, DatabaseRecruiter.getRecruiterById(2)));
                }catch (RecruiterNotFoundException e){
                        System.out.println(e.getMessage());
                }

                try{
                        DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Data Analyst", 8000000, JobCategory.DataAnalyst, DatabaseRecruiter.getRecruiterById(3)));
                }catch (RecruiterNotFoundException e){
                        System.out.println(e.getMessage());
                }

                try{
                        DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "UI/UX Designer", 8000000, JobCategory.UIUX, DatabaseRecruiter.getRecruiterById(3)));
                }catch (RecruiterNotFoundException e){
                        System.out.println(e.getMessage());
                }

                try{
                        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Qisas Hasanudin", "q.t.hasanudin@gmail.com", "Sedih6969"));
                }catch (EmailAlreadyExistsException e){
                        System.out.println(e.getMessage());
                }

                Invoice invoice = null;
                try{
                        invoice = new EwalletPayment(DatabaseInvoice.getLastId() + 1, DatabaseJob.getJobByRecruiter(3), DatabaseJobseeker.getJobseekerById(1));
                        invoice.setTotalFee();
                }catch(JobseekerNotFoundException e){
                        System.out.println(e.getMessage());
                }

                try{
                        DatabaseInvoice.addInvoice(invoice);
                }catch(OngoingInvoiceAlreadyExistsException e){
                        System.out.println(e.getMessage());
                }

                SpringApplication.run(JWork.class, args);
        }



}
