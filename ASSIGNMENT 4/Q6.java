
import java.awt.*;
import java.awt.event.*;

public class Q6 extends Frame implements ActionListener {

    // Labels
    Label title, nameLabel, fatherLabel, ageLabel;
    Label genderLabel, courseLabel, hobbiesLabel, addressLabel;

    // Text fields
    TextField nameField, fatherField, ageField;

    // Gender radio buttons
    CheckboxGroup genderGroup;
    Checkbox male, female;

    // Course dropdown
    Choice courseChoice;

    // Hobbies checkboxes
    Checkbox drawing, singing, music, others;

    // Address text area
    TextArea addressArea;

    // Buttons
    Button saveButton, clearButton;

    Q6() {

        setTitle("User Registration Form");
        setSize(700, 480);
        setBackground(new Color(52, 58, 70));
        setLayout(new BorderLayout(10, 10));

        // Title
        title = new Label("Registration Form", Label.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(Color.YELLOW);

        add(title, BorderLayout.NORTH);

        // Main form panel
        Panel formPanel = new Panel(new GridBagLayout());
        formPanel.setBackground(new Color(52, 58, 70));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Name
        nameLabel = new Label("Name");
        nameField = new TextField(30);

        addRow(formPanel, gbc, 0, nameLabel, nameField);

        // Father Name
        fatherLabel = new Label("Father Name");
        fatherField = new TextField(30);

        addRow(formPanel, gbc, 1, fatherLabel, fatherField);

        // Age
        ageLabel = new Label("Age");
        ageField = new TextField(30);

        addRow(formPanel, gbc, 2, ageLabel, ageField);

        // Gender
        genderLabel = new Label("Gender");

        genderGroup = new CheckboxGroup();

        male = new Checkbox("Male", genderGroup, true);
        female = new Checkbox("Female", genderGroup, false);

        Panel genderPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
        genderPanel.setBackground(new Color(52, 58, 70));

        genderPanel.add(male);
        genderPanel.add(female);

        addRow(formPanel, gbc, 3, genderLabel, genderPanel);

        // Course
        courseLabel = new Label("Course");

        courseChoice = new Choice();
        courseChoice.add("Java");
        courseChoice.add("Python");
        courseChoice.add("C");
        courseChoice.add("C++");
        courseChoice.add("Data Structures");
        courseChoice.add("Computer Science");

        addRow(formPanel, gbc, 4, courseLabel, courseChoice);

        // Hobbies
        hobbiesLabel = new Label("Hobbies");

        drawing = new Checkbox("Drawing");
        singing = new Checkbox("Singing");
        music = new Checkbox("Music");
        others = new Checkbox("Others");

        Panel hobbiesPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
        hobbiesPanel.setBackground(new Color(52, 58, 70));

        hobbiesPanel.add(drawing);
        hobbiesPanel.add(singing);
        hobbiesPanel.add(music);
        hobbiesPanel.add(others);

        addRow(formPanel, gbc, 5, hobbiesLabel, hobbiesPanel);

        // Address
        addressLabel = new Label("Address");
        addressArea = new TextArea(4, 30);

        addRow(formPanel, gbc, 6, addressLabel, addressArea);

        add(formPanel, BorderLayout.CENTER);

        // Buttons
        saveButton = new Button("Save Details");
        clearButton = new Button("Clear All");

        saveButton.setBackground(Color.BLUE);
        saveButton.setForeground(Color.WHITE);

        clearButton.setBackground(Color.RED);
        clearButton.setForeground(Color.WHITE);

        Panel buttonPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(saveButton);
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Register action listeners
        saveButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Window closing
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    // Method to align labels and components
    void addRow(Panel panel, GridBagConstraints gbc,
                int row, Component label, Component field) {

        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0.3;

        panel.add(label, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.7;

        panel.add(field, gbc);
    }

    // Button click handling
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == saveButton) {

            String gender = genderGroup.getSelectedCheckbox().getLabel();

            String hobbies = "";

            if (drawing.getState()) hobbies += "Drawing ";
            if (singing.getState()) hobbies += "Singing ";
            if (music.getState()) hobbies += "Music ";
            if (others.getState()) hobbies += "Others ";

            if (hobbies.isEmpty()) {
                hobbies = "None";
            }

            String details =
                    "Name: " + nameField.getText() +
                    "\nFather Name: " + fatherField.getText() +
                    "\nAge: " + ageField.getText() +
                    "\nGender: " + gender +
                    "\nCourse: " + courseChoice.getSelectedItem() +
                    "\nHobbies: " + hobbies +
                    "\nAddress: " + addressArea.getText();

            // Display registration details
            Dialog dialog = new Dialog(this, "Student Details", true);

            dialog.setLayout(new BorderLayout());

            TextArea result = new TextArea(details, 8, 40,
                    TextArea.SCROLLBARS_VERTICAL_ONLY);

            result.setEditable(false);

            Button okButton = new Button("OK");

            okButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dialog.dispose();
                }
            });

            dialog.add(result, BorderLayout.CENTER);
            dialog.add(okButton, BorderLayout.SOUTH);

            dialog.setSize(400, 280);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        }

        // Clear all fields
        else if (e.getSource() == clearButton) {

            nameField.setText("");
            fatherField.setText("");
            ageField.setText("");

            genderGroup.setSelectedCheckbox(male);

            courseChoice.select(0);

            drawing.setState(false);
            singing.setState(false);
            music.setState(false);
            others.setState(false);

            addressArea.setText("");
        }
    }

    public static void main(String[] args) {

        new Q6();
    }
}
