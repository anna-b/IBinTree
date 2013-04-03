/*
 * An interface for a sorted binary tree.
 *
 * The interface provides methods for inserting values, checking if certain values are 
 * contained and iterating over the elements.
 * Note: Implementing classes should provide an iterator that traverse the inserted 
 * object in the sorted order.
 */
public interface IBinTree<V extends Comparable<V>> extends Iterable<V> {
	/*
	 * Insert an object into the binary tree. Note: The tree should be sorted, 
	 * inserting the same object twice is allowed but the insert is expected 
	 * to be stable.
	 */
	void insert(V obj);
	
	/*
	 * Check if the object is already in the tree. Return true if it is, 
	 * false otherwise.
	 */
	boolean contains(V obj);
	
	
} //End IBinTree interface
