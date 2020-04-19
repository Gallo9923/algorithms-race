package model;

import java.util.ArrayList;
import java.util.Random;

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
		
		generateRandomList(n);
	}
	
	//Methods
	
	private void generateRandomList(int n) {
		
		Random r = new Random();
		int rNum;
		
		for(int i=0; i<n; i++) {
			rNum = r.nextInt(n);
			numberList.add(rNum);
			
			rNum = r.nextInt(n);
			queryList.add(rNum);
		}

	}
	

	
	
}
