package edu.grinnell.csc207.sortslab;

/**
 * A collection of sorting algorithms over generic arrays.
 */
public class Sorts {

    public static int binarySearch(int value, int[] arr, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (value < arr[mid]) {
            return binarySearch(value, arr, lo, mid);
        }
        if (value > arr[mid]) {
            return binarySearch(value, arr, mid + 1, hi);
        }
        return mid;
    }

    /**
     * Swaps indices <code>i</code> and <code>j</code> of array <code>arr</code>.
     * 
     * @param <T> the carrier type of the array
     * @param arr the array to swap
     * @param i   the first index to swap
     * @param j   the second index to swap
     */
    public static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * Sorts the array according to the bubble sort algorithm:
     * 
     * <pre>
     * [ unprocessed | i largest elements in order ]
     * </pre>
     * 
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void bubbleSort(T[] arr) {
        boolean arrayinorder = false;
        while (arrayinorder == false) {
            arrayinorder = true;
            for (int iter = 0; iter < (arr.length - 1); iter++) {
                if (arr[iter].compareTo(arr[iter + 1]) > 0) {
                    swap(arr, iter, iter + 1);
                    arrayinorder = false;
                }
            }

        }
    }

    /**
     * Sorts the array according to the selection sort algorithm:
     * 
     * <pre>
     * [ i smallest elements in order | unprocessed ]
     * </pre>
     * 
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void selectionSort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    swap(arr, i, j);
                }
            }
        }
    }

    /**
     * Sorts the array according to the insertion sort algorithm:
     * 
     * <pre>
     * [ i elements in order | unprocessed ]
     * </pre>
     * 
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void insertionSort(T[] arr) {
        for(int iter = 0; iter < arr.length; iter++){
            T save = arr[iter];
            int iter2;
            for (iter2 = 0; iter2 < iter; iter2++){
                if (save.compareTo(arr[iter2]) < 0)
                break;
            }
            for(int iter3 = iter; iter3 > iter2; iter3--){
                arr[iter3] = arr[iter3 - 1];
            }
            arr[iter2] = save;
        }
    }

    /**
     * Sorts the array according to the merge sort algorithm:
     * 
     * <pre>
     * [ sorted | sorted ] -> [ sorted ]
     * </pre>
     * 
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void mergeSort(T[] arr) {
        mergeSortHelper(arr, arr, arr.length, 0);
        /*int midPoint = arr.length/2;
        for (int i = 0; i < midPoint; i++) {
            for (int j = i; j < midPoint; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    swap(arr, i, j);
                }
            }
        }
        for (int i = midPoint; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    swap(arr, i, j);
                }
            }
        }
        int pointerFir = 0;
        int pointerSec = midPoint;
        for (int i = 0; i < arr.length; i++) { 
            //valid pointers?
            if (arr[pointerFir].compareTo(arr[pointerSec]) < 0) {
                arr2[i] = arr[pointerFir];
                pointerFir++;
            } else {

            }
        }*/

    }

    public static <T extends Comparable<? super T>> void mergeSortHelper(T[] arr, T[] arr2, int hi, int lo) {
        if(lo >= hi) {
            if (arr[hi].compareTo(arr[lo]) > 0) {
                swap(arr2, hi, lo);
            }
            return ;
        }
        int midPoint = arr.length/2;

        int pointerFir = lo;
        int pointerSec = midPoint;
        for (int i = lo; i < hi; i++) {
            if (pointerFir == midPoint) {
                arr2[i] = arr[pointerSec];
                pointerSec++;
            } else if (pointerSec == hi) {
                arr2[i] = arr[pointerFir];
                pointerFir++;
            } else if (arr[pointerFir].compareTo(arr[pointerSec]) < 0) {
                arr2[i] = arr[pointerFir];
                pointerFir++;
            } else if (arr[pointerSec].compareTo(arr[pointerFir]) < 0) {
                arr2[i] = arr[pointerSec];
                pointerSec++;
            } 
        }
        System.arraycopy(arr2, 0, arr, 0, arr.length);

        mergeSortHelper(arr, arr2, hi, midPoint + 1);
        mergeSortHelper(arr, arr2, midPoint, lo);
    }
     

    /**
     * Sorts the array according to the quick sort algorithm:
     * 
     * <pre>
     * []
     * </pre>
     * 
     * @param <T>
     * @param arr
     */
    public static <T extends Comparable<? super T>> void quickSort(T[] arr) {

    }

    /**
     * 
     * @param <T>
     * @param arr
     * @param hi exclusive
     * @param lo inclusive
     */
    public static <T extends Comparable<? super T>> void quickSortHelper(T[] arr, int hi, int lo) {
        T midpoint = arr[(hi + lo)/2];
        if(arr[hi - 1].compareTo(arr[lo]) > 0){
            
        }
    }


}
