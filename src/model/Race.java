package model;

import java.util.ArrayList;

public class Race {
	
	//Attributes
	private ArrayList numberList;
	private ArrayList queryList;
	private BinaryTree binaryTree;
	private CArrayList arrayList;
	private LinkedList linkedList;
	
	//Constructor
	public Race(int n) {
		numberList = new ArrayList<Integer>(n);
		queryList = new ArrayList<Integer>(n);
		binaryTree = new BinaryTree();
		arrayList = new CArrayList();
		linkedList = new LinkedList();
		
		
	}
	
	//Methods
	
	private void generateRandomList(int n) {
		
		
	}
	
	
	
}
