import java.util.*;
import java.sql.*;
public class BoM {
    public static void main(String[] args){
        try {
            Scanner sc = new Scanner(System.in);
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Enter db pwd:");

            String db_pwd=sc.next();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrp_db", "root",db_pwd);
            Statement stmt = con.createStatement();

            String[] items = {"Seats","Frames","Brakesets","Brakepaddles","Brakecables","Levers","BrakeShoes","Handlebars","Wheels","Tires","Chains","Cankset","Paddles"};
            System.out.println("Enter number of cycles to be assembled");
            int no_of_cycles = sc.nextInt();// Number of cycles to be assembled
            BicycleParts honda_cycle = new BicycleParts(no_of_cycles);

            int update_flag = 1; // flag to check if we want to update the stock in the inventory
            while(update_flag==1) // loop runs till flag is set zero
            {
                int item_to_be_updated=0;// variable to store the item whose stock is to be updated
                int stock_update=0;// variable to store the new value of the stock
                System.out.println("Want to update the Inventory? " + '\n' + "Enter 1 for yes , 0 (zero) for No:");
                update_flag = sc.nextInt(); //updates flag value

                if (update_flag == 1) {
                    int i = 1;
                    for (String it : items) { //prints all the item in database
                        System.out.println("Enter " + i + " for " + it);
                        i++;
                    }
                    System.out.println("Enter -1 to not update any item");// to stop from the loop if we choose not to update any item's stock
                    item_to_be_updated=sc.nextInt();

                    if(item_to_be_updated==-1){
                        break;
                    }

                    item_to_be_updated--;
                    System.out.println("Enter the stock to be updated in the item: ");
                    stock_update=sc.nextInt();
                    String quer="update mrp_db.cycle set stock=? where item='"+items[item_to_be_updated]+"'";

                    PreparedStatement ps = con.prepareStatement(quer);
                    ps.setInt(1,stock_update);
                    ps.executeUpdate();

                }
            }
            for(String it:items) {//prints all items which needs to print inventory net off
                String itm="select stock from mrp_db.cycle where item='"+it+"'";
                ResultSet rs = stmt.executeQuery(itm);

                switch (it) {
                    case "Frames": while (rs.next()) {System.out.println("Frames req: "+(honda_cycle.getFrame() - rs.getInt(1))+'\n');} break;
                    case "Seats": while (rs.next()) {System.out.println("Seats req: "+(honda_cycle.getSeat() - rs.getInt(1)));} break;
                    case "Brakesets": while (rs.next())
                    {
                        int brakeset_req=honda_cycle.getBrakeset() - rs.getInt(1);
                        int multiplier=1;//multiplier for brakeshoes
                        System.out.println("Brakesets req: "+(brakeset_req)+'\n'+"The parts required for "+brakeset_req+" brakesets over the parts already in inventory are :");
                        for(int loop=3;loop<=6;loop++){
                            if(loop==6){
                                multiplier=2;
                            }
                            itm="select stock from mrp_db.cycle where item='"+items[loop]+"'";
                            rs = stmt.executeQuery(itm);
                            while (rs.next()) {System.out.println(items[loop]+" req: "+((multiplier*brakeset_req) - rs.getInt(1)));}
                        }
                        System.out.println();
                    }
                    break;
                    case "Wheels": while (rs.next()) {System.out.println("Wheels req:"+(honda_cycle.getWheels() - rs.getInt(1)));} break;
                    case "Tires": while (rs.next()) {System.out.println("Tires req: "+(honda_cycle.getTires() - rs.getInt(1)));} break;
                    case "Chains": while (rs.next()) {System.out.println("Chains req: "+(honda_cycle.getChain() - rs.getInt(1)));} break;
                    case "Canksets": while (rs.next()) {System.out.println("Cranksets req :"+(honda_cycle.getCrankset() - rs.getInt(1)));} break;
                    case "Paddles": while (rs.next()) {System.out.println("Pedals Req: "+(honda_cycle.getPedals() - rs.getInt(1)));} break;
                    default:break;
                }
            }
            sc.close();
            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}