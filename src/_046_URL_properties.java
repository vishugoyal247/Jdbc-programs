import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class _046_URL_properties
{
    public static void main(String[] args) throws IOException, SQLException {
        Properties p = new Properties();
        FileInputStream fis = new FileInputStream("db1.properties");
        p.load(fis);

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database",p);

        Statement st=con.createStatement();

        ResultSet rs=st.executeQuery("select * from emp1");

        System.out.println("NAME \t GENDER \t AGE \t SALARY");
        System.out.println("...............................");
        while(rs.next())
        {
            System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+
                    rs.getFloat(4));
        }
        con.close();
    }




}

