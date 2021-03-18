public class DatabaseJob {
    private String[] listJob;

    public DatabaseJob(String[] listJob) {
        this.listJob = listJob;
    }

    public boolean addJob(Job job) {
        return false;
    }

    public boolean removeJob(Job job) {
        return false;
    }

    public Job getJob() {
        return null;
    }

    public String[] getListJob() {
        return listJob;
    }

    public void setListJob(String[] listJob) {
        this.listJob = listJob;
    }

}
