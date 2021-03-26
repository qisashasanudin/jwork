
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
    
    private final String category;
    
    private JobCategory(String category){
        this.category = category;        
    }
    
    public String toString(){
        return category;
    }
}
