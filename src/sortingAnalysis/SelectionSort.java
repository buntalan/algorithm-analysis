package sortingAnalysis;

public class SelectionSort 
{
	private static long comparisons = 0;
	private static long movements= 0;
	
	// Constructors
	public SelectionSort()
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
	
	
	// Method for sorting the numbers
	public static void selectionSort(int[] list)
	{
		comparisons = 0;
		movements = 0;
		
		for (int i = 0; i < list.length - 1; i++)
		{
			// Find minimum in list[i..linst.length-1]
			int currentMin = list[i];
			int currentMinIndex = i;
			movements++;
			movements++;
			
			for (int j = i + 1; j < list.length; j++)
			{
				if (currentMin > list[j])
				{
					currentMin = list[j];
					currentMinIndex = j;
					movements++;
					movements++;
				}
				comparisons++;
			}
			
			// Swap list[i] with list[currentMinIndex] if necessary
			if (currentMinIndex != i)
			{
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
				movements++;
				movements++;
			}
			comparisons++;
		}
	}
}
