package org.yup.accountingledger;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

public class Ledger {

    //create a new Add Deposit csv file

    public static void addDeposit(String userName) {
        //method that takes deposits
        String depositTotalString = JOptionPane.showInputDialog("Enter the deposit amount: ");
        double depositTotal = Double.parseDouble(depositTotalString);

        //deposit confirmation
        int confrimDeposit = JOptionPane.showConfirmDialog(null, "Are you sure you want to deposit$" + depositTotal + "?");
        if (confrimDeposit == JOptionPane.YES_NO_OPTION) {


            try {
                FileWriter writer = new FileWriter(userName + "_ledger.csv", true);
                writer.write("Deposit,+" + depositTotal + "\n");
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

    public static void makePayment (String userName) {
      //method that takes payment from user
        String makePaymentTotalString = JOptionPane.showInputDialog("Enter the payment amount: ");
        double makePaymentTotal = Double.parseDouble(makePaymentTotalString);

        //Payment input using String and JOptionPane method
        String cardNumber = JOptionPane.showInputDialog(null, "Enter your debit card number");
        String expirationDate = JOptionPane.showInputDialog(null, "Enter your card's expiration date (MM/YY): ");
        String securityCode = JOptionPane.showInputDialog(null, "Enter your card's security code:");

        int confrimPayment = JOptionPane.showConfirmDialog(null, "Are you sure you want to pay$" + makePaymentTotal + "?");
        if (confrimPayment == JOptionPane.YES_NO_OPTION) {


            try {
                FileWriter writer = new FileWriter(userName + "_ledger.csv", true);
                writer.write("Payment,+" + makePaymentTotal + "\n");
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

    public static void displayLedger (String userName) {
        //method that displays ledger
        

    }



}

