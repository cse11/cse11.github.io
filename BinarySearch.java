public class BinarySearch {

  public static void main(String[] args) {
    int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    System.out.println( binarySearch(array, 8, 0, 9) );
  }

  /*
   * Recursive search for key in array[start..end]. Return the index of key,
   * or -1 if it is not found.
   */
  public static int binarySearch(int[] array, int value, int start, int end) {
    if (start > end) {
      return -1;
    } else {
      int middleIndex = (start + end) / 2;
      if (value == array[middleIndex]) {
        return middleIndex;
      } else if (value < array[middleIndex]) {
        return binarySearch(array, key, start, middleIndex - 1);
      } else {  // value > array[middleIndex]
        return binarySearch(array, key, middleIndex + 1, end);
      }
    }
  }
}
