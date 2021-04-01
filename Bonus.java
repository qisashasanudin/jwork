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

    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getReferralCode(){
        return referralCode;
    }
    
    public void setReferralCode(String referralCode){
        this.referralCode = referralCode;
    }
    
    public int getExtraFee(){
        return extraFee;
    }
    
    public void setExtraFee(int extraFee){
        this.extraFee = extraFee;
    }
    
    public int getMinTotalFee(){
        return minTotalFee;
    }
    
    public void setMinTotalFee(int minTotalFee){
        this.minTotalFee = minTotalFee;
    }
    
    public boolean getActive(){
        return active;
    }
    
    public void setActive(boolean active){
        this.active = active;
    }
    
    public void printData(){
        System.out.println(id);
        System.out.println(referralCode);
        System.out.println(extraFee);
        System.out.println(minTotalFee);
        System.out.println(active);
    }
    
}