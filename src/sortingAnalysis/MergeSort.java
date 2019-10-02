package sortingAnalysis;

public class MergeSort 
{
	private static long comparisons = 0;
	private static long movements= 0;
	
	// Constructors
	public MergeSort()
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
	public static void mergeSort(int[] list)
	{
		comparisons = 0;
		movements = 0;
		
		if (list.length > 1)
		{
			// Merge sort the first half
			int[] firstHalf = new int[list.length / 2];
			movements++;
			System.arraycopy(list,  0, firstHalf, 0, list.length / 2);
			mergeSort(firstHalf);
			
			// Merge sort the second half
			int secondHalfLength = list.length - list.length / 2;
			int[] secondHalf = new int[secondHalfLength];
			movements++;
			movements++;
			System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
			
			for (int i = 0; i < list.length; i++)
			{
				movements++;
			}
			
			// Merge firstHalf with secondHalf into list
			merge(firstHalf, secondHalf, list);
		}
		comparisons++;
	}
	
	// Merge two sorted lists
	public static void merge(int[] list1, int[]list2, int[] temp)
	{
		int current1 = 0; // Current index in list1
		int current2 = 0; // Current index in list2
		int current3 = 0; // Current index in temp
		
		while (current1 < list1.length && current2 < list2.length)
		{
			if (list1[current1] < list2[current2])
				temp[current3++] = list1[current1++];
			else
				temp[current3++] = list2[current2++];
			movements++;
			comparisons++;
		}
		
		while (current1 < list1.length) {
			temp[current3++] = list1[current1++];
			movements++;
			comparisons++;
		}
		
		while (current2 < list2.length) {
			temp[current3++] = list2[current2++];			
			movements++;
			comparisons++;
		}
	}
	
//	// Test method
//	public static void main(String[] args)
//	{
//		int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
//		mergeSort(list);
//		for (int i = 0; i < list.length; i++)
//		{
//			System.out.print(list[i] + " ");
//		}
//	}
}
