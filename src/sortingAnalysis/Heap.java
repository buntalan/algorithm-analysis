package sortingAnalysis;

public class Heap<E extends Comparable<E>>
{
	private java.util.ArrayList<E> list = new java.util.ArrayList<>();
	
	private static long comparisons = 0;
	private static long movements = 0;
	
	// Create a default heap
	public Heap()
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
	
	
	// Setters
	public static void setComparisons(int num)
	{
		comparisons = num;
	}
	
	public static void setMovements(int num)
	{
		movements = num;
	}
	
	
	// Create a heap from an array of objects
	public Heap(E[] objects)
	{
		for (int i = 0; i < objects.length; i++)
		{
			add(objects[i]);
		}
	}
	
	// Add a new object into the heap
	public void add(E newObject)
	{
		list.add(newObject); // Append to the heap
		int currentIndex = list.size() - 1; // Index of the last node			
		movements++;
		
		while (currentIndex > 0)
		{
			int parentIndex = (currentIndex - 1) / 2;
			// Swap if the current object is greater than its parent
			comparisons++;				
			movements++;
			
			if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0)
			{
				E temp = list.get(currentIndex);
				list.set(currentIndex, list.get(parentIndex));
				list.set(parentIndex, temp);
				movements++;
				movements++;
				movements++;
				comparisons++;
			}
			else
				break; // The tree is a heap now
			
			currentIndex = parentIndex;
			
		}
	}
	
	// Remove the root from the heap
	public E remove()
	{
		comparisons++;
		if (list.size() == 0) return null;
		
		E removedObject = list.get(0);		
		movements++;
		list.set(0, list.get(list.size() - 1));
		movements++;
		list.remove(list.size() - 1);
		movements++;
		
		int currentIndex = 0;
		movements++;
		while (currentIndex < list.size()) 
		{
			int leftChildIndex = 2 * currentIndex + 1;
			int rightChildIndex = 2 * currentIndex + 2;
			movements++;
			movements++;
			
			// Find maximum between two children
			comparisons++;
			if (leftChildIndex >= list.size()) break; // Tree is a heap
			int maxIndex = leftChildIndex;
			movements++;
			comparisons++;
			if (rightChildIndex < list.size())
			{
				comparisons++;
				if(list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0)
				{
					maxIndex = rightChildIndex;
					movements++;
				}
			}
			
			// Swap if the current node is less than maximum
			comparisons++;
			if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0)
			{
				E temp = list.get(maxIndex);				
				movements++;
				list.set(maxIndex, list.get(currentIndex));
				movements++;
				list.set(currentIndex, temp);
				movements++;
				currentIndex = maxIndex;
				movements++;
			}
			else
				break; // Tree is a heap
		}
		
		return removedObject;
	}
	
	// Get the number of nodes in the tree
	public int getSize()
	{
		return list.size();
	}
}
