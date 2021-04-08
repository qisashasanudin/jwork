/**
 * Praktikum OOP - Program "JWork" class Recruiter: berfungsi untuk
 * meng-generate object yang merepresentasikan seorang perekrut karyawan
 * tertentu
 *
 * @author Qisas Tazkia Hasanudin
 * @version 18-03-2021
 */

public class Recruiter {
    // instance variable
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private Location location;

    /**
     * Constructor untuk object dari class Recruiter
     */
    public Recruiter(int id, String name, String email, String phoneNumber, Location location) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
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
     * method getPhoneNumber, berfungsi sebagai getter untuk mengambil value
     * phoneNumber
     *
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * method getLocation, berfungsi sebagai getter untuk mengambil value location
     *
     * @return location
     */
    public Location getLocation() {
        return location;
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
     * method setPhoneNumber, berfungsi sebagai setter untuk mengisi value
     * phoneNumber
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * method setLocation, berfungsi sebagai setter untuk mengisi value location
     *
     * @param location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * method toString, berfungsi untuk mencetak instance variable ke layar
     */
    public String toString() {
        return ("Id = " + getId() + "\nNama = " + getName() + "\nPhoneNumber = " + getPhoneNumber() + "\nLocation = "
                + getLocation());
    }
}
