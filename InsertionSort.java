public class InsertionSort {

  public static void main(String[] args) {
    int[] array = { 5, 7, 2, 6, 3, 1, 0, 9, 4 };
    insertionSort(array);

    for (int elem : array) {
      System.out.print(elem + " ");
    }
    System.out.println();
  }

  /*
   * POST: array is sorted in nondecreasing order
   */
  public static void insertionSort(int[] array) {
    // array[0..index-1] are in order
    for (int i = 1; i < array.length; i++) {
      insertNext(i, array);
    }
  }

  /*
   * PRE: array[0..lastIndex-1] is in nondecreasing order and
   *      lastIndex < array.lenth
   * POST: array[0..lastIndex] contains the same elements as it did before
   *       the execution of the method, but now is in nondecreasing order
   */
  private static void insertNext(int lastIndex, int[] array) {
    // search for first element (from rear) <= array[lastIndex]
    int position = lastIndex - 1;  // position where element should be
                                   // inserted
    while (position >= 0 && array[lastIndex] < array[position]) {
      position--;
    }
    position++;  // position is now where array[lastIndex] belongs

    // Move array[position..lastIndex-1] to make room for
    // array[lastIndex] in array[position]
    int tempElement = array[lastIndex];
    for (int moveIndex = lastIndex - 1; moveIndex >= position; moveIndex--) {
      array[moveIndex+1] = array[moveIndex];
    }
    // Insert element into proper position
    array[position] = tempElement;
    // Now array[0..lastIndex] are in order
  }
}
