package sortingAnalysis;

public class InsertionSort 
{
	private static long comparisons = 0;
	private static long movements= 0;
	
	// Constructors
	public InsertionSort()
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
	
	
	// Method for sorting numbers
	public static void insertionSort(int[] list) 
	{
		comparisons = 0;
		movements = 0;
		
		for (int i = 1; i < list.length; i++)
		{
			// Insert list[i] into a sorted sublist list[0..i-1] so that
			// list[0..i] is sorted
			int currentElement = list[i];				
			movements++;

			int k;
			comparisons++;
			for (k = i - 1; k >= 0 && list[k] > currentElement; k--, comparisons++)
			{
				list[k + 1] = list[k];
				movements++;
			}
			
			// Insert current element into list[k + 1]
			list[k + 1] = currentElement;
			movements++;
		}
	}
}
