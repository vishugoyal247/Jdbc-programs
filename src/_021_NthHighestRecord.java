import java.sql.*;
import java.util.Scanner;

public class _021_NthHighestRecord
{
    public static void main(String[] args) throws SQLException
    {
        Scanner sc = new Scanner(System.in);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
        Statement st = con.createStatement();
        System.out.print("Enter the order : ");
        String sql = "SELECT * FROM (SELECT name,gender,age,salary,dense_rank() over (order by salary DESC ) AS RANKING FROM emp1 ) WHERE RANKING ="+sc.nextInt();
        ResultSet rs = st.executeQuery(sql);
        if(rs.next())
        {
            System.out.println("The total no. of rows is : "+rs.getInt(1));
        }
        con.close();
    }
}



//select * from(
//
//        select name,gender,age, salary, dense_rank()
//        over(order by salary desc) r from emp1)
//        where r=sc.nextInt();