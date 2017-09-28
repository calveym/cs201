// BubbleSort
// Mike Calvey

public class Sort
{

    // instance vars

    int[] array;


    // constructors

    public Sort(int[] array)
    {
        this.array = array;
    }


    // interface

    public void printSort()
    // calls printsort with starter array
    {
        printSort(array);
    }

    public void printSort(int[] array)
    {
        printArray(sort(array, array.length));
    }


    // work

    void swap(int[] data, int i, int j)
    // i and j are swapped
    {
        int temp = data[i];
        temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    int[] bubbleSort(int[] data, int n)
    // uses bubble sort algorithm to sort data array
    {
        int numSorted = 0;
        int index;
        while(numSorted < n)
        {
            for(index = 1; index < n-numSorted; index++)
            {
                // compare values
                if(data[index-1] > data[index])
                {
                    // swap if i-1 value is larger than i value
                    swap(data, index-1, index);
                }
            }
            numSorted++; // at least one more value in place
        }
        return data;
    }

    int[] selectionSort(int[] data, int n)
    {
        for (int numUnSorted = n; numUnSorted > 0; numUnSorted--)
        {
            int largestLoc = 0;
            for (int i = 1; i < numUnSorted; i++)
            {
                if(data[i] > largestLoc)
                {
                    largestLoc = i;
                }
            }
            swap(data, largestLoc, numUnSorted - 1);
        }
    }

    void printArray(int[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            if(i+1 < array.length)
            {
                System.out.print(array[i] + ", ");
            }
            else
            {
                System.out.print(array[i]);
            }
        }
        System.out.println();
    }
}
