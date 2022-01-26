import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class _048_TransactionMethod
{
    public static void main(String[] args) throws IOException, SQLException {

        Scanner sc = new Scanner(System.in);
        Properties p = new Properties();
        FileInputStream fis = new FileInputStream("db.properties");
        p.load(fis);
        String url = p.getProperty("url");
        String user = p.getProperty("user");
        String pwd = p.getProperty("pwd");

        MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();
        ds.setURL(url);
        ds.setUser(user);
        ds.setPassword(pwd);
        Connection con = ds.getConnection();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT  * FROM balance");

        System.out.println("The detail before transaction : ");

        System.out.println("NAME\t\tAMOUNT");
        while (rs.next())
        {
            System.out.println(rs.getString(1)+"\t\t"+rs.getInt(2));
        }

        System.out.println("Transaction begin : ");
        con.setAutoCommit(false);
        st.executeUpdate("update balance set amt=amt+1000 where name='vishu'");
        st.executeUpdate("update balance set amt=amt-1000 where name='arnav'");
        System.out.print("Are you sure for this transaction : ");
        String choice = sc.next();
        if(choice.equalsIgnoreCase("yes"))
        {
            con.commit();
            System.out.println("Transaction completed ");
        }
        else
        {
            con.rollback();
            System.out.println("Transaction failed ");
        }

        System.out.println("The detail after transaction : ");
        ResultSet rs1 = st.executeQuery("select * from balance");
        System.out.println("NAME\t\tAMOUNT");
        while (rs1.next())
        {
            System.out.println(rs1.getString(1)+"\t\t"+rs1.getInt(2));
        }

        con.close();
    }
}
