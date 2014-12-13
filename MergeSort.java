public class MergeSort {
  public static void main(String[] args) {
    int[] array = { 0, 9, 1, 8, 2, 7, 3, 6, 5, 4 };
    sort(array);

    for (int elem : array) {
      System.out.print(elem);
    }
    System.out.println();
  }

  // POST: elements of array are rearranged in nodecreasing order
  public static void sort(int[] array) {
    // Create tempArray for use in merging
    int[] tempArray = new int[array.length];
    mergeSort(array, 0, array.length-1, tempArray);
  }

  /*
   * PRE: left and right are valid indices of array with left <= right - 1.
   *      tempArray.length == array.length
   * POST: elements of array[left..right] are rearranged in nondecreasing order
   */
  private static void mergeSort(int[] array, int left, int right, int[] tempArray) {
    if (left < right) {
      int middle = (right + left) / 2;
      mergeSort(array, left, middle, tempArray);
      mergeSort(array, middle + 1, right, tempArray);
      merge(array, left, middle, right, tempArray);
    }
  }

  /* PRE: 0 <= left <= middle <= right < array.length, tempArray.length == array.length,
   *      and array[left..middle] and array[middle+1..right] are both in
   *      nondecreasing order.
   * POST: The two halves (array[left..middle] and array[middle+1..right]) have been
   *       merged together so that array[left..right] is now in nondescending order.
   */
  private static void merge(int[] array, int left, int middle, int right, int[] tempArray) {
    int indexLeft = left;
    int indexRight = right;
    int target = left;

    // Copy both pieces into tempArray.
    for (int i = left; i <= right; i++) {
      tempArray[i] = array[i];
    }

    // Merge values while there are elements left in both halves.
    while(indexLeft <= middle && indexRight <= right) {
      if (tempArray[indexLeft] < tempArray[indexRight]) {
        array[target] = tempArray[indexLeft];
        indexLeft++;
      } else {
        array[target] = tempArray[indexRight];
        indexRight++;
      }
    }
    target++;
  }

  // Move any remaining elements from the left half.
  while (indexLeft <= middle) {
    array[target] = tempArray[indexLeft];
    indexLeft++;
    target++;
  }

  // Move any remaining elements from the right half.
  while (indexRight <= right) {
    array[target] = tempArray[indexRight];
    indexRight++;
    target++;
  }
}
