package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class LinkedListTest {

	private LinkedList ll;

	public void emptyLinkedList() {
		ll = new LinkedList();
	}

	public void iterativeLinkedList() {
		ll = new LinkedList();
		ll.addIterative(Long.MIN_VALUE);
		ll.addIterative((long) 0);
		ll.addIterative(Long.MAX_VALUE);
	}

	public void recursiveLinkedList() {
		ll = new LinkedList();
		ll.addRecursive(Long.MIN_VALUE);
		ll.addRecursive((long) 0);
		ll.addRecursive(Long.MAX_VALUE);
	}

	@Test
	public void LinkedListConstructorTest() {

		emptyLinkedList();

		assertNull(ll.getFirst());
	}

	@Test
	public void addIterativeTest() {

		// Case 1
		iterativeLinkedList();

		ArrayList<Long> list = new ArrayList<Long>();
		list.add(Long.MIN_VALUE);
		list.add((long) 0);
		list.add(Long.MAX_VALUE);

		assertEquals(list, ll.getLinkedList());

	}

	@Test
	public void addRecursiveTest() {

		recursiveLinkedList();

		ArrayList<Long> list = new ArrayList<Long>();
		list.add(Long.MIN_VALUE);
		list.add((long) 0);
		list.add(Long.MAX_VALUE);

		assertEquals(list, ll.getLinkedList());

	}

	@Test
	public void deleteIterative() {

		iterativeLinkedList();

		ArrayList<Long> list = new ArrayList<Long>();

		ll.deleteIterative(Long.MAX_VALUE);
		ll.deleteIterative(Long.MIN_VALUE);
		ll.deleteIterative((long) 0);

		assertEquals(list, ll.getLinkedList());

		// Case 2
		iterativeLinkedList();

		list = new ArrayList<Long>();
		list.add(Long.MIN_VALUE);
		list.add((long) 0);
		list.add(Long.MAX_VALUE);

		ll.deleteIterative((long) 50);

		assertEquals(list, ll.getLinkedList());

	}

	@Test
	public void deleteRecursive() {

		// Case 1

		iterativeLinkedList();

		ArrayList<Long> list = new ArrayList<Long>();

		ll.deleteRecursive(Long.MAX_VALUE);
		ll.deleteRecursive(Long.MIN_VALUE);
		ll.deleteRecursive((long) 0);

		assertEquals(list, ll.getLinkedList());

		// Case 2
		iterativeLinkedList();

		list = new ArrayList<Long>();
		list.add(Long.MIN_VALUE);
		list.add((long) 0);
		list.add(Long.MAX_VALUE);

		ll.deleteRecursive((long) 50);

		assertEquals(list, ll.getLinkedList());
	}

	@Test
	public void queryIterativeTest() {

		iterativeLinkedList();

		assertTrue(ll.queryIterative(Long.MIN_VALUE));
		assertFalse(ll.queryIterative((long) 50));

	}

	@Test
	public void queryRecursiveTest() {
		iterativeLinkedList();

		assertTrue(ll.queryRecursive(Long.MIN_VALUE));
		assertFalse(ll.queryRecursive((long) 50));
	}

}
