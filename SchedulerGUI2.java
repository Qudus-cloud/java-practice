import javax.swing.*; //Import Swing library for creating graphical user interfaces
import javax.swing.border.EmptyBorder; //Import class used to create padding around components
import java.awt.*; //Import AWT classes for layout, fonts, colours and graphics

// SchedulerGUI class extends JFrame to create a window application
public class SchedulerGUI extends JFrame {

    private SchedulerSystem system;  // Create an instance of the backend system
    private JTextArea displayArea;  // Text area used to display information to the user

    //Define colour constants used for styling the interface
    private final Color BLACK_BG = new Color(15, 15, 15);
    private final Color DARK_PANEL = new Color(28, 28, 28);
    private final Color MID_GREY = new Color(45, 45, 45);
    private final Color GOLD = new Color(212, 175, 55);
    private final Color GOLD_HOVER = new Color(232, 195, 70);
    private final Color TEXT_LIGHT = new Color(240, 240, 240);
    private final Color TEXT_MUTED = new Color(170, 170, 170);
    
    //Constructor used to build the GUI     
    public SchedulerGUI() {   
        system = new SchedulerSystem();  // Create the system object that manages professionals and appointments

        // Try to set a consistent UI theme across different operating systems
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        setTitle("Hospital Operation Scheduler");  // Set the title of the window
        setSize(1000, 620);  // Set window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close the program when the window is closed
        setLocationRelativeTo(null);  // Center the window on screen

        JPanel root = new JPanel(new BorderLayout(20, 20)); // Root panel containing all other GUI components
        root.setBackground(BLACK_BG);  // Set background colour
        root.setBorder(new EmptyBorder(20, 20, 20, 20));  // Add padding around the interface
        setContentPane(root);  // Set the root panel as the window content

        // HEADER
        JPanel headerPanel = new JPanel();  // Create panel for header
        headerPanel.setBackground(BLACK_BG);  // Set header background colour
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS)); // Arrange components vertically

        JLabel titleLabel = new JLabel("Hospital Operation Scheduler");  // Title label
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));   // Set title font style
        titleLabel.setForeground(GOLD);  // Set title colour
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);  // Center the title

        JLabel subtitleLabel = new JLabel("Manage professionals, appointments and records"); // Subtitle label explaining system purpose
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));  // Set subtitle font
        subtitleLabel.setForeground(TEXT_MUTED);  //Set subtitle colour
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);  // Center subtitle

        headerPanel.add(titleLabel);  // Add title to header
        headerPanel.add(Box.createVerticalStrut(6));  // Add spacing
        headerPanel.add(subtitleLabel);  // Add subtitle

        root.add(headerPanel, BorderLayout.NORTH);  // Add header to top of window

        // CENTER
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 20, 20));  // Create panel dividing screen into two sections
        centerPanel.setBackground(BLACK_BG);   // Set background

        // LEFT PANEL
        JPanel actionsGrid = new JPanel(new GridLayout(3, 2, 12, 12));  // Grid layout for action buttons
        actionsGrid.setBackground(DARK_PANEL);

        // Create buttons for system actions
        JButton addProfessionalBtn = new JButton("Add Professional");
        JButton viewProfessionalBtn = new JButton("View Professionals");
        JButton addAppointmentBtn = new JButton("Add Appointment");
        JButton viewDiaryBtn = new JButton("View Diary");
        JButton deleteAppointmentBtn = new JButton("Delete Appointment");
        JButton clearScreenBtn = new JButton("Clear Display");

        // Add buttons to grid
        actionsGrid.add(addProfessionalBtn);
        actionsGrid.add(viewProfessionalBtn);
        actionsGrid.add(addAppointmentBtn);
        actionsGrid.add(viewDiaryBtn);
        actionsGrid.add(deleteAppointmentBtn);
        actionsGrid.add(clearScreenBtn);


        // RIGHT PANEL = DISPLAY AREA
        JPanel displayContent = new JPanel(new BorderLayout(15, 15));  // Layout for display components
        displayContent.setBackground(DARK_PANEL);

         // Title for display area
        JLabel displayTitle = new JLabel("Live Records Viewer");
        displayTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        displayTitle.setForeground(GOLD);
        displayTitle.setBorder(new EmptyBorder(0, 0, 5, 0));

        displayArea = new JTextArea();   // Create text area where results will appear
        displayArea.setEditable(false);   // Prevent user editing
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 14));  // Set font style

        // Set colours
        displayArea.setBackground(MID_GREY);
        displayArea.setForeground(TEXT_LIGHT);

        // Enable text wrapping
        displayArea.setLineWrap(true);
        displayArea.setWrapStyleWord(true);
        displayArea.setBorder(new EmptyBorder(20, 20, 20, 20));  // Add padding

        // Initial welcome message
        displayArea.setText(
                "Welcome to the Hospital Operation Scheduler.\n\n" +
                "Use View Professionals to see all professionals.\n" +
                "Use View Diary to see one professional and the patients assigned to them.\n"
        );

        // Create a scroll pane so the display area can scroll if the text becomes long
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());   // Remove default borders around the scroll pane
        scrollPane.getViewport().setBackground(MID_GREY);   // Set the background colour of the scroll area

        // save/load buttons
        JPanel saveLoadPanel = new JPanel(new GridLayout(1, 2, 12, 12)); // Set background colour of the panel
        saveLoadPanel.setBackground(DARK_PANEL);  

        JButton saveBtn = createStyledButton("Save Data");  // Create button used to save system data
        JButton loadBtn = createStyledButton("Load Data");  // Add save button to the panel

        saveLoadPanel.add(saveBtn);  // Add save button to the panel
        saveLoadPanel.add(loadBtn);   // Add load button to the panel

        // Add the display title to the top of the display panel
        displayContent.add(displayTitle, BorderLayout.NORTH);

        // Add scrollable text area to the center
        displayContent.add(scrollPane, BorderLayout.CENTER);

        // Add save/load buttons at the bottom
        displayContent.add(saveLoadPanel, BorderLayout.SOUTH);

        // Add display content to the display panel
        displayPanel.add(displayContent, BorderLayout.CENTER);

        // Add action buttons panel to the left side
        centerPanel.add(actionsPanel);

        // Add display panel to the right side
        centerPanel.add(displayPanel);

        // Add the center panel to the main root layout
        root.add(centerPanel, BorderLayout.CENTER);

        // Create footer text label
        JLabel footerLabel = new JLabel("Premium hospital scheduler interface");

        // Center align the footer text
        footerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Set footer font style
        footerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        // Set footer text colour
        footerLabel.setForeground(TEXT_MUTED);

        // Add footer label to bottom of window
        root.add(footerLabel, BorderLayout.SOUTH);

        // =======================
        // BUTTON ACTIONS
        // =======================

        // Action for adding a new health professional
        addProfessionalBtn.addActionListener(e -> {

    // Prompt user to enter name
    String name = JOptionPane.showInputDialog(this, "Enter Name");

    // Stop if user cancels or enters empty value
    if (name == null || name.trim().isEmpty()) return;

    // Prompt user to enter profession
    String profession = JOptionPane.showInputDialog(this, "Enter Profession");

    // Validate input
    if (profession == null || profession.trim().isEmpty()) return;

    // Prompt user to enter location
    String location = JOptionPane.showInputDialog(this, "Enter Location");

    // Validate input
    if (location == null || location.trim().isEmpty()) return;

    // Add professional to the scheduler system
    system.addProfessional(name, profession, location);

    // Display confirmation message in the display area
    displayArea.setText("Professional added successfully:\n\nName: " + name +
            "\nProfession: " + profession +
            "\nLocation: " + location);
});


// Button used to view all professionals
viewProfessionalBtn.addActionListener(e -> {

    // StringBuilder used to build large text efficiently
    StringBuilder result = new StringBuilder();

    // Add heading text
    result.append("ALL HEALTH PROFESSIONALS\n");

    // Add separator line
    result.append("====================================\n\n");

    // Variable used to check if professionals exist
    boolean found = false;

    // Loop through possible IDs
    for (int i = 1; i <= 100; i++) {

        // Check if professional exists
        if (system.professionalExists(i)) {

            // Add professional details to text
            result.append(system.getProfessional(i)).append("\n\n");

            // Mark as found
            found = true;
        }
    }

    // If no professionals exist
    if (!found) {

        result.append("No professionals found.");
    }

    // Display results in the text area
    displayArea.setText(result.toString());

    // Move scroll position to top
    displayArea.setCaretPosition(0);
});


        // Add appointment button action
        addAppointmentBtn.addActionListener(e -> {
            try {

        // Ask for professional ID
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Professional ID"));

        // Check if professional exists
        if (!system.professionalExists(id)) {

            JOptionPane.showMessageDialog(this, "Professional not found");
            return;
        }
    }
}

        // Ask for patient name
        String patientName = JOptionPane.showInputDialog(this, "Patient Name");

        // Validate input
        if (patientName == null || patientName.trim().isEmpty()) return;

        // Ask for patient age
        int patientAge = Integer.parseInt(JOptionPane.showInputDialog(this, "Patient Age"));

        // Ask for appointment date
        String date = JOptionPane.showInputDialog(this, "Date");

        // Ask for start time
        String start = JOptionPane.showInputDialog(this, "Start Time");

        // Ask for end time
        String end = JOptionPane.showInputDialog(this, "End Time");

        // Ask for treatment type
        String treatment = JOptionPane.showInputDialog(this, "Treatment");

        // Create and add new appointment to professional diary
        system.getProfessional(id).getDiary().addAppointment(
                new Appointment(patientName, patientAge, date, start, end, treatment)
        );

        // Display confirmation
        displayArea.setText(
                "Appointment added successfully.\n\n" +
                "Professional ID: " + id + "\n" +
                "Patient Name: " + patientName + "\n" +
                "Patient Age: " + patientAge + "\n" +
                "Date: " + date + "\n" +
                "Start Time: " + start + "\n" +
                "End Time: " + end + "\n" +
                "Treatment: " + treatment
        );

        // Reset scroll position
        displayArea.setCaretPosition(0);

    } catch (NumberFormatException ex) {

        // Show error if invalid number entered
        JOptionPane.showMessageDialog(this, "Invalid number entered");
    }
}
    
















       