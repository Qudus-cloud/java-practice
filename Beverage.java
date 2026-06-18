//superclass: beverage
public class Beverage {
    protected String name;
    protected double cost;
    protected String size;
    public Beverage(String name, double cost, String size) {
        this.name = name ;
        this.cost = cost;
        this.size = size;
    }
    // Prints the basic details for any beverage
    public void printAttributes(){
        System.out.println("Beverage Name: " + name);
        System.out.println("size:"+size);
        System.out.println("cost: £"+cost);
    }
}

