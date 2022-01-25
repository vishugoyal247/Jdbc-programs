import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.*;

public class _043_Retrieve_CLOB_data
{
    public static void main(String[] args) throws SQLException, IOException, SQLException {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","");
        PreparedStatement ps=con.prepareStatement("select * from ds");
        ResultSet rs=ps.executeQuery();
        int n=1;
        while(rs.next())
        {
            FileWriter fw=new FileWriter("file"+n+".txt");
            String name=rs.getString(1);
            System.out.println(name);
            Reader r=rs.getCharacterStream(2);
            /*
            char[] buffer=new char[1024];   // we can use this buffer array because resume is too big so the character array is too large
            while(r.read(buffer)>0)
            {
                fw.write(buffer);
            }
             */
            int i=r.read();
            while(i!=-1)
            {
                fw.write(i);
                i=r.read();
            }
            fw.flush();
            System.out.println("Successfully retrieved file: file"+n+".txt");
            n++;
        }
        con.close();
    }
}