package model;

import java.util.ArrayList;
import java.util.Random;

public class CArrayList implements Algorithms {
	
	//Attributes
	private ArrayList<Long> arrayList;
	
	//Constructor
	public CArrayList() {
		arrayList = new ArrayList<Long>();
	}
	
	//Methods
	
	@Override
	public void addIterative(long num) {
		
		arrayList.add(num);
		
	}

	@Override
	public void addRecursive(long num) {

		arrayList.add(num);
		
	}
	

	@Override
	public void deleteIterative(long num) {
		
		boolean found = false;
		
		for(int i=0; i<arrayList.size() && found == false; i++) {
			
			if(arrayList.get(i) == num) {
				arrayList.remove(i);
				found = true;
			}
			
		}
		
	}

	@Override
	public void deleteRecursive(long num) {
		
		int i = 0;
		boolean found = false;
		
		while(i < arrayList.size() && found == false) {
			
			if(arrayList.get(i) == num) {
				arrayList.remove(i);
				found = true;
			}
			
			i++;
		}
		
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

	public ArrayList<Long> getArrayList() {
		return arrayList;
	}

	public void setArrayList(ArrayList<Long> arrayList) {
		this.arrayList = arrayList;
	}

		
	
}
