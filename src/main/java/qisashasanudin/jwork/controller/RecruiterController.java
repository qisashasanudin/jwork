package qisashasanudin.jwork.controller;

import qisashasanudin.jwork.*;
import org.springframework.web.bind.annotation.*;
import qisashasanudin.jwork.database.postgre.DatabaseRecruiterPostgre;

import java.util.ArrayList;

@RequestMapping("/recruiter")
@RestController
public class RecruiterController {

    @RequestMapping("")
    public ArrayList<Recruiter> getAllRecruiter() {
        return DatabaseRecruiterPostgre.getRecruiterDatabase();
    }

    @RequestMapping("/{id}")
    public Recruiter getRecruiterById(@PathVariable int id) {
        return DatabaseRecruiterPostgre.getRecruiterById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Recruiter addRecruiter(@RequestParam(value = "name") String name,
            @RequestParam(value = "email") String email, @RequestParam(value = "phoneNumber") String phoneNumber,
            @RequestParam(value = "province") String province, @RequestParam(value = "city") String city,
            @RequestParam(value = "description") String description) {
        return DatabaseRecruiterPostgre.addRecruiter(name, email, phoneNumber,
                new Location(province, city, description));
    }

}