import java.sql.*;
import java.util.Scanner;

public class _016_Select_Record_Second_character_based
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        Scanner sc = new Scanner(System.in);
        Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
        Statement st = con.createStatement();
        System.out.print("Enter the first letter of the name: ");
        String initialCharacter = "__"+sc.next()+"%";
        ResultSet rs = st.executeQuery(String.format("SELECT * FROM emp1 WHERE name LIKE '%s'",initialCharacter));
        System.out.println("NAME         GENDER        AGE       SALARY");
        while (rs.next())
        {
            System.out.println(rs.getString(1)+"        "+rs.getString(2)+"        "+rs.getInt(3)+"        "+rs.getFloat(4));
        }
        con.close();
    }
}
