import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class _044_Connection_pooling
{
    public static void main(String[] args) throws SQLException {
        MysqlConnectionPoolDataSource mcon=new MysqlConnectionPoolDataSource();
        mcon.setURL("jdbc:mysql://localhost:3306/database");
        mcon.setUser("root");
        mcon.setPassword("");
        Connection con=mcon.getConnection();
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