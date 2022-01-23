import java.sql.*;
import java.util.Scanner;

public class _022_ExecuteMethod
{
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
        Statement st = con.createStatement();
        System.out.print("Enter the sql query : ");
        String sql = sc.nextLine();
        boolean b = st.execute(sql);
        if(b==true)  // select query
        {
            ResultSet rs = st.getResultSet();
            while (rs.next())
            {
                System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getInt(3)+"\t\t"+rs.getFloat(4));

            }
        }
        else  // non select query
        {
            int rowCount = st.getUpdateCount();
            System.out.println("The number of the records affected : "+rowCount);
        }
        con.close();
    }
}
