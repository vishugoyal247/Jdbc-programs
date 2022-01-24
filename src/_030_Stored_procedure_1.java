import java.sql.*;
import java.util.Scanner;

/*
        * make sure store procedure already store in the database
        * create a callable statement object
        * provide values for every IN parameter by using corresponding setter method
        * register every out parameter with the JDBC types
        * execute procedure call
        * get result
 */



/*
        Stored Procedure
        create or replace procedure emp1(enane IN varchar(10), esal OUT decimal ) as
        BEGIN
              SELECT salary into esal FROM employee where name = ename;
        END;
        /
*/
public class _030_Stored_procedure_1
{
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
        CallableStatement cst = con.prepareCall("{call getSal(?,?)}");
        System.out.print("Enter the name of the employee : ");
        cst.setString(1,sc.next());
        cst.registerOutParameter(2,Types.DECIMAL);
        cst.execute();
        System.out.println("The salary of the employee is  : "+cst.getFloat(2));
        con.close();
    }
}

