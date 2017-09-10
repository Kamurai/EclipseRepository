//Masom Hamadeh
//Math3323
//Assignment #10

package a10_TestingDegreeSequences;

import java.util.*;
import degreeSequences.ReduceDegreeSequences;
import degreeSequences.SomeDegreeSequences;


public class TestDegreeSequences 
{
	//create variables to hold the different sequences to test
	static List<Integer> seq1 = SomeDegreeSequences.ds1;
	static List<Integer> seq2 = SomeDegreeSequences.ds2;
	static List<Integer> seq3 = SomeDegreeSequences.ds3;
	static List<Integer> seq4 = SomeDegreeSequences.ds4;
	static List<Integer> seq5 = SomeDegreeSequences.ds5;
	
	public static void main (String[] args)
	{
		List<List<Integer>> testers = new ArrayList<List<Integer>>();
		testers.add(seq1);
		testers.add(seq2);
		testers.add(seq3);
		testers.add(seq4);
		testers.add(seq5);
		
		for (int i = 0; i < testers.size(); i++)
		{
			ReduceDegreeSequences.fullReduce(testers.get(i), false);
			System.out.println("Degreee Sequence #" + (i+1) + ": " + testers.get(i));			
		}
		
		//CONCLUSION: after running program, sequences #2 and #3 are the ONLY valid ones b/c they are all Zeros, rest are not valid!
		System.out.println("Based on the tests and degree sequence reductions we can conclude that degree sequence #2 and #3 are the only valid ones!");
	}
}
