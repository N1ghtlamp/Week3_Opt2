package csc372_week2_option2;
import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class AgeCalculator extends JFrame {
    private static final long serialVersionUID = 1L;
	private JPanel panel;
    private JButton calculateButton;
    private JTextField birthDateField;
    private JLabel ageLabel;

    public AgeCalculator() {
        createView();
        setTitle("Age Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
    }

    private void createView() {
        panel = new JPanel();
        getContentPane().add(panel);

        panel.add(new JLabel("Enter your birthdate (yyyy-mm-dd):"));
        birthDateField = new JTextField(10);
        panel.add(birthDateField);

        calculateButton = new JButton("Calculate Age");
        panel.add(calculateButton);

        ageLabel = new JLabel("You are ___ years old.");
        panel.add(ageLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAge();
            }
        });
    }

    private void calculateAge() {
        String birthDateText = birthDateField.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate birthDate = LocalDate.parse(birthDateText, formatter);
            LocalDate currentDate = LocalDate.now();
            int age = Period.between(birthDate, currentDate).getYears();
            ageLabel.setText("You are " + age + " years old.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid date in the format yyyy-mm-dd.");
        }
    }


    public static void main(String[] args) {
     SwingUtilities.invokeLater(new Runnable() {
       @Override
       public void run() {
         new AgeCalculator().setVisible(true);
        }
    });
   }
}