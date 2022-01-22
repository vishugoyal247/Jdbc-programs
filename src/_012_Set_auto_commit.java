import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _012_Set_auto_commit
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
        con.setAutoCommit(false);
        Statement st = con.createStatement();
        st.executeUpdate("DELETE FROM emp1  WHERE name='raman'");
        System.out.println("Matched records are deleted properly but not update in database becoz of setautocommit is false ");
        con.close();
    }
}
