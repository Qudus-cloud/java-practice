// Import serializable so professionals can be saved
import java.io.Serializable;

// Class represents a doctor, nurse, or medical staff
public class HealthProfessional implements Serializable {

    // Unique ID used to identify each health professional
    private int id;

    // Name of the health professional
    private String name;

    // Profession type (Doctor, Nurse etc.)
    private String profession;

    // Location of the professional
    private String location;

    // Diary storing appointments
    private Diary diary;

    // Constructor used to create a professional
    public HealthProfessional(int id, String name, String profession, String location) {

        // Assign values to the class variables
        this.id = id;  //Assign id
        this.name = name;  // Assign neme
        this.profession = profession;  // Assign profession
        this.location = location;  // assign location

        // Create a new diary for this health professional
        this.diary = new Diary();
    }
    // Method to return professional ID
    public int getId() {
        return id;
    }
    // Method to return the diary
    public Diary getDiary() {
        return diary;
    }

    //Convert professional object to readable text
    @Override
    public String toString() {
        return "ID: " + id +
               " | Name: " + name +
               " | Profession: " + profession +
               " | Location: " + location;
    }
}