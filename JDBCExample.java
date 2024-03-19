import java.sql.*;

public class JDBCExample {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?createDatabaseIfNotExist=true","root","BakaDesuGa?1");
            Statement stmt = con.createStatement();
            //Creating a table in the database
            String createTableQuery = "CREATE TABLE EMP"
                    + "(id INTEGER," +
                    "name VARCHAR(40)," +
                    "PRIMARY KEY(id))";
            stmt.executeUpdate(createTableQuery);

            //Creating a record into the created table
            String insertQuery = "INSERT INTO EMP VALUES" +
                    "(1,\"Subhrajit\")";
            stmt.executeUpdate(insertQuery);

            //Retrieving Data from the table
            String selectQuery1="Select * from emp";
            ResultSet rs1=stmt.executeQuery(selectQuery1);
            while(rs1.next()){
                System.out.println("ID:" + rs1.getInt(1));
                System.out.println("Name: " + rs1.getString(2));
            }
            rs1.close();

            //Updating Records in the database
            String updateQuery = "UPDATE EMP set name=\"Sengupta\" where id = 1";
            stmt.executeUpdate(updateQuery);
            String selectQuery2="Select * from emp";
            ResultSet rs2=stmt.executeQuery(selectQuery2);
            while(rs2.next()){
                System.out.println("ID:" + rs2.getInt(1));
                System.out.println("Name: " + rs2.getString(2));
            }
            rs2.close();

            //Deleting Records from the database
            String deleteQuery = "DELETE FROM EMP where id = 1";
            stmt.executeUpdate(deleteQuery);
            String selectQuery3="Select * from emp";
            ResultSet rs3=stmt.executeQuery(selectQuery3);
            while(rs3.next()){
                System.out.println("ID:" + rs3.getInt(1));
                System.out.println("Name: " + rs3.getString(2));
            }
            rs3.close();

            //Closing the Database Connection
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
