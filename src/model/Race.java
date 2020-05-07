package model;

import java.util.ArrayList;
import java.util.Random;

public class Race {

	// Attributes
	private BinaryTree binaryTree;
	private CArrayList arrayList;
	private LinkedList linkedList;
	private long seed;

	// Constructor
	public Race(long seed) {
		binaryTree = new BinaryTree();
		arrayList = new CArrayList();
		linkedList = new LinkedList();

	}

	public long addIterativeAL(int n) {
		arrayList.addIterative(n);

		return System.currentTimeMillis();

	}

	public long addIterativeLE(int n) {

		return System.currentTimeMillis();
	}

	public long addIterativeABB(int n) {

		return System.currentTimeMillis();
	}

	public long addRecursiveAL(int n) {

		return System.currentTimeMillis();
	}

	public long addRecursiveLE(int n) {

		return System.currentTimeMillis();
	}

	public long addRecursiveABB(int n) {

		return System.currentTimeMillis();
	}

	public long deleteIterativeAL(int n) {

		return System.currentTimeMillis();
	}

	public long deleteIterativeLE(int n) {

		return System.currentTimeMillis();
	}

	public long deleteIterativeABB(int n) {

		return System.currentTimeMillis();
	}

	public long deleteRecursiveAL(int n) {

		return System.currentTimeMillis();
	}

	public long deleteRecursiveLE(int n) {

		return System.currentTimeMillis();
	}

	public long deleteRecursiveABB(int n) {

		return System.currentTimeMillis();
	}

	public long queryIterativeAL(int num) {

		return System.currentTimeMillis();
	}

	public long queryIterativeLE(int num) {
		return System.currentTimeMillis();
	}

	public long queryIterativeABB(int num) {

		return System.currentTimeMillis();
	}

	public long queryRecursiveAL(int num) {

		return System.currentTimeMillis();
	}

	public long queryRecursiveLE(int num) {
		return System.currentTimeMillis();
	}

	public long queryRecursiveABB(int num) {

		return System.currentTimeMillis();
	}

}
