package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CArrayListTest {

	private CArrayList al; 
	
	@Test
	public void CArrayListTest() {
		
		al = new CArrayList();
		
		assertTrue(al.getArrayList().isEmpty());
		
	}

}
