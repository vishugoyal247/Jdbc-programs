import java.sql.*;
import java.util.Scanner;

public class _031_Stored_procedure_2
{
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
        CallableStatement cst = con.prepareCall("{call empAge(?,?)}");
        System.out.print("Enter the employee name : ");
        cst.setString(1,sc.next());
        cst.registerOutParameter(2, Types.INTEGER);
        cst.execute();
        System.out.println("The age of the employee : "+cst.getInt(2));
        con.close();
    }
}
