// Import Swing library for creating graphical user interfaces
import javax.swing.*;

// Import class used to create padding around components
import javax.swing.border.EmptyBorder;

// Import AWT classes for layout, fonts, colours and graphics
import java.awt.*;

// SchedulerGUI class extends JFrame to create the program window
public class SchedulerGUI extends JFrame {

    // Backend system object that manages professionals and appointments
    private SchedulerSystem system;

    // Text area used to display information and results to the user
    private JTextArea displayArea;

    // Colours used for styling the interface
    private final Color BLACK_BG = new Color(15,15,15);
    private final Color DARK_PANEL = new Color(28,28,28);
    private final Color MID_GREY = new Color(45,45,45);
    private final Color GOLD = new Color(212,175,55);
    private final Color TEXT_LIGHT = new Color(240,240,240);
    private final Color TEXT_MUTED = new Color(170,170,170);

    // Constructor that builds the GUI
    public SchedulerGUI(){

        // Create the scheduler system object
        system = new SchedulerSystem();

        // Set window title
        setTitle("Hospital Operation Scheduler");

        // Set window size
        setSize(1000,620);

        // Close application when window closes
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Center the window on screen
        setLocationRelativeTo(null);

        // Root panel that holds everything
        JPanel root = new JPanel(new BorderLayout(20,20));
        root.setBackground(BLACK_BG);
        root.setBorder(new EmptyBorder(20,20,20,20));
        setContentPane(root);

        // ==========================
        // HEADER SECTION
        // ==========================

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(BLACK_BG);
        headerPanel.setLayout(new BoxLayout(headerPanel,BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Hospital Operation Scheduler");
        titleLabel.setFont(new Font("Segoe UI",Font.BOLD,30));
        titleLabel.setForeground(GOLD);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitleLabel = new JLabel("Manage professionals, appointments and records");
        subtitleLabel.setFont(new Font("Segoe UI",Font.PLAIN,14));
        subtitleLabel.setForeground(TEXT_MUTED);
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        headerPanel.add(titleLabel);
        headerPanel.add(Box.createVerticalStrut(6));
        headerPanel.add(subtitleLabel);

        root.add(headerPanel,BorderLayout.NORTH);

        // ==========================
        // CENTER SECTION
        // ==========================

        JPanel centerPanel = new JPanel(new GridLayout(1,2,20,20));
        centerPanel.setBackground(BLACK_BG);

        // ==========================
        // LEFT PANEL (Buttons)
        // ==========================

        JPanel actionsPanel = new JPanel(new GridLayout(3,2,12,12));
        actionsPanel.setBackground(DARK_PANEL);

        JButton addProfessionalBtn = new JButton("Add Professional");
        JButton viewProfessionalBtn = new JButton("View Professionals");
        JButton addAppointmentBtn = new JButton("Add Appointment");
        JButton viewDiaryBtn = new JButton("View Diary");
        JButton deleteAppointmentBtn = new JButton("Delete Appointment");
        JButton clearScreenBtn = new JButton("Clear Display");

        actionsPanel.add(addProfessionalBtn);
        actionsPanel.add(viewProfessionalBtn);
        actionsPanel.add(addAppointmentBtn);
        actionsPanel.add(viewDiaryBtn);
        actionsPanel.add(deleteAppointmentBtn);
        actionsPanel.add(clearScreenBtn);

        // ==========================
        // RIGHT PANEL (Display)
        // ==========================

        JPanel displayPanel = new JPanel(new BorderLayout(10,10));
        displayPanel.setBackground(DARK_PANEL);

        JLabel displayTitle = new JLabel("System Display");
        displayTitle.setFont(new Font("Segoe UI",Font.BOLD,20));
        displayTitle.setForeground(GOLD);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced",Font.PLAIN,14));
        displayArea.setBackground(MID_GREY);
        displayArea.setForeground(TEXT_LIGHT);

        displayArea.setText(
                "Welcome to the Hospital Operation Scheduler.\n\n" +
                "Use View Professionals to see all professionals.\n" +
                "Use View Diary to see appointments.\n"
        );

        JScrollPane scrollPane = new JScrollPane(displayArea);

        // Save / Load panel
        JPanel saveLoadPanel = new JPanel(new GridLayout(1,2,10,10));
        saveLoadPanel.setBackground(DARK_PANEL);

        JButton saveBtn = new JButton("Save Data");
        JButton loadBtn = new JButton("Load Data");

        saveLoadPanel.add(saveBtn);
        saveLoadPanel.add(loadBtn);

        displayPanel.add(displayTitle,BorderLayout.NORTH);
        displayPanel.add(scrollPane,BorderLayout.CENTER);
        displayPanel.add(saveLoadPanel,BorderLayout.SOUTH);

        centerPanel.add(actionsPanel);
        centerPanel.add(displayPanel);

        root.add(centerPanel,BorderLayout.CENTER);

        // Footer text
        JLabel footer = new JLabel("Hospital Scheduler System");
        footer.setHorizontalAlignment(SwingConstants.CENTER);
        footer.setForeground(TEXT_MUTED);

        root.add(footer,BorderLayout.SOUTH);

        // ==========================
        // BUTTON ACTIONS
        // ==========================

        // Add Professional
        addProfessionalBtn.addActionListener(e -> {

            String name = JOptionPane.showInputDialog(this,"Enter Name");
            if(name == null || name.trim().isEmpty()) return;

            String profession = JOptionPane.showInputDialog(this,"Enter Profession");
            if(profession == null || profession.trim().isEmpty()) return;

            String location = JOptionPane.showInputDialog(this,"Enter Location");
            if(location == null || location.trim().isEmpty()) return;

            system.addProfessional(name,profession,location);

            displayArea.setText("Professional added:\n\n"
                    + "Name: " + name
                    + "\nProfession: " + profession
                    + "\nLocation: " + location);
        });


        // View Professionals
        viewProfessionalBtn.addActionListener(e -> {

            StringBuilder result = new StringBuilder();

            result.append("ALL HEALTH PROFESSIONALS\n");
            result.append("========================\n\n");

            boolean found = false;

            for(int i=1;i<=100;i++){

                if(system.professionalExists(i)){

                    result.append(system.getProfessional(i)).append("\n\n");
                    found = true;
                }
            }

            if(!found){
                result.append("No professionals found.");
            }

            displayArea.setText(result.toString());
        });

        // Add Appointment
        addAppointmentBtn.addActionListener(e -> {

            try{

                int id = Integer.parseInt(JOptionPane.showInputDialog(this,"Enter Professional ID"));

                if(!system.professionalExists(id)){
                    JOptionPane.showMessageDialog(this,"Professional not found");
                    return;
                }

                String patientName = JOptionPane.showInputDialog(this,"Patient Name");
                int patientAge = Integer.parseInt(JOptionPane.showInputDialog(this,"Patient Age"));
                String date = JOptionPane.showInputDialog(this,"Date");
                String start = JOptionPane.showInputDialog(this,"Start Time");
                String end = JOptionPane.showInputDialog(this,"End Time");
                String treatment = JOptionPane.showInputDialog(this,"Treatment");

                system.getProfessional(id).getDiary().addAppointment(
                        new Appointment(patientName,patientAge,date,start,end,treatment)
                );

                displayArea.setText("Appointment added successfully.");

            }catch(NumberFormatException ex){

                JOptionPane.showMessageDialog(this,"Invalid number entered");
            }
        });

        // View Diary
        viewDiaryBtn.addActionListener(e -> {

            try{

                int id = Integer.parseInt(JOptionPane.showInputDialog(this,"Enter Professional ID"));

                if(!system.professionalExists(id)){
                    JOptionPane.showMessageDialog(this,"Professional not found");
                    return;
                }

                displayArea.setText(
                        system.getProfessional(id)
                        + "\n\n"
                        + system.getProfessional(id).getDiary().getAppointmentsText()
                );

            }catch(NumberFormatException ex){

                JOptionPane.showMessageDialog(this,"Invalid ID entered");
            }
        });

        // Delete Appointment
        deleteAppointmentBtn.addActionListener(e -> {

            try{

                int id = Integer.parseInt(JOptionPane.showInputDialog(this,"Enter Professional ID"));
                int index = Integer.parseInt(JOptionPane.showInputDialog(this,"Enter Appointment Number"));

                system.getProfessional(id).getDiary().deleteAppointment(index-1);

                displayArea.setText("Appointment deleted.");

            }catch(Exception ex){

                JOptionPane.showMessageDialog(this,"Invalid input.");
            }
        });

        // Clear Screen
        clearScreenBtn.addActionListener(e -> {
            displayArea.setText("Display cleared.");
        });

        // Save Data
        saveBtn.addActionListener(e -> {

            system.saveData("hospital.dat");
            displayArea.setText("Data saved successfully.");
        });

        // Load Data
        loadBtn.addActionListener(e -> {

            system.loadData("hospital.dat");
            displayArea.setText("Data loaded successfully.");
        });
    }

    // Main method that launches the GUI
    public static void main(String[] args){

        SwingUtilities.invokeLater(() ->
                new SchedulerGUI().setVisible(true)
        );
    }
}
