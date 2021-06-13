package qisashasanudin.jwork;

/**
 * Praktikum OOP - Program "JWork" - Enumeration class JobCategory -
 * mengenumerasi semua kategori pekerjaan
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */
public enum JobCategory {
    /**
     * Semua enumerasi yang ada
     */
    Network("Network"), FrontEnd("Front End"), BackEnd("Back End"), WebDeveloper("Web Developer"),
    MobileDeveloper("Mobile Developer"), UIUX("UI/UX"), Devops("Devops"), DataScientist("Data Scientist"),
    DataAnalyst("Data Analyst");

    private final String text;

    /**
     * Constructor untuk enumerator JobCategory
     * 
     * @param text
     */
    private JobCategory(String text) {
        this.text = text;
    }

    /**
     * /** method toString, berfungsi untuk mengembalikan enumerasi dalam bentuk
     * string
     * 
     * @return text
     */
    public String toString() {
        return text;
    }

    /**
     * method fromString, berfungsi untuk mengembalikan enumerasi dalam bentuk objek
     * 
     * @param input
     */
    public static JobCategory fromString(String input) {
        for (JobCategory element : JobCategory.values()) {
            if (element.text.equalsIgnoreCase(input)) {
                return element;
            }
        }
        return null;
    }
}
