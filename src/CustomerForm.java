import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomerForm extends JFrame {
    private JTextField customerIdField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField sexField;
    private JComboBox<String> dayComboBox;
    private JComboBox<String> monthComboBox;
    private JComboBox<String> yearComboBox;
    private JTextField houseNoField;
    private JTextField streetNoField;
    private JTextField sangkatField;
    private JTextField khanField;
    private JTextField provinceField;
    private JTextField businessNumberField;
    private JTextField personalNumberField;

    public CustomerForm() {
        setTitle("Customer Information Form");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize components
        JPanel formPanel = new JPanel(new GridLayout(14, 2));
        customerIdField = new JTextField();
        firstNameField = new JTextField();
        lastNameField = new JTextField();
        sexField = new JTextField();
        dayComboBox = new JComboBox<>(generateNumbers(1, 31));
        monthComboBox = new JComboBox<>(new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"});
        yearComboBox = new JComboBox<>(generateNumbers(1900, 2024)); // Assuming range for birth year
        houseNoField = new JTextField();
        streetNoField = new JTextField();
        sangkatField = new JTextField();
        khanField = new JTextField();
        provinceField = new JTextField();
        businessNumberField = new JTextField();
        personalNumberField = new JTextField();

        // Add components to the form panel
        formPanel.add(new JLabel("Customer ID:"));
        formPanel.add(customerIdField);
        formPanel.add(new JLabel("First Name:"));
        formPanel.add(firstNameField);
        formPanel.add(new JLabel("Last Name:"));
        formPanel.add(lastNameField);
        formPanel.add(new JLabel("Sex:"));
        formPanel.add(sexField);
        formPanel.add(new JLabel("Birth Date:"));
        JPanel birthDatePanel = new JPanel(new FlowLayout());
        birthDatePanel.add(dayComboBox);
        birthDatePanel.add(monthComboBox);
        birthDatePanel.add(yearComboBox);
        formPanel.add(birthDatePanel);
        formPanel.add(new JLabel("House No:"));
        formPanel.add(houseNoField);
        formPanel.add(new JLabel("Street No:"));
        formPanel.add(streetNoField);
        formPanel.add(new JLabel("Sangkat:"));
        formPanel.add(sangkatField);
        formPanel.add(new JLabel("Khan:"));
        formPanel.add(khanField);
        formPanel.add(new JLabel("Province:"));
        formPanel.add(provinceField);
        formPanel.add(new JLabel("Business Number:"));
        formPanel.add(businessNumberField);
        formPanel.add(new JLabel("Personal Number:"));
        formPanel.add(personalNumberField);

        // Add form panel to the frame
        add(formPanel, BorderLayout.CENTER);

        // Add submit button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get data from fields
                int customerId = Integer.parseInt(customerIdField.getText());
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String sex = sexField.getText();
                // Combine selected day, month, and year into a single string representing birth date
                String birthDate = dayComboBox.getSelectedItem() + " " + monthComboBox.getSelectedItem() + " " + yearComboBox.getSelectedItem();
                int houseNo = Integer.parseInt(houseNoField.getText());
                int streetNo = Integer.parseInt(streetNoField.getText());
                String sangkat = sangkatField.getText();
                String khan = khanField.getText();
                String province = provinceField.getText();
                int businessNumber = Integer.parseInt(businessNumberField.getText());
                int personalNumber = Integer.parseInt(personalNumberField.getText());

                // Print data to console
                System.out.println("Customer ID: " + customerId);
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                System.out.println("Sex: " + sex);
                System.out.println("Birth Date: " + birthDate);
                System.out.println("House No: " + houseNo);
                System.out.println("Street No: " + streetNo);
                System.out.println("Sangkat: " + sangkat);
                System.out.println("Khan: " + khan);
                System.out.println("Province: " + province);
                System.out.println("Business Number: " + businessNumber);
                System.out.println("Personal Number: " + personalNumber);

                // You can also call a method here to save the data to the database if needed
            }
        });
        add(submitButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private String[] generateNumbers(int start, int end) {
        String[] numbers = new String[end - start + 1];
        for (int i = start; i <= end; i++) {
            numbers[i - start] = String.valueOf(i);
        }
        return numbers;
    }

    public static void main(String[] args) {
        new CustomerForm();
    }
}
