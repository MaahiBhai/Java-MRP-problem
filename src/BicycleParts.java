import java.sql.*;
public class BicycleParts {
    public static int cycles;
    public BicycleParts(int n){
        cycles=n;
    }
    public static int getSeat(){
        return cycles;
    }
    public static int getFrame(){
        return cycles;
    }
    public static int getWheels(){
        return cycles*2;
    }
    public static int getTires(){
        return cycles*2;
    }
    public static int getHandlebar(){
        return cycles;
    }
    public static int getChain(){
        return cycles;
    }
    public static int getCrankset(){
        return cycles;
    }
    public static int getPedals(){
        return 2*cycles;
    }
    public static int getBrakepaddle(){
        return cycles*2;
    }
    public static int getBrakecable(){
        return cycles*2;
    }
    public static int getBrakelever(){
        return cycles*2;
    }
    public static int getBrakeshoe(){
        return cycles*4;
    }
    /*public static void setSeat(int val){
        String sql = "UPDATE Users SET stock=? WHERE item=seat";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1,val);
    }
    /*public static void setFrame(int val){
        ;
    }
    public static void setWheels(int val){
        ;
    }
    public static void setTires(int val){
        ;
    }
    public static void setHandlebar(int val){
        ;
    }
    public static void setChain(int val){
        ;
    }
    public static void setCrankset(int val){
        ;
    }
    public static void setPedals(int val){
        ;
    }
    public static void setBrakepaddle(int val){
        ;
    }
    public static void setBrakecable(int val){
        ;
    }
    public static void setBrakeshoe(int val){
        ;
    }*/
}
