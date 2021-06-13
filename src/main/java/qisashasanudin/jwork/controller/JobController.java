package qisashasanudin.jwork.controller;

import qisashasanudin.jwork.*;
import org.springframework.web.bind.annotation.*;
import qisashasanudin.jwork.database.postgre.DatabaseJobPostgre;
import qisashasanudin.jwork.database.postgre.DatabaseRecruiterPostgre;

import java.util.ArrayList;

@RequestMapping("/job")
@RestController
public class JobController {

    @RequestMapping("")
    public ArrayList<Job> getAllJob() {
        return DatabaseJobPostgre.getJobDatabase();
    }

    @RequestMapping("/{id}")
    public Job getJobById(@PathVariable int id) {
        return DatabaseJobPostgre.getJobById(id);
    }

    @RequestMapping("/recruiter/{recruiterId}")
    public ArrayList<Job> getJobByRecruiter(@PathVariable int recruiterId) {
        return DatabaseJobPostgre.getJobByRecruiter(recruiterId);
    }

    @RequestMapping("/category/{category}")
    public ArrayList<Job> getJobByCategory(@PathVariable JobCategory category) {
        return DatabaseJobPostgre.getJobByCategory(category);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Job addJob(@RequestParam(value = "name") String name, @RequestParam(value = "fee") int fee,
            @RequestParam(value = "category") JobCategory category,
            @RequestParam(value = "recruiterId") int recruiterId) {
        int id = DatabaseJobPostgre.getLastId() + 1;
        Job job = new Job(id, name, fee, category, DatabaseRecruiterPostgre.getRecruiterById(recruiterId));
        return DatabaseJobPostgre.addJob(job);
    }
}