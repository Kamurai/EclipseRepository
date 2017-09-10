//Masom Hamadeh
//CS3401 HW#11

package homework12;
import java.util.*;
/*
public abstract class AbstractGraphMH implements Graph {
  protected Object[] vertices; // Store vertices
  protected List<Integer>[] neighbors; // Adjacency lists

  /** Construct a graph from edges and vertices stored in arrays ---
  protected AbstractGraphMH(int[][] edges, Object[] vertices) {
    this.vertices = vertices;
    createAdjacencyLists(edges, vertices.length);
  }

  /** Construct a graph from edges and vertices stored in ArrayList ---
  protected AbstractGraphMH(List<Edge> edges, List vertices) {
    this.vertices = vertices.toArray();
    createAdjacencyLists(edges, vertices.size());
  }

  /** Construct a graph from edges and vertices in ArrayList ---
  protected AbstractGraphMH(List<Edge> edges, int numberOfVertices) {
    vertices = new Integer[numberOfVertices]; // Create vertices
    for (int i = 0; i < numberOfVertices; i++) {
      vertices[i] = new Integer(i); // vertices is {0, 1, 2, ...}
    }
    createAdjacencyLists(edges, numberOfVertices);
  }

  /** Construct a graph from edges in array ---
  protected AbstractGraphMH(int[][] edges, int numberOfVertices) {
    vertices = new Integer[numberOfVertices]; // Create vertices
    for (int i = 0; i < numberOfVertices; i++) {
      vertices[i] = new Integer(i); // vertices is {0, 1, 2, ...}
    }
    createAdjacencyLists(edges, numberOfVertices);
  }

  /** Create adjacency lists for each vertex ---
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

  /** Create adjacency lists for each vertex ---
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

  /** Return the number of vertices in the graph ---
  public int getSize() {
    return vertices.length;
  }

  /** Return the vertices in the graph ---
  public Object[] getVertices() {
    return vertices;
  }

  /** Return the object for the specifed vertex ---
  public Object getVertex(int v) {
    return vertices[v];
  }

  /** Return the index for the specified vertex object ---
  public int getIndex(Object vertex) {
    for (int i = 0; i < getSize(); i++) {
      if (vertex.equals(vertices[i])) {
        return i;
      }
    }

    return -1; // If vertex is not in the graph
  }

  /** Return the neighbors of vertex v ---
  public List getNeighbors(int v) {
    return neighbors[v];
  }

  /** Return the degree for a specified vertex ---
  public int getDegree(int v) {
    return neighbors[v].size();
  }

  /** Return the adjacency matrix ---
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

  /** Print the adjacency matrix ---
  public void printAdjacencyMatrix() {
    int[][] adjacencyMatrix = getAdjacencyMatrix();
    for (int i = 0; i < adjacencyMatrix.length; i++) {
      for (int j = 0; j < adjacencyMatrix[0].length; j++) {
        System.out.print(adjacencyMatrix[i][j] + " ");
      }

      System.out.println();
    }
  }

  /** Print the edges ---
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
  
  /******************************************************************************************
   * Homework #11: Add getConnectedComponents() method
   * Method: gets a list of the connected components in this graph
   * Returns: A List of connected Components (each list item is itself a List of the nodes in that component)
   *****************************************************************************************---
  public List<List<Integer>> getConnectedComponents(){
	  
	  List<List<Integer>> parent = new LinkedList<List<Integer>>(); //create the head list to keep track of other lists
	  List<Integer> child = new LinkedList<Integer>(); //list of the integer components for building
	  
	  int [] tracker = new int [getSize()]; //list for tracking
	  
	 //we now need to make all the elements -1 stating they have NOT been visited yet
	  for (int index = 0; index < tracker.length; index++){
		  tracker [index] = -1;
	  }
	  
	  //create our tree to traverse
	  Tree cTree;
	  
	  //check to see if specific elements have been traversed by comparing -1 or some other number
	  for (int x = 0; x < tracker.length; x++){
		  if (tracker[x] == -1){
			  cTree = dfs(x); //traverse the tree using depth first search
			  child = new LinkedList<Integer>(cTree.searchOrders);
			  
			  //updates element traversal key
			  for (int z = 0; z < child.size(); z++){
				  tracker[child.get(z)] = 0;
			  }
			  
			  parent.add(child); //adds the search order list to the list of lists
		  }
	  }
	  
	  return parent; //Method return: the List of Lists
  }
  
  /******************************************************************************************
   * Homework #11: Add isCycle() method
   * Method: determines if the graph contains a cycle
   * Returns: TRUE if there is a cycle; false otherwise
   *****************************************************************************************---
  public boolean isCycle(){
	  //automatically set to false, presumed false until PROVEN true (has cycle)
	  boolean checker = false;
	  List<List<Integer>> parent = getConnectedComponents(); //use previous method to walk through the graph and get a LinkedList of its lists
	  List<Integer> child = new LinkedList<Integer>();
	  List<Integer> neighbors = new LinkedList<Integer>();
	  
	  //now walk thru the parent
	  for (int x = 0; x < parent.size(); x++){
		  child = new LinkedList(parent.get(x));
		  neighbors = new LinkedList(getNeighbors(child.get(child.size()-1))); // list of neighbors OF LAST ELEMENT
		  
		  //now it checks to see if the neighbors of the last element include the starting element, then we know we have a cycle
		  //however there is another checker to make sure that the child list is larger than two, b/c you can't have a cycle with 2 or less vertices
		  if (child.size() <= 1){
			  checker = false;
		  }
		  else if (child.size() > 2 && neighbors.contains(child.get(0)) == true){
			  checker = true;
		  }
	  }
	  return checker; //if program doesn't go through loop then we know that it is not Cyclic
  }
  
  /*****************************************************************************************
   * Homework #12: Add isHamiltonianCycle() method
   * (def): Hamiltonian path that visits every vertex exactly once (except for starting/ending vertex
   * Method: Determines if there is a Hamiltonian cycle in this graph
   * Return: true if there is a Hamiltonian cycle; false otherwise
   ***************************************************************************************---
  public boolean isHamiltonianCycle(int v){
	  boolean checker = false; //similar to previously written method - automatically set to false
	  List<List<Integer>> parent = getConnectedComponents(); //get main list of lists with the connected components
	  List<Integer> tester = null; //create a tester sublist 
	  
	  for (int x = 0; x < parent.size(); x++){
		  tester = new LinkedList(parent.get(x)); //fill out with parent list 
	  }
	  
	  tester = getHamiltonianPath(v); //use the method in tree to return a list of paths
	  
	  if (tester != null){ //if it returns a path and NOT null then there is a ham path
		  //now to see if there is a cycle - tests last index with first index
		  if (tester.get(0) == tester.get(tester.size()-1)){
			  checker = true;
		  }
		  else{
			  checker = false;
		  }
	  }
	  return checker;
  }

  /** Edge inner class inside the AbstractGraphMH class ---
  public static class Edge {
    public int u; // Starting vertex of the edge
    public int v; // Ending vertex of the edge

    /** Construct an edge for (u, v) ---
    public Edge(int u, int v) {
      this.u = u;
      this.v = v;
    }
  }

  /** Obtain a DFS tree starting from vertex v ---
  /** To be discussed in Section 27.6 ---
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

  /** Recursive method for DFS search ---
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

  /** Starting bfs search from vertex v ---
  /** To be discussed in Section 27.7 ---
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

  /** Tree inner class inside the AbstractGraphMH class ---
  /** To be discussed in Section 27.5 ---
  public class Tree {
    private int root; // The root of the tree
    private int[] parent; // Store the parent of each vertex
    private List<Integer> searchOrders; // Store the search order

    /** Construct a tree with root, parent, and searchOrder ---
    public Tree(int root, int[] parent, List<Integer> searchOrders) {
      this.root = root;
      this.parent = parent;
      this.searchOrders = searchOrders;
    }

    /** Construct a tree with root and parent without a
     *  particular order ---
    public Tree(int root, int[] parent) {
      this.root = root;
      this.parent = parent;
    }

    /** Return the root of the tree ---
    public int getRoot() {
      return root;
    }

    /** Return the parent of vertex v ---
    public int getParent(int v) {
      return parent[v];
    }

    /** Return an array representing search order ---
    public List<Integer> getSearchOrders() {
      return searchOrders;
    }

    /** Return number of vertices found ---
    public int getNumberOfVerticesFound() {
      return searchOrders.size();
    }

    /** Return the iterator for a path starting from the root to v ---
    public Iterator pathIterator(int v) {
      return new PathIterator(v);
    }

    /** PathIterator inner class inside the tree ---
    public class PathIterator implements java.util.Iterator {
      private Stack<Integer> stack;

      /** Construct an iterator for the vertices on the path ---
      public PathIterator(int v) {
        stack = new Stack<Integer>();
        do {
          stack.add(v);
          v = parent[v];
        }
        while (v != -1);
      }

      /** Has next element in the iterator? ---
      public boolean hasNext() {
        return !stack.isEmpty();
      }

      /* Get the current element in the iterator and move the
       * iterator to point to the next element ---
      public Object next() {
        return vertices[stack.pop()];
      }

      /* This remove method is defined in the Iterator interface
       * Do not implement it ---
      public void remove() {
        // Do nothing
      }
    }

    /** Print a path from the root to vertex v ---
    public void printPath(int v) {
      Iterator iterator = pathIterator(v);
      System.out.print("A path from " + vertices[root] + " to " +
        vertices[v] + ": ");
      while (iterator.hasNext()) {
        System.out.print(iterator.next() + " ");
      }
    }

    /** Print the whole tree ---
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
   * Return null if the graph does not contain a Hamiltonian path ---
  public List<Integer> getHamiltonianPath(Object vertex) {
    return getHamiltonianPath(getIndex(vertex));
  }

  /** Return a Hamiltonian path from the specified vertex label
   * Return null if the graph does not contain a Hamiltonian path ---
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

  /** Reorder the adjacency list in increasing order of degrees ---
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
  
  /** Return true if all elements in array isVisited are true ---
  private boolean allVisited(boolean[] isVisited) {
    boolean result = true;
    
    for (int i = 0; i < getSize(); i++) 
      result = result && isVisited[i];
    
    return result;
  }
  
  /** Search for a Hamiltonian path from v ---
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
}*/