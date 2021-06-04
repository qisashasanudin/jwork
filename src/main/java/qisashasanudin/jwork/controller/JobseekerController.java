package qisashasanudin.jwork.controller;

import qisashasanudin.jwork.*;
import org.springframework.web.bind.annotation.*;
import qisashasanudin.jwork.database.DatabaseJobseeker;
import qisashasanudin.jwork.exception.EmailAlreadyExistsException;
import qisashasanudin.jwork.exception.InvalidEmailException;
import qisashasanudin.jwork.exception.InvalidPasswordException;
import qisashasanudin.jwork.exception.JobseekerNotFoundException;

import java.util.ArrayList;

@RequestMapping("/jobseeker")
@RestController
public class JobseekerController {

    @RequestMapping("")
    public ArrayList<Jobseeker> getAllJobseeker() {
        ArrayList<Jobseeker> jobseeker = null;
        jobseeker = DatabaseJobseeker.getJobseekerDatabase();
        return jobseeker;
    }

    @RequestMapping("/{id}")
    public Jobseeker getJobseekerById(@PathVariable int id) {
        Jobseeker jobseeker = null;
        try {
            jobseeker = DatabaseJobseeker.getJobseekerById(id);
        } catch (JobseekerNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return jobseeker;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Jobseeker registerJobseeker(
            @RequestParam(value="name") String name,
            @RequestParam(value="email") String email,
            @RequestParam(value="password") String password
    ){
        Jobseeker jobseeker = new Jobseeker(DatabaseJobseeker.getLastId()+1, name, email, password);
        try {
            DatabaseJobseeker.addJobseeker(jobseeker);
        } catch (EmailAlreadyExistsException | InvalidEmailException | InvalidPasswordException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return jobseeker;
    }




    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Jobseeker loginJobseeker(
            @RequestParam(value="email") String email,
            @RequestParam(value="password") String password
    ){
        try {
            return(DatabaseJobseeker.getJobseekerLogin(email, password));
        } catch (InvalidEmailException | InvalidPasswordException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}

