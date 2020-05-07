package model;

import java.util.ArrayList;
import java.util.Random;

public class Race {

	// Attributes
	private BinaryTree binaryTree;
	private CArrayList arrayList;
	private LinkedList linkedList;
	private long firstSeed;
	private long secondSeed;
	private int binaryTreeN;
	private int arrayListN;
	private int linkedListN;
	
	// Constructor
	public Race(long firstSeed, long secondSeed) {
		binaryTree = new BinaryTree();
		arrayList = new CArrayList();
		linkedList = new LinkedList();
		this.firstSeed = firstSeed;
		this.secondSeed = secondSeed;	
		
		binaryTreeN = 0;
		arrayListN = 0;
		linkedListN = 0;
	}

	// Add Iterative Methods
	
	public long addIterativeAL(int n) {

		Random r = new Random(firstSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			arrayList.addIterative(num);
			arrayListN++;
		}

		return System.currentTimeMillis();

	}

	public long addIterativeLE(int n) {

		Random r = new Random(firstSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			linkedList.addIterative(num);
			linkedListN++;
		}

		
		return System.currentTimeMillis();
	}

	public long addIterativeABB(int n) {

		Random r = new Random(firstSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			binaryTree.addIterative(num);
			binaryTreeN++;
		}

		return System.currentTimeMillis();
		
	}

	// Add Recursive Methods
	
	public long addRecursiveAL(int n) {
		
		Random r = new Random(firstSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			arrayList.addRecursive(num);
			arrayListN++;
		}
		
		return System.currentTimeMillis();
	}

	public long addRecursiveLE(int n) {

		Random r = new Random(firstSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			linkedList.addRecursive(num);
			linkedListN++;
		}
		
		return System.currentTimeMillis();
	}

	public long addRecursiveABB(int n) {
		
		Random r = new Random(firstSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			binaryTree.addRecursive(num);
			binaryTreeN++;
		}
		
		return System.currentTimeMillis();
	}

	// Delete Iterative Methods
	
	public long deleteIterativeAL(int n) {
		
		Random r = new Random(secondSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			arrayList.deleteIterative(num);
			arrayListN++;
		}
		
		return System.currentTimeMillis();
	}

	public long deleteIterativeLE(int n) {
		
		Random r = new Random(secondSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			linkedList.deleteIterative(num);
			linkedListN++;
		}
		
		return System.currentTimeMillis();
	}

	public long deleteIterativeABB(int n) {

		Random r = new Random(secondSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			binaryTree.deleteIterative(num);
			binaryTreeN++;
		}
		
		return System.currentTimeMillis();
	}

	//Delete Recursive Methods
	
	public long deleteRecursiveAL(int n) {
		Random r = new Random(secondSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			arrayList.deleteRecursive(num);
			arrayListN++;
		}
		return System.currentTimeMillis();
	}

	public long deleteRecursiveLE(int n) {
		Random r = new Random(secondSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			linkedList.deleteRecursive(num);
			linkedListN++;
		}
		return System.currentTimeMillis();
	}

	public long deleteRecursiveABB(int n) {
		
		Random r = new Random(secondSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			binaryTree.deleteRecursive(num);
			binaryTreeN++;
		}
		
		return System.currentTimeMillis();
	}

	// Query Iterative Methods
	
	public long queryIterativeAL(int n) {
		
		Random r = new Random(secondSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			arrayList.queryIterative(num);
			arrayListN++;
		}
		
		return System.currentTimeMillis();
	}

	public long queryIterativeLE(int n) {
		
		Random r = new Random(secondSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			linkedList.queryIterative(num);
			linkedListN++;
		}
		
		return System.currentTimeMillis();
	}

	public long queryIterativeABB(int n) {

		Random r = new Random(secondSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			binaryTree.queryIterative(num);
			binaryTreeN++;
		}
		
		return System.currentTimeMillis();
	}

	// Query Recursive Methods
	
	public long queryRecursiveAL(int n) {
		
		Random r = new Random(secondSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			arrayList.queryRecursive(num);
			arrayListN++;
		}
		
		return System.currentTimeMillis();
	}

	public long queryRecursiveLE(int n) {
		
		Random r = new Random(secondSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			linkedList.queryRecursive(num);
			linkedListN++;
		}
		
		return System.currentTimeMillis();
	}

	public long queryRecursiveABB(int n) {

		Random r = new Random(secondSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			binaryTree.queryRecursive(num);
			binaryTreeN++;
		}
		
		return System.currentTimeMillis();
	}

}
