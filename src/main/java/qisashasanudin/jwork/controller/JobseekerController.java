package qisashasanudin.jwork.controller;

import org.springframework.web.bind.annotation.*;
import qisashasanudin.jwork.Jobseeker;
import qisashasanudin.jwork.database.postgre.DatabaseJobseekerPostgre;

import java.util.ArrayList;

/**
 * Praktikum OOP - Program "JWork" - class JobseekerController: berfungsi untuk
 * mengatur HTML query antara client dan server
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */
@RequestMapping("/jobseeker")
@RestController
public class JobseekerController {

    /**
     * method getAllJobseeker, berfungsi sebagai getter untuk mengambil list berisi
     * semua objek yang berada di dalam database
     *
     * @return ArrayList<Jobseeker> JOBSEEKER_DATABASE
     */
    @RequestMapping("")
    public ArrayList<Jobseeker> getAllJobseeker() {
        return DatabaseJobseekerPostgre.getJobseekerDatabase();
    }

    /**
     * method getJobseekerById, berfungsi sebagai getter untuk mengambil salah satu
     * objek menggunakan ID-nya
     *
     * @param jobseekerId
     * @return Jobseeker jobseeeker
     */
    @RequestMapping("/{id}")
    public Jobseeker getJobseekerById(@PathVariable int id) {
        return DatabaseJobseekerPostgre.getJobseekerById(id);
    }

    /**
     * method registerJobseeker, berfungsi untuk menambah objek baru
     *
     * @param jobseeker
     * @return Jobseeker jobseeker
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Jobseeker registerJobseeker(@RequestParam(value = "name") String name,
            @RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {
        int id = DatabaseJobseekerPostgre.getLastId() + 1;
        Jobseeker jobseeker = new Jobseeker(id, name, email, password);
        return DatabaseJobseekerPostgre.addJobseeker(jobseeker);
    }

    /**
     * method loginJobseeker, berfungsi sebagai getter untuk mengambil salah satu
     * objek menggunakan email dan password-nya
     *
     * @param email_new
     * @param password_new
     * @return Jobseeker jobseeker
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Jobseeker loginJobseeker(@RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password) {
        return DatabaseJobseekerPostgre.getJobseekerLogin(email, password);
    }
}
