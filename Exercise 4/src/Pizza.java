import java.util.InputMismatchException;
import java.util.Scanner;

public class Pizza {

    protected String name;
    protected String shortDescription;
    protected int price;
    protected String ingredients;
    protected double discount;

    public String getName() {
        return name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public int getPrice() {
        return price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public double getDiscount() {
        return discount;
    }

    public void displayPizzaDetails() {
        System.out.println("Name: " + name);
        System.out.println("Description: " + shortDescription);
        System.out.println("Price: $" + price);
        System.out.println("Ingredients: " + ingredients);
        System.out.println("Discount: " + discount + "%");
    }

    public static void main(String[] args) {

        System.out.println("Welcome to the Pizza Shop!");
        System.out.println("Please select a pizza:");

        System.out.println("1. Pepperoni Pizza");
        System.out.println("2. Hawaiian Pizza");
        System.out.println("3. Buffalo Pizza");
        System.out.println("4. All Meat Pizza");

        Scanner scan = new Scanner(System.in);

        Pizza pizza = null;
        boolean validInput = false;
        while (!validInput) {
            try {
                switch (scan.nextInt()) {
                    case 1:
                        pizza = new PepperoniPizza();
                        validInput = true;
                        break;
                    case 2:
                        pizza = new HawaiianPizza();
                        validInput = true;
                        break;
                    case 3:
                        pizza = new BuffaloPizza();
                        validInput = true;
                        break;
                    case 4:
                        pizza = new AllMeatPizza();
                        validInput = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        validInput = false;
                        return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Please enter a valid integer.");
                scan.nextLine();
                validInput = false;
            }
        }

        System.out.println("You selected: " + pizza.name);
        System.out.println("Here are the details of your pizza:");
        pizza.displayPizzaDetails();
        System.out.println("Do you want to select a pizza again? y/n");

        boolean validInput1 = false;
        while (!validInput1) {
            try {
                switch (scan.next()) {
                    case "y":
                        main(args);
                        validInput1 = true;
                        break;
                    case "n":
                        System.out.println("Program Terminated");

                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        validInput1 = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Please enter y or n");
                validInput1 = false;
            }
        }

    }

}
