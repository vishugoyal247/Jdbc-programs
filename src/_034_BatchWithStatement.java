import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _034_BatchWithStatement
{
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
        Statement st = con.createStatement();
        st.addBatch("update emp1 set salary = 99 where name='vishu' ;");
        st.addBatch("insert  into emp1 values ('vishu','male',21,34.7)");
        st.addBatch("delete from emp1 where name='vishu'");

        int[] update = st.executeBatch();
        int update_Count = 0;
        for (int ele : update)
        {
            System.out.print(ele+"  ");
        }
    }
}
