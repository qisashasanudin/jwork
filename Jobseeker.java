
/**
 * Praktikum OOP - Program "JWork"
 *
 * @author Qisas Tazkia Hasanudin
 * @version 18-03-2021
 */

public class Jobseeker {
    // instance variable
    private int id;
    private String name;
    private String email;
    private String password;
    private String joinDate;

    /*
     * Constructor untuk object dari class Jobseeker
     */
    public Jobseeker(int id, String name, String email, String password, String joinDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
    }

    /**
     * method getId, berfungsi sebagai getter untuk mengambil value id
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * method getName, berfungsi sebagai getter untuk mengambil value name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * method getEmail, berfungsi sebagai getter untuk mengambil value email
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * method getPassword, berfungsi sebagai getter untuk mengambil value password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * method getJoinDate, berfungsi sebagai getter untuk mengambil value joinDate
     *
     * @return joinDate
     */
    public String getJoinDate() {
        return joinDate;
    }

    /**
     * method setId, berfungsi sebagai setter untuk mengisi value id
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * method setName, berfungsi sebagai setter untuk mengisi value name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method setEmail, berfungsi sebagai setter untuk mengisi value email
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * method setPassword, berfungsi sebagai setter untuk mengisi value password
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * method setJoinDate, berfungsi sebagai setter untuk mengisi value joinDate
     *
     * @param joinDate
     */
    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    /**
     * method printData, berfungsi untuk mencetak instance variable ke layar
     */
    public void printData() {
        System.out.println("nama Jobseeker: " + name);
    }
}
