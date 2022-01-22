import java.sql.*;

public class _014_Select_row_desc
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM emp1 ORDER BY salary DESC ");
        System.out.println("NAME         GENDER        AGE       SALARY");
        while (rs.next())
        {
            System.out.println(rs.getString(1)+"        "+rs.getString(2)+"        "+rs.getInt(3)+"        "+rs.getFloat(4));
        }
        con.close();
    }
}
