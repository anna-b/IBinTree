import java.util.Iterator;
import java.util.Stack;

public class TreeIterator<V> implements Iterator<V> {
	private Stack<Node<V>> unexplored;

	public TreeIterator(Node<V> root) {
		unexplored = new Stack<Node<V>>();
		Node<V> n = root;
		while(n != null) { // push left spine of tree onto stack
			unexplored.push(n);
			n = n.left;
		}
	}

	public boolean hasNext() {
		return !unexplored.isEmpty();
	}

	public V next() {
		Node<V> ret = unexplored.pop();
		Node<V> n = ret.right;
		while(n != null) {
			unexplored.push(n);
			n = n.left;
		}
		return ret.data;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}
