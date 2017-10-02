package homework12;

/*

Do exercises 27.2 and 27.4 according to the attached specification.

 Write a test program that thoroughly tests the getConnectedComponents 
 and isCycle methods. Be sure to include all of the necessary positive 
 & negative tests. After exchanging test programs with another student, 
 follow the instructions for submitting an Eclipse program.

*/

import homework11.AbstractGraph.Tree;

import java.util.*;

public abstract class AbstractGraph implements Graph {
  protected Object[] vertices; // Store vertices
  protected List<Integer>[] neighbors; // Adjacency lists

  /** Construct a graph from edges and vertices stored in arrays */
  protected AbstractGraph(int[][] edges, Object[] vertices) {
    this.vertices = vertices;
    createAdjacencyLists(edges, vertices.length);
  }

  /** Construct a graph from edges and vertices stored in ArrayList */
  protected AbstractGraph(List<Edge> edges, List vertices) {
    this.vertices = vertices.toArray();
    createAdjacencyLists(edges, vertices.size());
  }

  /** Construct a graph from edges and vertices in ArrayList */
  protected AbstractGraph(List<Edge> edges, int numberOfVertices) {
    vertices = new Integer[numberOfVertices]; // Create vertices
    for (int i = 0; i < numberOfVertices; i++) {
      vertices[i] = new Integer(i); // vertices is {0, 1, 2, ...}
    }
    createAdjacencyLists(edges, numberOfVertices);
  }

  /** Construct a graph from edges in array */
  protected AbstractGraph(int[][] edges, int numberOfVertices) {
    vertices = new Integer[numberOfVertices]; // Create vertices
    for (int i = 0; i < numberOfVertices; i++) {
      vertices[i] = new Integer(i); // vertices is {0, 1, 2, ...}
    }
    createAdjacencyLists(edges, numberOfVertices);
  }

  /** Create adjacency lists for each vertex */
  private void createAdjacencyLists(
      int[][] edges, int numberOfVertices) {
    // Create a linked list
    neighbors = new LinkedList[numberOfVertices];
    for (int i = 0; i < numberOfVertices; i++) {
      neighbors[i] = new LinkedList<Integer>();
    }

    for (int i = 0; i < edges.length; i++) {
      int u = edges[i][0];
      int v = edges[i][1];
      neighbors[u].add(v);
    }
  }

  /** Create adjacency lists for each vertex */
  private void createAdjacencyLists(
      List<Edge> edges, int numberOfVertices) {
    // Create a linked list
    neighbors = new LinkedList[numberOfVertices];
    for (int i = 0; i < numberOfVertices; i++) {
      neighbors[i] = new LinkedList<Integer>();
    }

    for (Edge edge: edges) {
      neighbors[edge.u].add(edge.v);
    }
  }

  /** Return the number of vertices in the graph */
  public int getSize() {
    return vertices.length;
  }

  /** Return the vertices in the graph */
  public Object[] getVertices() {
    return vertices;
  }

  /** Return the object for the specifed vertex */
  public Object getVertex(int v) {
    return vertices[v];
  }

  /** Return the index for the specified vertex object */
  public int getIndex(Object vertex) {
    for (int i = 0; i < getSize(); i++) {
      if (vertex.equals(vertices[i])) {
        return i;
      }
    }

    return -1; // If vertex is not in the graph
  }

  /** Return the neighbors of vertex v */
  public List getNeighbors(int v) {
    return neighbors[v];
  }

  /** Return the degree for a specified vertex */
  public int getDegree(int v) {
    return neighbors[v].size();
  }

  /** Return the adjacency matrix */
  public int[][] getAdjacencyMatrix() {
    int[][] adjacencyMatrix = new int[getSize()][getSize()];

    for (int i = 0; i < neighbors.length; i++) {
      for (int j = 0; j < neighbors[i].size(); j++) {
        int v = neighbors[i].get(j);
        adjacencyMatrix[i][v] = 1;
      }
    }

    return adjacencyMatrix;
  }

  /** Print the adjacency matrix */
  public void printAdjacencyMatrix() {
    int[][] adjacencyMatrix = getAdjacencyMatrix();
    for (int i = 0; i < adjacencyMatrix.length; i++) {
      for (int j = 0; j < adjacencyMatrix[0].length; j++) {
        System.out.print(adjacencyMatrix[i][j] + " ");
      }

      System.out.println();
    }
  }
  


  /** Print the edges */
  public void printEdges() {
    for (int u = 0; u < neighbors.length; u++) {
      System.out.print("Vertex " + u + ": ");
      for (int j = 0; j < neighbors[u].size(); j++) {
        System.out.print("(" + u + ", " +
          neighbors[u].get(j) + ") ");
      }
      System.out.println();
    }
  }
   
  
//getConnectedComponents
  public List<List<Integer>> getConnectedComponents()
  {
	//List of Lists of Integers
	  List<List<Integer>> Bob = new LinkedList<List<Integer>>();

	  if(getSize() == 0)
	  {
		return Bob;  
	  }
	  
	  int counter = 0;
	  boolean flag = true;
	  
	  //List of Integers for building
	  List<Integer> Adam = new LinkedList<Integer>();
	  
	  //List of Integers to track visitation
	  int[] Tim = new int[getSize()];
	  
	  //Set all vertices = 0
	  for(int x =0; x < Tim.length; x++)
	  {
		  Tim[x] = 0;
	  }
	 
	  //make a tree
	  Tree Ted;
	  
	  //Get a list of the Connected components in this graph 
		 
	  //check the visitation list
	  for(int x = 0; x < Tim.length; x++)
	  {
		  //if there is an unvisited vertex
		  if(Tim[x] == 0)
		  {
		  	//then create a new tree and add it in as a list to the list of lists
			  //make a tree
			  Ted = dfs(x);
			  
			  //put the tree's order of search into a list
			  Adam = new LinkedList<Integer>(Ted.searchOrders);
			  
			  //update the visitation list
			  for(int y = 0; y < Adam.size(); y++)
			  {
				  Tim[Adam.get(y)] = 1;
			  }
			  
			  //then add the order of search list to the list of lists
			  Bob.add(Adam);
			  
			  
		  }

	  }
	  
	  
	  //System.out.println( Bob );
	  
	  //Returns:
	  //A List of Connected Components. Each List item is itself a List of the nodes in that component
	  return Bob;
  }
  
//getConnectedPaths
  public List<List<Integer>> getConnectedPaths()
  {
	  //List of Lists of Integers
	  List<List<Integer>> Bob = new LinkedList<List<Integer>>();

	  if(getSize() == 0 )
	  {
		return Bob;  
	  }
	  
	  boolean flag = true;
	  
	  //List of Integers for building
	  List<Integer> Adam = new LinkedList<Integer>();
	  
	  //List of Integers to track visitation
	  int[] Tim = new int[getSize()];
	  
	  //Set all vertices = 0
	  for(int x =0; x < Tim.length; x++)
	  {
		  Tim[x] = 0;
	  }
	 
	  //make a tree
	  Tree Ted;
	  
	  //Get a list of the Connected components in this graph 
		 
	  //check the visitation list
	  for(int x = 0; x < Tim.length; x++)
	  {
		  flag = true;
		  
		  //if there is an unvisited vertex
		  if(Tim[x] == 0)
		  {
		  	//then create a new tree and add it in as a list to the list of lists
			//make a tree
			  Ted = dfs(x);
			  
			  //put the tree's order of search into a list
			  Adam = new LinkedList<Integer>(Ted.searchOrders);
			  
			  for(int y = 0; y < Adam.size(); y++)
			  {
				  //if the next element is not adjacent to the current element
				  	//and the current element is not the last element
				  if( y != Adam.size()-1 && getNeighbors(Adam.get(y)).contains(Adam.get(y+1)) == false )
				  {
					  //do not add list to the list of lists
					  flag = false;
					  //escape
					  y = Adam.size()-1;
				  }
				  
				
			  }
			  
			  //update the visitation list
			  for(int y = 0; y < Adam.size(); y++)
			  {
				  Tim[Adam.get(y)] = 1;
			  }
			  
			  
			  if(flag == true)
			  {
				  //then add the order of search list to the list of lists
				  Bob.add(Adam);
			  }
			  
		  }

	  }
	  
	  
	  //System.out.println( Bob );
	  
	  //Returns:
	  //A List of Connected Components. Each List item is itself a List of the nodes in that component
	  return Bob;
  }
  
  //isCycle
  public boolean isCycle() 
  {
	  boolean cycle = false;
	  List<List<Integer>> Bob = getConnectedComponents();
	  List<Integer> Adam = new LinkedList<Integer>();
	  List<Integer> Eve = new LinkedList<Integer>();
	  
	  //Determines if this graph has a cycle
	  	//Detecting whether there is a cycle in the graph. (See Exercise 27.4)
	  	//Finding all connected components. A connected component is a maximal connected 
	  	//subgraph in which every pair of vertices are connected by a path. (See Exercise 27.4)

	  //Use getConnectCompoments() to walk through the graph and return a LinkedList of Lists
	  
	  //if getConnectComponents() returns an empty list of lists
	  	//or a list of lists with size 0
	  if(Bob == new LinkedList<List<Integer>>() || Bob.size() == 0 )
	  {
		  return false;
	  }
	  
	  
	  //Once a LinkedList of Lists is returned, walk through list of lists
	  for(int x = 0; x < Bob.size(); x++)
	  {
		  //get a list from the list of lists
		  Adam = new LinkedList(Bob.get(x));
		  
		  //create a list based of the neighbors of the last element in the list
		  if(Adam.size() !=0)
		  {
			  Eve = new LinkedList(getNeighbors(Adam.get(Adam.size()-1)));
		  }
		  
		  
		  //if graph is a non cycle graph of two vertices
		  if( (Adam.size() == 2 && getDegree(Adam.get(0)) == 1))
		  {
			  cycle = false;
		  }
		  //if graph has one vertex and multiple edges
		  else if( Adam.size() == 1 && getDegree(Adam.get(0)) > 0 )
		  {
			  return true;
		  }
		  //see if head of the list is adjacent to the tail of the list
		  else if( Eve.contains(Adam.get(0)) == true)
		  {
		  		//if true, then return true
			  return true;
		  }
		  
		  
		  

	  }
	  
	  
	
	  
	  //Returns:
	  //true if there is a cycle; false otherwise
	  
	  return cycle;

  }

  /** Edge inner class inside the AbstractGraph class */
  public static class Edge {
    public int u; // Starting vertex of the edge
    public int v; // Ending vertex of the edge

    /** Construct an edge for (u, v) */
    public Edge(int u, int v) {
      this.u = u;
      this.v = v;
    }
  }

  /** Obtain a DFS tree starting from vertex v */
  /** To be discussed in Section 27.6 */
  public Tree dfs(int v) {
    List<Integer> searchOrders = new ArrayList<Integer>();
    int[] parent = new int[vertices.length];
    for (int i = 0; i < parent.length; i++)
      parent[i] = -1; // Initialize parent[i] to -1

    // Mark visited vertices
    boolean[] isVisited = new boolean[vertices.length];

    // Recursively search
    dfs(v, parent, searchOrders, isVisited);

    // Return a search tree
    return new Tree(v, parent, searchOrders);
  }

  /** Recursive method for DFS search */
  private void dfs(int v, int[] parent, List<Integer> searchOrders,
      boolean[] isVisited) {
    // Store the visited vertex
    searchOrders.add(v);
    isVisited[v] = true; // Vertex v visited

    for (int i : neighbors[v]) {
      if (!isVisited[i]) {
        parent[i] = v; // The parent of vertex i is v
        dfs(i, parent, searchOrders, isVisited); // Recursive search
      }
    }
  }

  /** Starting bfs search from vertex v */
  /** To be discussed in Section 27.7 */
  public Tree bfs(int v) {
    List<Integer> searchOrders = new ArrayList<Integer>();
    int[] parent = new int[vertices.length];
    for (int i = 0; i < parent.length; i++)
      parent[i] = -1; // Initialize parent[i] to -1

    LinkedList<Integer> queue = new LinkedList<Integer>(); // list used as a queue
    boolean[] isVisited = new boolean[vertices.length];
    queue.offer(v); // Enqueue v
    isVisited[v] = true; // Mark it visited

    while (!queue.isEmpty()) {
      int u = queue.poll(); // Dequeue to u
      searchOrders.add(u); // u searched
      for (int w : neighbors[u]) {
        if (!isVisited[w]) {
          queue.offer(w); // Enqueue w
          parent[w] = u; // The parent of w is u
          isVisited[w] = true; // Mark it visited
        }
      }
    }

    return new Tree(v, parent, searchOrders);
  }

  /** Tree inner class inside the AbstractGraph class */
  /** To be discussed in Section 27.5 */
  public class Tree {
    private int root; // The root of the tree
    private int[] parent; // Store the parent of each vertex
    private List<Integer> searchOrders; // Store the search order

    /** Construct a tree with root, parent, and searchOrder */
    public Tree(int root, int[] parent, List<Integer> searchOrders) {
      this.root = root;
      this.parent = parent;
      this.searchOrders = searchOrders;
    }

    /** Construct a tree with root and parent without a
     *  particular order */
    public Tree(int root, int[] parent) {
      this.root = root;
      this.parent = parent;
    }

    /** Return the root of the tree */
    public int getRoot() {
      return root;
    }

    /** Return the parent of vertex v */
    public int getParent(int v) {
      return parent[v];
    }

    /** Return an array representing search order */
    public List<Integer> getSearchOrders() {
      return searchOrders;
    }

    /** Return number of vertices found */
    public int getNumberOfVerticesFound() {
      return searchOrders.size();
    }

    /** Return the iterator for a path starting from the root to v */
    public Iterator pathIterator(int v) {
      return new PathIterator(v);
    }

    /** PathIterator inner class inside the tree */
    public class PathIterator implements java.util.Iterator {
      private Stack<Integer> stack;

      /** Construct an iterator for the vertices on the path */
      public PathIterator(int v) {
        stack = new Stack<Integer>();
        do {
          stack.add(v);
          v = parent[v];
        }
        while (v != -1);
      }

      /** Has next element in the iterator? */
      public boolean hasNext() {
        return !stack.isEmpty();
      }

      /* Get the current element in the iterator and move the
       * iterator to point to the next element */
      public Object next() {
        return vertices[stack.pop()];
      }

      /* This remove method is defined in the Iterator interface
       * Do not implement it */
      public void remove() {
        // Do nothing
      }
    }

    /** Print a path from the root to vertex v */
    public void printPath(int v) {
      Iterator iterator = pathIterator(v);
      System.out.print("A path from " + vertices[root] + " to " +
        vertices[v] + ": ");
      while (iterator.hasNext()) {
        System.out.print(iterator.next() + " ");
      }
    }

    /** Print the whole tree */
    public void printTree() {
      System.out.println("Root is: " + vertices[root]);
      System.out.print("Edges: ");
      for (int i = 0; i < parent.length; i++) {
        if (parent[i] != -1) {
          // Display an edge
          System.out.print("(" + vertices[parent[i]] + ", " +
            vertices[i] + ") ");
        }
      }
      System.out.println();
    }
  }
  
  /** Return a Hamiltonian path from the specified vertex object
   * Return null if the graph does not contain a Hamiltonian path */
  public List<Integer> getHamiltonianPath(Object vertex) {
    return getHamiltonianPath(getIndex(vertex));
  }

  /** Return a Hamiltonian path from the specified vertex label
   * Return null if the graph does not contain a Hamiltonian path */
  public List<Integer> getHamiltonianPath(int v) {
    // A path starts from v. (i, next[i]) represents an edge in 
    // the path. isVisited[i] tracks whether i is currently in the 
    // path.
    int[] next = new int[getSize()];       
    for (int i = 0; i < next.length; i++)
      next[i] = -1; // Indicate no subpath from i is found yet
    
    boolean[] isVisited = new boolean[getSize()]; 
    
    // The vertices in the Hamiltionian path are stored in result
    List<Integer> result = null;

    // To speed up search, reorder the adjacency list for each 
    // vertex so that the vertices in the list are in increasing 
    // order of their degrees
    for (int i = 0; i < getSize(); i++)
      reorderNeigborsBasedOnDegree(neighbors[i]);
    
    if (getHamiltonianPath(v, next, isVisited)) {
      result = new ArrayList<Integer>(); // Create a list for path        
      int vertex = v; // Starting from v
      while (vertex != -1) {
        result.add(vertex); // Add vertex to the result list
        vertex = next[vertex]; // Get the next vertex in the path
      }
    }
    
    return result; // return null if no Hamiltionian path is found
  }
  
  
  
  
  //isHamiltonianCycle
  //Parameters:  node - to begin search at 
  public boolean isHamiltonianCycle(int v)
  {
	// The vertices in the Hamiltionian path are stored in result
	    List<Integer> result = null;

	    if(getSize() == 0)
	    {
	    	return false;
	    }
	  
	    int[] next = new int[getSize()];       
	    for (int i = 0; i < next.length; i++)
	      next[i] = -1; // Indicate no subpath from i is found yet
	    
	    boolean[] isVisited = new boolean[getSize()]; 
	    
	    
	    // To speed up search, reorder the adjacency list for each 
	    // vertex so that the vertices in the list are in increasing 
	    // order of their degrees
	    for (int i = 0; i < getSize(); i++)
	      reorderNeigborsBasedOnDegree(neighbors[i]);
	    
	    if (getHamiltonianPath(v, next, isVisited)) {
	      result = new ArrayList<Integer>(); // Create a list for path        
	      int vertex = v; // Starting from v
	      while (vertex != -1) {
	        result.add(vertex); // Add vertex to the result list
	        vertex = next[vertex]; // Get the next vertex in the path
	      }
	    }
	  
	  //real isHamiltonCycle methods work
	  boolean hami = false;
	  List<Integer> Adam = new LinkedList<Integer>();
	  List<Integer> Eve = new LinkedList<Integer>();
	  
	  //Determines if there is a Hamiltonian cycle in this graph 
  
	  if(result != null)
	  {
		  //get some Hamiltonian paths  
		  Adam = new ArrayList(result);
	  }
	  
	  
	  //if getConnectComponents() returns an empty list
	  	//or a list of lists with size 0
	  	//or null
	  if(Adam == new LinkedList<Integer>() || Adam.size() == 0 || Adam == null )
	  {
		  return false;
	  }

	  //create a list based of the neighbors of the last element in the list
	    Eve = new LinkedList(getNeighbors(Adam.get(Adam.size()-1)));
	  

		  //if graph is a graph of two vertices
		  if( Adam.size() == 2)
		  {
			  if(getDegree(Adam.get(0)) >= 1 && getDegree(Adam.get(Adam.size()-1)) >= 1)
			  {
				  return true;
			  }
			  else
			  {
				  return false;
			  }
		  }
		  
		  //if graph has one vertex and multiple edges
		  else if( Adam.size() == 1 && getDegree(Adam.get(0)) > 0 )
		  {
			  return true;
		  }
		  
		  //see if head of the list is adjacent to the tail of the list
		  else if( Eve.contains(Adam.get(0)) == true)
		  {
		  		//if true, then return true
			  return true;
		  }
		  
			  


  //Returns:
  //true if there is a Hamiltonian cycle;
  //false otherwise
	  return hami;
  }
  
  
  
  
  

  /** Reorder the adjacency list in increasing order of degrees */
  private void reorderNeigborsBasedOnDegree(List<Integer> list) {
    for (int i = list.size() - 1; i >= 1; i--) {
      // Find the maximum in the list[0..i]
      int currentMaxDegree = getDegree(list.get(0));
      int currentMaxIndex = 0;

      for (int j = 1; j <= i; j++) {
        if (currentMaxDegree < getDegree(list.get(j))) { 
          currentMaxDegree = getDegree(list.get(j));
          currentMaxIndex = j;
        }
      }

      // Swap list[i] with list[currentMaxIndex] if necessary;
      if (currentMaxIndex != i) {
        int temp = list.get(currentMaxIndex);
        list.set(currentMaxIndex, list.get(i));
        list.set(i, temp);
      }
    }
  }
  
  /** Return true if all elements in array isVisited are true */
  private boolean allVisited(boolean[] isVisited) {
    boolean result = true;
    
    for (int i = 0; i < getSize(); i++) 
      result = result && isVisited[i];
    
    return result;
  }
  
  /** Search for a Hamiltonian path from v */
  private boolean getHamiltonianPath(int v, int[] next,
      boolean[] isVisited) {
    isVisited[v] = true; // Mark vertex v visited

    if (allVisited(isVisited)) 
      return true; // The path now includes all vertices, thus found
      
    for (int i = 0; i < neighbors[v].size(); i++) {
      int u = neighbors[v].get(i);
      if (!isVisited[u] && 
          getHamiltonianPath(u, next, isVisited)) {
        next[v] = u; // Edge (v, u) is in the path
        return true; 
      }
    }

    isVisited[v] = false; // Backtrack, v is marked unvisited now
    return false; // No Hamiltonian path exists from vertex v
  }


  

}