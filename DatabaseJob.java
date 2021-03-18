/**
 * Praktikum OOP - Program "JWork"
 *
 * @author Qisas Tazkia Hasanudin
 * @version 18-03-2021
 */

public class DatabaseJob {
    // instance variable
    private String[] listJob;
    
    /*
     * Constructor untuk object dari class DatabaseJob
     */
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
