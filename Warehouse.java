// @author Elias Trana

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The Warehouse class. This is the user client class
 */
public class Warehouse {
  /**
   * The entry point of application.
   * Here the example items are dumped before the menu is shown
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    System.out.println("Welcome to the Warehouse Management System");
    Storage s = new Storage();
    fillStorageWithItems(s);
    while (true) {
      showMenu(s);
    }
  }

  /**
   * This method shows the menu to the user, and uses a switch case to take inputs.
   * It catches InputMismatchException and tells the user about the wrong input.
   *
   * @param s Storage
   */
  private static void showMenu(Storage s) {
    Scanner in = new Scanner(System.in);
    System.out.println("\n");
    System.out.println("1: Show all items");
    System.out.println("2: Show QuickView");
    System.out.println("3: Enter PriceViewer");
    System.out.println("4: Print amount of items in storage");
    System.out.println("5: Add new item to storage");
    System.out.println("6: Modify item attributes");
    System.out.println("7: Search for an item");
    System.out.println("8: Delete item");
    System.out.println("9: Cancel program");

    try {
      int menuInput = in.nextInt();
      switch (menuInput) {
        case 1 -> printEverything(s);
        case 2 -> System.out.println(s.toString2());
        case 3 -> priceViewer(s);
        case 4 -> showItemAmount(s);
        case 5 -> askForInformation(s);
        case 6 -> modifier(s);
        case 7 -> searchFunction(s);
        case 8 -> itemDeleter(s);
        case 9 -> {
          System.out.println("Canceling program...");
          System.exit(0);
        }
        default -> {
          System.out.println("Invalid input, input must be between 1-7");
          showMenu(s);
        }
      }
    } catch (InputMismatchException e) {
      System.out.println("Enter a number not letters!" + "\n");
    }
  }

  /**
   * This method gets the item dump from the Storage class runs it.
   *
   * @param s Storage
   */

  private static void fillStorageWithItems(Storage s) {
    s.itemDump();
  }

  /**
   * This method checks that the ArrayList is not empty,
   * and then  prints alle the items.
   *
   * @param s Storage
   */
  private static void printEverything(Storage s) {
    System.out.println("\n");
    if (s.getTotalItem() < 1) {
      System.out.println("There are no items in storage");
    } else {
      System.out.print(s.toString());
    }
  }

  /**
   * The priceViewer method is a menu with a switch case that allows the
   * user to choose all the price related methods.
   * It catches InputMismatchException and tells the user about the wrong input.
   *
   * @param s Storage
   */
  private static void priceViewer(Storage s) {
    Scanner in = new Scanner(System.in);
    System.out.println("Welcome to the PriceViewer");
    System.out.println("Here you can find everything price related!");
    System.out.println("\n");
    System.out.println("1. Search for an item within a price range");
    System.out.println("2. Sort items by price (Lowest to highest)");
    System.out.println("3. Sort items by price (Highest to lowest)");
    System.out.println("4. Add a discount to an item");
    System.out.println("5. Go back to main menu");

    try {
      int priceMenuChoice = in.nextInt();
      switch (priceMenuChoice) {
        case 1 -> getPriceSearch(s);
        case 2 -> getSortLowHigh(s);
        case 3 -> getSortHighLow(s);
        case 4 -> getDiscount(s);
        case 5 -> showMenu(s);
        default -> {
          System.out.println("Input from 1-4");
          priceViewer(s);
        }
      }
    } catch (InputMismatchException e) {
      System.out.println("Enter a number not letters!" + "\n");
      priceViewer(s);
    }
  }

  /**
   * Collects the highest and lowest value, runs the priceSearch method from Storage,
   * and prints the result.
   * It catches exceptions and tells the user about the wrong input.
   *
   * @param s Storage
   */
  private static void getPriceSearch(Storage s) {
    Scanner in = new Scanner(System.in);
    try {
      System.out.println("Enter the lowest price: ");
      int min = in.nextInt();
      System.out.println("Enter the highest price: ");
      int max = in.nextInt();
      ArrayList<Item> items = s.priceSearch(min, max);
      System.out.println("Items within the price-range  " + min + " and " + max + ":" + "\n");
      System.out.println(items.toString());

    } catch (Exception e) {
      System.out.println(e.getMessage());
      getPriceSearch(s);
    }
  }

  /**
   * Prints the sorting method from the Storage class.
   *
   * @param s Storage
   */
  private static void getSortLowHigh(Storage s) {
    System.out.println(s.sortLowHigh());
  }

  /**
   * Prints the sorting method from the Storage class.
   *
   * @param s Storage
   */
  private static void getSortHighLow(Storage s) {
    System.out.println(s.sortHighLow());
  }

  /**
   * Asks user for name and percentage.
   * Runs the create discount method.
   * Prints the result.
   * Catches exceptions.
   *
   * @param s Storage
   */
  private static void getDiscount(Storage s) {
    Scanner in = new Scanner(System.in);
    try {
      System.out.println(s.toString2());
      System.out.println("Enter the name you wish to add a discount to: ");
      String name = in.nextLine();
      System.out.println("Enter the discount you wish to add to the item (%): ");
      double discountPercent = in.nextDouble();
      s.createDiscount(name, discountPercent);
      System.out.println("The discount to " + name + " was added" + "\n");
      System.out.println(s.toString2());

    } catch (Exception e) {
      System.out.println(e.getMessage());
      priceViewer(s);
    }
  }

  /**
   * Checks if there is more than 0 items in storage.
   * Prints the total amount of items by running the get total item method
   * and printing the results.
   *
   * @param s Storage
   */
  private static void showItemAmount(Storage s) {
    System.out.println("\n");
    if (s.getTotalItem() < 1) {
      System.out.println("There are no items in storage");
    } else {
      System.out.print(s.getTotalItem() + " item(s) are in storage" + "\n");
    }
  }

  /**
   * Asks for all the information and creates a new item with the given information.
   * Catches exceptions.
   * Prints that the item was added, if the add was successful.
   *
   * @param s Storage
   */
  private static void askForInformation(Storage s) {
    Scanner in = new Scanner(System.in);
    try {
      System.out.println("Enter the name of the item: ");
      final String name = in.nextLine();
      System.out.println("Enter itemnumber: ");
      final int itemNumber = in.nextInt();
      System.out.println("Enter description: ");
      in.nextLine();
      final String description = in.nextLine();
      System.out.println("Enter price(Nok): ");
      final double price = in.nextDouble();
      System.out.println("Enter brand-name: ");
      in.nextLine();
      final String brand = in.nextLine();
      System.out.println("Enter weight(g): ");
      final double weight = in.nextDouble();
      System.out.println("Enter length(cm): ");
      final double length = in.nextDouble();
      System.out.println("Enter height(cm): ");
      final double height = in.nextDouble();
      System.out.println("Enter color:");
      in.nextLine();
      final String color = in.nextLine();
      System.out.println("Enter amount: ");
      final int amount = in.nextInt();
      System.out.println("Enter category: ");
      System.out.println("""
              1: FLOOR_LAMINATE
              2: WINDOWS
              3: DOORS
              4: LUMBER""");
      int category = in.nextInt();

      s.newItem(name, itemNumber, description, price, brand,
              weight, length, height, color, amount, category);
      System.out.println(name + " was successfully added to the warehouse");
    } catch (IllegalArgumentException e) {
      System.out.println("Item was not added because: " + e.getMessage() + "!" + "\n");
      showMenu(s);
    }
  }

  /**
   * This method is a menu that allows the user to pick what attribute it wishes to modify.
   * It catches InputMismatchException.
   *
   * @param s Storage
   */
  private static void modifier(Storage s) {
    Scanner in = new Scanner(System.in);
    System.out.println("What attribute do you wish to modify? ");
    System.out.println("1: Price");
    System.out.println("2: Itemnumber");
    System.out.println("3: Amount");
    System.out.println("4: Go back to main menu");

    try {
      int attributeChoice = in.nextInt();
      switch (attributeChoice) {
        case 1 -> getChangePrice(s);
        case 2 -> getChangeItemnumber(s);
        case 3 -> inventoryManipulator(s);
        case 4 -> showMenu(s);
        default -> {
          System.out.println("Input har to be 1-4");
          modifier(s);
        }
      }
    } catch (InputMismatchException e) {
      System.out.println("Enter a number not letters!" + "\n");
      modifier(s);
    }
  }

  /**
   * This method collects the user information.
   * Runs the change price method from Storage.
   * Prints the result.
   * It catches IllegalArgumentException.
   *
   * @param s Storage
   */

  private static void getChangePrice(Storage s) {
    Scanner in = new Scanner(System.in);
    System.out.println(s.toString2());
    System.out.println("Enter the name of the item: ");
    String name = in.nextLine();
    System.out.println("Enter your new price: ");
    double newPrice = in.nextDouble();

    try {
      s.changePrice(name, newPrice);
      System.out.println("The price of " + name + " has been changed to: "
              + newPrice + "kr" + "\n");
      System.out.println(s.getDeepCopy(name));


    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * This method collects the user information.
   * Runs the change item number method from Storage.
   * Prints the result.
   * It catches IllegalArgumentException.
   *
   * @param s Storage
   */
  private static void getChangeItemnumber(Storage s) {
    Scanner in = new Scanner(System.in);
    try {
      System.out.println(s.toString2());
      System.out.println("Enter the name of the item: ");
      String name = in.nextLine();
      System.out.println("Enter the new itemnumber: ");
      int newItemnumber = in.nextInt();
      s.changeItemnumber(name, newItemnumber);
      System.out.println("The itemnumber of " + name
              + " has been changed to: " + newItemnumber + "\n");
      System.out.println(s.getDeepCopy(name));


    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * This method is a menu that allows the user to choose different ways of
   * manipulating the inventory.
   * Catches InputMismatchException.
   *
   * @param s Storage
   */
  private static void inventoryManipulator(Storage s) {
    Scanner in = new Scanner(System.in);
    System.out.println("1. Choose a new amount");
    System.out.println("2. Increase the amount");
    System.out.println("3. Decrease the amount");
    System.out.println("4. Go back to modifier menu");

    try {
      int inventoryMenuChoice = in.nextInt();
      switch (inventoryMenuChoice) {
        case 1 -> getChangeInventoryamount(s);
        case 2 -> getIncreaseInventoryamount(s);
        case 3 -> getDecreaseInventoryamount(s);
        case 4 -> modifier(s);
        default -> inventoryManipulator(s);
      }
    } catch (InputMismatchException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * This method collects the user information.
   * Runs the change inventory amount method from Storage.
   * Prints the result.
   * It catches IllegalArgumentException.
   *
   * @param s Storage
   */
  private static void getChangeInventoryamount(Storage s) {
    Scanner in = new Scanner(System.in);
    try {
      System.out.println(s.toString2());
      System.out.println("Enter the name of the item: ");
      String name = in.nextLine();
      System.out.println("Enter your new inventoryamount: ");
      int newAmount = in.nextInt();
      s.changeInventoryamount(name, newAmount);
      System.out.println("The inventoryamount of " + name
              + " has been changed to: " + newAmount + "\n");
      System.out.println(s.getDeepCopy(name));

    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * This method collects the user information.
   * Runs the increase inventoryamount method from Storage.
   * Prints the result.
   * It catches IllegalArgumentException.
   *
   * @param s Storage
   */
  private static void getIncreaseInventoryamount(Storage s) {
    Scanner in = new Scanner(System.in);
    try {
      System.out.println(s.toString2());
      System.out.println("Enter the name of the item: ");
      String name = in.nextLine();
      System.out.println("Enter the amount you wish "
              + "to add to the inventoryamount: ");
      int increasedAmount = in.nextInt();
      s.increaseInverntoryamount(name, increasedAmount);
      System.out.println("The inventoryamount of " + name
              + " has been increased by: " + increasedAmount + "\n");
      System.out.println(s.getDeepCopy(name));

    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * This method collects the user information.
   * Runs the decrease inventoryamount method from Storage.
   * Prints the result.
   * It catches IllegalArgumentException.
   *
   * @param s Storage
   */
  private static void getDecreaseInventoryamount(Storage s) {
    Scanner in = new Scanner(System.in);
    try {
      System.out.println(s.toString2());
      System.out.println("Enter the name of the item: ");
      String name = in.nextLine();
      System.out.println("Enter the amount you wish "
              + "to decrease from the inventoryamount: ");
      int decreasedAmount = in.nextInt();
      s.decreaseInverntoryamount(name, decreasedAmount);
      System.out.println("The inventoryamount of " + name
              + " has been decreased by: " + decreasedAmount + "\n");
      System.out.println(s.getDeepCopy(name));

    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }


  /**
   * This method is a menu that allows the user to search for an item based on
   * different attributes.
   * It catches InputMismatchException.
   *
   * @param s Storage
   */
  private static void searchFunction(Storage s) {
    Scanner in = new Scanner(System.in);
    System.out.println("Choose attribute you wish to search for: ");
    System.out.println("1: Name");
    System.out.println("2: Description");
    System.out.println("3: Itemnumber");
    System.out.println("4: Go back to main menu");

    try {
      int searchInput = in.nextInt();
      switch (searchInput) {
        case 1 -> getSearchItemName(s);
        case 2 -> getSearchItemDescription(s);
        case 3 -> getSearchItemNumber(s);
        case 4 -> showMenu(s);
        default -> {
          System.out.println("Input has to be between 1-4" + "\n");
          searchFunction(s);
        }
      }
    } catch (InputMismatchException e) {
      System.out.println("Enter a number not letters!" + "\n");
      searchFunction(s);
    }
  }

  /**
   * Collects the name of the item.
   * Prints the getItemName method with the given name.
   * It catches Exception.
   *
   * @param s Storage
   */
  private static void getSearchItemName(Storage s) {
    Scanner in = new Scanner(System.in);
    try {
      System.out.println(s.toString2());
      System.out.println("Name: ");
      String name = in.nextLine();
      System.out.println(s.getItemName(name));

    } catch (Exception e) {
      System.out.println(e.getMessage() + "\n");
      getSearchItemName(s);
    }
  }

  /**
   * Collects the name of the item.
   * Prints the getItemDescription method with the given description.
   * It catches Exception.
   *
   * @param s Storage
   */
  private static void getSearchItemDescription(Storage s) {
    Scanner in = new Scanner(System.in);
    try {
      System.out.println(s.toString2());
      System.out.println("Description: ");
      String description = in.nextLine();
      System.out.println(s.getItemDescription(description));

    } catch (Exception e) {
      System.out.println(e.getMessage() + "\n");
    }
  }

  /**
   * Collects the name of the item.
   * Prints the getItemNumber method with the given item number.
   * It catches Exception.
   *
   * @param s Storage
   */
  private static void getSearchItemNumber(Storage s) {
    Scanner in = new Scanner(System.in);
    try {
      System.out.println(s.toString2());
      System.out.println("Number: ");
      int itemnumber = in.nextInt();
      System.out.println(s.getItemItemnumber(itemnumber));

    } catch (Exception e) {
      System.out.println(e.getMessage() + "\n");
      getSearchItemNumber(s);
    }
  }

  /**
   * This method collects the name of the item, then runs the deleteItem method.
   * Then it prints the result.
   * It catches the IllegalArgumentException.
   *
   * @param s the s
   */
  private static void itemDeleter(Storage s) {
    Scanner in = new Scanner(System.in);
    System.out.println(s.toString2());
    System.out.println("Name:");
    String name = in.nextLine();
    try {
      s.deleteItem(name);
      System.out.println("The item with the name: " + name + " was deleted");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }
}


