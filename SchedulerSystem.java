import java.io.*;  //Import file input and output classes
import java.util.HashMap; // Import HashMap for storing professionals
// Main system class that manages the sheduler
public class SchedulerSystem implements Serializable { 
    private HashMap<Integer, HealthProfessional> professionals;  // HashMap stores professionals using ID as key
    private int nextId;  // Variable to generate next professional ID

    // Constructor initializes system
    public SchedulerSystem() {
        professionals = new HashMap<>(); //Create HashMap
        nextId = 1; // Start ID from 1
    }
    // Method to add a professional
    public void addProfessional(String name, String profession, String location) {

        // Create a new HealthProfessional object
        HealthProfessional hp = new HealthProfessional(nextId, name, profession, location);

        // Store it in the HashMap
        professionals.put(nextId, hp);

        // Inform the user that the professional was added
        System.out.println("Health Professional added with ID: " + nextId);

        // Increase ID for the next professional
        nextId++;
    }
     //Method to display professionals
    public void displayProfessionals() {

        // Check if the system is empty
        if (professionals.isEmpty()) {
            System.out.println("No health professionals found.");
            return;
        }

        // Loop through all professionals 
        for (HealthProfessional hp : professionals.values()) {
            System.out.println(hp);  //print professional details
        }
    }
    // Method to get professional using ID
    public HealthProfessional getProfessional(int id) {
        return professionals.get(id);
    }
     // check if professional exists
    public boolean professionalExists(int id) {
        return professionals.containsKey(id);
    }
     // Method to save data to file
    public void saveData(String filename) {
         try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {

            // Write the HashMap of professionals to the file
            out.writeObject(professionals);

            // Save the next ID so it continues correctly after loading
            out.writeInt(nextId);

        } catch (IOException e) {

            // Handle errors during file saving
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    //Method to load saved data
    @SuppressWarnings("unchecked")
    public void loadData(String filename) {

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {

            // Read the HashMap of professionals 
            professionals = (HashMap<Integer, HealthProfessional>) in.readObject();

            // Read the next ID value
            nextId = in.readInt();

        } catch (FileNotFoundException e) {

            // If the save file does not exist
            System.out.println("Save file not found.");

        } catch (IOException | ClassNotFoundException e) {

            // Handle other loading errors
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}