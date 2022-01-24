import javax.swing.*;
import java.sql.*;
import java.text.CompactNumberFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class _038_retrieve_date_dd_MMM_yyyy
{
    public static void main(String[] args) throws SQLException
    {
        Scanner sc = new Scanner(System.in);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","");
        PreparedStatement ps = con.prepareStatement("select * from detail");
        ResultSet rs = ps.executeQuery();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

        while (rs.next())
        {
            System.out.println("The details are : ");
            System.out.println("The name of the employee : "+rs.getString(1));

            java.sql.Date sdate = rs.getDate(2);
            String dob = sdf.format(sdate);
            System.out.println("The Date of birth is : "+dob );

            System.out.println("The age of the employee : "+rs.getInt(3));
            System.out.println("\n\n");
        }
        con.close();
    }
}
