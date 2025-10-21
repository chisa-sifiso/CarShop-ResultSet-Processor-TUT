📘 README.md
🚗 CarShopApp1 — Java + Derby SQL Database Application
📖 Overview

CarShopApp1 is a simple Java console-based application that connects to a Derby database (CarShop) to manage and query car records.
It demonstrates how to:

Establish a JDBC connection

Execute SQL queries using a Statement

Process a ResultSet to search and compute values

Work with user input via Scanner

⚙️ Features

Search Cars (by Make/Model)

Allows the user to search cars by entering a keyword.

Filters matching results by make or model.

Total Value by Year

Prompts the user for a year and calculates the total value of all cars manufactured in that year.

Exit

Gracefully exits the program.

🗃️ Database Setup

Create Database

CREATE DATABASE CarShop;


Import Data

Locate the provided data.sql file.

Run it inside your SQL tool (e.g., Derby or NetBeans Services → Database → Execute Command) to create and populate the Cars table.

Example of what data.sql may contain:

CREATE TABLE Cars (
    ID INT PRIMARY KEY,
    MAKE VARCHAR(50),
    MODEL VARCHAR(50),
    YEAR INT,
    PRICE DECIMAL(10,2)
);

INSERT INTO Cars VALUES
(1, 'Toyota', 'Corolla', 2020, 250000),
(2, 'Ford', 'Focus', 2021, 310000),
(3, 'BMW', '320i', 2020, 600000);

💻 How to Run the Program

Open NetBeans or VS Code (with Java support).

Create a new Java Project named CarShopApp1.

Copy the provided source code into CarShopApp1.java.

Ensure your database connection string matches your local setup:

Connection conn = DriverManager.getConnection(
    "jdbc:derby://localhost:1527/CarShop", "app", "123"
);


Run the program — the menu will appear in the console.

🧠 Code Explanation

JDBC Connection – Establishes connection with the Derby database.

Statement + ResultSet – Executes SELECT * FROM CARS and retrieves data.

searchCars() – Loops through the result set and prints matches.

totalValueByYear() – Calculates total price of all cars from a given year.

DecimalFormat – Used for displaying currency format (e.g., #,###.00).

🧩 Example Output
Menu:
1. Search Cars (by make/model)
2. Total Value by Year
3. Exit
Choose an option: 1
Enter make/model keyword: toyota
ID | MAKE | MODEL | YEAR | PRICE
Results:
1    Toyota    Corolla    2020    250000.0
Matches found: 1

🧑‍💻 Author

Sifiso Vinjwa
sifisovinjwa1@gmail.com
💻 Created as part of an SQL and Java integration exercise.
