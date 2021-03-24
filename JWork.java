public class JWork {

    public static void main(String[] args) {
        Location location1 = new Location("Jawa Barat", "Sukabumi", "RS Ridogalih");
        Recruiter recruiter1 = new Recruiter(1, "Qisas Hasanudin", "q.t.hasanudin@gmail.com", "0696969696", location1);
        Job job1 = new Job(2, "Guru", 5000000, "PNS", recruiter1);
        Jobseeker jobseeker1 = new Jobseeker(2, "Andi", "andi@gmail.com", "sedih123", "20 Maret 2021");
        Invoice invoice1 = new Invoice(3, 2, "18 Maret 2021", 5000000, jobseeker1);
        
        System.out.println(recruiter1.getName());
        recruiter1.setName("Hary Ridart");
        System.out.println(recruiter1.getName());
        
        System.out.println(job1.getName());
        }
}