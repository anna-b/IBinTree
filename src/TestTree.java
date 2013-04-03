import java.util.Iterator;

import org.junit.*;

import static org.junit.Assert.*;

public class TestTree {
	IBinTreeImp<Integer> tree;		
	int[] input = new int[] { 8, 3, 3, 10, 1, 6, 14, 4, 4, 4, 7, 13 };
	
	
	@BeforeClass
	public static void oneTimeSetUp() {
		// one-time initialization code   
		System.out.println("@BeforeClass - oneTimeSetUp");
	}

	@AfterClass
	public static void oneTimeTearDown() {
		// one-time cleanup code
		System.out.println("@AfterClass - oneTimeTearDown");
	}

	@Before
	public void setUp() {
		tree = new IBinTreeImp<Integer>();		
		System.out.println("@Before - setUp");
	}
	
	@After
	public void tearDown() {
		System.out.println("@After - tearDown");		
	}

	@Test
	public void testTreeInsert() { 
		for (int i : input) {
			tree.insert(i);
		}
		
		assertTrue(tree.contains(14));
		assertFalse(tree.contains(2));
		assertFalse(tree.contains(1252));
		assertTrue(tree.contains(1));
		assertFalse(tree.contains(-1));		
		
		System.out.println("@Test - populate tree with values");
	}
	
	@Test
	public void testPrintOrder(){
		tree.printInOrder();
		tree.printPostOrder();
		tree.printPreOrder();
		
		System.out.println("@Test - print tree order");
	}
	
	@Test
	public void testNodeRemove(){
		int possibleToRemove = 55, impossibleToRemove = 33;
		tree.insert(possibleToRemove);
		assertTrue(tree.contains(possibleToRemove));
		tree.remove(possibleToRemove);
		assertFalse(tree.contains(possibleToRemove));
		
		assertFalse(tree.contains(impossibleToRemove));
		tree.remove(impossibleToRemove);
		assertFalse(tree.contains(impossibleToRemove));
		
		System.out.println("@Test - remove nodes from the tree");		
	}
	
	@Test 
	public void testTraverseWithIterator() {
		//traversing the tree with iterator	
		for(Iterator<Integer> treeIterator = tree.iterator(); treeIterator.hasNext(); ) {
			treeIterator.next();
		}
		
		System.out.println("@Test - traverse with iterator");		
	}
}