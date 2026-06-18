public class stepstat {
    // stores the number of thousands
    private int thousands;
    // stores the number of thousands 
    private int hundreds;
    // stores the number of tens
    private int tens;
    // constuctor: takes all steps units and stores them
    public stepstat(int thousands, int hundreds, int tens) {
        //Assign the values
        this.thousands = thousands;
        this.hundreds = hundreds;
        this.tens = tens;
    }

    public String prettyPrint() {
        String result = "";
         // if value is not zero, add to result 
         // correctly pluralize
         // combine using "," or " and"
        if (thousands > 0) {
            result += thousands + " " + (thousands == 1 ? "thousand" : "thousands");
        }

        if (hundreds > 0) {
            if (!result.isEmpty()) result += thousands > 0 && tens == 0 ? " and " : ", ";
            result += hundreds + " " + (hundreds == 1 ? "hundred" : "hundreds");
        }

        if (tens > 0) {
            if (!result.isEmpty()) result += " and ";
            result += tens + " " + (tens == 1 ? "ten" : "tens");
        }
          // if all units werw xero, return"0steps"
        if (result.isEmpty()) return "0 steps";
        // return final formatted output
        return result;
    
    }
}

