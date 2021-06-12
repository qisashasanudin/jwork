// package qisashasanudin.jwork.controller.legacy;

// import qisashasanudin.jwork.*;
// import org.springframework.web.bind.annotation.*;
// import qisashasanudin.jwork.database.legacy.DatabaseRecruiter;
// import qisashasanudin.jwork.exception.RecruiterNotFoundException;

// import java.util.ArrayList;

// @RequestMapping("/recruiter")
// @RestController
// public class RecruiterController {

// @RequestMapping("")
// public ArrayList<Recruiter> getAllRecruiter() {
// return DatabaseRecruiter.getRecruiterDatabase();
// }

// @RequestMapping("/{id}")
// public Recruiter getRecruiterById(@PathVariable int id) {
// Recruiter recruiter = null;
// try {
// recruiter = DatabaseRecruiter.getRecruiterById(id);
// } catch (RecruiterNotFoundException e) {
// System.out.println(e.getMessage());
// }

// return recruiter;
// }

// @RequestMapping(value = "", method = RequestMethod.POST)
// public Recruiter addRecruiter(
// @RequestParam(value="name") String name,
// @RequestParam(value="email") String email,
// @RequestParam(value="phoneNumber") String phoneNumber,
// @RequestParam(value="province") String province,
// @RequestParam(value="city") String city,
// @RequestParam(value="description") String description
// ){
// Recruiter recruiter = new Recruiter(DatabaseRecruiter.getLastId()+1, name,
// email, phoneNumber, new Location(province, city, description));

// try{
// DatabaseRecruiter.addRecruiter(recruiter);
// } catch (Exception e) {
// System.out.println(e.getMessage());
// return null;
// }
// return recruiter;
// }

// }