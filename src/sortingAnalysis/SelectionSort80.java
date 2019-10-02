package sortingAnalysis;

public class SelectionSort80 
{
	// Method for sorting the numbers
	public static void selectionSort(int[] list)
	{
		for (int i = 0; i < ((list.length - 1) / 5) * 4; i++)
		{
			// Find minimum in list[i..linst.length-1]
			int currentMin = list[i];
			int currentMinIndex = i;
			
			for (int j = i + 1; j < (list.length / 5) * 4; j++)
			{
				if (currentMin > list[j])
				{
					currentMin = list[j];
					currentMinIndex = j;
				}
			}
			
			// Swap list[i] with list[currentMinIndex] if necessary
			if (currentMinIndex != i)
			{
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}
		}
	}
}
