package org.yup.accountingledger;
import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static org.yup.accountingledger.LedgerOptions.*;

public class menuOptions {

    //create a new Add Deposit csv file

    public static void addDeposit() {

        // get the date and time of the transaction
        LocalDateTime dateTime = LocalDateTime.now();

        //get deposit information on ONE page
        JPanel addDepositPanel = new JPanel();
        addDepositPanel.setLayout(new GridLayout(3, 2));
        JTextField paymentDesc = new JTextField();
        JTextField vendorName = new JTextField();
        JTextField depositTotal = new JTextField();
        addDepositPanel.add(new JLabel("Enter the description of the deposit:"));
        addDepositPanel.add(paymentDesc);
        addDepositPanel.add(new JLabel("Enter the name of the vendor"));
        addDepositPanel.add(vendorName);
        addDepositPanel.add(new JLabel("Enter the deposit amount"));
        addDepositPanel.add(depositTotal);
        int result = JOptionPane.showConfirmDialog(null, addDepositPanel, "Add Deposit", JOptionPane.OK_CANCEL_OPTION);

        int willThatBeAll = JOptionPane.showConfirmDialog(null, "Deposit added. Will that be all?");
        if (willThatBeAll == JOptionPane.NO_OPTION){
        } else {
            //exit the program
            JOptionPane.showMessageDialog(null, "Goodbye!");
            System.exit(0);
        }


        //deposit confirmation
        if (result == JOptionPane.OK_OPTION) {
            double amountTotal = Double.parseDouble(depositTotal.getText());

            try {
                FileWriter writer = new FileWriter("Transactions.csv", true);

                //Decided to format date and time using the DateTimeFormatter offered in the class library
                DateTimeFormatter formatEntryDate = DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm:ss");
                String formatDateTimeEntry = dateTime.format(formatEntryDate);

                // write payment data to the file
                writer.write(formatDateTimeEntry + "|" + paymentDesc.getText() + "|" + vendorName.getText() + "|" + depositTotal.getText() + "\n" );


                writer.close();


                //allow the user to decide weather they would like to exit
                //or select another menu option



            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error adding deposit. Please try again.");
                e.printStackTrace();
            }
            }

        }

    public static void makePayment () {

       // get the date and time of the transaction
        LocalDateTime dateTime = LocalDateTime.now();

        //get deposit information on ONE page
        JPanel makePaymentPanel = new JPanel();
        makePaymentPanel.setLayout(new GridLayout(3, 2));
        JTextField paymentDesc = new JTextField();
        JTextField vendorName = new JTextField();
        JTextField makePaymentTotal = new JTextField();
        makePaymentPanel.add(new JLabel("Enter the description of the deposit:"));
        makePaymentPanel.add(paymentDesc);
        makePaymentPanel.add(new JLabel("Enter the name of the vendor"));
        makePaymentPanel.add(vendorName);
        makePaymentPanel.add(new JLabel("Enter the payment amount"));
        makePaymentPanel.add(makePaymentTotal);
        int result = JOptionPane.showConfirmDialog(null, makePaymentPanel, "Please confirm you'd like to make this payment", JOptionPane.OK_CANCEL_OPTION);

        //allow the user to decide weather they would like to exit
        //or select another menu option

        int willThatBeAll = JOptionPane.showConfirmDialog(null, "Payment made. Will that be all?");
        if (willThatBeAll == JOptionPane.OK_CANCEL_OPTION){

        } else {

            //exit the program
            JOptionPane.showMessageDialog(null, "Goodbye!");
            System.exit(0);
        }

        // payment confirmation
        if (result == JOptionPane.OK_OPTION) {
            double amountTotal = Double.parseDouble(makePaymentTotal.getText());


            try {
                FileWriter writer = new FileWriter("Transactions.csv", true);

                //Decided to format date and time using the DateTimeFormatter offered in the class library
                DateTimeFormatter formatEntryDate = DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm:ss");
                String formatDateTimeEntry = dateTime.format(formatEntryDate);

                //write header to the files
                writer.write(formatDateTimeEntry + "|" + paymentDesc.getText() + "|" + vendorName.getText() + "|" + makePaymentTotal.getText() + "\n");


                writer.close();



            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error taking payment. Please try again.");
                e.printStackTrace();
            }
        }

    }

    public static void displayLedger () {
        //method that displays ledger

        int ledgerSelection = 0;

        while (ledgerSelection != 4) {

            JOptionPane.showMessageDialog(null, "You selected to view the ledger");

            ledgerSelection = Integer.parseInt(JOptionPane.showInputDialog(
                            "Press 1 to view month to month entries\n" +
                            "Press 2 to view previous month entries\n" +
                            "Press 3 to view year to date\n" +
                            "Press 4 to view previous year\n" +
                            "Press 5 to search entries by vendor\n" +
                            "Press 0 to go back to main menu\n" +
                            "Enter your selection"));

            // process user choice
            switch (ledgerSelection) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Here are your month to month entries: ");
                    // code to display month to month entries
                    entryMonthToMonth();
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, "Here are your previous month entries: ");
                    // code to display previous month entries
                    entryPreviousMonth();
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Here are your year to date entries: ");
                    // code to display year to date
                    entryYearToDate();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Here are your entries from the previous year: ");
                    //display previous year entries
                    entryPreviousYear();
                    break;

                case 5:
                    JOptionPane.showInputDialog(null, "You selected search by vendor\n type vendor name below: ");
                    //code that allows user to search for specific vendor via csv file
                    entryCustomSearch();
                    break;

                case 0:
                    //takes user back to main menu

                    break;

                default:
                    JOptionPane.showMessageDialog(null, "You chose an invalid option...try again.");
                    break;
            }
        }

    }



}

