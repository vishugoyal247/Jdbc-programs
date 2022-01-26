import java.sql.*;

public class _053_ResultSetMetaData1
{
    /*
       ResultSetMetaData
    */
    public static void main(String[] args) throws SQLException
    {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/database?user=root&password=");
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from emp1");
        ResultSetMetaData rsmd=rs.getMetaData();
        int count=rsmd.getColumnCount();
        for (int i = 1; i <= count; i++)
        {
            System.out.println("Column Number:"+i);
            System.out.println("Column Name:"+rsmd.getColumnName(i));
            System.out.println("Column Type:"+rsmd.getColumnType(i));
            System.out.println("Column Size:"+rsmd.getColumnDisplaySize(i));
            System.out.println(".........................");
        }
        con.close();
    }
}