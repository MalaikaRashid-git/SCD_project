package project;

import javax.swing.*;
import java.awt.*;


public class SmartCurrencyConverter extends JFrame {
    private static final long serialVersionUID = 1L;
	private JTextField amountField, rateField, resultField;

    public SmartCurrencyConverter() {
        setTitle("Currency Converter");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 5, 5));

        add(new JLabel("Amount:"));
        amountField = new JTextField();
        add(amountField);

        add(new JLabel("Exchange Rate:"));
        rateField = new JTextField();
        add(rateField);

        add(new JLabel("Converted Amount:"));
        resultField = new JTextField();
        resultField.setEditable(false);
        add(resultField);

        JButton convertButton = new JButton("Convert");
        add(convertButton);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });

        setVisible(true);
    }

    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            double rate = Double.parseDouble(rateField.getText());
            double result = amount * rate;
            resultField.setText(String.format("%.2f", result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter valid numbers!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new SmartCurrencyConverter();
    }
}
