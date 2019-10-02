package sortingAnalysis;

public class HeapSort 
{
	private static long comparisons = 0;
	private static long movements= 0;
	
	// Constructors
	public HeapSort()
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
	
	
	// Heap sort method
	public static <E extends Comparable<E>> void heapSort(E[] list )
	{
		comparisons = 0;
		movements = 0;
		
		// Create a heap of integers
		Heap<E> heap = new Heap<>();
		
		// Add elements to the heap
		for (int i = 0; i< list.length; i++)
		{
			heap.add(list[i]);
		}
		
		comparisons = heap.getComparisons();
		movements = heap.getMovements();
		
		heap.setComparisons(0);
		heap.setMovements(0);
		
		// Remove elements from the heap
		for (int i = list.length - 1; i >= 0; i--)
		{
			list[i] = heap.remove();
		}
		
		comparisons += heap.getComparisons();
		movements += heap.getMovements();
	}
	
//	// Test method
//	public static void main(String[] args)
//	{
//		Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
//		heapSort(list);
//		for(int i = 0; i < list.length; i++)
//		{
//			System.out.print(list[i] + " " );
//		}
//	}
}
