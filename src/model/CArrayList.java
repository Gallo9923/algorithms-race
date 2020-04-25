package model;

import java.util.ArrayList;
import java.util.Random;

public class CArrayList implements Algorithms {
	
	//Attributes
	private ArrayList arrayList;
	
	//Constructor
	public CArrayList() {
		arrayList = new ArrayList<Long>();
	}
	
	//Methods
	
	@Override
	public void addIterative(long num) {
		
		Random r = new Random();
	
		for(int i=0; i<num; i++) {
			arrayList.add(r.nextInt());
		}
		
	}

	@Override
	public void addRecursive(long num) {
		
		Random r = new Random();
		
		if(arrayList.size() != num) {
			arrayList.add(r.nextInt());
			addRecursive(num);
		}
		
	}
	

	@Override
	public void deleteIterative(long num) {
		
		
		
	}

	@Override
	public void deleteRecursive(long num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean queryIterative(long num) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean queryRecursive(long num) {
		// TODO Auto-generated method stub
		return false;
	}

}
