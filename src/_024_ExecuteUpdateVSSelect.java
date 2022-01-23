import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _024_ExecuteUpdateVSSelect
{

    public static void main(String[] args) throws SQLException {
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root",""))
        {
            Statement st = con.createStatement();
            System.out.println(st.executeUpdate("select * from emp1"));  // It will generate error
        }
        catch ( SQLException e)
        {
            System.out.println();
            System.out.println(" Exception because "+e.getMessage());
        }
    }
}
