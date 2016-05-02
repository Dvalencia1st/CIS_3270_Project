package AirlineProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Driver {
  
public static void main(String[] args) {

    // Establish a connection
 try { 
Class.forName("com.mysql.jdbc.Driver");
         
         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flight_reservation", "root", "salmo911");
         // Create a statement
         Statement statement = connection.createStatement();

         // Execute a statement
         ResultSet resultSet = statement.executeQuery("select * from ticket_number"); 

         // Iterate through the result and print the student names
         while (resultSet.next()) {
        System.out.println(resultSet.getString("idTicket_number")+ "," +resultSet.getString("Date") + ", " 
         + resultSet.getString("flight_number") + ", " + resultSet.getString("Departure")+","
        		+("Destination")+ "," +resultSet.getString("Econimic_class") + ", " + resultSet.getString("Business_class") + ", " + resultSet.getString("First_class"));
    }
  
}
 catch (Exception exc) {
 exc.printStackTrace();
 }
  }
}
