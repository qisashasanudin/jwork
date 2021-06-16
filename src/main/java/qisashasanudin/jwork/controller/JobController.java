package qisashasanudin.jwork.controller;

import qisashasanudin.jwork.*;
import org.springframework.web.bind.annotation.*;
import qisashasanudin.jwork.database.postgre.DatabaseJobPostgre;
import qisashasanudin.jwork.database.postgre.DatabaseRecruiterPostgre;

import java.util.ArrayList;

/**
 * Praktikum OOP - Program "JWork" - class JobController: berfungsi untuk
 * mengatur HTML query antara client dan server
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */
@RequestMapping("/job")
@RestController
public class JobController {

    /**
     * method getAllJob, berfungsi sebagai getter untuk mengambil list berisi semua
     * objek yang berada di dalam database
     *
     * @return ArrayList<Job> JOB_DATABASE
     */
    @RequestMapping("")
    public ArrayList<Job> getAllJob() {
        return DatabaseJobPostgre.getJobDatabase();
    }

    /**
     * method getJobById, berfungsi sebagai getter untuk mengambil salah satu objek
     * menggunakan ID-nya
     *
     * @param id
     * @return Job job
     */
    @RequestMapping("/{id}")
    public Job getJobById(@PathVariable int id) {
        return DatabaseJobPostgre.getJobById(id);
    }

    /**
     * method getJobByRecruiter, berfungsi sebagai getter untuk mengambil salah satu
     * objek berdasarkan ID dari recruiter yang membuat Job tersebut
     *
     * @param jobseekerId
     * @return ArrayList<Job> jobs
     */
    @RequestMapping("/recruiter/{recruiterId}")
    public ArrayList<Job> getJobByRecruiter(@PathVariable int recruiterId) {
        return DatabaseJobPostgre.getJobByRecruiter(recruiterId);
    }

    /**
     * method getJobByRecruiter, berfungsi sebagai getter untuk mengambil salah satu
     * job berdasarkan kategorinya
     *
     * @param category
     * @return ArrayList<Job> jobs
     */
    @RequestMapping("/category/{category}")
    public ArrayList<Job> getJobByCategory(@PathVariable JobCategory category) {
        return DatabaseJobPostgre.getJobByCategory(category);
    }

    /**
     * method addJob, berfungsi untuk menambah objek baru
     *
     * @param job
     * @return Job job
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Job addJob(@RequestParam(value = "name") String name, @RequestParam(value = "fee") int fee,
            @RequestParam(value = "category") JobCategory category,
            @RequestParam(value = "recruiterId") int recruiterId) {
        int id = DatabaseJobPostgre.getLastId() + 1;
        Job job = new Job(id, name, fee, category, DatabaseRecruiterPostgre.getRecruiterById(recruiterId));
        return DatabaseJobPostgre.addJob(job);
    }
}