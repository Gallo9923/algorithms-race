package model;

public class Node {
	
	//Attributes
	private long value;
	private Node left;
	private Node right;
	private Node parent;
	
	//Constructor
	public Node(long value) {
		this.value = value;
		this.left = null;
		this.right = null;
		this.parent = null;
	}

	//Getters & Setters
	
	@Override
	public String toString() {
		return value + "";
	}
	
	
	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	
	
}
