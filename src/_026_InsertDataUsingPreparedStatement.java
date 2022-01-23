import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class _026_InsertDataUsingPreparedStatement
{
    public static void main(String[] args) throws SQLException
    {
        Scanner sc = new Scanner(System.in);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
        PreparedStatement ps = con.prepareStatement("INSERT  INTO emp1 VALUES (?,?,?,?)");
        while (true)
        {
            System.out.print("Enter the records of the table : ");
            ps.setString(1, sc.next());
            ps.setString(2, sc.next());
            ps.setInt(3, sc.nextInt());
            ps.setFloat(4, sc.nextFloat());
            ps.executeUpdate();
            System.out.print("Are you want to insert a new data :(yes/no) ");
            String op = sc.next();
            if (op.equalsIgnoreCase("no"))
            {
                break;
            }
        }

        System.out.println("ALL the records are successfully added to the database ");

    }
}