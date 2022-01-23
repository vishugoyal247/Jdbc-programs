import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class _027_DeleteRecordPreparedStatement
{
    public static void main(String[] args) throws SQLException
    {
        Scanner sc = new Scanner(System.in);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
        PreparedStatement ps = con.prepareStatement("DELETE  from  emp1 where name = ?");
        while (true)
        {
            System.out.print("Enter the name of the employee you want to delete :  ");
            ps.setString(1, sc.next());
            ps.executeUpdate();
            System.out.print("Are you want to insert a new data :(yes/no) ");
            String op = sc.next();
            if (op.equalsIgnoreCase("no"))
            {
                break;
            }
        }

        System.out.println("ALL the records are successfully deleted in the database ");
        con.close();
    }
}
