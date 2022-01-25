import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class _045_Properties_example
{
    public static void main(String[] args) throws IOException, SQLException, SQLException, FileNotFoundException, ClassNotFoundException {
        Properties p = new Properties();
        FileInputStream fis = new FileInputStream("db.properties");

        //copy all the properties from the properties file to the properties object.
        p.load(fis);

        String  url = p.getProperty("url");
        String username = p.getProperty("user");
        String password = p.getProperty("pwd");

        MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();

        ds.setURL(url);
        ds.setUser(username);
        ds.setPassword(password);

        Connection con = ds.getConnection();

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
