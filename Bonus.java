/**
 * Praktikum OOP - Program "JWork"
 * class Bonus: berfungsi untuk meng-generate object yang merepresentasikan bonus gaji
 *
 * @author Qisas Tazkia Hasanudin
 * @version 01-04-2021
 */
public class Bonus
{
    // instance variables - replace the example below with your own
    private int id;
    private String referralCode;
    private int extraFee;
    private int minTotalFee;
    private boolean active;

    /**
     * Constructor untuk object dari class Bonus
     */
    public Bonus(int id, String referralCode, int extraFee, int minTotalFee, boolean active){
        this.id = id;
        this.referralCode = referralCode;
        this.extraFee = extraFee;
        this.minTotalFee = minTotalFee;
        this.active = active;
    }

    /**
     * method getId, berfungsi sebagai getter untuk mengambil value id
     *
     * @return id
     */
    public int getId(){
        return id;
    }
    
    /**
     * method getReferralCode, berfungsi sebagai getter untuk mengambil value referralCode
     *
     * @return referralCode
     */
    public String getReferralCode(){
        return referralCode;
    }
    
    /**
     * method getExtraFee, berfungsi sebagai getter untuk mengambil value extraFee
     *
     * @return extraFee
     */
    public int getExtraFee(){
        return extraFee;
    }
    
    /**
     * method getMinTotalFee, berfungsi sebagai getter untuk mengambil value minTotalFee
     *
     * @return minTotalFee
     */
    public int getMinTotalFee(){
        return minTotalFee;
    }
    
    /**
     * method getActive, berfungsi sebagai getter untuk mengambil value active
     *
     * @return active
     */
    public boolean getActive(){
        return active;
    }

    /**
     * method setId, berfungsi sebagai setter untuk mengisi value id
     *
     * @param id
     */    
    public void setId(int id){
        this.id = id;
    }
    
    /**
     * method setReferralCode, berfungsi sebagai setter untuk mengisi value referralCode
     *
     * @param referralCode
     */ 
    public void setReferralCode(String referralCode){
        this.referralCode = referralCode;
    }
    
    /**
     * method setExtraFee, berfungsi sebagai setter untuk mengisi value extraFee
     *
     * @param extraFee
     */ 
    public void setExtraFee(int extraFee){
        this.extraFee = extraFee;
    }
    
    /**
     * method setMinTotalFee, berfungsi sebagai setter untuk mengisi value minTotalFee
     *
     * @param minTotalFee
     */ 
    public void setMinTotalFee(int minTotalFee){
        this.minTotalFee = minTotalFee;
    }
    
    /**
     * method setActive, berfungsi sebagai setter untuk mengisi value active
     *
     * @param active
     */ 
    public void setActive(boolean active){
        this.active = active;
    }

    /**
     * method printData, berfungsi untuk mencetak instance variable ke layar
     */

    public void printData(){
        System.out.println(id);
        System.out.println(referralCode);
        System.out.println(extraFee);
        System.out.println(minTotalFee);
        System.out.println(active);
    }
    
}