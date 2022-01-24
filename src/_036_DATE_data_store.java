import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class _036_DATE_data_store
{
    public static void main(String[] args) throws SQLException, ParseException {
        Scanner sc = new Scanner(System.in);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","");

        System.out.print("Enter the name of the employee : ");
        String name = sc.next();

        System.out.print("Enter the age of the employee : ");
        int age = sc.nextInt();


        // input the data in the string form
        System.out.print("Enter the DOB(dd-MM-yyyy) : ");
        String dob = sc.next();

        // creating a object of simple date format
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        // convert the string into the java.util.Date form by using parse method
        java.util.Date udate = sdf.parse(dob);

        // convert Date to Time
        long t = udate.getTime();

        // Convert Time to java.sql.Date
        java.sql.Date sdate = new java.sql.Date(t);

        // create a statement to insert a data into the table "detail"
        PreparedStatement ps = con.prepareStatement("INSERT  INTO detail value (?,?,?)");
        ps.setString(1,name);
        ps.setDate(2,sdate);
        ps.setInt(3,age);

        int count = ps.executeUpdate();

        if(count == 0)
        {
            System.out.println("Record not inserted ");
        }
        else
        {
            System.out.println(count + " Records are successfully inserted ");
        }

        con.close();

    }
}
