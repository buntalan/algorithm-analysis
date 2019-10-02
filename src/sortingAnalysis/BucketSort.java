package sortingAnalysis;

import java.util.Arrays;

public class BucketSort 
{
	private static long comparisons = 0;
	private static long movements= 0;
	
	// Constructors
	public BucketSort()
	{
	}
	
	// Getters
	public static long getComparisons()
	{
		return comparisons;
	}
	
	public static long getMovements()
	{
		return movements;
	}
	
    // A utility function to get maximum value in arr[] 
    static int getMax(int arr[], int n) 
    { 
        int mx = arr[0];
        movements++;

        for (int i = 1; i < n; i++)
        {
        	comparisons++;
            if (arr[i] > mx)
            {
                mx = arr[i];
                movements++;
            }
        }
        return mx; 
    } 
  
    // A function to do counting sort of arr[] according to 
    // the digit represented by exp. 
    static void countSort(int arr[], int n, int exp) 
    { 
        int output[] = new int[n]; // output array 
        int i; 
        int count[] = new int[10]; 
        Arrays.fill(count,0); 
        movements++;
        movements++;
  
        // Store count of occurrences in count[] 
        for (i = 0; i < n; i++) 
        {
            count[ (arr[i]/exp)%10 ]++;
            movements++;
        }
  
        // Change count[i] so that count[i] now contains 
        // actual position of this digit in output[] 
        for (i = 1; i < 10; i++) 
        {
            count[i] += count[i - 1]; 
            movements++;
        }
  
        // Build the output array 
        for (i = n - 1; i >= 0; i--) 
        { 
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i]; 
            count[ (arr[i]/exp)%10 ]--; 
            movements++;
            movements++;
        } 
  
        // Copy the output array to arr[], so that arr[] now 
        // contains sorted numbers according to curent digit 
        for (i = 0; i < n; i++)
        {
            arr[i] = output[i]; 
        	movements++;
        }
    } 
  
    // The main function to that sorts arr[] of size n using 
    // Radix Sort 
    static void radixSort(int arr[], int n) 
    { 
    	comparisons = 0;
    	movements = 0;
    	
        // Find the maximum number to know number of digits 
        int m = getMax(arr, n); 
  
        // Do counting sort for every digit. Note that instead 
        // of passing digit number, exp is passed. exp is 10^i 
        // where i is current digit number 
        for (int exp = 1; m/exp > 0; exp *= 10) 
            countSort(arr, n, exp); 
    } 
    
// *** Radix sort from https://www.geeksforgeeks.org/radix-sort/
}
