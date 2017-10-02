/**
 * @author SGR
 *
 */

package Dirty;

public class Graph {
	
	private boolean[] edgeset;
	private boolean[][] matrix;
	private int numPossibleEdges;
	private int numVertices;
	private int index;
	
	
	public Graph (int index, int numPossibleEdges, int numVertices)
	{
		this.index = index;
		this.numVertices = numVertices;
		this.numPossibleEdges = numPossibleEdges;
		this.edgeset = new boolean[numPossibleEdges];
		this.edgeset = generateEdges(index);
		this.matrix = generateMatrix(edgeset);	
		
	}
	
	private boolean[] generateEdges (int index)
	{
		int currentNum = index;
		boolean[] edges = new boolean[numPossibleEdges];
		for (int i = numPossibleEdges - 1; i >= 0; i--)
		{
			if (currentNum % 2 == 0)
				edges[i] = false;
			else
				edges[i] = true;
			currentNum /= 2;
		}
		return edges;
	}
	
	private boolean[][] generateMatrix (boolean[] edgeset)
	{
		boolean [][] matrix = new boolean [numVertices][numVertices];		
		int counter = 1;
		
		for (int row = 1; row < numVertices; row++)					
			for (int col = 0; col < row; col++)						
			{
				if (edgeset[numPossibleEdges-counter] == true)
				{
					matrix[col][row] = true;
					matrix[row][col] = true; 
				}
				counter += 1;
			}	
		
		return matrix;
	}
	
	public boolean dominate (int[] vertexSet)
	{
		/**
		 *  If the vertex set dominates the graph,
		 *  return true,
		 *  else
		 */	
		boolean [] isDominated = new boolean [numVertices];
		boolean dominated = true;

		for (int v = 0; v < vertexSet.length; v++)		// For each vertex in the candidate set
		{
			isDominated[vertexSet[v]-1] = true;				// The vertex dominates itself
			for (int row = 0; row < numVertices; row++)		// iterate down the matrix in the column of vertex v
				if (matrix[row][vertexSet[v]-1] == true)	// Check for a corresponding edge between v and the vertex known as [row]
					isDominated[row] = true;				// if found, set this vertex as dominated (by vertex v)
		}
		
		for (int i = 0; i < numVertices; i++)	// iterate through the isDominated list
			if (isDominated[i] == false)		// Check for ANY vertex that is NOT dominated
				dominated = false;				// if so, candidate set does not dominate graph
		
		return dominated;
	}
	

	public boolean totalDominate (int[] vertexSet)
	{
		/**
		 * If the vertex set is a total dominating set,
		 * return true,
		 * else
		 */
		boolean [] isDominated = new boolean [numVertices];
		boolean dominated = true;
		
		for (int v = 0; v < vertexSet.length; v++)			// For each vertex in the candidate set
		{
			for (int row = 0; row < numVertices; row++)		// iterate down the matrix in the column of vertex v
				if (matrix[row][vertexSet[v]-1] == true)	// check for a corresponding edge between v and the vertex known as [row]
					isDominated[row] = true;				// if found, set this vertex as dominated (by vertex v)			
		}
		
		for (int i = 0; i < numVertices; i++)	// iterate through isDominated list
			if (isDominated[i] == false)		// check for ANY vertex that is NOT dominated
				dominated = false;				// if found, candidate set does not dominate graph
		
		return dominated;
	}

	public int getNumVertices() {
		return numVertices;
	}

	public boolean[] getEdgeset() {
		return edgeset;
	}
	
	public boolean[][] getMatrix() {
		return matrix;
	}

	public int getNumPossibleEdges() {
		return numPossibleEdges;
	}

	public int getIndex() {
		return index;
	}
	
	/**
	 * The following method is a form of graph toString
	 * it outputs the bit string that represents the graph both
	 * as set of edges, and it's index number in binary form
	 * @return returns a string enclosed in brackets that 
	 */
	public String printBitString() 
	{
		String graphBits = "[";
		for (int i = 0; i < numPossibleEdges; i++)
		{
			if (edgeset[i] == false)
				graphBits += "0";
			else
				graphBits += "1";
			if (i < numPossibleEdges - 1)
				graphBits += ", ";
		}
		graphBits += "]";
		return graphBits;
	}
	
	public String printMatrix()
	{
		String stringMatrix = "";
		for (int row = 0; row < numVertices; row++)
		{
			for (int col = 0; col < numVertices; col++)
			{
				if (matrix[col][row] == true)
					stringMatrix += "1";
				else
					stringMatrix += "0";
				if (col < numVertices - 1)
					stringMatrix += ", ";
				else
					stringMatrix += "\n";
			}
		}
		return stringMatrix;
	}


}
