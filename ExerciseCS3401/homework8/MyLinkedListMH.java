//Masom Hamadeh
//CS3401 HW#8

package homework8;

/**Homework #8: Doubly Linked List
 * Change MyLinkList.java from using a singly linked list to using a doubly linked list.  
 * Be sure to change the internal method locate to take advantageof this new structure.
 * Write a test program that thoroughly tests the class.  Be sure to include all of the 
 * necessary tests.*/

/**Taken out of book for my benefit:
 * A doubly linked list contains the nodes with two pointers.  One points to the next 
 * node and the other points to the previous node.  The two pointers are conveniently 
 * called a forward/backward pointer.  So, a doubly linked list can be traversed both
 * forward and backwards.
 */
 
public class MyLinkedListMH<E> extends MyAbstractList<E> {
	private Node<E> head, tail;

	//create an empty list
	//NOTE: this linked list will be formatted to work with double linked lists
	public MyLinkedListMH() {
	}

	/** 
	 * Create a list from an array of objects
	 * @param objects
	 */
	public MyLinkedListMH(E[] objects) {
		super(objects);
	}

	/** 
	 * Get first element in the list
	 * @return the first element
	 */
	public E getFirst() {
		if (size == 0) {
			return null;
		} else {
			return head.element;
		}
	}

	/** 
	 * Get the last element in the list
	 * @return the last element of the list
	 */
	public E getLast() {
		if (size == 0) {
			return null;
		} else {
			return tail.element;
		}
	}

	/** 
	 * Add an element at the beginning of the list
	 * @param e element to add to list
	 */
	public void addFirst(E e) {
		Node<E> newNode = new Node<E>(e); // Create a new node
		newNode.next = head; // link the new node with the head
		head = newNode; // head points to the new node
		size++; // Increase list size

		if (tail == null) // the new node is the only node in list
			tail = head;
	}

	/** 
	 * Add an element to the end of the list
	 * @param e element to add to list
	 */
	public void addLast(E e) {
		Node<E> newNode = new Node<E>(e); // Create a new for element e

		if (tail == null) {
			head = tail = newNode; // The new node is the only node in list
		} else {
			tail.next = newNode; // Link the new with the last node
			tail = tail.next; // tail now points to the last node
		}
		size++; // Increase size
	}

	/** 
	 * Add an element to the list at the specified position
	 * @param index position to add new element. First position = 0
	 * @param e Element to add to the list
	 * @throws IndexOutOfBoundsException if index is negative
	 */
	public void add(int index, E e) throws IndexOutOfBoundsException {
	//addition of the thrown exception based on design contract
		if (index < 0){
			throw new IndexOutOfBoundsException();
		}
		else if (index == 0) {
			addFirst(e);
		} 
		else if (index >= size) {
			addLast(e);
		}
		else {
//Make sure you connect the .previous links as well
			Node<E> current = locate(index);
			Node<E> temp = current.next;
			current.next = new Node<E>(e);
			(current.next).next = temp;
			size++;
		}
	}

	/**
	 * Removes first element from the list
	 * @return Element that was first
	 */
	public E removeFirst() {
		if (size == 0) {
			return null;
		} else {
			E temp = head.element;
			head = head.next;
			size--;
			if (head == null) {
				tail = null;
			}
			return temp;
		}
	}

	/**
	 * Removes the last element from the last
	 * @return element that was last
	 */
	public E removeLast() {
		if (size == 0) {
			return null;
		} 
		E temp = head.element;
		if (size == 1) {
			head = tail = null;
		} else {
			Node<E> current = locate(size-2);
			tail = current;
			tail.next = null;
		}
		size--;
		return temp;
	}

	/**
	 * Remove an element at the specified position
	 * @param index position of the specified element
	 * @return The element that was removed
	 * @throws IndexOutOfBoundsException if index is negative or greater than the size of the list
	 */
	public E remove(int index) throws IndexOutOfBoundsException {
	//addition of the thrown exception based on design contract
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		else if (index == 0) {
			return removeFirst();
		} 
		else if (index == size - 1) {
			return removeLast();
		} 
		else {
			Node<E> previous = locate(index);
			Node<E> current = previous.next;
			previous.next = current.next;
			size--;
			return current.element;
		}
	}

	/**
	 * Overrides standard toString method
	 */
	public String toString() {
		StringBuilder result = new StringBuilder("[");

		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			result.append(current.element);
			current = current.next;
			if (current != null) {
				result.append(", "); // Separate two elements with a comma
			} else {
				result.append("]"); // Insert the closing ] in the string
			}
		}

		return result.toString();
	}

	/**
	 * Clears the list
	 */
	public void clear() {
		head = tail = null;
		size = 0;
	}

	/**
	 * Determines if the specified element is in the list
	 * @param e Element to search for
	 * @return true if the element is in the list; false otherwise
	 */
	public boolean contains(E e) {
		return (indexOf(e) > -1);
	}

	/**
	 * Get the element at the specified index
	 * @param index position of the specified element
	 * @return The specified element
	 * @throws IndexOutOfBoundsException if index is negative or greater than the size of the list
	 */
	public E get(int index) {
	//same as return method, it'll throw exception based on preconditions
		return locate(index).element;
	}

	/**
	 * Determine the first index of an element in the list
	 * @param e The element to look for
	 * @return the index of the element if it is in the list; -1 otherwise
	 */
	public int indexOf(E e) {
		Node<E> curr = head;
		for (int i = 0; i < size; i++) {
			if (curr.element == e) {
				return i;
			} else {
				curr = curr.next;
			}
		}
		return -1;
	}
	/**
	 * Determine the last index of an element in the list
	 * @param e The element to look for
	 * @return the index of the element if it is in the list; -1 otherwise
	 */
	public int lastIndexOf(E e) {
		int index = -1;
		Node<E> curr = head;
		for (int i = 0; i < size; i++) {
			if (curr.element == e) {
				index = i;
			}
			curr = curr.next;
		}
		return index;
	}

	/**
	 * Change the element in the list at a specified location
	 * @param index The position of the element to change
	 * @param e New value for the element at that position
	 * @return The element being placed into the list
	 * @throws IndexOutOfBoundsException if index is negative or greater than the size of the list
	 */
	public E set(int index, E e) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}
		else {
			locate(index).element = e;
			return e;
		}
	}
	
	/**This is where the meat of the homework is, we need to make sure to
	 * make this internal method be as efficient as possible and for it to
	 * take advantage of the doubly linked structure.
	 */ 
	private Node<E> locate(int index) throws IndexOutOfBoundsException {
		if (index<0 ||index>=size) {
			throw new IndexOutOfBoundsException();
		}
	//addition of efficiency code with TWO cases: 1)if index is in first half and 2) if index is in second half
		int z = size/2;
		if (index <= z) { //if the index is located in first half list, will traverse the first half only
			Node<E> curr = head;
//you actually need to stop at the index, not z
			for (int i = 0; i < index; i++) {
					curr = curr.next;
			}
			return curr;
		}
//you could make this an else instead of an else if
//you know that index is in-bounds and that it'll be in one half or the other of the array
		else // if (index > z) 
		{ //if the index is located in back half, it will traverse backwards for efficiency
//the pointer starts at the tail, not the midpoint
			Node<E> backwards = tail;
//what this loop says is: "Start from 1 past the endpoint while at 1 past the midpoint and go backwards to 0"
//needs to start at endpoint and roll back to index     for (int j = size; j == z+1; j--){ //it wills tart
			for (int j = size-1; j > index; j--){ //it wills tart
//the pointer moves forward while the loop is moving backwards
				backwards = backwards.previous; //?? I know this doesn't sound right
			}
			return backwards;
		}
		//I dont know what I should return here??
//you could set up the node to initialize before the if statements and
//then define it as the tail if index is not <= z
//then you always return the new node at the end of your if statements
	}
	

	private static class Node<E> {
		E element;
		Node<E> next;
//need to add a previous node here
		Node<E> previous;

		public Node(E element) {
			this.element = element;
		}
	}
}