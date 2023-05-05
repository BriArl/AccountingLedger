/*
Brianna Y.
04/30/23

This program prompts the user to use the interactive
The accounting ledger app is a software program designed
to help individuals and businesses manage their finances
by tracking their income and expenses. The app provides
an easy-to-use interface for entering financial transactions,
such as deposits, withdrawals, and purchases.
It then organizes and summarizes the data into useful reports,
such as balance sheets and income statements.


 */

package org.yup.accountingledger;
import javax.swing.*;
import java.util.Scanner;

import static org.yup.accountingledger.menuOptions.*;

public class AccountingLedgerApp {

    public static void main(String[] args) {

        //Home Screen and its options go here

            Scanner keyboard = new Scanner(System.in);
            int userSelection = 0;

            while (userSelection != 4) {

                JOptionPane.showMessageDialog(null, "Welcome to LedgerPro");

                String depositLedger = null;
                String paymentLedger = null;

                userSelection = Integer.parseInt(JOptionPane.showInputDialog(
                                "Press 1 to add a deposit\n" +
                                "Press 2 to make a payment\n" +
                                "Press 3 to display ledger\n" +
                                "Press 4 to exit\n" +
                                "Enter your selection"));

                // process user choice
                switch (userSelection) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "You have selected add deposit");
                        // code to add a deposit
                        addDeposit();
                        break;

                    case 2:
                        JOptionPane.showMessageDialog(null, "You have selected make a payment");
                        // code to make a payment
                        makePayment();
                        break;

                    case 3:
                        JOptionPane.showMessageDialog(null, "You have selected display ledger");
                        displayLedger();
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "You have selected exit\n Goodbye!");
                        System.exit(0);
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "You chose an invalid option...try again.");
                        break;
                }
            }


        }
    }

