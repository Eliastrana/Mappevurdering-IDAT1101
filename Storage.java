// @author Elias Trana

import java.util.ArrayList;
import java.util.Comparator;

/**
 * The Storage class is responsible for the calculations.
 * that are sent to the client class.
 */
public class Storage {

  /**
   * The ArrayList that holds the information of the items.
   */
  private ArrayList<Item> items;

  /**
   * Instantiates a new Storage.
   */
  public Storage() {
    items = new ArrayList<Item>();
  }

  /**
   * A get-method for the ArrayList.
   *
   * @return the item
   */
  public ArrayList<Item> getItem() {
    return items;
  }

  /**
   * This is the method returns the original item.
   * @ param name
   * @ return
   */
  private Item getOriginalItem(String name) {
    for (Item item : items) {
      if (item.getName().equalsIgnoreCase(name)) {
        return item;
      }
    }
    throw new IllegalArgumentException("This item does not exist");
  }

  /**
   * Deep copy function that creates a copy of the item.
   *
   * @param name name
   * @return Item
   */
  public Item getDeepCopy(String name) {
    return new Item(getOriginalItem(name));
  }

  /**
   * Gets the total size of the amount of item.
   *
   * @return the item amount
   */
  public int getTotalItem() {
    return items.size();
  }

  /**
   * This method takes the details of the items given by the user.
   * It checks if they are already existing.
   *
   * @param name        the name
   * @param itemNumber  the item number
   * @param description the description
   * @param price       the price
   * @param brand       the brand
   * @param weight      the weight
   * @param length      the length
   * @param height      the height
   * @param color       the color
   * @param amount      the amount
   * @param category    the category
   */
  public void newItem(String name, int itemNumber, String description,
                      double price, String brand, double weight,
                      double length, double height, String color, int amount, int category) {
    boolean nameExists = false;
    for (int i = 0; i < getTotalItem(); i++) {
      if (items.get(i).getName().equalsIgnoreCase(name)) {
        nameExists = true;
      }
    }
    if (!nameExists) {
      Item newItem = new Item(name, itemNumber, description, price,
              brand, weight, length, height, color, amount, category);
      items.add(newItem);
    } else {
      System.out.println("This item is already in storage! Press 6 to increse the amount instead");
    }
  }

  /**
   * Method that deletes an item.
   * It checks if the name is entered, then uses ".remove"
   * to delete it.
   * If it already exists it throws an illegal argument
   *
   * @param name the name
   */
  public void deleteItem(String name) {
    boolean alreadyExists = false;
    if (name.isEmpty()) {
      throw new IllegalArgumentException("You must enter a name");
    } else {
      for (int i = 0; i < getTotalItem(); i++) {
        if (items.get(i).getName().equalsIgnoreCase(name)) {
          alreadyExists = true;
          Item item = items.get(i);
          items.remove(item);
          break;
        }
      }
      if (!alreadyExists) {
        throw new IllegalArgumentException("The item does not exist");
      }
    }
  }

  /**
   * This method checks that the new price is posistive, then changes the price using the.
   * setPrice method from the item class
   * Throws illegal argument if the item doesn't exist
   *
   * @param name     the name
   * @param newPrice the new price
   */
  public void changePrice(String name, double newPrice) {
    boolean alreadyExists = false;
    if (newPrice < 0) {
      throw new IllegalArgumentException("The new value must be positive");
    } else {
      for (int i = 0; i < getTotalItem(); i++) {
        if (items.get(i).getName().equalsIgnoreCase(name)) {
          alreadyExists = true;
          items.get(i).setPrice(newPrice);
          break;
        }
      }
      if (!alreadyExists) {
        throw new IllegalArgumentException("The item you tried to modify doesn't exist");
      }
    }
  }

  /**
   * This method changes the inventory amount by checking if the new amount is positive,
   * then using the setAmount method from the item class to change it.
   * Throws illegal argument if the item doesn't exist
   *
   * @param name      the name
   * @param newAmount the new amount
   */
  public void changeInventoryamount(String name, int newAmount) {
    boolean alreadyExists = false;
    if (newAmount < 0) {
      throw new IllegalArgumentException("The new value must be positive");
    } else {
      for (int i = 0; i < getTotalItem(); i++) {
        if (items.get(i).getName().equalsIgnoreCase(name)) {
          alreadyExists = true;
          items.get(i).setAmount(newAmount);
          break;
        }
      }
      if (!alreadyExists) {
        throw new IllegalArgumentException("The item you tried to modify doesn't exist");
      }
    }
  }

  /**
   * This method changes the inventory amount by checking if the new amount is positive,
   * then using the increaseAmount method from the item class to change it.
   * Throws illegal argument if the item doesn't exist
   *
   * @param name name
   * @param increasedAmount increasedAmount
   */
  public void increaseInverntoryamount(String name, int increasedAmount) {
    boolean alreadyExists = false;
    if (increasedAmount < 0) {
      throw new IllegalArgumentException("The value must be positive");
    } else {
      for (int i = 0; i < getTotalItem(); i++) {
        if (items.get(i).getName().equalsIgnoreCase(name)) {
          alreadyExists = true;
          items.get(i).increaseAmount(increasedAmount);
          break;
        }
      }
      if (!alreadyExists) {
        throw new IllegalArgumentException("The item you tried to modify doesn't exist");
      }

    }
  }

  /**
   * This method changes the inventory amount by checking if the new amount is positive,
   * then using the decreaseAmount method from the item class to change it.
   * Throws illegal argument if the item doesn't exist.
   *
   * @param name name
   * @param decreasedAmount decreasedAmount
   */
  public void decreaseInverntoryamount(String name, int decreasedAmount) {
    boolean alreadyExists = false;
    if (decreasedAmount < 0) {
      throw new IllegalArgumentException("The value must be positive");
    } else {
      for (int i = 0; i < getTotalItem(); i++) {
        if (items.get(i).getName().equalsIgnoreCase(name)) {
          alreadyExists = true;
          items.get(i).decreaseAmount(decreasedAmount);
          break;
        }
      }
      if (!alreadyExists) {
        throw new IllegalArgumentException("The item you tried to modify doesn't exist");
      }
    }
  }

  /**
   * This method changes the item number by checking if the new amount is positive,
   * then using the decreaseAmount method from the item class to change it.
   * Throws illegal argument if the item doesn't exist.
   *
   * @param name          the name
   * @param newItemnumber the new itemnumber
   */
  public void changeItemnumber(String name, int newItemnumber) {
    boolean alreadyExists = false;
    if (newItemnumber < 0) {
      throw new IllegalArgumentException("The new value must be positive");
    } else {
      for (int i = 0; i < getTotalItem(); i++) {
        if (items.get(i).getName().equalsIgnoreCase(name)) {
          alreadyExists = true;
          items.get(i).setItemnumber(newItemnumber);
          break;
        }
      }
      if (!alreadyExists) {
        throw new IllegalArgumentException("The item you tried to modify doesn't exist");
      }
    }
  }

  /**
   * This method changes the price by checking if the discounted price is positive,
   * then using the discount method from the item class to change it.
   * Throws illegal argument if the item doesn't exist.
   *
   * @param name name
   * @param discountedPrice discountedPrice
   */
  public void createDiscount(String name, double discountedPrice) {
    boolean alreadyExists = false;
    if (discountedPrice < 0) {
      throw new IllegalArgumentException("The new value must be positive");
    } else {
      for (int i = 0; i < getTotalItem(); i++) {
        if (items.get(i).getName().equalsIgnoreCase(name)) {
          alreadyExists = true;
          items.get(i).discount(discountedPrice);
          break;
        }
      }
      if (!alreadyExists) {
        throw new IllegalArgumentException("The item you tried to modify doesn't exist");
      }
    }
  }

  /**
   * Gets item description by checking if it exists and then returns it.
   * Throws illegal argument if it doesn't exist.
   *
   * @param name the name
   * @return item name
   */
  public Item getItemName(String name) {
    boolean alreadyExists = false;
    for (Item item : items) {
      if (item.getName().equalsIgnoreCase(name)) {
        alreadyExists = true;
        return new Item(item);
      }
    }
    if (!alreadyExists) {
      throw new IllegalArgumentException("The item you searched for does not exist!");
    }
    return null;

  }


  /**
   * Gets item description by checking if it exists and then returns it.
   * Throws illegal argument if it doesn't exist.
   *
   * @param description the description
   * @return the item description
   */
  public Item getItemDescription(String description) {
    boolean alreadyExists = false;
    for (Item item : items) {
      if (item.getDescription().equalsIgnoreCase(description)) {
        alreadyExists = true;
        return new Item(item);
      }
    }
    if (!alreadyExists) {
      throw new IllegalArgumentException("The item you searched for does not exist!");
    }
    return null;
  }

  /**
   * Gets item number by checking if it exists and then returns it.
   * Throws illegal argument if it doesn't exist.
   *
   * @param itemnumber the itemnumber
   * @return the item itemnumber
   */
  public Item getItemItemnumber(int itemnumber) {
    boolean alreadyExists = false;
    for (Item item : items) {
      if (item.getItemNumber() == itemnumber) {
        alreadyExists = true;
        return new Item(item);
      }
    }
    if (!alreadyExists) {
      throw new IllegalArgumentException("The item you searched for does not exist!");

    }
    return null;
  }

  /**
   * This method searches through the arrayList between the two limits given by the user.
   *
   * @param min the min
   * @param max the max
   * @return the array list
   */
  public ArrayList<Item> priceSearch(double min, double max) {
    if (max < min) {
      throw new IllegalArgumentException("The smallest number must come first!");

    } else if (min < 0) {
      throw new IllegalArgumentException("Price cannot be a negative number!");
    }
    ArrayList<Item> priceSearch = new ArrayList<Item>();
    for (int i = 0; i < getItem().size(); i++) {
      if (getItem().get(i).getPrice() >= min && getItem().get(i).getPrice() <= max) {
        priceSearch.add(getItem().get(i));
      }
    }
    priceSearch.sort(Comparator.comparing(Item::getPrice));
    return priceSearch;
  }

  /**
   * This method sorts the ArrayList from low to high based on price.
   * This is used to give the user more control.
   *
   * @return the array list
   */
  public ArrayList<Item> sortLowHigh() {
    items.sort(Comparator.comparing(Item::getPrice));
    return items;
  }

  /**
   * This method sorts the ArrayList from low to high based on price.
   * This is used to give the user more control.
   *
   * @return the array list
   */
  public ArrayList<Item> sortHighLow() {
    items.sort(Comparator.comparing(Item::getPrice).reversed());
    return items;
  }

  /**
   * This method contains all the example items.
   * This is dumped in the warehouse when the program is started,
   * before the while loop that shows the menu.
   */
  public void itemDump() {
    newItem("Chair", 2, "Good chair", 450, "Gucci", 450, 4, 5, "Blue", 8, 2);
    newItem("Plank", 3, "Sturdy plank", 90, "Prada", 50, 100, 30, "Brown", 4, 3);
    newItem("Door", 4, "Strong", 300, "Dior", 250, 40, 90, "White", 5, 3);
    newItem("Window", 5, "See through", 2000, "Megaflis", 5000, 65, 100, "Black", 9, 1);
    newItem("Stick", 22345, "Small stick with good grip",
            25, "Carhartt", 50, 2, 40, "Beige", 500, 4);

  }

  /**
   * This is the full toString from the item class.
   * The Warehouse client is not able to access the item class directly,
   * therefore the toString is traveling through the Storage class first.
   * @ return
   */
  public String toString() {
    String toString = "";
    for (int i = 0; i < getTotalItem(); i++) {
      toString = toString + items.get(i).toString();
    }
    return toString;
  }

  /**
   * This is the short toString with only the most important info.
   * The Warehouse client is not able to access the item class directly,
   * therefore the toString is traveling through the Storage class first.
   *
   * @return the string
   */
  public String toString2() {
    String toString2 = "";
    for (int i = 0; i < getTotalItem(); i++) {
      toString2 = toString2 + items.get(i).toString2();
    }
    return toString2;
  }
}