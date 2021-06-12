package qisashasanudin.jwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import qisashasanudin.jwork.database.legacy.DatabaseJob;
import qisashasanudin.jwork.database.legacy.DatabaseRecruiter;
import qisashasanudin.jwork.exception.RecruiterNotFoundException;

@SpringBootApplication
public class JWork {

        public static void main(String[] args) {

                // TODO: Create new database if not exists

                Location loc1 = new Location("Jawa Barat", "Sukabumi", "Cikole");
                // Location loc2 = new Location("DKI Jakarta", "Jakarta Selatan", "Kemang");
                // Location loc3 = new Location("Jawa Barat", "Depok", "Kukusan");

                DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Hary", "hary@ui.ac.id",
                                "081234567890", loc1));

                try {
                        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "Mobile Developer", 7000000,
                                        JobCategory.FrontEnd, DatabaseRecruiter.getRecruiterById(1)));
                } catch (RecruiterNotFoundException e) {
                        System.out.println(e.getMessage());
                }

                try {
                        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "Data Analyst", 8000000,
                                        JobCategory.BackEnd, DatabaseRecruiter.getRecruiterById(1)));
                } catch (RecruiterNotFoundException e) {
                        System.out.println(e.getMessage());
                }

                SpringApplication.run(JWork.class, args);
        }
}
