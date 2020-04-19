package model;

import org.omg.CORBA.Current;

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
		
		Node curr = root;
		Node newNode = new Node(num);
		
		if(curr == null) {
			
			root = newNode;
			
		}else {
			
			while(curr != null) {
				
				if(num <= curr.getValue()) {
				
					if(curr.getLeft() == null) {
						curr.setLeft(newNode);
						newNode.setParent(curr);
						
					}else {
						curr = curr.getLeft();
					}
					
				}else {	
					
					if(curr.getRight() == null) {
						curr.setRight(newNode);
						newNode.setParent(curr);
						
					}else {
						curr = curr.getRight();
					}
				}
			}
		}
		
		
		
		
		
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
		
		Node curr = root;
		boolean found = false; 
		
		while(curr != null && !found) {
			
			if(num == curr.getValue()) {
				found = true;
			}else if(num <= curr.getValue()) {
				curr = curr.getLeft();
			}else {
				curr = curr.getRight();
			}
			
		}
	
		return found;
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
