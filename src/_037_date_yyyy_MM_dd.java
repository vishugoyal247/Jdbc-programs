import com.mysql.cj.jdbc.ConnectionImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class _037_date_yyyy_MM_dd
{
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","");

        PreparedStatement ps = con.prepareStatement("Insert into detail values (?,?,?)");
        while (true)
        {
            System.out.print("Enter the employee detail : ");
            String name = sc.next();

            System.out.print("Enter the age of the employee : ");
            int age = sc.nextInt();

            System.out.print("Enter the DOB of the employee (yyyy-MM-dd) : ");
            String dob = sc.next();

            java.sql.Date sdate = java.sql.Date.valueOf(dob);

            ps.setString(1,name);
            ps.setDate(2,sdate);
            ps.setInt(3,age);

            System.out.print("Are you want to insert more data into you detail table (Yes/No) : ");
            String choice = sc.next();
            if(choice.equalsIgnoreCase("no"))
                break;
        }

        int count = ps.executeUpdate();
        if(count == 0)
        {
            System.out.println("Not added any data successfully ");
        }
        else
        {
            System.out.println(count + " Records are added successfully ");
        }
        con.close();

    }
}
