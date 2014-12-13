public class LinearSearch {

  public static void main(String[] args) {
    int[] array = { 0, 1, 3, 5, 7, 9, 2, 4, 6, 5 };
    System.out.println( search(array, 9) );
  }

  /*
   * Search for the key in the array. Return the first index of key, or
   * -1 if it is not found.
   */
  public static int search(int[] array, int key) {
    for (int i = 0; i < array.length; i++) {
      if (key == array[i]) {
        return i;
      }
    }
    return -1;
  }
}
