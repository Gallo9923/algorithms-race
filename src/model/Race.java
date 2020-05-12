package model;

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
		linkedListN = 0;
	}

	// Add Iterative Methods
	
	public void addIterativeAL(int n) {

		Random r = new Random(firstSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			arrayList.addIterative(num);
			arrayListN++;
		}

	}

	public void addIterativeLE(int n) {

		Random r = new Random(firstSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			linkedList.addIterative(num);
			linkedListN++;
		}
		
	}

	public void addIterativeABB(int n) {

		Random r = new Random(firstSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			binaryTree.addIterative(num);
			binaryTreeN++;
		}
		
	}

	// Add Recursive Methods
	
	public void addRecursiveAL(int n) {
		
		Random r = new Random(firstSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			arrayList.addRecursive(num);
			arrayListN++;
		}
		
	}

	public void addRecursiveLE(int n) {

		Random r = new Random(firstSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			linkedList.addRecursive(num);
			linkedListN++;
		}
		
	
	}

	public void addRecursiveABB(int n) {
		
		Random r = new Random(firstSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			binaryTree.addRecursive(num);
			binaryTreeN++;
		}
		
	}

	// Delete Iterative Methods
	
	public void deleteIterativeAL(int n) {
		
		Random r = new Random(secondSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			arrayList.deleteIterative(num);
			arrayListN++;
		}
		
	}

	public void deleteIterativeLE(int n) {
		
		Random r = new Random(secondSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			linkedList.deleteIterative(num);
			linkedListN++;
		}
		
	
	}

	public void deleteIterativeABB(int n) {

		Random r = new Random(secondSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			binaryTree.deleteIterative(num);
			binaryTreeN++;
		}
		
		
	}

	//Delete Recursive Methods
	
	public void deleteRecursiveAL(int n) {
		Random r = new Random(secondSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			arrayList.deleteRecursive(num);
			arrayListN++;
		}
		
	}

	public void deleteRecursiveLE(int n) {
		Random r = new Random(secondSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			linkedList.deleteRecursive(num);
			linkedListN++;
		}
		
	}

	public void deleteRecursiveABB(int n) {
		
		Random r = new Random(secondSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			binaryTree.deleteRecursive(num);
			binaryTreeN++;
		}
		
	}

	// Query Iterative Methods
	
	public void queryIterativeAL(int n) {
		
		Random r = new Random(secondSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			arrayList.queryIterative(num);
			arrayListN++;
		}
		
	}

	public void queryIterativeLE(int n) {
		
		Random r = new Random(secondSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			linkedList.queryIterative(num);
			linkedListN++;
		}
		
	}

	public void queryIterativeABB(int n) {

		Random r = new Random(secondSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			binaryTree.queryIterative(num);
			binaryTreeN++;
		}
		
		
	}

	// Query Recursive Methods
	
	public void queryRecursiveAL(int n) {
		
		Random r = new Random(secondSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			arrayList.queryRecursive(num);
			arrayListN++;
		}
		
	
	}

	public void queryRecursiveLE(int n) {
		
		Random r = new Random(secondSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			linkedList.queryRecursive(num);
			linkedListN++;
		}
		
		
	}

	public void queryRecursiveABB(int n) {

		Random r = new Random(secondSeed);

		for (int i = 0; i < n; i++) {
			long num = r.nextLong();
			binaryTree.queryRecursive(num);
			binaryTreeN++;
		}
		
		
	}

	public BinaryTree getBinaryTree() {
		return binaryTree;
	}

	public CArrayList getArrayList() {
		return arrayList;
	}

	public LinkedList getLinkedList() {
		return linkedList;
	}

	public int getBinaryTreeN() {
		return binaryTreeN;
	}

	public int getArrayListN() {
		return arrayListN;
	}

	public int getLinkedListN() {
		return linkedListN;
	}

	public void setBinaryTreeN(int binaryTreeN) {
		this.binaryTreeN = binaryTreeN;
	}

	public void setArrayListN(int arrayListN) {
		this.arrayListN = arrayListN;
	}

	public void setLinkedListN(int linkedListN) {
		this.linkedListN = linkedListN;
	}

	
	
	
	
}
