// @author Elias Trana

/**
 * This enum connects the Category with a number each,
 * so that when a number is chosen, the category name is added to the item.
 */
public enum Category {

  FLOOR_LAMINATE(1),
  WINDOWS(2),
  DOORS(3),
  LUMBER(4);

  final int categoryNumber;

  /**
   * This method checks if the number is within the limitations and then
   * confirms it.
   *
   * @param categoryNumber categoryNumber
   */
  Category(int categoryNumber) {
    if (categoryNumber < 0 || categoryNumber > 4) {
      throw new IllegalArgumentException("Category has to be between 1-4");
    }
    this.categoryNumber = categoryNumber;

  }

  /**
   * A method that gets the category number.
   * @ return
   */

  public int getCategoryNumber() {
    return categoryNumber;
  }

  /**
   * returns the enum corresponding with the number.
   *
   * @param categoryNumber categoryNumber
   * @ return
   */
  public static Category getCategoryNumber(int categoryNumber) {
    for (Category c : Category.values()) {
      if (c.getCategoryNumber() == categoryNumber) {
        return c;
      }
    }
    return null;
  }


}
