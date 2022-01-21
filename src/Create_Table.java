import java.sql.*;

public class Create_Table
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
        PreparedStatement ps = con.prepareStatement("CREATE TABLE emp (name varchar(20),gender varchar(8),age int,salary decimal (5,3) );");
        ps.executeUpdate();
        ps.close();
        con.close();
    }
}
