package qisashasanudin.jwork.controller;

import org.springframework.web.bind.annotation.*;
import qisashasanudin.jwork.Jobseeker;
import qisashasanudin.jwork.database.postgre.DatabaseJobseekerPostgre;

import java.util.ArrayList;

@RequestMapping("/jobseeker")
@RestController
public class JobseekerController {

    @RequestMapping("")
    public ArrayList<Jobseeker> getAllJobseeker() {
        return DatabaseJobseekerPostgre.getJobseekerDatabase();
    }

    @RequestMapping("/{id}")
    public Jobseeker getJobseekerById(@PathVariable int id) {
        return DatabaseJobseekerPostgre.getJobseekerById(id);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Jobseeker registerJobseeker(@RequestParam(value = "name") String name,
            @RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {
        return DatabaseJobseekerPostgre.addJobseeker(name, email, password);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Jobseeker loginJobseeker(@RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password) {
        return DatabaseJobseekerPostgre.getJobseekerLogin(email, password);
    }
}
