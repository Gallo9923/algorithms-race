package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

public class RaceTest {

	private static final int SAME_SEED_N = 5;
	private static final int SAME_SEED = 1;
	private Race race;
	private ArrayList<Long> arrayList;
	private ArrayList<Long> preOrderArrayList;
	
	public void sameSeedRace() {
		race = new Race(SAME_SEED, SAME_SEED);
	}
	
	public void sameSeedRaceArrayList() {
		
		Random r = new Random(SAME_SEED);
		
		arrayList = new ArrayList<Long>();
		
		for(int i=0; i<SAME_SEED_N; i++) {
			arrayList.add(r.nextLong());
		}
		
		
		
	}
	
	public void sameSeedPreOrderList() {
		preOrderArrayList = new ArrayList<Long>();
		
		preOrderArrayList.add(-4964420948893066024L);
		preOrderArrayList.add(7564655870752979346L);
		preOrderArrayList.add(3831662765844904176L);
		preOrderArrayList.add(-594798593157429144L);
		preOrderArrayList.add(6137546356583794141L);
		
	}
	
	@Test
	public void addTest() {
		
		sameSeedRaceArrayList();
		sameSeedPreOrderList();
		BinaryTree abb;
		CArrayList al;
		LinkedList ll;
		
		//Case 1, 2, 3
		sameSeedRace();
		abb = race.getBinaryTree();
		al = race.getArrayList();
		ll = race.getLinkedList();
		
		race.addIterativeAL(SAME_SEED_N);
		race.addIterativeLE(SAME_SEED_N);
		race.addIterativeABB(SAME_SEED_N);
		
		assertEquals(arrayList, al.getArrayList());
		assertEquals(arrayList, ll.getLinkedList());
		assertEquals(preOrderArrayList.toString(), abb.preOrder().toString());
		
		assertEquals(SAME_SEED_N, race.getArrayListN());
		assertEquals(SAME_SEED_N, race.getBinaryTreeN());
		assertEquals(SAME_SEED_N, race.getLinkedListN());
		
		//Case 4, 5, 6
		
		
	}

}
