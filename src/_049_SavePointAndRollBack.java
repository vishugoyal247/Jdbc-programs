

/*
    - Savepoint sp=con.setSavepoint()   ----> if we want to rollback particular operations based on some condition
    - con.rollback(sp)                  ----> to perform rollback based on condition
    - con.releaseSavepoint(sp)          ----> to release or delete savepoint
     */

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class _049_SavePointAndRollBack
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
        con.setAutoCommit(false);

        Statement st = con.createStatement();


        st.executeUpdate("Insert into balance values ('vishu',1000)");
        st.executeUpdate("Insert into balance values ('arnav',2000)");

        Savepoint sp = con.setSavepoint();

        st.executeUpdate("insert  into balance values ('etisha',3000)");

        System.out.println("Oops! Wrong entry will entered : just roll backed ");

        con.rollback(sp);
        con.releaseSavepoint(sp);
        System.out.println("Operation are roll back successfully ");

        con.commit();

        con.close();




    }
}
