import java.sql.*;

public class _001_Create_Table_statement
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
//        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
        Statement st = con.createStatement();
        st.executeUpdate("CREATE TABLE emp1 (name varchar(20),gender varchar(8),age int,salary decimal (5,3) );");
//        st.close();
        con.close();
    }
}