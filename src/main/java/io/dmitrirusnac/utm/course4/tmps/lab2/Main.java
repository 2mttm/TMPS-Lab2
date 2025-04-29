package io.dmitrirusnac.utm.course4.tmps.lab2;

import io.dmitrirusnac.utm.course4.tmps.lab2.Facade.FoodOrderFacade;
import io.dmitrirusnac.utm.course4.tmps.lab2.adapter.DeliveryAdapter;
import io.dmitrirusnac.utm.course4.tmps.lab2.adapter.DeliveryService;
import io.dmitrirusnac.utm.course4.tmps.lab2.adapter.JsonPlaceholderDeliveryService;
import io.dmitrirusnac.utm.course4.tmps.lab2.adapter.LocalCourierAdapter;
import io.dmitrirusnac.utm.course4.tmps.lab2.adapter.LocalCourierService;
import io.dmitrirusnac.utm.course4.tmps.lab2.model.FoodItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
  private static final List<FoodItem> MENU = Arrays.asList(
      new FoodItem("Burger", 5.99),
      new FoodItem("Fries", 2.99),
      new FoodItem("Soda", 1.99),
      new FoodItem("Pizza", 8.99),
      new FoodItem("Salad", 4.99)
  );

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<FoodItem> selectedItems = new ArrayList<>();

    System.out.println("=== Welcome to the Food Ordering System ===");
    boolean ordering = true;

    while (ordering) {
      System.out.println("\nMenu:");
      for (int i = 0; i < MENU.size(); i++) {
        FoodItem item = MENU.get(i);
        System.out.printf("%d. %s - $%.2f\n", i + 1, item.getName(), item.getPrice());
      }

      System.out.print("Select an item by number (0 to finish): ");
      int choice = scanner.nextInt();

      if (choice == 0) {
        ordering = false;
      } else if (choice > 0 && choice <= MENU.size()) {
        selectedItems.add(MENU.get(choice - 1));
        System.out.println("Item added: " + MENU.get(choice - 1).getName());
      } else {
        System.out.println("Invalid choice. Try again.");
      }
    }

    if (selectedItems.isEmpty()) {
      System.out.println("No items selected. Exiting.");
      return;
    }

    scanner.nextLine(); // consume newline

    System.out.print("\nEnter delivery address: ");
    String address = scanner.nextLine();

    System.out.print("Add a gift to the order? (yes/no): ");
    boolean addGift = scanner.nextLine().trim().equalsIgnoreCase("yes");

    System.out.print("Apply 10% discount? (yes/no): ");
    boolean addDiscount = scanner.nextLine().trim().equalsIgnoreCase("yes");

    System.out.print("Choose delivery service (1 = JSONPlaceholder, 2 = Local Courier): ");
    int serviceChoice = scanner.nextInt();
    scanner.nextLine();

    DeliveryService deliveryService;
    if (serviceChoice == 1) {
      deliveryService = new DeliveryAdapter(new JsonPlaceholderDeliveryService());
    } else {
      deliveryService = new LocalCourierAdapter(new LocalCourierService());
    }

    FoodOrderFacade facade = new FoodOrderFacade(deliveryService);

    System.out.println("\nPlacing your order...");
    facade.placeOrder(selectedItems, address, addGift, addDiscount);
  }
}