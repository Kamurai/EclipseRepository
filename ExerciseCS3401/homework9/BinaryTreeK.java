package homework9;

import java.util.*;

/*
 Change BinaryTree.java to add the countLeaves and breadthFirst methods
 described in the attached specification. Write a test program that
 thoroughly tests the class. Be sure to include all of the necessary 
 positive & negative tests. After exchanging test programs with
 another student, follow the instructions for 
 submitting an Eclipse program.
 
 */

public class BinaryTreeK<E extends Comparable<E>> 
    extends AbstractTree<E> {
  protected TreeNode<E> root;

  protected int size = 0;

  /** Create a default binary tree */
  public BinaryTreeK() {
  }

  /** Create a binary tree from an array of objects */
  public BinaryTreeK(E[] objects) {
    for (int i = 0; i < objects.length; i++)
      insert(objects[i]);
  }

  /** Returns true if the element is in the tree */
  public boolean search(E e) {
    TreeNode<E> current = root; // Start from the root

    while (current != null) {
      if (e.compareTo(current.element) < 0) {
        current = current.left;
      } else if (e.compareTo(current.element) > 0) {
        current = current.right;
      } else
        // element matches current.element
        return true; // Element is found
    }

    return false;
  }

  /**
   * Insert element o into the binary tree Return true if the element is
   * inserted successfully
   */
  public boolean insert(E e) {
    if (root == null)
      root = createNewNode(e); // Create a new root
    else {
      // Locate the parent node
      TreeNode<E> parent = null;
      TreeNode<E> current = root;
      while (current != null)
    	  //if e is less than current element
        if (e.compareTo(current.element) < 0) {
          //focus on the current element as the parent
          parent = current;
          //proceed to the left child
          current = current.left;
        }//else if e is more than the current element 
        else if (e.compareTo(current.element) > 0) {
          //focus on the current element as the parent
          parent = current;
          //proceed to the right child
          current = current.right;
        } else
          return false; // Duplicate node not inserted

      // Create the new node and attach it to the parent node
      if (e.compareTo(parent.element) < 0)
        parent.left = createNewNode(e);
      else
        parent.right = createNewNode(e);
    }

    size++;
    return true; // Element inserted
  }

  protected TreeNode<E> createNewNode(E e) {
    return new TreeNode<E>(e);
  }

  /** Inorder traversal from the root */
  public void inorder() {
    inorder(root);
  }

  /** Inorder traversal from a subtree */
  protected void inorder(TreeNode<E> root) {
    if (root == null)
      return;
    inorder(root.left);
    System.out.print(root.element + " ");
    inorder(root.right);
  }

  /** Postorder traversal from the root */
  public void postorder() {
    postorder(root);
  }

  /** Postorder traversal from a subtree */
  protected void postorder(TreeNode<E> root) {
    if (root == null)
      return;
    postorder(root.left);
    postorder(root.right);
    System.out.print(root.element + " ");
  }

  /** Preorder traversal from the root */
  public void preorder() {
    preorder(root);
  }

  /** Preorder traversal from a subtree */
  protected void preorder(TreeNode<E> root) {
    if (root == null)
      return;
    System.out.print(root.element + " ");
    preorder(root.left);
    preorder(root.right);
  }

  /** Inner class tree node */
  public static class TreeNode<E extends Comparable<E>> {
    E element;

    TreeNode<E> left;

    TreeNode<E> right;

    public TreeNode(E e) {
      element = e;
    }
  }

  /** Get the number of nodes in the tree */
  public int getSize() {
    return size;
  }

  /** Returns the root of the tree */
  public TreeNode getRoot() {
    return root;
  }

  /** Returns a path from the root leading to the specified element */
  public java.util.ArrayList<TreeNode<E>> path(E e) {
    java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<TreeNode<E>>();
    TreeNode<E> current = root; // Start from the root

    while (current != null) {
      list.add(current); // Add the node to the list
      if (e.compareTo(current.element) < 0) {
        current = current.left;
      } else if (e.compareTo(current.element) > 0) {
        current = current.right;
      } else
        break;
    }

    return list; // Return an array of nodes
  }

  /**
   * Delete an element from the binary tree. Return true if the element is
   * deleted successfully Return false if the element is not in the tree
   */
  public boolean delete(E e) {
    // Locate the node to be deleted and also locate its parent node
    TreeNode<E> parent = null;
    TreeNode<E> current = root;
    while (current != null) {
      if (e.compareTo(current.element) < 0) {
        parent = current;
        current = current.left;
      } else if (e.compareTo(current.element) > 0) {
        parent = current;
        current = current.right;
      } else
        break; // Element is in the tree pointed by current
    }

    if (current == null)
      return false; // Element is not in the tree

    // Case 1: current has no left children
    if (current.left == null) {
      // Connect the parent with the right child of the current node
      if (parent == null) {
        root = current.right;
      } else {
        if (e.compareTo(parent.element) < 0)
          parent.left = current.right;
        else
          parent.right = current.right;
      }
    } else {
      // Case 2: The current node has a left child
      // Locate the rightmost node in the left subtree of
      // the current node and also its parent
      TreeNode<E> parentOfRightMost = current;
      TreeNode<E> rightMost = current.left;

      while (rightMost.right != null) {
        parentOfRightMost = rightMost;
        rightMost = rightMost.right; // Keep going to the right
      }

      // Replace the element in current by the element in rightMost
      current.element = rightMost.element;

      // Eliminate rightmost node
      if (parentOfRightMost.right == rightMost)
        parentOfRightMost.right = rightMost.left;
      else
        // Special case: parentOfRightMost == current
        parentOfRightMost.left = rightMost.left;
    }

    size--;
    return true; // Element inserted
  }

  /** Obtain an iterator. Use inorder. */
  public java.util.Iterator iterator() {
    return inorderIterator();
  }

  /** Obtain an inorder iterator */
  public java.util.Iterator inorderIterator() {
    return new InorderIterator();
  }

  // Inner class InorderIterator
  class InorderIterator implements java.util.Iterator {
    // Store the elements in a list
    private java.util.ArrayList<E> list = new java.util.ArrayList<E>();

    private int current = 0; // Point to the current element in list

    public InorderIterator() {
      inorder(); // Traverse binary tree and store elements in list
    }

    /** Inorder traversal from the root */
    private void inorder() {
      inorder(root);
    }

    /** Inorder traversal from a subtree */
    private void inorder(TreeNode<E> root) {
      if (root == null)
        return;
      inorder(root.left);
      list.add(root.element);
      inorder(root.right);
    }

    /** Next element for traversing? */
    public boolean hasNext() {
      if (current < list.size())
        return true;

      return false;
    }

    /** Get the current element and move cursor to the next */
    public Object next() {
      return list.get(current++);
    }

    /** Remove the current element and refresh the list */
    public void remove() {
      delete(list.get(current)); // Delete the current element
      list.clear(); // Clear the list
      inorder(); // Rebuild the list
    }
  }

  /** Remove all elements from the tree */
  public void clear() {
    root = null;
    size = 0;
  }
  
  //breadthFirst
  public String breadthFirst()
  {
	  if(root == null)
	  {
		  return "";
	  }
	  
	  String result = "";
	  //Produces a list of elements in a Tree in breadth first order 
	  
	  //could use LinkedList of TreeNodes to process breadth
		  	LinkedList<TreeNode<E>> checkers = new LinkedList<TreeNode<E>>();
		  	//add one when needed
		  	checkers.add(0, root);
		  
		//search while there are still valid trees to search
		  	//create helper method to test to see if there is still a valid TreeNode in the ArrayList
		  		//while this helper method returns true, continuing looping
		  do
		  {
			  //for each checker
			  for(int x = 0; x < checkers.size(); x++)
			  {
				//record current checkers
				  
				result += checkers.get(x).element + ",";
				
			  	//check for left and right
					//if left exists
				if(checkers.get(x).left != null)
				{
					//create another if needed
					if(checkers.get(x).right != null)
					{
						//then add it to the next position on the list
						checkers.add(x+1, checkers.get(x).right);
						//increment x past the new checker
						x++;
						//redirect to left
						checkers.set(x-1, checkers.get(x-1).left);
					}
					else
					{
						//redirect to left
						checkers.set(x, checkers.get(x).left);
					}
					
								
				}
				else if(checkers.get(x).right != null)
				{
					//redirect to right
					checkers.set(x, checkers.get(x).right);
				}
				else
				{
					checkers.remove(x);
					x--;
				}
				
			  }
			  
			  
			  
			  
		  }
		  while(stillchecking(checkers) == true);
			  
		  for(int x = 0; x < checkers.size(); x++)
		  {
			  
		  	//record current checkers
			result += checkers.get(x).element;
			if(x != checkers.size()-1)
			{
				result += ",";
			}
		  }
		
		  
		  if(result.equals(""))
		  {
			  result = "0";
		  }

	//Returns:
	  //A string containing the tree elements, with elements separated by comma (e.g. "a,b,c").
	  //if the Tree has no nodes, then Return the empty string.
	  return result;
  }

  private boolean stillchecking(LinkedList<TreeNode<E>> list)
  {
	  for(int x = 0; x < list.size(); x++)
	  {
		  //if there is something to check
		  if(list.get(x).left != null || list.get(x).right != null)
		  {
			 return true; 
		  }
	  }
	  
	  return false;
  }
  

  //countLeaves
  public int countLeaves()
  {
	  //Counts the number of leaves in a Tree (node that has NO children)
  
	  if(root == null)
	  {
		  return 0;
	  }
	  
	  int count = 0;
		//could use LinkedList of TreeNodes to process breadth
		  	LinkedList<TreeNode<E>> checkers = new LinkedList<TreeNode<E>>();

		  	//add one when needed
		  	checkers.add(0, root);
	    
		//search while there are still valid trees to search
		  	//create helper method to test to see if there is still a valid TreeNode in the ArrayList
		  		//while this helper method returns true, continuing looping
		  do
		  {
			  //for each checker
			  for(int x = 0; x < checkers.size(); x++)
			  {
				//check for left and right
					//if left exists
				if(checkers.get(x).left != null)
				{
					//create another if needed
					if(checkers.get(x).right != null)
					{
						//then add it to the next position on the list
						checkers.add(x+1, checkers.get(x).right);
						//increment x past the new checker
						x++;
						//redirect to left
						checkers.set(x-1, checkers.get(x-1).left);
					}
					else
					{
						//redirect to left
						checkers.set(x, checkers.get(x).left);
					}
					
								
				}
				else if(checkers.get(x).right != null)
				{
					//redirect to right
					checkers.set(x, checkers.get(x).right);
				}
				
				
			  }
			  
		  }
		  while(stillchecking(checkers) == true);
			  
		  count = checkers.size();
		  
		  
	 //Returns:
	  //the number of leaves
	  return count;
  }
  
}