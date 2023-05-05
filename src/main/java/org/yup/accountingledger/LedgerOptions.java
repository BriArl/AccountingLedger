package org.yup.accountingledger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LedgerOptions {

    /*
     transactionPath is set to private static final ensures
     that it cannot be accidentally modified by other parts of my code
     I configured this method of my code inorder of it to stay the
     same whilst executing the application
     */
    private static final String transaction_Path = "transaction.csv";

public static void entryMonthToMonth(){

    //create a DateTimeFormatter for the date format in my CSV file
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    //get the date range for the last month and current month
    LocalDate now = LocalDate.now();
    LocalDate beginningOfLastMonth = now.minusMonths(1).withDayOfMonth(1);
    LocalDate endOfLastMonth = now.withDayOfMonth(1).minusDays(1);
    LocalDate beginingofCurrentMonth = now.withDayOfMonth(1);

    //create a list to store the parsed data from CSV file
    List<String[]> data = new ArrayList<String[]>();
    try(BufferedReader readCSV = new BufferedReader(new FileReader(transaction_Path))){
        String line;
        while ((line = readCSV.readLine()) !=null){

            //split the line array
            String[] values = line.split(",");

            //parse the date from the first value in the array
            LocalDate date = LocalDate.parse(values[0],dateFormatter);

            //check if the date is within the desired date range
            if(date.isEqual(beginingofCurrentMonth) || date.isAfter(beginingofCurrentMonth) && date.isBefore(endOfLastMonth)){
                //add the values to the data list
                data.add(values);
            }
            readCSV.close();

        }
    } catch (IOException e){
        e.printStackTrace();
    }

    //display parsed data
    for (String[] entry : data){
        System.out.println(Arrays.toString(entry));
    }
    }


public static void entryPreviousMonth(){
    //get date of previous month
    LocalDate entryPreviousMonth = LocalDate.now().minusMonths(1);
    //create a DateTimeFormatter for the date format in my CSV file
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    //create a list to store the parsed data from CSV file
    List<String[]> data = new ArrayList<String[]>();

    try(BufferedReader readCSV = new BufferedReader(new FileReader(transaction_Path))){
        String line;
        while ((line = readCSV.readLine()) !=null){
            //split the line array
            String[] values = line.split(",");

            //parse the date from the first value in the array
            LocalDate date = LocalDate.parse(values[0],dateFormatter);

            //check if the date is in the previous month
            if(date.getMonthValue() == entryPreviousMonth.getMonthValue() && date.getYear() == entryPreviousMonth.getYear()){
                //add the values to the data list
                data.add(values);
            }
            readCSV.close();
        }
    } catch (IOException e){
        e.printStackTrace();
    }

    //display parsed data
    for (String[] entry : data){
        System.out.println(Arrays.toString(entry));
    }

}





public static void entryYearToDate() {

    //get the current year
    int thisYear = LocalDate.now().getYear();
    //create a DateTimeFormatter for the date format in my CSV file
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    //create a list to store the parsed data from CSV file
    List<String[]> data = new ArrayList<String[]>();

    try(BufferedReader readCSV = new BufferedReader(new FileReader(transaction_Path))){
        String line;
        while((line = readCSV.readLine()) != null){
            //split the line array
            String[] values = line.split(",");
            //parse the date from the first value in the array
            LocalDate date = LocalDate.parse(values[0], dateFormatter);
            //check if the date is in the current year
            if(date.getYear() == thisYear){
                //add the values to the data list
                data.add(values);
            }
        }

    }catch (IOException e){
        e.printStackTrace();
    }

    //display parsed data
    for(String[] entry : data){
        System.out.print(Arrays.toString(entry));
    }

}


public static void entryPreviousYear(){
    //get date of previous year
    LocalDate previousYear = LocalDate.now().minusYears(1);
    //create a DateTimeFormatter for the date format in my CSV file
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    //create a list to store the parsed data from CSV file
    List<String[]> data = new ArrayList<String[]>();

    try(BufferedReader readCSV = new BufferedReader(new FileReader(transaction_Path))){
        String line;
        while((line = readCSV.readLine()) != null){
            //split the line array
            String[] values = line.split("'");

            // parse the dat from first value in the array
            LocalDate date = LocalDate.parse(values[0], dateFormatter);

            //check if the date is in the previous year
            if (date.getYear() == previousYear.getYear()){
                //add the values to the data list
                data.add(values);
            }

        }
    }catch (IOException e) {
        e.printStackTrace();
    }
    //display parsed data
    for(String[] entry : data){
        System.out.println(Arrays.toString(entry));
    }
}


public static void entryCustomSearch(){


}

}
