// BubbleSort
// Mike Calvey

public class BubbleSort
{

    // instance vars

    int[] array;


    // constructors

    public BubbleSort(int[] array)
    {
        this.array = array;
        printSort();
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

    int[] sort(int[] data, int n)
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
