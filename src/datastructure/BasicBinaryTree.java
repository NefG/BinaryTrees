package datastructure;


public class BasicBinaryTree {
	
	private BasicBinaryNode root;
	
	public BasicBinaryTree () {
		
	}
	
	public void add(double key, String value) {
		if (this.root == null) {
			this.root = new BasicBinaryNode(key, value);
			return;
		}
		this.insert(this.root, key, value);
	}
	
	public String get(double key) {
		if (this.root == null) {
			return null;
		}
		return this.find(this.root, key);
	}
	
	private void insert(BasicBinaryNode node, double key, String value) {
		if (key < node.key) {
			if (node.left == null) {
				node.left = new BasicBinaryNode(key, value);
				return;
			}
			this.insert(node.left, key, value);
			return;
		} else if (key > node.key) {
			if (node.right == null) {
				node.right = new BasicBinaryNode(key, value);
				return;
			}
			this.insert(node.right, key, value);
			return;
		}
	}
	
	private String find(BasicBinaryNode node, double key) {
		if (node.key == key) {
			return node.value;
		}
		if (key < node.key && node.left != null) {
			return this.find(node.left, key);
		}
		if (key > node.key && node.right != null) {
			return this.find(node.right, key);
		}
		return null;
	}
	
	public void print() {
		this.print(this.root);
	}
	
	public void print(BasicBinaryNode node) {
		if (node != null) {
			print(node.right);
			System.out.println(node.value);
			print(node.left);
		}
	}
	
	public void printRange(double a, double b) {
		this.printRange(this.root, a, b);
	}
	
	private void printRange(BasicBinaryNode node, double a, double b) {
		if (node != null) {
			this.printRange(node.left, a, b);
			if (a < node.key && b > node.key) {
				System.out.println(node.value);
			}
			this.printRange(node.right, a, b);
		}
	}
}

class BasicBinaryNode {
	
	double key;
	String value;
	
	BasicBinaryNode left;
	BasicBinaryNode right;
	
	public BasicBinaryNode (double key , String value) {
		this.key = key;
		this.value = value;
	}
}
