import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _010_Delete_multiple_records
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
        Statement st = con.createStatement();
        st.executeUpdate("DELETE FROM emp1  WHERE age>18");
        con.close();
    }
}
