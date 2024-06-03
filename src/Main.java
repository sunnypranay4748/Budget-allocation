import java.util.Scanner;
import java.util.ArrayList;

//  MP4: https://www.youtube.com/watch?v=uZDuvMo-4pU

public class Main{
    public static void main(String[] args){
        System.out.println("How much can you spend");
        Scanner scan = new Scanner(System.in);
        double total = scan.nextDouble();
        double sum =0.0;
        int i = 0;
        ArrayList<Double> proportions = new ArrayList<>();
        System.out.println("Enter your proportion of various expenses. ");
        System.out.println("The system stops if cumulative proprtion exceeds 100%");
        do {
            System.out.println("Your proption of expense "+
                    (i+1) + ": ");
            double value = scan.nextDouble();
            proportions.add(value);
            sum += proportions.get(i);
            i++;
        }while(sum <= 100);
        scan.close();

        if(sum > 100){
            double cumulativeSum = 0.0;
            for(int j =0; j<proportions.size()-1; j++){
                cumulativeSum += proportions.get(j);
            }
            proportions.set(proportions.size()-1, 100.0-cumulativeSum);
        }
        for( double value: proportions){
            double expense = value * total/100.0;
            System.out.println("Your " + value + "% equals $" + expense);
        }
    }
}