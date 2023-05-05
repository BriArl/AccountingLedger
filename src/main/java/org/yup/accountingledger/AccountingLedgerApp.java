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

/*
Brianna Y.
04/30/23
This program prompts the user to use the interactive
The accounting ledger app is a software program designed
to help individuals manage their finances
by tracking their income and expenses. The app provides
an easy-to-use interface for entering financial transactions,
such as deposits, withdrawals, and purchases.
It then organizes and summarizes the data into useful reports,
such as balance sheets and income statements.
 */

package org.yup.accountingledger;
import javax.swing.*;


import static org.yup.accountingledger.menuOptions.*;

public class AccountingLedgerApp {

    public static void main(String[] args) {

        //Home Screen and its options go here

        char userSelection = ' ';

        while (userSelection != 'X') {

            JOptionPane.showMessageDialog(null, "Welcome to LedgerPro");

            userSelection = JOptionPane.showInputDialog(
                            "Enter D to add a deposit\n" +
                            "Enter P to make a payment\n" +
                            "Enter L to display ledger\n" +
                            "Enter X to exit\n" ).toUpperCase().charAt(0);

            // process user choice
            switch (userSelection) {
                case 'D':
                    JOptionPane.showMessageDialog(null, "You have selected add deposit");
                    // code to add a deposit
                    menuOptions.addDeposit();
                    break;

                case 'P':
                    JOptionPane.showMessageDialog(null, "You have selected make a payment");
                    // code to make a payment
                    menuOptions.makePayment();
                    break;

                case 'L':
                    JOptionPane.showMessageDialog(null, "You have selected display ledger");
                    menuOptions.displayLedger();
                    break;
                case 'X':
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