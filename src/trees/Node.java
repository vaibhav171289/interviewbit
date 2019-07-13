package trees;


public class Node {

	Node left;
	Node right;
	Node parent;
	int data;
	public Node(){}
	public Node(int data)
	{
		this.data=data;
		this.left=null;
		this.parent=null;
		this.right=null;
		
	}
	public Node (int data,Node left, Node right)
	{
		this.data=data;
		this.left=left;
		this.right=right;
		this.parent=null;
	}
	public Node (int data,Node left, Node right,Node parent)
	{
		this.data=data;
		this.left=left;
		this.right=right;
		this.parent=parent;
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
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	
}
