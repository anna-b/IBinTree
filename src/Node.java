public final class Node<V>{
	public Node<V> left;
	public Node<V> right;
	public V data;
	public int count;
	
	public Node(V newData) {
		left = null;
		right = null;
		data = newData;
		count = 1;
	}

	public Node(V newData, Node<V> l, Node<V> r) {
		this.data = newData; 
		this.left = l; 
		this.right = r;
		this.count = 1;
	}
}