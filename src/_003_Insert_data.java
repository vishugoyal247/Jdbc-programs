import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class _003_Insert_data
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        Scanner sc = new Scanner(System.in);
//        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
        PreparedStatement ps = con.prepareStatement("INSERT INTO emp VALUES (?,?,?,? );");
        System.out.print("Enter the name of the employee: ");
        String name = sc.next();
        System.out.print("Enter the gender male/female: ");
        String gender = sc.next();
        System.out.print("Enter the age of the employee: ");
        int age = sc.nextInt();
        System.out.print("Enter the salary of the employee: ");
        float sal = sc.nextFloat();
        ps.setString(1,name);
        ps.setString(2,gender);
        ps.setInt(3,age);
        ps.setFloat(4,sal);
        ps.executeUpdate();
//        ps.close();
        con.close();
    }
}