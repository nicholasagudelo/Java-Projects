import java.sql.*;
import java.util.*;

class Database { //User chooses whats inserted, deleted, etc. 

      public static void main(String[] args) throws Exception {

            String url = "jdbc:oracle:thin:@//sabzevi2.homeip.net:1521/FREEPDB1";
            String username = "csus";
            String password = "student";

            try (Connection connection = DriverManager.getConnection(url, username, password);
                 Statement statement = connection.createStatement()) {

                  // Create tables every run
                  dropTables(statement);
                  spawnTables(statement);

                  int choice;

                  do {
                        choice = menu();

                        switch (choice) {
                              case 1:
                                    insertData(statement);
                                    break;
                              case 2:
                                    deleteData(statement);
                                    break;
                              case 3:
                                    updateData(statement);
                                    break;
                              case 4:
                                    viewData(statement);
                                    break;
                              case 0:
                                    System.out.println("Goodbye.");
                                    break;
                              default:
                                    System.out.println("Invalid choice.");
                        }
                  } while (choice != 0);

            } catch (SQLException e) {
                  e.printStackTrace();
            }
      }


      // ----------------------
      //   TABLE CREATION
      // ----------------------
      private static void spawnTables(Statement statement) throws SQLException {

            String parent_table =
            "CREATE TABLE Agude_Publisher (" +
            "publisher_id INT PRIMARY KEY, " +
            "publisher_name VARCHAR2(50) NOT NULL)";

            String child_table =
            "CREATE TABLE Agude_Book (" +
            "book_id INT PRIMARY KEY, " +
            "book_title VARCHAR2(50) NOT NULL, " +
            "author VARCHAR2(50) NOT NULL, " +
            "publisher_id INT REFERENCES Agude_Publisher(publisher_id))";

            statement.executeUpdate(parent_table);
            statement.executeUpdate(child_table);

            System.out.println("Tables created successfully.");
      }

      private static void dropTables(Statement statement) {
            try { statement.executeUpdate("DROP TABLE Agude_Book"); } catch (Exception e) {}
            try { statement.executeUpdate("DROP TABLE Agude_Publisher"); } catch (Exception e) {}
      }


      // ----------------------
      //        MENU
      // ----------------------
      private static int menu() {
            Scanner kb = new Scanner(System.in);
            int input;

            System.out.println("\nSelect what you'd like to do:" +
                  "\n1. Insert" +
                  "\n2. Delete" +
                  "\n3. Update" +
                  "\n4. View" +
                  "\n0. Quit program");

            while (true) {
                  System.out.print("Enter choice: ");

                  while (!kb.hasNextInt()) {
                        System.out.println("That's not a number!");
                        kb.next();
                  }

                  input = kb.nextInt();

                  if (input >= 0 && input <= 4)
                        return input;

                  System.out.println("Please enter a valid choice.");
            }
      }


      // ----------------------
      //      INSERT DATA
      // ----------------------
      private static void insertData(Statement statement) throws SQLException {

         Scanner kb = new Scanner(System.in);

         System.out.println("Into which table would you like to insert?" +
            "\n1. Publisher" +
            "\n2. Book");

         int choice = checkInput_Int(1, 2);

         if (choice == 1) {
         // Publisher input
            System.out.print("Enter publisher ID: ");
            int pub_id = kb.nextInt();
            kb.nextLine(); // consume newline

            System.out.print("Enter publisher name: ");
            String pub_name = kb.nextLine();

            String publisherInsert =
                "INSERT INTO Agude_Publisher (publisher_id, publisher_name) " +
                "VALUES (" + pub_id + ", '" + pub_name + "')";

            statement.executeUpdate(publisherInsert);
            System.out.println("Publisher inserted successfully.");

         } else {
            // Book input
            System.out.print("Enter book ID: ");
            int b_id = kb.nextInt();
            kb.nextLine();

            System.out.print("Enter book title: ");
            String b_title = kb.nextLine();

            System.out.print("Enter author: ");
            String author = kb.nextLine();

            System.out.print("Enter publisher ID (must exist): ");
            int pub_id = kb.nextInt();

            String bookInsert =
                "INSERT INTO Agude_Book (book_id, book_title, author, publisher_id) " +
                "VALUES (" + b_id + ", '" + b_title + "', '" + author + "', " + pub_id + ")";

            statement.executeUpdate(bookInsert);
            System.out.println("Book inserted successfully.");
    }
}



      // ----------------------
      //        VIEW DATA
      // ----------------------
      private static void viewData(Statement statement) throws SQLException {

            ResultSet rs = statement.executeQuery(
                  "SELECT b.book_id, b.book_title, b.author, p.publisher_name " +
                  "FROM Agude_Book b JOIN Agude_Publisher p " +
                  "ON b.publisher_id = p.publisher_id");

            System.out.println("\nBooks in database:");
            while (rs.next()) {
                  System.out.println(
                        rs.getInt(1) + " | " +
                        rs.getString(2) + " | " +
                        rs.getString(3) + " | " +
                        rs.getString(4));
            }
      }
      
      // ----------------------
      //        DELETE
      // ----------------------
      private static void deleteData(Statement statement) throws SQLException {

         Scanner kb = new Scanner(System.in);

         System.out.print("Enter book title to delete: ");
         String b_title = kb.nextLine();

         String deleteSQL =
            "DELETE FROM Agude_Book WHERE book_title = '" + b_title + "'";

         int rows = statement.executeUpdate(deleteSQL);

         if (rows > 0)
            System.out.println("Book deleted successfully.");
         else
            System.out.println("No book found with that title.");
      }
      
      // ----------------------
      //        UPDATE
      // ----------------------
      private static void updateData(Statement statement) throws SQLException {

         Scanner kb = new Scanner(System.in);

         System.out.print("Enter current publisher identification number: ");
         int pub_id = checkInput_Int(1, 20);

         System.out.print("Enter new publisher name: ");
         String newName = kb.nextLine();

         String updateSQL =
            "UPDATE Agude_Publisher " +
            "SET publisher_name = '" + newName + "' " +
            "WHERE publisher_id = " + pub_id + "";

         int rows = statement.executeUpdate(updateSQL);

         if (rows > 0)
            System.out.println("Publisher updated successfully.");
         else
            System.out.println("No publisher matched that name.");
}
      
      
      // -----------------------
      //        CHECK INT
      // -----------------------
      public static int checkInput_Int(int a, int b) {
      
         Scanner kb = new Scanner(System.in);
         int input;
         
         while (true) {
                  System.out.print("Enter choice: ");

                  while (!kb.hasNextInt()) {
                        System.out.println("That's not a number!");
                        kb.next();
                  }

                  input = kb.nextInt();

                  if (input >= a && input <= b)
                        return input;

                  System.out.println("Please enter a valid choice.");
            }
      }

}
