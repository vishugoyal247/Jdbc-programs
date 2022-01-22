import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _008_Update_multiple_Records
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
        Statement st = con.createStatement();
        st.executeUpdate("UPDATE emp1 SET salary=salary+10 WHERE age<45");
        con.close();
    }
}
