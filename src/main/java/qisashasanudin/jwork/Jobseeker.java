package qisashasanudin.jwork;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;

/**
 * Praktikum OOP - Program "JWork" class Jobseeker: berfungsi untuk
 * meng-generate object yang merepresentasikan pencari pekerjaan / karyawan
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
    public Calendar joinDate;

    /**
     * Constructor untuk object dari class Jobseeker
     */
    public Jobseeker(int id, String name, String email, String password, Calendar joinDate) {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        this.joinDate = joinDate;
    }

    public Jobseeker(int id, String name, String email, String password, int year, int month, int dayOfMonth) {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        this.joinDate = new GregorianCalendar(year, month - 1, dayOfMonth);
    }

    public Jobseeker(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        this.joinDate = Calendar.getInstance();
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
    public Calendar getJoinDate() {
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
        String regex = "\\A[a-z0-9!#$%&'*+/=?^_‘{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_‘{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\z";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            this.email = email;
        } else {
            this.email = "";
        }
    }

    /**
     * method setPassword, berfungsi sebagai setter untuk mengisi value password
     *
     * @param password
     */
    public void setPassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {
            this.password = password;
        } else {
            this.password = "";
        }
    }

    /**
     * method setJoinDate, berfungsi sebagai setter untuk mengisi value joinDate
     *
     * @param joinDate
     */
    public void setJoinDate(Calendar joinDate) {
        this.joinDate = joinDate;
    }

    public void setJoinDate(int year, int month, int dayOfMonth) {
        this.joinDate = new GregorianCalendar(year, month - 1, dayOfMonth);
    }

    /**
     * method toString, berfungsi untuk mencetak instance variable ke layar
     */
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
        String date = dateFormat.format(getJoinDate().getTime());
        if (joinDate != null) {
            return ("\nId = " + getId() + "\nNama = " + getName() + "\nEmail = " + getEmail() + "\nPassword = "
                    + getPassword() + "\nJoin Date = " + date);
        } else {
            return ("\nId = " + getId() + "\nNama = " + getName() + "\nEmail = " + getEmail() + "\nPassword = "
                    + getPassword());
        }
    }

}
