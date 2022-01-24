import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class _042_Insert_CLOB_data
{
    public static void main(String[] args) throws SQLException, FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","");
        PreparedStatement ps = con.prepareStatement("INSERT  into ds values (?,?)");
        while (true)
        {
            System.out.print("Enter the name of the employee : ");
            String name = sc.next();
            ps.setString(1,name);

            System.out.print("Enter the path of the resume : ");
            String path = sc.next();

            File f = new File(path);
            FileReader fr = new FileReader(f);
            ps.setCharacterStream(2,fr);

            System.out.println(name + " Successfully insert your data into the table ");

            System.out.print("Are you want to insert more data into your database YES/NO : ");
            String choice = sc.next();
            if(choice.equalsIgnoreCase("no"))
                break;
        }
        int count = ps.executeUpdate();
        if(count == 0 )
            System.out.println("No record is added ");
        else
            System.out.println(count+" Records are uploaded ");
        con.close();

    }
}
