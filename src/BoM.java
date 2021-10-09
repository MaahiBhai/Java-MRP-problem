import java.util.*;
import java.sql.*;

public class BoM {
    public static void main(String[] args){
        try {
            Scanner sc = new Scanner(System.in);
            String db_pwd=sc.next();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root",db_pwd );
            Statement stmt = con.createStatement();
            System.out.println("Enter number of cycles to be assembled");
            int no_of_cycles = sc.nextInt();
            BicycleParts honda_cycle = new BicycleParts(no_of_cycles);

        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}
