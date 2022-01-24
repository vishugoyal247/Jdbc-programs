import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.text.CompactNumberFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/*
            Step 1 : create table data (name varchar(10), image BLOB);
            File f = new File("Karina.jpg");
            Step 2 : Create FIS object to read binary data from the file
            FIS fis = new FIS(f);
            Step 3 : create a statment
            PreparedStatement ps = con.PrepareStatement("insert into data values (?,?)" );
            ps.setString(1,sc.next());
            ps.setBinaryStream(2,fis);
            Step 4 : ps.executeupdate();


            object should be
                               image
                               video
                               audio


           Set max packet sql:
           SET GLOBAL max_allowed_packet=268435456
 */


public class _040_Insert_BLOB_data
{
    public static void main(String[] args) throws SQLException, FileNotFoundException
    {
        Scanner sc = new Scanner(System.in);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","");
        Statement st = con.createStatement();

        System.out.print("Enter the name of the employee: ");
        String name = sc.next();

        File f = new File("C:/Users/ASUS/Desktop/DurgaSir.mp4");
        FileInputStream fis = new FileInputStream(f);

        PreparedStatement ps = con.prepareStatement("INSERT INTO data values (?,?)");
        ps.setString(1,name);
        ps.setBinaryStream(2,fis);

        ps.executeUpdate();
        con.close();
    }
}

