package tutorial3;


import java.util.EmptyStackException;


public class ArrayStack<E> implements Cloneable {

	private E[] data;
	private int manyItems;

	/**
	 * Initialize an empty stack with an initial capacity of 10. Note that the
	 * <CODE>push</CODE> method works efficiently (without needing more memory)
	 * until this capacity is reached. <b>Postcondition:</b> This stack is empty
	 * and has an initial capacity of 10.
	 * 
	 * @exception OutOfMemoryError
	 *                Indicates insufficient memory for:
	 *                <CODE>new Object[10]</CODE>.
	 **/
	public ArrayStack() {
		final int INITIAL_CAPACITY = 10;
		manyItems = 0;
		data = (E[]) new Object[INITIAL_CAPACITY];
	}

	/**
	 * Initialize an empty stack with a specified initial capacity. Note that
	 * the <CODE>push</CODE> method works efficiently (without needing more
	 * memory) until this capacity is reached.
	 * 
	 * @param initialCapacity
	 *            the initial capacity of this stack <b>Precondition:</b>
	 *            <CODE>initialCapacity</CODE> is non-negative.
	 *            <b>Postcondition:</b> This stack is empty and has the given
	 *            initial capacity.
	 * @exception IllegalArgumentException
	 *                Indicates that initialCapacity is negative.
	 * @exception OutOfMemoryError
	 *                Indicates insufficient memory for:
	 *                <CODE>new Object[initialCapacity]</CODE>.
	 **/
	public ArrayStack(int initialCapacity) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException("initialCapacity too small " + initialCapacity);
		manyItems = 0;
		data = (E[]) new Object[initialCapacity];
	}

	/**
	 * Generate a copy of this stack.
	 * 
	 * @return The return value is a copy of this stack. Subsequent changes to
	 *         the copy will not affect the original, nor vice versa.
	 * @exception OutOfMemoryError
	 *                Indicates insufficient memory for creating the clone.
	 **/
	public ArrayStack<E> clone() { // Clone an ArrayStack.
		ArrayStack<E> answer;

		try {
			answer = (ArrayStack<E>) super.clone();
		} catch (CloneNotSupportedException e) {
			// This exception should not occur. But if it does, it would
			// probably indicate a
			// programming error that made super.clone unavailable. The most
			// comon error
			// The most common error would be forgetting the "Implements
			// Cloneable"
			// clause at the start of this class.
			throw new RuntimeException("This class does not implement Cloneable");
		}

		answer.data = data.clone();

		return answer;
	}

	/**
	 * Change the current capacity of this stack.
	 * 
	 * @param minimumCapacity
	 *            the new capacity for this stack <b>Postcondition:</b> This
	 *            stack's capacity has been changed to at least
	 *            <CODE>minimumCapacity</CODE>. If the capacity was already at
	 *            or greater than <CODE>minimumCapacity</CODE>, then the
	 *            capacity is left unchanged.
	 * @exception OutOfMemoryError
	 *                Indicates insufficient memory for:
	 *                <CODE>new Object[minimumCapacity]</CODE>.
	 **/
	public void ensureCapacity(int minimumCapacity) {
		E biggerArray[];

		if (data.length < minimumCapacity) {
			biggerArray = (E[]) new Object[minimumCapacity];
			System.arraycopy(data, 0, biggerArray, 0, manyItems);
			data = biggerArray;
		}
	}

	/**
	 * Accessor method to get the current capacity of this stack. The
	 * <CODE>push</CODE> method works efficiently (without needing more memory)
	 * until this capacity is reached.
	 * 
	 * @return the current capacity of this stack
	 **/
	public int getCapacity() {
		return data.length;
	}

	/**
	 * Determine whether this stack is empty.
	 * 
	 * @return <CODE>true</CODE> if this stack is empty; <CODE>false</CODE>
	 *         otherwise.
	 **/
	public boolean isEmpty() {
		return (manyItems == 0);
	}

	/**
	 * Get the top item of this stack, without removing the item.
	 * <b>Precondition:</b> This stack is not empty.
	 * 
	 * @return the top item of the stack
	 * @exception EmptyStackException
	 *                Indicates that this stack is empty.
	 **/
	public E peek() {
		if (manyItems == 0)
			// EmptyStackException is from java.util and its constructor has no
			// argument.
			throw new EmptyStackException();
		return data[manyItems - 1];
	}

	/**
	 * Get the top item, removing it from this stack. <b>Precondition:</b> This
	 * stack is not empty.
	 * 
	 * @return The return value is the top item of this stack, and the item has
	 *         been removed.
	 * @exception EmptyStackException
	 *                Indicates that this stack is empty.
	 **/
	public E pop() {
		if (manyItems == 0)
			// EmptyStackException is from java.util and its constructor has no
			// argument.
			throw new EmptyStackException();
		return data[--manyItems];
	}

	/**
	 * Push a new item onto this stack. If the addition would take this stack
	 * beyond its current capacity, then the capacity is increased before adding
	 * the new item. The new item may be the null reference.
	 * 
	 * @param item
	 *            the item to be pushed onto this stack <b>Postcondition:</b>
	 *            The item has been pushed onto this stack.
	 * @exception OutOfMemoryError
	 *                Indicates insufficient memory for increasing the stack's
	 *                capacity. <b>Note:</b> An attempt to increase the capacity
	 *                beyond <CODE>Integer.MAX_VALUE</CODE> will cause the stack
	 *                to fail with an arithmetic overflow.
	 **/
	public void push(E item) {
		if (manyItems == data.length) {
			// Double the capacity and add 1; this works even if manyItems is 0.
			// However, in
			// case that manyItems*2 + 1 is beyond Integer.MAX_VALUE, there will
			// be an
			// arithmetic overflow and the bag will fail.
			ensureCapacity(manyItems * 2 + 1);
		}
		data[manyItems] = item;
		manyItems++;
	}

	/**
	 * Accessor method to determine the number of items in this stack.
	 * 
	 * @return the number of items in this stack
	 **/
	public int size() {
		return manyItems;
	}

	/**
	 * Reduce the current capacity of this stack to its actual size (i.e., the
	 * number of items it contains). <b>Postcondition:</b> This stack's capacity
	 * has been changed to its current size.
	 * 
	 * @exception OutOfMemoryError
	 *                Indicates insufficient memory for altering the capacity.
	 **/
	public void trimToSize() {
		E trimmedArray[];

		if (data.length != manyItems) {
			trimmedArray = (E[]) new Object[manyItems];
			System.arraycopy(data, 0, trimmedArray, 0, manyItems);
			data = trimmedArray;
		}
	}

	public int remainedCapacity() {

		return data.length - manyItems;
	}
}