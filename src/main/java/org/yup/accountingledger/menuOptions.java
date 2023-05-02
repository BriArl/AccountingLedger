package org.yup.accountingledger;
import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class menuOptions {

    //create a new Add Deposit csv file

    public static void addDeposit(String depositLedger) {

        // get the date and time of the transaction
        LocalDateTime dateTime = LocalDateTime.now();

        // get the description of the payment
        String paymentDesc = JOptionPane.showInputDialog("Enter the description of the deposit:  ");

        // get the vendor name
        String vendorName = JOptionPane.showInputDialog("Enter the name of the vendor: ");

        //method that takes deposits
        String depositTotalString = JOptionPane.showInputDialog("Enter the deposit amount: ");
        double depositTotal = Double.parseDouble(depositTotalString);


        //deposit confirmation
        int confirmDeposit = JOptionPane.showConfirmDialog(null, "Are you sure you want to deposit$" + depositTotal + "?");
        if (confirmDeposit == JOptionPane.YES_NO_OPTION) {

            try {
                FileWriter writer = new FileWriter("Transactions.csv", true);

                // write payment data to the file
                writer.write(dateTime + "|" + paymentDesc + "|" + vendorName + "|" + depositTotal);
                writer.close();


                //allow the user to decide weather they would like to exit
                //or select another menu option

                int willThatBeAll = JOptionPane.showConfirmDialog(null, "Deposit added. Will that be all?");
                if (willThatBeAll == JOptionPane.NO_OPTION){
                } else {
                    //exit the program
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    System.exit(0);
                }

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error adding deposit. Please try again.");
                e.printStackTrace();
            }
            }

        }

    public static void makePayment (String paymentLedger) {

       // get the date and time of the transaction
        LocalDateTime dateTime = LocalDateTime.now();

        // get the description of the payment
        String paymentDesc = JOptionPane.showInputDialog("Enter the description of the payment:  ");

       // get the vendor name
        String vendorName = JOptionPane.showInputDialog("Enter the name of the vendor: ");

        //method that takes payment from user
        String makePaymentTotalString = JOptionPane.showInputDialog("Enter the payment amount: ");
        double makePaymentTotal = Double.parseDouble(makePaymentTotalString);


        // payment confirmation
        int confirmPayment = JOptionPane.showConfirmDialog(null, "Are you sure you want to pay$" + makePaymentTotal + "?");
        if (confirmPayment == JOptionPane.YES_NO_OPTION) {


            try {
                FileWriter writer = new FileWriter("Transactions.csv", true);

                // write payment data to the file
                writer.write(dateTime + "|" + paymentDesc + "|" + vendorName + "|" + makePaymentTotal);
                writer.close();

                //allow the user to decide weather they would like to exit
                //or select another menu option

                int willThatBeAll = JOptionPane.showConfirmDialog(null, "Payment posted. Will that be all?");
                if (willThatBeAll == JOptionPane.NO_OPTION){
                    return; //returns user to main menu
                } else {

                    //exit the program
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    System.exit(0);
                }

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error taking payment. Please try again.");
                e.printStackTrace();
            }
        }

    }

    public static void displayLedger (String displayLedger) {
        //method that displays ledger


    }



}

