import java.io.Serializable; // Import serializable so objects can be saved to files

//Appointment class represent a patient appointment
// serializable allows the object to be stored in a file 
public class Appointment implements Serializable {

    // Variable to store name of the patient attending the appointment
    private String patientName;

    // Variable to store age of the patient
    private int patientAge;

    // Variable to store date of the appointment (e.g. 12/03/2026)
    private String date;

    // Variable to store start time of the appointment (e.g. 10:00)
    private String startTime;

    // Variable to store end time of the appointment (e.g. 11:00)
    private String endTime;

   // Variable to store the treatment type
    private String treatmentType;

     // Constructor used to create a new appointment
    public Appointment(String patientName, int patientAge,
                       String date, String startTime,
                       String endTime, String treatmentType) {

        this.patientName = patientName; // Assign the patient name to the variable
        this.patientAge = patientAge; // Assign the patient age
        this.date = date; // Assign appointment date
        this.startTime = startTime; // Assign start time
        this.endTime = endTime; // Assign end time
        this.treatmentType = treatmentType; //Assign treatment type
    }

     //toString method converts the appointment object to readable text
    @Override
    public String toString() {
        // Return formatted appointment information
        return "Patient: " + patientName 
               + " (Age " + patientAge + ")" +
               " | Date: " + date +
               " | Start: " + startTime +
               " | End: " + endTime +
               " | Treatment: " + treatmentType;
    }
}