import java.util.*;
import java.sql.*;
public class BoM {
    public static void main(String[] args){
        try {
            Scanner sc = new Scanner(System.in);
            Class.forName("com.mysql.cj.jdbc.Driver");
            //String db_pwd=sc.next();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrp_db", "root","Mahesh1210@");
            Statement stmt = con.createStatement();
            String[] items = {"Seats","Frames","Brakesets","Brakepaddles","Brakecables","Levers","BrakeShoes","Handlebars","Wheels","Tires","Chains","Cankset","Paddles"};
            System.out.println("Enter number of cycles to be assembled");
            int no_of_cycles = sc.nextInt();
            BicycleParts honda_cycle = new BicycleParts(no_of_cycles);
            for(String it:items) {
                String itm="select stock from mrp_db.cycle where item='"+it+"'";
                ResultSet rs = stmt.executeQuery(itm);
                switch (it) {
                    case "Frames": while (rs.next()) {System.out.println("Frames req: "+(honda_cycle.getFrame() - rs.getInt(1)));} break;
                    case "Seats": while (rs.next()) {System.out.println("Seats req: "+(honda_cycle.getSeat() - rs.getInt(1)));} break;
                    case "Brakesets": while (rs.next()) {System.out.println("Brakesets req: "+(honda_cycle.getBrakeset() - rs.getInt(1)));} break;
                    case "Wheels": while (rs.next()) {System.out.println("Wheels req:"+(honda_cycle.getWheels() - rs.getInt(1)));} break;
                    case "Tires": while (rs.next()) {System.out.println("Tires req: "+(honda_cycle.getTires() - rs.getInt(1)));} break;
                    case "Chains": while (rs.next()) {System.out.println("Chains req: "+(honda_cycle.getChain() - rs.getInt(1)));} break;
                    case "Canksets": while (rs.next()) {System.out.println("Cranksets req :"+(honda_cycle.getCrankset() - rs.getInt(1)));} break;
                    case "Paddles": while (rs.next()) {System.out.println("Pedals Req: "+(honda_cycle.getPedals() - rs.getInt(1)));} break;
                    default:break;
                }
            }
            sc.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
