package org.macalester.edu.comp124.lists;


/**
 * An unfinished implementation of an array-based List.
 *
 * @author shilad
 * @param <E>
 */
public class MyArrayList<E> {
	/**
	 * The array elements
	 */
	private E elements[];
	
	/**
	 * The number of elements currently contained in the list.
	 */
	private int currentSize;

	/**
	 * Creates a new list.
	 */
	public MyArrayList() {
		clear();
	}
	
	/**
	 * Clears the contents of the array.
	 */
	public void clear() {
		elements = newArrayOfE(4);
		currentSize = 0;
	}
	
	/**
	 * Returns the current size of the list.
	 * @return
	 */
	public int size() {
		return currentSize;
	}
	
	/**
	 * Returns the element at position index.
	 * @param index
	 * @return
	 */
	public E get(int index) {
        return elements[index];    // replaced this line with hopefully the correct code
	}
	
	/**
	 * Adds a new element to the end of the list:
	 * 
	 * If the array is full, expand the array.
	 * Add the element to the first unused position in the array.
	 * Update the size of the array.
	 * 
	 * @param elem
	 */
	public void add(E elem) {
        if (this.currentSize < elements.length) {
            for(int i=0; i<elements.length; i++) {
                if (elements[i] == null) {
                    elements[currentSize] = elem;
                    currentSize++;
                    break;
                }
            }
        } else {
            expandSize();
            add(elem);
        }
	}

	/**
	 * Inserts a new element at the specified index.
	 * 
	 * If the array is full, expand the array.
	 * Slide the elements of the array starting with index over.
	 * Place the new element in the correct spot of the array.
	 * 
	 * Update the size of the array.
	 * 
	 * @param elem
	 */
	public void add(int index, E elem) {
        E[] elementsFromIndexToEnd = newArrayOfE(elements.length - index + 1); //dont think I need the +1

        if (this.currentSize + 1 < elements.length) {
            for(int i =index; i< elements.length; i++){
                elementsFromIndexToEnd[i-index] = elements[i];
            }

            elements[index] = elem;
            currentSize++;

            for(int i=index+1; i<elements.length; i++) {
                elements[i] = elementsFromIndexToEnd[i-index-1];
            }
        } else {
            expandSize();
            add(index,elem);
        }
	}
	
	/**
	 * Doubles the size of the array, copies the old elements
	 * into the new array, and updates elements to point to the
	 * new array.
	 * 
	 * This will be useful for both versions of add().
     * Hint: use newArrayOfE!
	 */
	private void expandSize() {
        E[] elementsNew = newArrayOfE(this.currentSize * 2);
        for (int i =0; i < elements.length; i++) {
            elementsNew[i] = elements[i];
        }

        elements = elementsNew;
	}
	
	/**
	 * Due to some crazy Java constraints, we can't simply create a
	 * new array of elements of class E.  We need to create an array
	 * of class Object and then cast the array to E.
	 * @param capacity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private E[] newArrayOfE(int capacity) {
		return (E[])new Object[capacity];
	}
}
