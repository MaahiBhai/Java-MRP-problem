import java.util.Scanner;

public class BoM {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of cycles to be assembled");
        int no_of_cycles=sc.nextInt();
        BicycleParts honda_cycle = new BicycleParts(no_of_cycles);

    }
}
