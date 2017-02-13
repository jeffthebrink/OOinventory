import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<InventoryItem> itemArrayList = new ArrayList<>();

    public static void printList() {
        //print out current inventory list
        System.out.println();
        System.out.println("Item #   Quantity     Item                  Category");
        System.out.println("-----------------------------------------------------------");
        int i = 1;
        for (InventoryItem item : itemArrayList) {

            System.out.printf("%s\t\t\t%s\t\t\t%s\t\t\t%s\n", i, item.itemQty, item.item, item.category);
            i++;
        }

    }

    public static void main(String[] args) throws Exception {


        String password;

        System.out.printf("Hello and welcome to the armory!\n");
        System.out.printf("Please enter your password.\n");
        password = scanner.nextLine();

        if (password.equals("Jeff")) {
            System.out.printf("Password correct.\n");

            System.out.printf("We currently have the following: \n");

            //Initialize inventory list

            itemArrayList.add(new InventoryItem(1, "broad sword", "Sword"));
            itemArrayList.add(new InventoryItem(1, "battle axe", "Axe"));
            itemArrayList.add(new InventoryItem(3, "long bow", "Bow"));

            printList();


            //print out options
            while (true) {
                System.out.println();
                System.out.println("Please select an option. ");
                System.out.println("1. Add a new item: ");
                System.out.println("2. Remove an item: ");
                System.out.println("3. Update the quantity of an item: ");

                int option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1:
                        createItem();
                        continue;
                    case 2:
                        System.out.println("Type number of item you'd like to remove. ");
                        printList();
                        int optionRemove = Integer.parseInt(scanner.nextLine());
                        itemArrayList.remove(optionRemove - 1);
                        System.out.println("Item removed! ");
                        printList();
                        continue;

                    case 3:
                        System.out.println("Enter the number of the item you want to update the quantity of. ");
                        printList();
                        int indexToUpdate = Integer.parseInt(scanner.nextLine()) - 1;
                        System.out.println("Input the new quantity");
                        int newQty = Integer.parseInt(scanner.nextLine());
                        itemArrayList.get(indexToUpdate).itemQty = newQty;
                        printList();
                        continue;
                    default:
                        System.out.println("Invalid choice.");
                        continue;
                }
            }

        } else System.out.println("Incorrect password. ");
    }

    public static void createItem() throws Exception {
        System.out.println("Enter a new item name: ");
        String item = scanner.nextLine();
        System.out.printf("Enter the category (case sensitive) for the new item.\n");
        System.out.printf("Sword    Axe     Bow     Armor      Helmet\n");
        String category = scanner.nextLine();

        switch (category) {
            case "Sword":
                itemArrayList.add(new Sword(0, item));
                break;
            case "Axe":
                itemArrayList.add(new Axe(0, item));
                break;
            case "Bow":
                itemArrayList.add(new Bow(0, item));
                break;
            case "Armor":
                itemArrayList.add(new Armor(0, item));
                break;
            case "Helmet":
                itemArrayList.add(new Helmet(0, item));
                break;
            default:
                throw new Exception("Invalid category!");

        }
        return;

    }

}

