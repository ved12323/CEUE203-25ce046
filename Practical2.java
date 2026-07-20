
import java.util.Scanner;
 
record Vehicle(String number, String type) {}
 
public class Practical2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        System.out.println("Enter vehical. Type 'done' for the number to stop...");
 
        int totalToll = 0;
        int bikeCount = 0;
        int carCount = 0;
        int truckCount = 0;
 
        while (true) {
            System.out.print("Enter Vehicle Number: ");
            String number = sc.nextLine();
 
            if (number.equalsIgnoreCase("done")) {
                String mostFrequent = "bike";
 
                if (carCount > bikeCount && carCount >= truckCount) {
                    mostFrequent = "car";
                } else if (truckCount > bikeCount && truckCount > carCount) {
                    mostFrequent = "truck";
                }
 
                System.out.println("Total toll: " + totalToll);
                System.out.println("Most frequent: " + mostFrequent);
                sc.close();
                return;
            }
 
            System.out.print("Enter Vehicle Type: ");
            String type = sc.nextLine().toLowerCase();
 
            Vehicle v = new Vehicle(number, type);
 
            int toll = switch (v.type()) {
                case "bike" -> 20;
                case "car" -> 50;
                case "truck" -> 150;
                default -> 0;
            };
 
            totalToll += toll;
 
            switch (v.type()) {
                case "bike" -> bikeCount++;
                case "car" -> carCount++;
                case "truck" -> truckCount++;
            }
 
            System.out.println(v.number() + " " + v.type() + " pays: " + toll);
        }
    }
}
 
 