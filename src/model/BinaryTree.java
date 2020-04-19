package model;

public class BinaryTree implements Algorithms {
	
	//Attributes
	private Node root;
	
	
	//Constructor
	public BinaryTree() {
		this.root = null;
	}
	
	//Methods

	@Override
	public void addIterative(int num) {
		
	}


	@Override
	public void addRecursive(int num) {

		if(root ==null) {
			root = new Node(num);
		}else {
			addRecursive(root, num);
		}
		
	}
	
	private void addRecursive(Node curr, int num) {
		if (num <= curr.getValue()) {
            
            Node left = curr.getLeft();
            
            if(left == null){
                curr.setLeft(new Node(num));
                curr.getLeft().setParent(curr);
            }else{
                addRecursive(left, num);
            }
            
        }else{
            
            Node right = curr.getRight();
    
            if(right == null){
                curr.setRight(new Node(num));
                curr.getRight().setParent(curr);
            }else{
                addRecursive(right, num);
            }
        }
	}

	@Override
	public void deleteIterative() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteRecursive() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean queryIterative(int num) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean queryRecursive(int num) {
		// TODO Auto-generated method stub
		return false;
	}
	
	// Getters && Setters
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
}
