import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCPreparedStatementExample {

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctwo?createDatabaseIfNotExist=true","root","BakaDesuGa?1");

            //Creating table in the database
            PreparedStatement psmt = con.prepareStatement("CREATE TABLE EMP(" +
                    "id INTEGER," +
                    "name VARCHAR(40)," +
                    "PRIMARY KEY(id))");
            psmt.executeUpdate();
            System.out.println("Table Created");

            //Creating Record into the database
            String insertQuery = "INSERT INTO EMP VALUES(?,?)";
            PreparedStatement psmt2 = con.prepareStatement(insertQuery);
            psmt2.setInt(1,101);
            psmt2.setString(2,"Subhrajit");
            int i = psmt2.executeUpdate();
            System.out.println("No. of rows inserted " + i);

            //Retrieving Records from the database
            String selectQuery = "SELECT * FROM EMP";
            PreparedStatement psmt3 = con.prepareStatement(selectQuery);
            ResultSet rs = psmt3.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }

            //Updating Records in the database
            String updateQuery = "UPDATE EMP SET name=? WHERE id=?";
            PreparedStatement psmt4 = con.prepareStatement(updateQuery);
            psmt4.setString(1,"Sengupta");
            psmt4.setInt(2,101);
            int j = psmt4.executeUpdate();
            System.out.println("no.of rows updated " + j);
            String selectQuery1 = "SELECT * FROM EMP";
            PreparedStatement psmt5 = con.prepareStatement(selectQuery1);
            ResultSet rs1 = psmt5.executeQuery();
            while(rs1.next()){
                System.out.println(rs1.getInt(1) + " " + rs1.getString(2));
            }


            //Deleting Records from the database
            String deleteQuery = "DELETE FROM EMP WHERE id=?";
            PreparedStatement psmt6 = con.prepareStatement(deleteQuery);
            psmt6.setInt(1,101);
            int k = psmt6.executeUpdate();
            System.out.println("No. of rows deleted " + k);
            String selectQuery2 = "SELECT * FROM EMP";
            PreparedStatement psmt7 = con.prepareStatement(selectQuery2);
            ResultSet rs2 = psmt7.executeQuery();
            while(rs2.next()){
                System.out.println(rs2.getInt(1)+ " " + rs2.getString(2));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
