package com.fdmgroup.demos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeSet;

public class Client {

	// Increase the sample size for a more pronounced effect
	private final static int SAMPLE_LIMIT = 100;

	public static void main(String[] args) {

		StopWatch stopWatch = new StopWatch();
		Random random = new Random();

		Integer[] arraySample = new Integer[SAMPLE_LIMIT];
		for (int index = 0; index < SAMPLE_LIMIT; index++)
			arraySample[index] = random.nextInt(SAMPLE_LIMIT);

		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		TreeSet<Integer> treeSet = new TreeSet<Integer>();

		long arrayListAddTime = timeAdd(stopWatch, arraySample, arrayList);
		long linkedListAddTime = timeAdd(stopWatch, arraySample, linkedList);
		long treeSetAddTime = timeAdd(stopWatch, arraySample, treeSet);

		long arrayListFindTime = timeContains(stopWatch, arraySample, arrayList);
		long linkedListFindTime = timeContains(stopWatch, arraySample,linkedList);
		long treeSetFindTime = timeContains(stopWatch, arraySample, treeSet);

		
		/*	Commented out for large sample sizes 
		 
		System.out.print("Array Sample: ");
		for (Integer i : arraySample) 
			System.out.print(i+" ");
		System.out.println();
		
		printContents(arrayList);
		printContents(linkedList);
		printContents(treeSet);
		*/
		
		System.out.println("Add time for ArrayList:" + arrayListAddTime);
		System.out.println("Add time for LinkedList:" + linkedListAddTime);
		System.out.println("Add time for TreeSet:" + treeSetAddTime);

		System.out.println("Find time for ArrayList:" + arrayListFindTime);
		System.out.println("Find time for LinkedList:" + linkedListFindTime);
		System.out.println("Find time for TreeSet:" + treeSetFindTime);
	}

	private static void printContents(Collection<Integer> collection) {
		
		System.out.print(collection.getClass().getSimpleName()+": ");
		for (Integer i : collection) 
			System.out.print(i+" ");
		System.out.println();
	}

	private static long timeAdd(StopWatch stopWatch, 
			Integer[] arraySample, Collection<Integer> collection) {
		
		stopWatch.start();

		for (int index = 0; index < SAMPLE_LIMIT; index++)
			collection.add(arraySample[index]);

		stopWatch.stop();
		
		return stopWatch.getElapsedMillis();
	}

	private static long timeContains(StopWatch stopWatch,
			Integer[] arraySample, Collection<Integer> collection) {
		
		stopWatch.start();

		for (int index = 0; index < SAMPLE_LIMIT; index++)
			collection.contains(arraySample[index]);

		stopWatch.stop();
		
		return stopWatch.getElapsedMillis();
	}

}
