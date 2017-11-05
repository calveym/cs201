// CS 201 HW 4, Problem 2
// Michael Calvey
// An implementation of the Vector class that uses generic comparators when
// comparing values
import java.util.Vector;
import java.util.Comparator;

public class MyVector<T> extends Vector<T> {

    // Constructs a new empty MyVector
    public MyVector() {
        super(); // call constructor of super class
    }

    // Constructs a new MyVector with initial capacity n
    public MyVector(int n) {
        super(n); // call constructor of super class
    }

    // Sorts vector with suppied comparator using selectionSort algorithm
    public void selectionSort(Comparator<T> c) {
        for (int numUnsorted = this.size(); numUnsorted > 0; numUnsorted--) {
            // determine location of maximum value in array
            int maxIndex = 0;
            for (int index = 1; index < numUnsorted; index++) {
                if(c.compare(this.get(maxIndex), this.get(index)) < 0)
                {
                    maxIndex = index;
                }
            }
            swap(maxIndex, numUnsorted-1);
        }
    }

    // Sorts Vector with supplied comparator using insertionSort algorithm
    public void insertionSort(Comparator<T> c) {
        for (int numSorted = 1; numSorted < this.size(); numSorted++) {
            int index; // need to declare here since it's used outside of loop
            // get the first unsorted value ...
            T val = this.get(numSorted);
            // ... and insert it among the sorted
            for (index = numSorted; index > 0; index--) {
                if (c.compare(val, this.get(index-1)) < 0) {
                    this.set(index, this.get(index-1));
                } else {
                    break; // quits out of smallest enclosing loop
                }
            }
            // reinsert value
            this.set(index, val);
        }
    }

    // Sorts Vector with supplied comparator using quickSort algorithm
    public void quickSort(Comparator<T> c)  {
        quickSortRecursive(c, 0, this.size() - 1);
    }

    // Recursive quickSort call for contained Vector
    private void quickSortRecursive(Comparator<T> c, int low, int high)
    {
        int pivot;
        if (low < high) {
            pivot = partition(c, low, high);
            quickSortRecursive(c, low, pivot-1);
            quickSortRecursive(c, pivot+1, high);
        }
    }

    // Partition using data.get(left) as pivot element and Comparator c for
    // comparisons
    private int partition(Comparator<T> c, int left, int right)
    {
        while (true) {
            // move right "pointer" toward left
            while ((left < right) && c.compare(this.get(left), this.get(right)) < 0)
                right--;
            if (left < right) {
                swap(left++, right);
            } else {
                return left;
            }
            // move left "pointer" toward right
            while ((left < right) && c.compare(this.get(left), this.get(right)) < 0)
                left++;
            if (left < right) {
                swap(left, right--);
            } else {
                return right;
            }
        }
    }

    // Swaps items at indexes i and j
    private void swap(int i, int j)
    {
        T temp = this.get(i);

        this.set(i, this.get(j));
        this.set(j, temp);
    }
}
