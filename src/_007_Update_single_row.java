import java.security.cert.CertificateParsingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _007_Update_single_row
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
        Statement st = con.createStatement();
        st.executeUpdate("UPDATE emp1 SET salary = 64 WHERE name = 'vishu'");
        con.close();
    }
}
