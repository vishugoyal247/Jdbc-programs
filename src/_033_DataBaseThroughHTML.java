import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.*;

public class _033_DataBaseThroughHTML
{
    public static void main(String[] args) throws SQLException, IOException
    {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
        Statement st=con.createStatement();
        String sql_query="select * from emp1";
        ResultSet rs=st.executeQuery(sql_query);
        String data="";
        data=data+"<html><body bgcolor='white' text='black'><center><table border='2'>";
        data=data+"<tr><td>Name</td><td>Gender</td><td>Age</td><td>Salary</td></tr>";
        while(rs.next())
        {
            data=data+"<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"
                    +rs.getInt(3)+"</td><td>"+rs.getFloat(4)+"</td></tr>";
        }
        data=data+"</table></center></body></html>";
        FileOutputStream fos=new FileOutputStream("jdbc.html");
        byte[] b=data.getBytes();
        fos.write(b);
        fos.flush();
        System.out.println("Open jdbc.html to get Employees Data");
        fos.close();
        con.close();
    }
}