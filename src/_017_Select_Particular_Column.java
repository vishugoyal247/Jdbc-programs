import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class _017_Select_Particular_Column
{
    public static void main(String[] args) throws SQLException
    {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT name,gender FROM emp1 ");
        System.out.println("NAME         GENDER");
        while (rs.next())
        {
            System.out.println(rs.getString(1)+"        "+rs.getString(2));
        }
        con.close();
    }
}
