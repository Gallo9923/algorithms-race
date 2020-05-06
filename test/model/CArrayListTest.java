package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class CArrayListTest {

	private CArrayList al;

	public void EmptyArrayList() {
		al = new CArrayList();
	}
		
	public void ArrayListWithElements() {
		al = new CArrayList();
		al.addIterative(Long.MAX_VALUE);
		al.addIterative((long)0);
		al.addIterative(Long.MIN_VALUE);
	}

	@Test
	public void CArrayListUnitTest() {

		al = new CArrayList();

		assertTrue(al.getArrayList().isEmpty());

	}

	@Test
	public void addIterativeTest() {
		EmptyArrayList();
		
		al.addIterative(Long.MAX_VALUE);
		al.addIterative((long)0);
		al.addIterative(Long.MIN_VALUE);
		
		ArrayList<Long> AL2 = new ArrayList<Long>();
		AL2.add(Long.MAX_VALUE);
		AL2.add((long)0);
		AL2.add(Long.MIN_VALUE);
		
		assertTrue(al.getArrayList().equals(AL2));
		
	}
	
	@Test
	public void addRecursiveTest() {
		EmptyArrayList();
		
		al.addRecursive(Long.MAX_VALUE);
		al.addRecursive((long)0);
		al.addRecursive(Long.MIN_VALUE);
		
		ArrayList<Long> AL2 = new ArrayList<Long>();
		AL2.add(Long.MAX_VALUE);
		AL2.add((long)0);
		AL2.add(Long.MIN_VALUE);
		
		assertTrue(al.getArrayList().equals(AL2));
		
	}
	
	@Test
	public void deleteIterativeTest() {
		
		//Case 1
		ArrayListWithElements();
		
		ArrayList<Long> AL2 = new ArrayList<Long>();
		AL2.add(Long.MAX_VALUE);
		AL2.add((long)0);
		
		al.deleteIterative(Long.MIN_VALUE);
		
		assertTrue(al.getArrayList().equals(AL2));
		
		//Case 2
		ArrayListWithElements();
		
		AL2 = new ArrayList<Long>();
		AL2.add(Long.MAX_VALUE);
		AL2.add((long)0);
		AL2.add(Long.MIN_VALUE);
		
		assertTrue(al.getArrayList().equals(AL2));
	}
	
	@Test
	public void deleteRecursiveTest() {
		
		//Case 1
		ArrayListWithElements();
		
		ArrayList<Long> AL2 = new ArrayList<Long>();
		AL2.add(Long.MAX_VALUE);
		AL2.add((long)0);
		
		al.deleteRecursive(Long.MIN_VALUE);
		
		assertTrue(al.getArrayList().equals(AL2));
		
		//Case 2-
		ArrayListWithElements();
		
		AL2 = new ArrayList<Long>();
		AL2.add(Long.MAX_VALUE);
		AL2.add((long)0);
		AL2.add(Long.MIN_VALUE);
		
		assertTrue(al.getArrayList().equals(AL2));
	}
	
	@Test
	public void queryIterativeTest() {
		
		ArrayListWithElements();
		
		ArrayList<Long> AL2 = new ArrayList<Long>();
		AL2.add(Long.MAX_VALUE);
		AL2.add((long)0);
		
		//Case 1
		assertTrue(al.queryIterative(Long.MIN_VALUE));
		//Case 2
		assertFalse(al.queryIterative((long)50));
		
	}
	
	@Test
	public void queryRecursiveTest() {
		
		ArrayListWithElements();
		
		ArrayList<Long> AL2 = new ArrayList<Long>();
		AL2.add(Long.MAX_VALUE);
		AL2.add((long)0);
		
		//Case 1
		assertTrue(al.queryRecursive(Long.MIN_VALUE));
		//Case 2
		assertFalse(al.queryRecursive((long)50));
		
	}
	
	
	
}
