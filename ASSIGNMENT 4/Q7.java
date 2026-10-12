
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Q7 extends JFrame implements ActionListener {

    JTextField display;

    JButton add, subtract, multiply, divide;
    JButton zero, one, two, three, four;
    JButton five, six, seven, eight, nine;
    JButton dot, clear, equal;

    double num1, num2, result;
    String operator = "";

    Q7() {

        // Frame settings
        setTitle("Calculator");
        setSize(300, 380);
        setLayout(new BorderLayout(5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set background color
        getContentPane().setBackground(Color.BLUE);

        // Display field
        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 18));
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);

        JPanel displayPanel = new JPanel(new BorderLayout());
        displayPanel.setBackground(Color.BLUE);
        displayPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        displayPanel.add(display, BorderLayout.CENTER);

        add(displayPanel, BorderLayout.NORTH);

        // Create buttons
        add = new JButton("+");
        subtract = new JButton("-");
        multiply = new JButton("*");
        divide = new JButton("/");

        zero = new JButton("0");
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");

        dot = new JButton(".");
        clear = new JButton("C");
        equal = new JButton("=");

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        buttonPanel.setBackground(Color.BLUE);
        buttonPanel.setBorder(
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        );

        // Arrange buttons
        buttonPanel.add(add);
        buttonPanel.add(one);
        buttonPanel.add(two);
        buttonPanel.add(three);

        buttonPanel.add(subtract);
        buttonPanel.add(four);
        buttonPanel.add(five);
        buttonPanel.add(six);

        buttonPanel.add(multiply);
        buttonPanel.add(seven);
        buttonPanel.add(eight);
        buttonPanel.add(nine);

        buttonPanel.add(divide);
        buttonPanel.add(dot);
        buttonPanel.add(zero);
        buttonPanel.add(clear);

        add(buttonPanel, BorderLayout.CENTER);

        // Equals button panel
        JPanel equalPanel = new JPanel();
        equalPanel.setBackground(Color.BLUE);
        equalPanel.setBorder(
            BorderFactory.createEmptyBorder(5, 10, 10, 10)
        );

        equalPanel.add(equal);

        add(equalPanel, BorderLayout.SOUTH);

        // Register action listeners
        JButton buttons[] = {
            add, subtract, multiply, divide,
            zero, one, two, three, four,
            five, six, seven, eight, nine,
            dot, clear, equal
        };

        for (JButton b : buttons) {
            b.addActionListener(this);
        }

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Handle button clicks
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        // Number buttons
        if (command.matches("[0-9]")) {
            display.setText(display.getText() + command);
        }

        // Decimal button
        else if (command.equals(".")) {
            if (!display.getText().contains(".")) {
                if (display.getText().isEmpty()) {
                    display.setText("0.");
                } else {
                    display.setText(display.getText() + ".");
                }
            }
        }

        // Clear button
        else if (command.equals("C")) {
            display.setText("");
            num1 = 0;
            num2 = 0;
            result = 0;
            operator = "";
        }

        // Operator buttons
        else if (command.equals("+") ||
                 command.equals("-") ||
                 command.equals("*") ||
                 command.equals("/")) {

            if (!display.getText().isEmpty()) {
                num1 = Double.parseDouble(display.getText());
                operator = command;
                display.setText("");
            }
        }

        // Equals button
        else if (command.equals("=")) {

            if (!display.getText().isEmpty() && !operator.isEmpty()) {

                num2 = Double.parseDouble(display.getText());

                switch (operator) {

                    case "+":
                        result = num1 + num2;
                        break;

                    case "-":
                        result = num1 - num2;
                        break;

                    case "*":
                        result = num1 * num2;
                        break;

                    case "/":
                        if (num2 == 0) {
                            display.setText("Cannot divide by zero");
                            operator = "";
                            return;
                        }
                        result = num1 / num2;
                        break;
                }

                display.setText(num1 + operator + num2 + "=" + result);

                operator = "";
            }
        }
    }

    public static void main(String[] args) {

        new Q7();
    }
}
