package homework12;

import java.util.*;

public class UnweightedGraph extends AbstractGraph {
  /** Construct a graph with the specified edges and vertices in 
   *  arrays
   */
  public UnweightedGraph(int[][] edges, Object[] vertices) {
    super(edges, vertices);
  }

  /** Construct a graph with the specified edges and vertices in 
   *  lists
   */
  public UnweightedGraph(List<Edge> edges, List vertices) {
    super(edges, vertices);
  }

  /** Construct a graph with the specified edges in a list and 
   *  the number of vertices 
   */
  public UnweightedGraph(List<Edge> edges, int numberOfVertices) {
    super(edges, numberOfVertices);
  }
  
  /** Construct a graph with the specified edges in an array and 
   *  the number of vertices 
   */
  public UnweightedGraph(int[][] edges, int numberOfVertices) {
    super(edges, numberOfVertices);
  }
}
