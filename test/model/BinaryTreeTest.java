package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class BinaryTreeTest {

	private BinaryTree abb;

	public void emptyTree() {

		abb = new BinaryTree();
	}

	public void treeWithNodesIterative() {
		abb = new BinaryTree();

		abb.addIterative(0);
		abb.addIterative(-30);
		abb.addRecursive(-25);
		abb.addIterative(30);
		abb.addIterative(25);

	}

	public void treeWithMaxValuesIterative() {

		abb = new BinaryTree();

		abb.addIterative((long) 0);
		abb.addIterative(Long.MAX_VALUE);
		abb.addIterative(Long.MIN_VALUE);

	}

	public void treeWithNodesRecursive() {

		abb = new BinaryTree();

		abb.addRecursive(0);
		abb.addRecursive(-30);
		abb.addRecursive(-25);
		abb.addRecursive(30);
		abb.addRecursive(25);

	}

	@Test
	public void constructorTest() {

		BinaryTree abb = new BinaryTree();

		assertNull(abb.getRoot());

	}

	@Test
	public void addIterativeTest() {

		// Case 1

		treeWithNodesIterative();

		ArrayList<Long> AL = new ArrayList<Long>();
		AL.add((long) 0);
		AL.add((long) -30);
		AL.add((long) -25);
		AL.add((long) 30);
		AL.add((long) 25);

		assertEquals(AL.toString(), abb.preOrder().toString());

		// Case 2

		treeWithMaxValuesIterative();

		AL = new ArrayList<Long>();
		AL.add((long) 0);
		AL.add(Long.MIN_VALUE);
		AL.add(Long.MAX_VALUE);

		assertEquals(AL.toString(), abb.preOrder().toString());

	}

	@Test
	public void addRecursiveTest() {

		treeWithNodesRecursive();

		ArrayList<Long> AL = new ArrayList<Long>();
		AL.add((long) 0);
		AL.add((long) -30);
		AL.add((long) -25);
		AL.add((long) 30);
		AL.add((long) 25);

		assertEquals(AL.toString(), abb.preOrder().toString());

	}

	@Test
	public void queryIterativeTest() {

		treeWithNodesIterative();

		assertTrue(abb.queryIterative((long) 0));
		assertTrue(abb.queryIterative((long) -30));
		assertTrue(abb.queryIterative((long) 30));
		assertTrue(abb.queryIterative((long) 25));
		assertFalse(abb.queryIterative((long) -35));
		assertFalse(abb.queryIterative((long) 35));

	}

	@Test
	public void queryRecursiveTest() {

		treeWithNodesRecursive();

		assertTrue(abb.queryIterative((long) 0));
		assertTrue(abb.queryIterative((long) -30));
		assertTrue(abb.queryIterative((long) 30));
		assertTrue(abb.queryIterative((long) 25));
		assertFalse(abb.queryIterative((long) -35));
		assertFalse(abb.queryIterative((long) 35));

	}

	@Test
	public void maximumNodeTest() {

		treeWithNodesIterative();
		assertEquals((long) 30, abb.maximumNode(abb.getRoot()).getValue());

		emptyTree();
		assertNull(abb.maximumNode(abb.getRoot()));

	}

	@Test
	public void deleteIterativeTest() {

		// Case 1

		treeWithNodesIterative();

		ArrayList<Long> AL = new ArrayList<Long>();
		AL.add((long) 0);
		AL.add((long) -30);
		AL.add((long) 30);
		AL.add((long) 25);

		abb.deleteIterative((long) -25);
		assertEquals(AL.toString(), abb.preOrder().toString());

		// Case 2

		treeWithNodesIterative();

		AL = new ArrayList<Long>();
		AL.add((long) 0);
		AL.add((long) -30);
		AL.add((long) -25);
		AL.add((long) 25);

		abb.deleteIterative((long) 30);
		assertEquals(AL.toString(), abb.preOrder().toString());

		// Case 3

		treeWithNodesIterative();

		AL = new ArrayList<Long>();
		AL.add((long) -25);
		AL.add((long) -30);
		AL.add((long) 30);
		AL.add((long) 25);

		abb.deleteIterative((long) 0);
		assertEquals(AL.toString(), abb.preOrder().toString());

		// Case 4

		treeWithNodesIterative();

		AL = new ArrayList<Long>();
		AL.add((long) 0);
		AL.add((long) -30);
		AL.add((long) -25);
		AL.add((long) 30);
		AL.add((long) 25);

		abb.deleteIterative((long) 100);
		assertEquals(AL.toString(), abb.preOrder().toString());

	}

	@Test
	public void deleteRecursiveTest() {

		ArrayList<Long> AL = new ArrayList<Long>();

		// Case 1
		treeWithNodesIterative();
		AL = new ArrayList<Long>();
		AL.add((long) 0);
		AL.add((long) -30);
		AL.add((long) 30);
		AL.add((long) 25);

		abb.deleteRecursive((long) -25);
		assertEquals(AL.toString(), abb.preOrder().toString());

		// Case 2
		treeWithNodesIterative();
		AL = new ArrayList<Long>();
		AL.add((long) 0);
		AL.add((long) -30);
		AL.add((long) -25);
		AL.add((long) 25);

		abb.deleteRecursive((long) 30);
		assertEquals(AL.toString(), abb.preOrder().toString());

		// Case 3
		treeWithNodesIterative();
		AL = new ArrayList<Long>();
		AL.add((long) -25);
		AL.add((long) -30);
		AL.add((long) 30);
		AL.add((long) 25);

		abb.deleteRecursive((long) 0);
		assertEquals(AL.toString(), abb.preOrder().toString());

		// Case 4
		treeWithNodesIterative();
		AL = new ArrayList<Long>();
		AL.add((long) 0);
		AL.add((long) -30);
		AL.add((long) -25);
		AL.add((long) 30);
		AL.add((long) 25);

		abb.deleteRecursive((long) 100);
		assertEquals(AL.toString(), abb.preOrder().toString());

	}

}
