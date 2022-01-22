import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _009_Delete_Single_row
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
        Statement st = con.createStatement();
        st.executeUpdate("DELETE FROM emp1  WHERE name='vishu'");
        con.close();
    }
}
