package model;

import java.util.ArrayList;

public class LinkedList implements Algorithms {

	// Attributes
	private Element first;

	// Constructor

	public LinkedList() {
		this.first = null;

	}

	// Methods

	@Override
	public void addIterative(long num) {

		Element curr = first;
		Element newElement = new Element(num);

		if (first == null) {
			first = newElement;

		} else {

			while (curr.getNext() != null) {
				curr = curr.getNext();
			}

			curr.setNext(newElement);
			newElement.setPrev(curr);

		}

	}

	@Override
	public void addRecursive(long num) {

		Element newElement = new Element(num);

		if (first == null) {
			first = newElement;
		} else {
			addRecursive(newElement, first);
		}

	}

	private void addRecursive(Element newElement, Element curr) {

		if (curr.getNext() == null) {
			curr.setNext(newElement);
			newElement.setPrev(curr);
		} else {
			addRecursive(newElement, curr.getNext());
		}

	}

	@Override
	public void deleteIterative(long num) {
		
		Element curr = first;
		boolean found = false;
		
		while(curr != null && found == false) {
			
			if(curr.getValue() == num) {	
				
				deleteNode(curr);
			}
			
			curr = curr.getNext();
		}
		

	}

	@Override
	public void deleteRecursive(long num) {
		
		if (first != null) {
			deleteRecursive(num, first);
		}

	}

	private void deleteRecursive(long num, Element curr) {
		
		if(curr.getValue() == num) {

			deleteNode(curr);
			
		}else if(curr.getNext() != null) {
			deleteRecursive(num, curr.getNext());
		}
		
	}
	
	
	private void deleteNode(Element node) {
		
		Element prev = node.getPrev();
		Element next = node.getNext();
		
		if(prev == null) {
			first = node.getNext();
			
			if(first != null) {
				first.setPrev(null);
			}
			
		}else {
			prev.setNext(next);
			
			if(next != null) {
				next.setPrev(prev);
			}
			
		}
		
	}
	
	
	@Override
	public boolean queryIterative(long num) {
		
		Element curr = first;
		boolean found = false;
		
		while(curr != null && found == false) {
			
			if(curr.getValue() == num) {	
				
				found = true;
			}
			
			curr = curr.getNext();
		}
		
		return found;
	}

	@Override
	public boolean queryRecursive(long num) {
		
		boolean found = false;
		
		if (first != null) {
			found = queryRecursive(num, first);
		}
		
		return found;
	}
	
	private boolean queryRecursive(long num, Element curr) {
		
		boolean found = false;
		
		if(curr.getValue() == num) {
			found = true;
			
		}else if(curr.getNext() != null) {
			queryRecursive(num, curr.getNext());
		}
		
		return found;
	}

	public ArrayList<Long> getLinkedList() {

		ArrayList<Long> list = new ArrayList<Long>();
		Element curr = first;

		if (first != null) {

			list.add(first.getValue());

			while (curr.getNext() != null) {
				curr = curr.getNext();
				list.add(curr.getValue());
			}

		}

		return list;
	}

	// Getters & Setters

	public Element getFirst() {
		return first;
	}

	public void setFirst(Element first) {
		this.first = first;
	}

}
