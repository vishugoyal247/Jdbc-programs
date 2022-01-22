import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class _006_Insert_Data_Java_Format
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
        System.out.print("Enter the name of the employee : ");
        String name = sc.next();
        System.out.print("Enter the gender of the employee (male/female) : ");
        String gender = sc.next();
        System.out.print("Enter the age of the employee : ");
        int age = sc.nextInt();
        System.out.print("Enter the salary of the employe : ");
        float sal = sc.nextFloat();
        String sql_query = "INSERT INTO emp1 VALUES('"+name+"','"+gender+"',"+age+","+sal+")";
        Statement st = con.createStatement();
        st.executeUpdate(sql_query);


    }
}
