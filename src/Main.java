import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        System.out.println("Welcome to the tip calculator");


        System.out.print("How many people are in your group: ");
        int groupSize = scan.nextInt();


        System.out.print("What's the tip percentage? (0-100): ");
        double tipDecimal = scan.nextInt() / 100.0;


        double cost = 0;
        double itemCost = 0;
        String items[] = {};
        while (itemCost != -1) {
            System.out.print("Enter a cost in dollars and cents, e.g. 12.50 (-1 to end): ");
            itemCost = scan.nextDouble();
            scan.nextLine();
            if (itemCost != -1) {
                System.out.print("Enter the item: ");
                items = Arrays.copyOf(items, items.length + 1);
                items[items.length - 1] = scan.nextLine();
                cost += itemCost;
            }
        }
        System.out.println("-------------------------------");
        System.out.println("Total bill before tip: $" + cost);
        System.out.println("Total percentage: " + ((int) (tipDecimal * 100)) + "%");
        System.out.printf("Total tip: $%.2f %n", (cost * tipDecimal));
        System.out.printf("Total bill with tip: $%.2f %n", (cost + cost * tipDecimal));
        System.out.printf("Per person cost before tip: $%.2f %n", (cost / groupSize));
        System.out.printf("Tip per person: $%.2f %n", ((cost * tipDecimal) / groupSize));
        System.out.printf("Total cost per person: $%.2f %n", ((cost + cost * tipDecimal) / groupSize));
        System.out.println("-------------------------------");
        System.out.println("Items ordered:");
        for (String item : items) {
            System.out.println(item);
        }
    }
}
