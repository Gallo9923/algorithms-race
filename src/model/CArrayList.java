package model;

import java.util.ArrayList;


public class CArrayList implements Algorithms {

	// Attributes
	private ArrayList<Long> arrayList;

	// Constructor
	public CArrayList() {
		arrayList = new ArrayList<Long>();
	}

	// Methods

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

		for (int i = 0; i < arrayList.size() && found == false; i++) {

			if (arrayList.get(i) == num) {
				arrayList.remove(i);
				found = true;
			}

		}

	}

	@Override
	public void deleteRecursive(long num) {

		if (arrayList.size() > 0) {
			deleteRecursive(num, 0);
		}

	}

	private void deleteRecursive(long num, int index) {

		// Base case
		if (arrayList.get(index) == num) {
			arrayList.remove(index);
		} else if (index + 1 < arrayList.size()) {
			deleteRecursive(num, index + 1);
		} else {
			// do nothing
		}

	}

	@Override
	public boolean queryIterative(long num) {

		boolean found = false;

		for (int i = 0; i < arrayList.size() && found == false; i++) {

			if (arrayList.get(i) == num) {
				found = true;
			}

		}

		return found;
	}

	@Override
	public boolean queryRecursive(long num) {

		boolean found = false;

		if (arrayList.size() > 0) {
			found = queryRecursive(num, 0);
		}

		return found;
	}

	private boolean queryRecursive(long num, int index) {
		
		boolean found = false;
		
		if (arrayList.get(index) == num) {
			found = true;
		} else if (index + 1 < arrayList.size()) {
			found = queryRecursive(num, index + 1);
		} else {
			//Do nothing
		}
		
		return found;
		
	}

	public ArrayList<Long> getArrayList() {
		return arrayList;
	}

	public void setArrayList(ArrayList<Long> arrayList) {
		this.arrayList = arrayList;
	}

}
