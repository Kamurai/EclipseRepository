package homework8;

public class MyLinkedList<E> extends MyAbstractList<E> {
	private Node<E> head, tail;

	/**
	 * Create an empty list
	 */
	public MyLinkedList() {
	}

	/** 
	 * Create a list from an array of objects
	 * @param objects
	 */
	public MyLinkedList(E[] objects) {
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
		//link the new first node to the end of the list
		//newNode.previous = tail;
		newNode.previous = null;
		
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
		//link the new node with the tail
		newNode.previous = tail;
		//link the new last node to the beginning of the list
		//newNode.next = head;
		newNode.next = null;
		
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
//This method actually adds an element after the index by the original design
	public void add(int index, E e) throws IndexOutOfBoundsException {
		
		if (index == 0) {
			addFirst(e);
		} else if (index >= size) {
			addLast(e);
		} else {
			//find an the index to which to point
			Node<E> current = locate(index);
			//create a new node to insert
			Node<E> temp = new Node<E>(e);
			//connect temp's next to current's next
			temp.next = current.next;
			//connect current's next to temp
			current.next = temp;
			//connect the temp's next's previous to temp
			((current.next).next).previous = (current.next);
			//connect the temp's previous to current
			(current.next).previous = current;
			
			
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
			//attach head to end of list
			//head.previous = tail;
			head.previous = null;
			//tail.next = head;
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
			//attach tail to beginning of list
			//tail.next = head;
			tail.next = null;
			//head.previous = tail;
			
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
//This method actually removes the element after the index by the original design
	public E remove(int index) throws IndexOutOfBoundsException {
		if (index == 0) {
			return removeFirst();
		} else if (index == size - 1) {
			return removeLast();
		} else {
			//declare a node with target index
			Node<E> current = locate(index);
			//declare a node to be removed, which is current.next
			Node<E> removed = current.next;
			//set target index node's next to the node after the one to be removed
			current.next = removed.next;
			//set the next node's previous to current
			(current.next).previous = current;
			size--;
			return current.element;
		}
	}

	/**
	 * Overrides standard toString method
	 */
	public String toString() {
		//begin string
		StringBuilder result = new StringBuilder("[");

		//start point at head
		Node<E> current = head;
		for (int i = 0; i < size; i++) 
		{
			//add current element to end of string
			result.append(current.element);
			//if element is not the last element
			//if (current.next != head)
			if (current.next != null) 
			{
				//add comma
				result.append(", "); // Separate two elements with a comma
			}
			//move pointer to next element
			current = current.next;
			
		}
		//end string
		result.append("]"); // Insert the closing ] in the string
		
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
		Node<E> curr = tail;
		for (int i = size-1; i > -1; i--) {
			if (curr.element == e) {
				return i;
			}
			else
			{
				curr = curr.previous;
			}
		}
		return -1;
	}

	/**
	 * Change the element in the list at a specified location
	 * @param index The position of the element to change
	 * @param e New value for the element at that position
	 * @return The element being placed into the list
	 * @throws IndexOutOfBoundsException if index is negative or greater than the size of the list
	 */
	public E set(int index, E e) throws IndexOutOfBoundsException {
		locate(index).element = e;
		return e;
	}
	
	private Node<E> locate(int index) {
		if (index<0 ||index>=size) {
			throw new IndexOutOfBoundsException();
		}
		
		//declare pointer at head
		Node<E> curr = head;
		
		//if the target is before or at the midpoint
		if(index <= size/2)
		{
			//proceed to index before target
			for (int i = 0; i < index; i++) 
			{
				//record next index
				curr = curr.next;
			}
		}
		else if(index > size/2)
		{
			//start pointer at tail
			curr = tail;
			//proceed to index after target
			for (int i = size-1; i > index; i--)
			{
				//record previous
				curr = curr.previous;
			}
		}
		
		return curr;
	}
	

	private static class Node<E> {
		E element;
		Node<E> next;
		Node<E> previous;

		public Node(E element) {
			this.element = element;
		}
	}
}