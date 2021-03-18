public class Invoice {
    private int id;
    private int idJob;
    private String date;
    private int totalFee;
    private Jobseeker jobseeker;

    public Invoice(int id, int idJob, String date, int totalFee, Jobseeker jobseeker) {
        this.id = id;
        this.idJob = idJob;
        this.date = date;
        this.totalFee = totalFee;
        this.jobseeker = jobseeker;
    }

    public int getId() {
        return id;
    }

    public int getIdJob() {
        return idJob;
    }

    public String getDate() {
        return date;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public Jobseeker getJobseeker() {
        return jobseeker;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdJob(int idJob) {
        this.idJob = idJob;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public void setJobseeker(Jobseeker jobseeker) {
        this.jobseeker = jobseeker;
    }

    public void printData() {

    }
}
