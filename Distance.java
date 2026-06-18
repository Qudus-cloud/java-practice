public class Distance {
    // private field for storing ditance in km 
     private double km;
    // constuctor assigns the km
    public Distance(double km) {
        this.km = km;
    }
     //converts km into steps and breaks the number into thousands,hundrens and tens, then return a stepstat object
    public stepstat convert() {
        // km to steps in nearest whole number
        int totalSteps = (int) Math.round(km * 1312);
        
        int thousands = totalSteps / 1000;
        int remainder = totalSteps % 1000;
        int hundreds = remainder / 100;
        remainder = remainder % 100;
        int tens = remainder / 10;
        
        // Return a new StepStats object with extracted values
        return new stepstat(thousands, hundreds, tens);
    }
}

