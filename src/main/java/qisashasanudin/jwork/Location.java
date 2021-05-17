package qisashasanudin.jwork;

/**
 * Praktikum OOP - Program "JWork" class Location: berfungsi untuk meng-generate
 * object yang merepresentasikan lokasi tertentu
 *
 * @author Qisas Tazkia Hasanudin
 * @version 18-03-2021
 */

public class Location {
    // instance variable
    private String province;
    private String city;
    private String description;

    /**
     * Constructor untuk object dari class Location
     */
    public Location(String province, String city, String description) {
        this.province = province;
        this.city = city;
        this.description = description;
    }

    /**
     * method getProvince, berfungsi sebagai getter untuk mengambil value province
     *
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * method getCity, berfungsi sebagai getter untuk mengambil value city
     *
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * method getDescription, berfungsi sebagai getter untuk mengambil value
     * description
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * method setProvince, berfungsi sebagai setter untuk mengisi value province
     *
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * method setCity, berfungsi sebagai setter untuk mengisi value city
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * method setDescription, berfungsi sebagai setter untuk mengisi value
     * description
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * method toString, berfungsi untuk mencetak instance variable ke layar
     */
    public String toString() {
        return ("Province = " + getProvince() + "\nCity = " + getCity() + "\nDescription = " + getDescription());
    }
}
