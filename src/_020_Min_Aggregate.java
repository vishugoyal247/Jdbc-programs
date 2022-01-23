import java.sql.*;

import java.sql.*;

public class _020_Min_Aggregate
{
    public static void main(String[] args) throws SQLException
    {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT MIN(salary) FROM emp1 ");
        if(rs.next())
        {
            System.out.println("The total no. of rows is : "+rs.getInt(1));
        }
        con.close();
    }
}
