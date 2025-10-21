/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package carshopapp1;


import java.util.Scanner;
import java.sql.*;
import java.text.DecimalFormat;

/**
 *
 * @author Sifiso
 */
public class CarShopApp1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
   	// Establish connection to the database
        Connection conn= DriverManager.getConnection("jdbc:derby://localhost:1527/CarShop", "app", "123");
       //Create a Statement object
	//	Execute the SELECT * FROM CARS query
        Statement stmt = conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM CARS");
	//	Initialize Scanner for user input
	Scanner scanner = new Scanner(System. in);

	try     {
	boolean running = true;

	while (running) {
	// Display menu
	System.out. println("Menu:");
        System.out. println("1. Search Cars (by make/model)");
	System.out. println("2. Total Value by Year");
	System.out. println("3. Exit");
	System.out. print("Choose an option: ");
	int choice = scanner.nextInt();
	scanner.nextLine(); // consume newline
	// Execute the SELECT * FROM CARS query each time before calling a function
	rs = stmt.executeQuery("SELECT * FROM CARS");

	switch (choice) {
                case 1:
                        // Send the ResultSet to searchCars
                        searchCars(rs);
                break; 
                case 2:
                        //Send the ResultSet to totalValueByYear
                       totalValueByYear(rs);
                break; 
                case 3:
                    running = false;
                    System.out. println("Exiting ... ");
                break;
                default:
                        System.out. println("Invalid option. Please choose avalid option.");
                break;
	}
                System.out. println ();
	}
            } catch (Exception ex) {
                ex.printStackTrace();
	} finally {
                // TODO: Close resources
	}
	scanner. close();
	}

    private static void searchCars(ResultSet rs) throws SQLException {
       Scanner input = new Scanner(System.in);
        System.out.print("Enter make/model keyword:");
        String keyword = input.next().toLowerCase();
        int icount=0;
        System.out.println("ID | MAKE | MODEL | YEAR | PRICE\nResults:");
        while(rs.next()){
            int id = rs.getInt(1);
            String make =rs.getString(2);
            String model = rs.getString("MODEL");
            int year = rs.getInt(4);
            Double price =rs.getDouble(5);
          
          if(make.toLowerCase().contains(keyword) || model.toLowerCase().contains(keyword)){
              System.out.println(id+"\t"+make+"\t"+model+"\t"+year+"\t"+price);
              icount++;
          } 
            
            
            
        }
        System.out.println("Matches found:"+icount);
       
    }

    private static void totalValueByYear(ResultSet rs) throws SQLException {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter manufacture year:");
    int UserYear = input.nextInt();
    System.out.println("For year "+UserYear+";");
    double total=0.0;
    int iCount=0;
        DecimalFormat df = new DecimalFormat("#,###.00");
    while(rs.next()){
        
        
        int id = rs.getInt(1);
            String make =rs.getString(2);
            String model = rs.getString("MODEL");
            int year = rs.getInt(4);
            Double price =rs.getDouble(5);
        
            if(year==UserYear){
                total+=price;
                iCount++;
            }
            
    }
        System.out.println("Number of Cars:"+iCount);
        System.out.println("Total value "+df.format(total));
    
    }

    }
    

