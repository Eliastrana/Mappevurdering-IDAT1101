// @author Elias Trana

/**
 * The Item class. This holds the details of the item
 */
public class Item {
  /**
   * The Name. It is final because it is not going to be mutable
   */
  private final String name;
  /**
   * The Itemnumber.
   */
  private int itemnumber;
  /**
   * The Description. It is final because it is not going to be mutable
   */
  private final String description;
  /**
   * The Price.
   */
  private double price;
  /**
   * The Brand. It is final because it is not going to be mutable
   */
  private final String brand;
  /**
   * The Weight. It is final because it is not going to be mutable
   */
  private final double weight;
  /**
   * The Length. It is final because it is not going to be mutable
   */
  private final double length;
  /**
   * The Height. It is final because it is not going to be mutable
   */
  private final double height;
  /**
   * The Color. It is final because it is not going to be mutable
   */
  private final String color;
  /**
   * The Amount.
   */
  private int amount;
  /**
   * The Category. It is final because it is not going to be mutable
   */
  private final int category;


  /**
   * Instantiates a new Item.
   *
   * @param name        the name
   * @param itemnumber  the itemnumber
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
  public Item(String name, int itemnumber, String description,
              double price, String brand, double weight, double length,
              double height, String color, int amount, int category) {

    if (name.isEmpty()) {
      throw new IllegalArgumentException("Name cannot be blank");
    }

    if (itemnumber <= 0) {
      throw new IllegalArgumentException("Itemnumber cannot be zero");
    }

    if (description.isEmpty()) {
      throw new IllegalArgumentException("Description cannot be blank");
    }

    if (price <= 0) {
      throw new IllegalArgumentException("Price cannot be negative");
    }

    if (brand.isEmpty()) {
      throw new IllegalArgumentException("Brand cannot be blank");
    }

    if (weight <= 0) {
      throw new IllegalArgumentException("Weigth cannot be negative");
    }

    if (length <= 0) {
      throw new IllegalArgumentException("Length cannot be negative");
    }

    if (height <= 0) {
      throw new IllegalArgumentException("Height cannot be negative");
    }

    if (color.isEmpty()) {
      throw new IllegalArgumentException("Color cannot be blank");
    }

    if (amount <= 0) {
      throw new IllegalArgumentException("Amount cannot be negative");
    }

    if (category < 0 || category > 4) {
      throw new IllegalArgumentException("Category has to be between 1-4");
    }

    this.name = name;
    this.itemnumber = itemnumber;
    this.description = description;
    this.price = price;
    this.brand = brand;
    this.weight = weight;
    this.length = length;
    this.height = height;
    this.color = color;
    this.amount = amount;
    this.category = category;
  }

  /**
   * Instantiates a new Item.
   * This is the deep copy. This makes sure that the client cannot change attributes
   * that are not supposed to be changed
   *
   * @param item the item
   */
  public Item(Item item) {
    this.name = item.getName();
    this.itemnumber = item.getItemNumber();
    this.description = item.getDescription();
    this.price = item.getPrice();
    this.brand = item.getBrand();
    this.weight = item.getWeight();
    this.length = item.getLength();
    this.height = item.getHeight();
    this.color = item.getColor();
    this.amount = item.getAmount();
    this.category = item.getCategory();
  }


  /**
   * Gets name String.
   *
   * @return the name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Gets item number int.
   *
   * @return the int
   */
  public int getItemNumber() {
    return this.itemnumber;
  }

  /**
   * Gets description string.
   *
   * @return the string
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Gets price double.
   *
   * @return the double
   */
  public double getPrice() {
    return this.price;
  }

  /**
   * Gets brand string.
   *
   * @return the string
   */
  public String getBrand() {
    return this.brand;
  }

  /**
   * Gets weight double.
   *
   * @return the double
   */
  public double getWeight() {
    return this.weight;
  }

  /**
   * Gets length double.
   *
   * @return the double
   */
  public double getLength() {
    return this.length;
  }

  /**
   * Gets height double.
   *
   * @return the double
   */
  public double getHeight() {
    return this.height;
  }

  /**
   * Gets color string.
   *
   * @return the string
   */
  public String getColor() {
    return this.color;
  }

  /**
   * Gets amount int.
   *
   * @return the int
   */
  public int getAmount() {
    return this.amount;
  }

  /**
   * Gets category int.
   *
   * @return the int
   */
  public int getCategory() {
    return this.category;
  }

  public Enum<Category> getCategoryNumber() {
    return Category.getCategoryNumber(category);
  }

  /**
   * Sets amount.
   * The amount equals the new amount, making the normal amount become the new amount
   *
   * @param newAmount the new amount
   */
  public void setAmount(int newAmount) {
    this.amount = newAmount;
  }

  /**
   * This adds the increased amount, given by the user, to the amount.
   * Then it makes that iteration of the amount the current amount.
   * It checks for negative inputs and throws illegal argument if so.
   *
   * @param increasedAmount Item
   */
  public void increaseAmount(int increasedAmount) {
    this.amount = amount + increasedAmount;
    if (amount <= 0) {
      throw new IllegalArgumentException("Amount cannot be negative");
    }
  }

  /**
   * This subtracts the amount, given by the user, to the amount.
   * Then it makes that iteration of the amount the current amount.
   * It checks if the amount given by the user is larger than the.
   * current amount and throws illegal argument if so.
   *
   * @param decreasedAmount Item
   */
  public void decreaseAmount(int decreasedAmount) {
    if (decreasedAmount > amount) {
      throw new IllegalArgumentException("Total amount cannot be negative");
    }
    this.amount = amount - decreasedAmount;
  }

  /**
   * First it checks that the percent given by the user is between 0-100.
   * if it is outside the parameter, it throws illegal argument.
   * then it does the calculation for the percent, and subtracts it
   * from the current price.
   *
   * @param discountPercent Item
   */
  public void discount(double discountPercent) {
    if (discountPercent > 100 || discountPercent < 0) {
      throw new IllegalArgumentException("The percent has to be between 0-100");
    }
    this.price = price - ((price / 100) * discountPercent);
  }


  /**
   * Set price.
   *
   * @param newPrice the new price
   */
  public void setPrice(double newPrice) {
    this.price = newPrice;
  }

  /**
   * Set itemnumber.
   *
   * @param newItemnumber the new itemnumber
   */
  public void setItemnumber(int newItemnumber) {
    this.itemnumber = newItemnumber;
  }

  /**
   * A toString that returns the values with descriptions
   * and what it is measured in.
   *
   * @return toString
   */

  public String toString() {
    return
            " | Name: " + getName() + "\n"
                  +  " | Itemnumber: " + getItemNumber() + "\n"
                    +  " | Description: " + getDescription() + "\n"
                    +  " | Price: " + getPrice() + " kr" + "\n"
                    +  " | Brandname: " + getBrand() + "\n"
                    +  " | Weight: " + getWeight() + " grams" + "\n"
                    +  " | length: " + getLength() + " cm" + "\n"
                    +  " | height: " + getHeight() + " cm" + "\n"
                    + " | Color: " + getColor() + "\n"
                    + " | Amount: " + getAmount() + "\n"
                    + " | Category: " + getCategoryNumber() + "\n" + "\n";
  }

  /**
   * toString2 is a toString with only the most important information.
   * It is used when the user is asked for an input, as it gives the
   * user a quick overview of information.
   *
   * @return toString2
   */
  public String toString2() {
    return "Name: " + getName() + " | Amount: " + getAmount() + " | Itemnumber: "
            + getItemNumber() + " | Price: " + getPrice() + " kr" + "\n";

  }
}