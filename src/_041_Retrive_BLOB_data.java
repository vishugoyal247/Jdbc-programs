import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Scanner;

public class _041_Retrive_BLOB_data
{
    public static void main(String[] args) throws SQLException, IOException {
        Scanner sc = new Scanner(System.in);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","");

        PreparedStatement ps = con.prepareStatement("SELECT * FROM data");
        ResultSet rs = ps.executeQuery();

        int count = 1;
        while(rs.next())
        {

            FileOutputStream os = new FileOutputStream("data"+count+".mp4");
            String name = rs.getString(1);
            InputStream is = rs.getBinaryStream(2);
            byte[] buffer = new byte[2048];
            while (is.read(buffer)>0)
            {
                os.write(buffer);

            }
            os.flush();
            count++;

        }
        System.out.println("successfully loaded");
        con.close();
    }

}
