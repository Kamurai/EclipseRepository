package homework7;

/*
 * Finish the implementation of MyLinkedList (attached).
 *  Be sure to add in the pre-condition tests
 *   (see attached specification) Write a test program
 *   that thoroughly tests the class. Be sure to include
 *   all of the necessary positive & negative tests.
 *   After exchanging test programs with another student,
 *   follow the instructions for submitting an Eclipse program.
 */

public class MyLinkedListReference<E> extends MyAbstractList<E> {
	private Node<E> head, tail;

	/**
	 * Create an empty list
	 */
	public MyLinkedListReference() {
	}

	/** 
	 * Create a list from an array of objects
	 * @param objects
	 */
	public MyLinkedListReference(E[] objects) {
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
		
		if (index == 0) {
			addFirst(e);
		} else if (index >= size) {
			addLast(e);
		} else {
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
		if (index == 0) {
			return removeFirst();
		} else if (index == size - 1) {
			return removeLast();
		} else {
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
		locate(index).element = e;
		return e;
	}
	private Node<E> locate(int index) {
		if (index<0 ||index>=size) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> curr = head;
		for (int i = 0; i < index; i++) {
				curr = curr.next;
		}
		return curr;
	}
	

	private static class Node<E> {
		E element;
		Node<E> next;

		public Node(E element) {
			this.element = element;
		}
	}
}