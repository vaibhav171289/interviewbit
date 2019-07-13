package trees;

import java.util.Stack;

public class TreeTraversal {
	public static void main(String[] args) {
		Node root9 = new Node(9);
		Node root8 = new Node(8,root9,null);
		Node root4 = new Node(4,root8,null);
		
		Node root = new Node(1,null,null);
		Node root1 = new Node(2,null,null);
	}
public void inorderWithRecursion(Node root)
	{
	//time complexity : o(n) space complexity:o(n)
		if(root!=null)
		{
			inorderWithRecursion(root.left);
			System.out.print(root.data+" ");
			inorderWithRecursion(root.right);
		}
	}
public void inorderWithStacks(Node root)
{
	if(root==null)
		return ;
	Stack<Node> s = new Stack<Node>();
	while(true)
	{
		while(root!=null)
		{
			s.push(root);
			root=root.getLeft();
		}
		if(s.isEmpty())
			break;
		root = s.pop();
		System.out.print(root.getData()+" ");
		root=root.getRight();
	}
}
}
