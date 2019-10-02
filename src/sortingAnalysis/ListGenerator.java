package sortingAnalysis;

import java.util.*;
import java.io.*;

public class ListGenerator
{
	// Static attributes
	private static int instanceCounter = 0;
	
	// Attributes
	private int size;
	private int[] numberList;
	   
	// Constructors
	// Default
	public ListGenerator() 
	{
		instanceCounter++;
	}
	
	// Non-default
	public ListGenerator(int size)
	{
		// Set size and generateArray
		setSize(size);
		generateArray(getSize());
		instanceCounter++;
	}
	
	// Setters
	public void setSize(int size)
	{
		this.size = size;
	}
	
	public void setNumberList(int[] list)
	{
		numberList = list;
	}
	
	// Getters
	public int getSize()
	{
		return size;
	}
	
	public int[] getNumberList() 
	{
		return numberList;
	}
	
	public static int getInstances()
	{
		return instanceCounter;
	}
	
	// Generate array of random numbers
	public void generateArray(int size) 
	{
		//Parameters
		Random rand = new Random();
		int[] array;
		array = new int[size];
		
		for(int i = 0; i < size; i++)
		{
			array[i] = rand.nextInt(1000);
		}
		
		setNumberList(array);
	}
	
	// Generate number list file
	public void generateList(int[] list) 
	{
		// Create new File and OutputStream to store list of numbers
		File file = null;
		PrintWriter output = null;
		
		try 
		{
			file = new File("GeneratedList.txt");
			output = new PrintWriter(file);
			
			for (int number: list)
			{
				output.println(number);
			}
		}
		catch (IOException e)
		{
			System.err.println("An IOException was caught");
		}
		finally
		{
			output.close();
		}
	}
	
	// Sort array ascending
	public int[] sortAscending() 
	{
		int[] numberListAscending = Arrays.copyOf(getNumberList(), getNumberList().length);
		
		SelectionSort.selectionSort(numberListAscending);
		
		return numberListAscending;
	}
	
	// Sort array descending
	public int[] sortDescending() 
   	{
		int[] numberListDescending = Arrays.copyOf(getNumberList(), getNumberList().length);
		
		for (int i = 0; i < numberListDescending.length; i++)
		{
			numberListDescending[i] *= -1;
		}
		
		SelectionSort.selectionSort(numberListDescending);
		
		for (int i = 0; i < numberListDescending.length; i++)
		{
			numberListDescending[i] *= -1;
		}
		
		return numberListDescending;
   	}
	
	
	public int[] sortEighty() 
	{
		int[] numberListEighty = Arrays.copyOf(getNumberList(), getNumberList().length);
		
		SelectionSort80.selectionSort(numberListEighty);
		
		return numberListEighty;
	}

	public int[] sortTwenty() 
	{
		int[] numberListTwenty = Arrays.copyOf(getNumberList(), getNumberList().length);
		
		SelectionSort20.selectionSort(numberListTwenty);
		
		return numberListTwenty;
	}
	
}

