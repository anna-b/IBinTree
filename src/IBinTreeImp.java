import java.util.Iterator;

public class IBinTreeImp<V extends Comparable<V>> implements IBinTree<V>{

	/** The root of the entire tree. 
	 */ 
	private Node<V> root; 

	public void IBinTree(){
		root = null;
	}

	@Override
	public void insert(V obj) {
		root = insert(root, obj);
	}

	private Node<V> insert(Node<V> node,V data){
		if(node == null){
			return node = new Node<V>(data,null,null);			
		}
		else{
			int cmp = data.compareTo(node.data);
			if (cmp < 0 ) 
				node.left = insert(node.left,data);
			else if (cmp > 0 )
				node.right = insert(node.right,data);
			else if (cmp == 0)
				node.data = data;
			node.count = 1 + size(node.left) + size(node.left);
			return node;
		}		
	}	

	@Override
	public boolean contains(V obj) {
		return contains(root,obj);		
	}

	private boolean contains(Node<V> node, V data){
		if (node == null)
			return false;
		else
			if (data.compareTo(node.data) == 0)
				return true;
			else if (data.compareTo(node.data) < 0)
				return contains(node.left, data);
			else
				return contains(node.right, data);
	}

	public void remove(V data)
	{
		root = remove(root, data);
	}
	private Node<V> remove(Node<V> node, V data)
	{
		if (node == null){
			//throw new RuntimeException("Impossible to remove: element is not in the tree");
			System.out.println("Impossible to remove: element is not in the tree");
			return node;
		}
		else if (data.compareTo(node.data) < 0)
			node.left = remove(node.left, data);
		else if (data.compareTo(node.data) > 0)
			node.right = remove(node.right, data);
		else
		{
			if (node.left == null)
				return node.right;
			else if (node.right == null)
				return node.left;
			else
			{
				Node<V> tmp = new Node<V>(retrieveData(node.left));
				tmp.left = remove(node.left, tmp.data) ;
				tmp.right = node.right;
				node = tmp;
			}
		}
		node.count = size(node.left) + size(node.right) + 1;
		return node;
	}

	private V retrieveData(Node<V> node)
	{
		while (node.right != null) node = node.right;
		return node.data;
	} 

	@Override
	public Iterator<V> iterator() {
		return new TreeIterator<V>(root);
	}

	public int size(){
		return (size(root));
	}

	private int size(Node<V> node) {
		//if(node == null) return 0;
		//else return node.count;
		if(node == null) return (0);
		else{
			return (size(node.left) + 1 +  size(node.right));
		}
	}

	public int height(){
		return height(root);
	}

	private int height(Node<V> node) {
		if(node == null) return 0;
		else return 1 + Math.max(height(node.left), height(node.right));
	}

	public void printInOrder(){
		printInOrder(root);
	}

	private void printInOrder(Node<V> node) {
		if (node != null) {
			printInOrder(node.left);
			System.out.print(" -> " + node.data);
			printInOrder(node.right);
		}
	}

	public void printPreOrder() {
		printPreOrder(root);
	}

	public void printPreOrder(Node<V> node) {
		if (node != null) {
			System.out.print(node.data + " -> ");
			printPreOrder(node.left);
			printPreOrder(node.right);            
		}
	}

	public void printPostOrder() {
		printPostOrder(root);
	}

	private void printPostOrder(Node<V> node) {
		if (node != null) {
			printPostOrder(node.left);
			printPostOrder(node.right);
			System.out.print(node.data + " -> ");
		}
	}


	//public Node<V> BreadthFirstTraversal(){
	//	Queue<Node<V>> queue = new LinkedList<Node<V>>();	        
	//	queue.add(root);	        
	//	while (queue.size() != 0){
	//		Node<V> current = queue.poll();	            
	//		if (current != null){
	//			queue.add(current.left);
	//			queue.add(current.right);	                
	//			return current;
	//		}
	//	}
	//	return root;
	//}

	//public Node<V> DepthFirstTraversal()
	//{
	//Stack<Node<V>> queue = new Stack<Node<V>>();	        
	//Node<V> current;	        
	//queue.push(root);	        
	//while (queue.size() != 0){
	//	current = queue.pop();	            
	//	if (current != null){
	//		queue.push(current.right);
	//		queue.push(current.left);	                
	//		return current;
	//	}
	//}
	//return root;
	//}

	//public void BalanceTree(){
	//	List<Node> listOfNodes = new List<Node>();        
    //	FillListInOrder(root, listOfNodes);
	//	RemoveChildren(listOfNodes);        
	//	root = null;
	//	int count = Count;
	//	Count = 0;        
	//	BalanceTree(0, count - 1, listOfNodes);
	//}

	//private void BalanceTree(int min, int max, 
	//		List<Node> list){
	//	if (min <= max)
	//	{
	//		int middleNode = (int)Math.ceil(((double)min + max) / 2);			            
	//		Insert(list[middleNode]);			            
	//		BalanceTree(min, middleNode - 1, list);			            
	//		BalanceTree(middleNode + 1, max, list);
	//	}            
	//}

	//private void FillListInOrder(Node<V> node, List<Node<V>>  list){
	//	if (node != null){
	//		FillListInOrder(node.left, list);			            
	//		list.add(node);			            
	//		FillListInOrder(node.right, list);
	//	}
	//}

	//private void RemoveChildren(List<Node<V>> list){
	//	foreach(Node<V> node in list){
	//		node.Left = null;
	//		node.Right = null;
	//	}
	//}





}



