package a4_Permutations;

import multinomials.*;
import java.util.*;

//Permutations of AAAA, count: 1 multinomial: 1
//Permutations of AABB, count: 6 multinomial: 6
//Permutations of AABBBCCC, count: 560 multinomial: 560
//Permutations of ABBCCCDDDD, count: 12600 multinomial: 12600

//NOTE: Dr. Setzer - I still don't understand what the difference between "Counts" and "Multinomials"
	//shouldn't counts always be higher and multinomials (since they are distinct and are dividing the repeated letters) be smaller???

public class TestMultinomial 
{

	public static void main(String[] args) 
	{
		//create the four strings we are going to work with/test
		String t1 = "AAAA";
		String t2 = "AABB";
		String t3 = "AABBBCCC";
		String t4 = "ABBCCCDDDD";
		
		System.out.println("This program will count the the number of permutations as well as the number of distinct permutations:\n");
		
		//Test t1 string
		PermutationGeneratorCoveyouSullivan t1pg = new PermutationGeneratorCoveyouSullivan(t1);
		Set<String> set1 = new TreeSet<String>();
		for (String s : t1pg)
			set1.add(s);
		long c1 = set1.size();
		long m1 = multinomials.Multinomials.multinomial(4);
		System.out.println("The Permutations of 'AAAA'--->\t\tCount: " + c1 + "\tMultinomials: " + m1);
		
		
		//Test t2 string
		PermutationGeneratorCoveyouSullivan t2pg = new PermutationGeneratorCoveyouSullivan(t2);
		Set<String> set2 = new TreeSet<String>();
		for (String s : t2pg)
			set2.add(s);
		long c2 = set2.size();
		long m2 = multinomials.Multinomials.multinomial(2,2);
		System.out.println("The Permutations of 'AABB'--->\t\tCount: " + c2 + "\tMultinomials: " + m2);
		
		//Test t3 string
		PermutationGeneratorCoveyouSullivan t3pg = new PermutationGeneratorCoveyouSullivan(t3);
		Set<String> set3 = new TreeSet<String>();
		for (String s : t3pg)
			set3.add(s);
		long c3 = set3.size();
		long m3 = multinomials.Multinomials.multinomial(2,3,3);
		System.out.println("The Permutations of 'AABBBCCC'--->\tCount: " + c3 + "\tMultinomials: " + m3);
		
		//Test t4 string
		PermutationGeneratorCoveyouSullivan t4pg = new PermutationGeneratorCoveyouSullivan(t4);
		Set<String> set4 = new TreeSet<String>();
		for (String s : t4pg)
			set4.add(s);
		long c4 = set4.size();
		long m4 = multinomials.Multinomials.multinomial(1,2,3,4);
		System.out.println("The Permutations of 'ABBCCCDDDD'--->\tCount: " + c4  + "\tMultinomials: " + m4);
	}

}
