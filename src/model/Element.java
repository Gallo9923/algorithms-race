package model;

public class Element {
	
	//Attributes
	private long value;
	private Element next;
	private Element prev;
	
	//Constructor
	public Element(long value) {
		this.value = value;
		this.next = null;
		this.prev = null;
	}
	
	//Getters & Setters
	
	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public Element getNext() {
		return next;
	}

	public void setNext(Element next) {
		this.next = next;
	}

	public Element getPrev() {
		return prev;
	}

	public void setPrev(Element prev) {
		this.prev = prev;
	}
	
	
	
}
