import java.io.Serializable; //import Serializable so diary can be saved to a file
import java.util.ArrayList; // import ArrayList to store appointments

//Diary class stores appointments for a professional
public class Diary implements Serializable {
    // ArrayList used to store appointment objects
    private ArrayList<Appointment> appointments;

    // Constructor create an empty appointment list
    public Diary() {
        appointments = new ArrayList<>(); // create new arraylist
    }

    // Methos to add a new appointment
    public void addAppointment(Appointment appointment) {
        // check if appointment is valid
        if (appointment != null) {
            appointments.add(appointment);  // add appointment is valid
            System.out.println("Appointment added successfully."); //Display comnfirmation message
        } else {
            System.out.println("Invalid appointment."); //show error if appointment is null
        }
    }

    // Method to delete an appointment
    public void deleteAppointment(int index) {

        if (index >= 0 && index < appointments.size()) { //check if index is valid
            appointments.remove(index); // Remove appointment from list
            System.out.println("Appointment deleted successfully.");// Display confirmation
        } else {
            System.out.println("Invalid appointment number."); // show error message
        }
    }

    // Method to display appointments in the console
    public void displayAppointments() {

        if (appointments.isEmpty()) {  // check if diary is empty
            System.out.println("No appointments found.");  // rint message if no appointment exist
            return;
        }
         // loop through all appointment
        for (int i = 0; i < appointments.size(); i++) {  
            System.out.println("Appointment " + (i + 1) + ":"); // print appointment number
            System.out.println(appointments.get(i));   // print appointment details
            System.out.println(); //print blank line
        }
    }

     // Method used by GUI to display appointments as text
    public String getAppointmentsText() {
         // Check if list is empty
        if (appointments == null || appointments.isEmpty()) {
            return "No appointments found.";
        }
        // Create StringBuilder for efficient text creation
        StringBuilder sb = new StringBuilder();
         
        //Loop through appointment
        for (int i = 0; i < appointments.size(); i++) {

            sb.append("Appointment ").append(i + 1).append("\n");// Append appointment number
            sb.append("-----------------------------\n");  // Add separator line
            sb.append(appointments.get(i).toString()).append("\n\n");  // Append appointment details
        }

        return sb.toString(); // Return final text
    }

    // Get all appointments
    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    // Method to check if diary is empty
    public boolean isEmpty() {
        return appointments.isEmpty();
    }

    // Number of appointments
    public int size() {
        return appointments.size();
    }
}