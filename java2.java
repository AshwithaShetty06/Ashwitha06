import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private static ArrayList<String> toDoList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the To-Do List!");

        while (running) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. View items");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addItem(scanner);
                    break;
                case 2:
                    removeItem(scanner);
                    break;
                case 3:
                    viewItems();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        System.out.println("Thank you for using the To-Do List!");
        scanner.close();
    }

    private static void addItem(Scanner scanner) {
        System.out.print("Enter the item to add: ");
        String newItem = scanner.nextLine();
        toDoList.add(newItem);
        System.out.println("Item added successfully!");
    }

    private static void removeItem(Scanner scanner) {
        System.out.print("Enter the index of the item to remove: ");
        int index = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        
        if (index >= 0 && index < toDoList.size()) {
            String removedItem = toDoList.remove(index);
            System.out.println("Item '" + removedItem + "' removed successfully!");
        } else {
            System.out.println("Invalid index. No item removed.");
        }
    }

    private static void viewItems() {
        if (toDoList.isEmpty()) {
            System.out.println("The to-do list is empty.");
        } else {
            System.out.println("To-Do List:");
            for (int i = 0; i < toDoList.size(); i++) {
                System.out.println((i + 1) + ". " + toDoList.get(i));
            }
        }
    }
}
