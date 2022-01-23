import java.sql.*;
import java.util.Scanner;

public class _029_SQLInjection_2
{
    public static void main(String[] args) throws SQLException {
        Scanner sc=new Scanner(System.in);
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
        Statement st=con.createStatement();
        System.out.print("Enter the username : ");
        String user_name=sc.next();
        System.out.print("Enter the password : ");
        String passwd = sc.next();
        ResultSet rs =st.executeQuery("SELECT * FROM emp1 where name ='"+user_name+"' and pass='"+passwd+"'");    //username = vishu'--
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
