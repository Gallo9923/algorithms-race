package model;

import java.util.ArrayList;
import java.util.List;


public class BinaryTree implements Algorithms {

	// Attributes
	private Node root;

	// Constructor
	public BinaryTree() {
		this.root = null;
	}

	// Methods

	/*
	 * public static void main(String[] args) {
	 * 
	 * BinaryTree abb = new BinaryTree();
	 * 
	 * abb.addIterative(0); abb.addIterative(-30); abb.addIterative(30);
	 * abb.addIterative(25);
	 * 
	 * System.out.println(abb.preorder().toString());
	 * 
	 * 
	 * }
	 */

	// Recorrer preorden
	public List<Node> preOrder() {
		return preOrder(root);
	}

	private List<Node> preOrder(Node e) {

		ArrayList<Node> list = new ArrayList<Node>();

		// Base step doesnt do anything
		// Recursive step
		if (e != null) {

			list.add(e);

			Node nextLeft = e.getLeft();
			Node nextRight = e.getRight();

			if (nextLeft != null) {
				list.addAll(preOrder(nextLeft));
			}

			if (nextRight != null) {
				list.addAll(preOrder(nextRight));
			}

		}
		return list;
	}

	@Override
	public void addIterative(long num) {

		Node curr = root;
		Node newNode = new Node(num);

		if (curr == null) {

			root = newNode;

		} else {

			while (curr != null) {

				if (num <= curr.getValue()) {

					if (curr.getLeft() == null) {
						curr.setLeft(newNode);
						newNode.setParent(curr);
						curr = null;

					} else {
						curr = curr.getLeft();
					}

				} else {

					if (curr.getRight() == null) {
						curr.setRight(newNode);
						newNode.setParent(curr);
						curr = null;
					} else {
						curr = curr.getRight();
					}
				}
			}
		}

	}

	@Override
	public void addRecursive(long num) {

		if (root == null) {
			root = new Node(num);
		} else {
			addRecursive(root, num);
		}

	}

	private void addRecursive(Node curr, long num) {
		if (num <= curr.getValue()) {

			Node left = curr.getLeft();

			if (left == null) {
				curr.setLeft(new Node(num));
				curr.getLeft().setParent(curr);
			} else {
				addRecursive(left, num);
			}

		} else {

			Node right = curr.getRight();

			if (right == null) {
				curr.setRight(new Node(num));
				curr.getRight().setParent(curr);
			} else {
				addRecursive(right, num);
			}
		}
	}

	/*
	 * Returns the maximum node in any subtree given a node of the BST
	 * 
	 * @param node Parent node belonging to the BST
	 * 
	 * @return Node Maximum node in the given subtree of the BST
	 */
	public Node maximumNode(Node node) {
		Node maximum = null;

		if (node != null && node.getRight() != null) {
			maximum = maximumNode(node.getRight());
		} else if (node != null) {
			maximum = node;
		}

		return maximum;
	}

	@Override
	public void deleteIterative(long num) {

		Node curr = root;
		boolean found = false;

		while (curr != null && !found) {

			if (num == curr.getValue()) {
				deleteNode(curr);
				found = true;
			} else if (num <= curr.getValue()) {
				curr = curr.getLeft();
			} else {
				curr = curr.getRight();
			}

		}

	}

	private void deleteNode(Node node) {

		if (node.getLeft() != null && node.getRight() != null) { // Case: Node has two child nodes

			Node parent = node.getParent();
			Node maximum = maximumNode(node.getLeft());
			Node maximumParent = maximum.getParent();

			maximumParent.setRight(null);

			if (parent == null) {

				maximum.setRight(null);
				node.setValue(maximum.getValue());

			} else {

				if (parent.getLeft() != null && parent.getLeft().equals(node)) {
					parent.setLeft(maximum);

				} else {
					parent.setRight(maximum);
				}
			}

		} else if (node.getLeft() != null || node.getRight() != null) { // Case: Node has one child node

			Node parent = node.getParent();
			Node newNode = (node.getLeft() != null ? node.getLeft() : node.getRight());

			if (parent.getLeft() != null && parent.getLeft().equals(node)) {
				parent.setLeft(newNode);
			} else {
				parent.setRight(newNode);
			}

		} else { // Case: Node is a leaf

			Node parent = node.getParent();

			if (parent.getLeft() != null && parent.getLeft().equals(node)) {
				parent.setLeft(null);
			} else {
				parent.setRight(null);
			}

		}

	}

	@Override
	public void deleteRecursive(long num) {
		deleteRecursive(root, num);
	}

	private void deleteRecursive(Node curr, long num) {

		if (curr == null) {

		} else {

			if (num == curr.getValue()) {
				deleteNode(curr);

			} else if (num <= curr.getValue()) {
				deleteRecursive(curr.getLeft(), num);

			} else {
				deleteRecursive(curr.getRight(), num);
			}
		}
	}

	@Override
	public boolean queryIterative(long num) {

		Node curr = root;
		boolean found = false;

		while (curr != null && !found) {

			if (num == curr.getValue()) {
				found = true;
			} else if (num <= curr.getValue()) {
				curr = curr.getLeft();
			} else {
				curr = curr.getRight();
			}

		}

		return found;
	}

	@Override
	public boolean queryRecursive(long num) {
		return queryRecursive(root, num);
	}

	private boolean queryRecursive(Node curr, long num) {

		boolean found = false;

		if (curr == null) {

		} else {

			if (num == curr.getValue()) {
				found = true;
			} else if (num <= curr.getValue()) {
				found = queryRecursive(curr.getLeft(), num);
			} else {
				found = queryRecursive(curr.getRight(), num);
			}

		}

		return found;
	}

	// Getters && Setters

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

}
