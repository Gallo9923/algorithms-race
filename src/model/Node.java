package model;

public class Node {
	
	//Attributes
	private Node left;
	private Node right;
	
	//Constructor
	public Node() {
		this.left = null;
		this.right = null;
	}

	//Getters & Setters
	
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
	
	
	
}
