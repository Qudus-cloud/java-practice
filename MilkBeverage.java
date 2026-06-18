// MilkBeverage subclass
public class MilkBeverage extends Beverage{
    private String flavour;
    // Constructor that extends the functionality of the Beverage superclass
    public MilkBeverage(String name, double cost, String size, String flavour){
        super(name, cost, size);
        this.flavour= flavour;
    }
    public void printAttributes(){
        super.printAttributes();
        System.out.println("flavour"+flavour);
    }
}
