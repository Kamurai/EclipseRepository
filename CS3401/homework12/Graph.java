package homework12;



public interface Graph {
  /** Return the number of vertices in the graph */
  public int getSize();

  /** Return the vertices in the graph */
  public Object[] getVertices();

  /** Return the object for the specified vertex index */
  public Object getVertex(int index);

  /** Return the index for the specified vertex object */
  public int getIndex(Object v);

  /** Return the neighbors of vertex v */
  public java.util.List getNeighbors(int v);

  /** Return the degree for a specified vertex */
  public int getDegree(int v);

  /** Return the adjacency matrix */
  public int[][] getAdjacencyMatrix();

  /** Print the adjacency matrix */
  public void printAdjacencyMatrix();

  /** Print the edges */
  public void printEdges();

  /** Obtain a depth-first search tree */
  public AbstractGraph.Tree dfs(int v);

  /** Obtain a breadth-first search tree */
  public AbstractGraph.Tree bfs(int v);
  
  /** Return a Hamiltonian path from the specified vertex object
   * Return null if the graph does not contain a Hamiltonian path */
  public java.util.List<Integer> getHamiltonianPath(Object vertex);

  /** Return a Hamiltonian path from the specified vertex label
   * Return null if the graph does not contain a Hamiltonian path */
  public java.util.List<Integer> getHamiltonianPath(int v); 
  
  public boolean isHamiltonianCycle(int v);
}
