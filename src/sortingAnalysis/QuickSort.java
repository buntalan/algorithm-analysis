package sortingAnalysis;

public class QuickSort 
{
	private static long comparisons = 0;
	private static long movements= 0;
	
	// Constructors
	public QuickSort()
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
	
	
	public static void quickSort(int[] list)
	{
		comparisons = 0;
		movements = 0;
		quickSort(list, 0, list.length - 1);
	}
	
	public static void quickSort(int[] list, int first, int last)
	{
		if (last > first)
		{
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
			movements++;
		}
		comparisons++;
	}
	
	// Partition the array list [first..last]
	public static int partition(int[] list, int first, int last)
	{
		int pivot = list[first]; // Choose the first element as the pivot
		int low = first + 1; // Index for forward search
		int high = last; // Index for backward search
		movements++;
		movements++;
		movements++;
		
		while (high > low)
		{
			// Search forward from left
			while (low <= high && list[low] <= pivot)
			{
				low++;
				comparisons++;
			}
			
			// Search backward from right
			while (low <= high && list[high] > pivot)
			{
				high--;			
				comparisons++;
			}
			
			// Swap two elements in the list
			if (high > low)
			{
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
				movements++;
				movements++;
				movements++;
			}
			comparisons++;
			
			
			comparisons++;
		}
		
		while (high > first && list[high] >= pivot)
		{
			high--;
			comparisons++;
		}
		
		// Swap pivot with list[high]
		if (pivot > list[high])
		{
			list[first] = list[high];
			list[high] = pivot;
			comparisons++;
			movements++;
			movements++;
			return high;
		}
		else
		{
			comparisons++;
			return first;
		}
	}
}
