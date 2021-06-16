package qisashasanudin.jwork.controller;

import qisashasanudin.jwork.*;
import org.springframework.web.bind.annotation.*;
import qisashasanudin.jwork.database.postgre.DatabaseRecruiterPostgre;

import java.util.ArrayList;

/**
 * Praktikum OOP - Program "JWork" - class RecruiterController: berfungsi untuk
 * mengatur HTML query antara client dan server
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */

@RequestMapping("/recruiter")
@RestController
public class RecruiterController {

    /**
     * method getAllRecruiter, berfungsi sebagai getter untuk mengambil list berisi
     * semua objek yang berada di dalam database
     *
     * @return ArrayList<Recruiter> RECRUITER_DATABASE
     */
    @RequestMapping("")
    public ArrayList<Recruiter> getAllRecruiter() {
        return DatabaseRecruiterPostgre.getRecruiterDatabase();
    }

    /**
     * method getRecruiterById, berfungsi sebagai getter untuk mengambil salah satu
     * objek menggunakan ID-nya
     *
     * @param id
     * @return Recruiter recruiter
     */
    @RequestMapping("/{id}")
    public Recruiter getRecruiterById(@PathVariable int id) {
        return DatabaseRecruiterPostgre.getRecruiterById(id);
    }

    /**
     * method addRecruiter, berfungsi untuk menambah objek baru
     *
     * @param jobseeker
     * @return Recruiter recruiter
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Recruiter addRecruiter(@RequestParam(value = "name") String name,
            @RequestParam(value = "email") String email, @RequestParam(value = "phoneNumber") String phoneNumber,
            @RequestParam(value = "province") String province, @RequestParam(value = "city") String city,
            @RequestParam(value = "description") String description) {
        int id = DatabaseRecruiterPostgre.getLastId() + 1;
        Recruiter recruiter = new Recruiter(id, name, email, phoneNumber, new Location(province, city, description));
        return DatabaseRecruiterPostgre.addRecruiter(recruiter);
    }

}