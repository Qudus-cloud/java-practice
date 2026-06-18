// AlcoholicBeverage subclass
public class AlcoholicBeverage extends Beverage {
    private String strength;
    // Constructor that passes shared fields to the Beverage constructor
    public AlcoholicBeverage(String name,double cost, String size, String strength){
        super(name,cost,size);
        this.strength= strength;
    }
    public void printAttributes(){
        super.printAttributes();
        System.out.println("strength"+strength);
    }

}
