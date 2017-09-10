/**
 * 
 */
package Dirty;

import java.util.Arrays;

/**
 * @author SGR
 *
 */
public class Action {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int numVertices = 7;			// Change manually for each run, later add to arguments
		int permutations = (int) Math.pow(2, (Combinatorics.choose(numVertices,2)));	// Total number of graphs to calculate
		int numPossibleEdges = (int) Combinatorics.choose(numVertices,2);
		
		double numerator = 0;		// The numerator for calculating summed totals
		double denominator = 0;		// The denominator for calculating summed totals
		double averageTotal = 0;	// The numerator for calculating the average ratio total
		double averageCount = 0;	// The denominator for calculating the average ratio total
		
		VertexSets masterSet = new VertexSets(numVertices);  // One time generation of master set of vertex sets
		
		
		for (int index = 0; index < permutations; index++)		// For every possible graph of numVertices
		{
			Graph currentGraph = new Graph(index, numPossibleEdges, numVertices);	// Generates a single graph to evaluate
			
			int totalDominationNum = numVertices;		// Set high initially, will result in incorrect ratio
			int dominationNum = numVertices;			// 		if not changed by loops
			boolean domNumberNotYetFound = true;	// while-loop condition flag
			boolean totalDomNumberNotYetFound = true;		// while-loop condition flag
		
			String dominatingSet = "";		// Holds dominating set when found
			String totalDominatingSet = "";	// Holds total dominating set when found 
			int counter = -1;

			
			
			/**
			 * The following two loops determine the Domination and Total Domination
			 * numbers by testing vertex sets in order, beginning with the smallest.
			 * The first dominating set is found, and then the first total dominating
			 *  set is found, BEGINNING WHERE THE FIRST TEST LEFT OFF.
			 */		
			while (domNumberNotYetFound)		// While domination number not found
			{
				counter++;
				if (currentGraph.dominate(masterSet.getMasterVertexSet()[counter]))	// Check to see if set[counter] dominates
				{
					dominationNum = masterSet.getMasterVertexSet()[counter].length;	// If so, set domination number to length
					domNumberNotYetFound = false;	// Change condition flag to exit loop b/c domination number was found
					dominatingSet = Arrays.toString(masterSet.getMasterVertexSet()[counter]);	// set string to dominating set
				}				
			}
			while (totalDomNumberNotYetFound)	// While total domination number not found
			{
				if (currentGraph.totalDominate(masterSet.getMasterVertexSet()[counter]))	// Is set[counter] total dominating?
				{
					totalDominationNum = masterSet.getMasterVertexSet()[counter].length;  // totaldom number to @[counter] length
					totalDomNumberNotYetFound = false;	// Change to exit loop b/c total domination number was found
					totalDominatingSet = Arrays.toString(masterSet.getMasterVertexSet()[counter]);	// set string to totaldom set
				}
				counter++;
				if (counter == masterSet.getMasterVertexSet().length && totalDomNumberNotYetFound)	// Are we done?
				{
					totalDomNumberNotYetFound = false;	// Change condition flag to exit loop b/c not domination set exists
					totalDominationNum = 0;				// b/c Isolated Vertex Exists
					totalDominatingSet = "ISOLATED VERTEX";	// b/c Isolated Vertex Exists
					dominatingSet = "ISOLATED VERTEX";		// b/c Isolated Vertex Exists
				}
			}
			

			
			if (totalDominationNum != 0)	// If "no isolated vertex"
			{
				numerator += totalDominationNum;	// Adds total domination number to running sum
				denominator += dominationNum;		// Adds domination number to running sum
				averageCount++;		// Increment count for use as denominator in average ratio calculation
				averageTotal += (totalDominationNum / dominationNum);	// Adds average ratio to running sum
			}
			
			
			System.out.println();
			System.out.print ("Graph #" + index + ": ");
			System.out.println(currentGraph.printBitString() + "\n");	// Calls Graph method to print bit string		
			System.out.println(currentGraph.printMatrix());				// Calls Graph method to print matrix
			System.out.println("domination number = " + dominationNum);
			System.out.println("dominating set = " + dominatingSet);
			System.out.println("total domination number = " + totalDominationNum);
			System.out.println("total dominating set =  " + totalDominatingSet);
			System.out.println();
			System.out.println("----------------------------------------------------------------------------");
			
		}

		System.out.println(numVertices);
//		System.out.println(Arrays.deepToString(masterSet.getMasterVertexSet()));
		
		System.out.println ("Ratio of summed totals (totalDom/Dom) = " + numerator + "/" + denominator + " = " + (numerator/denominator));
		System.out.println ("Average Ratio (totalDom/Dom) = " + averageTotal + "/" + averageCount + " = " + (averageTotal/averageCount));

	}
}
