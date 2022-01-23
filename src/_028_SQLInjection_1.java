import java.sql.*;
import java.util.Scanner;

public class _028_SQLInjection_1
{
    public static void main(String[] args) throws SQLException {
        Scanner sc=new Scanner(System.in);
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
        Statement st=con.createStatement();
        System.out.print("Enter the name whose record you want to display : ");
        String name=sc.next();
        ResultSet rs =st.executeQuery("select * from emp1 where name='"+ name +"' or 2=2 ");
        System.out.println("ENO \t ENAME \t ESAL \t EADDR");
        System.out.println("...............................");
        while(rs.next())
        {
            System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getFloat(4));
        }
        System.out.println("...............................");
        con.close();

    }
}
