
/**
 * Enumeration class JobCategory - mengenumerasi semua kategori pekerjaan
 *
 * @author Qisas Tazkia Hasanudin
 * @version 25-03-2021
 */
public enum JobCategory
{
    WebDeveloper("Web Developer"), 
    FrontEnd("Front End"), 
    BackEnd("Back End"), 
    UI("UI"), 
    UX("UX"), 
    Devops("Devops"), 
    DataScientist("Data Scientist"), 
    DataAnalyst("Data Analyst");
    
    private final String label;
    
    private JobCategory(String label){
        this.label = label;        
    }
    
    public String toString(){
        return label;
    }
}
