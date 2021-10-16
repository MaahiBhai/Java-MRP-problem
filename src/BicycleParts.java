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
    public static int getBrakeset(){
        return cycles*2;
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
}
