package trees;

import java.util.Scanner;

public class ViolatesBST {
	Node first,middle,last,prev;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		int a[]= new int[n];
		Node root=null;
		ViolatesBST v = new ViolatesBST();
		for(int i=0;i<n;i++)
		{
			int val = scan.nextInt();
			root = v.insertBST(root,val);
			a[i]=val;
		}
		System.out.println("post order traversal");
		v.postOrder(root);
		System.out.println("----------------------");
		int[] inArr = new int[n];
		System.out.println("inorder traversal");
		inArr= v.inorder(root,inArr,0);
		/*for(int i=0;i<inArr.length;i++)
			System.out.print(inArr[i]+" ");*/
		System.out.println("\n---------------------");
		System.out.println("original  array");
		for(int i:a)
			System.out.print(i+" ");
		System.out.println("---------------------");
		v.voilate(root);
		System.out.println("after correction");
		inArr= v.inorder(root, inArr, 0);
		System.out.println("\n---------------");
		for(int i=0;i<inArr.length;i++)
			System.out.print(inArr[i]+" ");
	}
	private Node insertBT(Node root, int data)
	{
		if(root == null)
		{
			root = new Node();
			root.setData(data);
			root.setLeft(null);
			root.setRight(null);
		}
		else
			{
			if(root.getLeft() == null)
			
			root.setLeft(insertBT(root.getLeft(),data));
		else if(root.getRight()==null)
				root.setRight(insertBT(root.getRight(),data));
			}
		return root;
	}
	private Node insertBST(Node root,int data)
	{
		if(root == null)
		{
			root = new Node();
			root.setData(data);
			root.setLeft(null);
			root.setRight(null);
		}
		else
			{
			if(data<= root.getData())
			
			root.setLeft(insertBST(root.getLeft(),data));
		else
				root.setRight(insertBST(root.getRight(),data));
			}
		return root;
	}
	private void postOrder(Node root)
	{
		if(root!=null)
		{
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.print(root.getData()+"-->");
		}
		
	}
	private int[] inorder(Node root,int a[],int i)
	{
		if(root != null)
		{
			
			a= inorder(root.getLeft(),a,i);
			a[i++]=root.getData();
			System.out.print(a[i-1]+"-->");
			a= inorder(root.getRight(),a,i);
		}
		return a;
	}
	private void voilate(Node root)
	{
		
		first=middle=last=prev=null;
		correctBST(root,first,middle,last,prev);
		if(first != null && last != null)
		{
			swap(first,last);
		}
		else if(first!=null && middle !=null)
		{
			swap(first,middle);
		}
	}
	private void correctBST(Node root, Node first, Node middle, Node last, Node prev) {
		if(root !=null)
		{
			correctBST(root.left, first, middle, last, prev);
			if(prev != null && root.getData() < prev.getData())
			{
				if(first == null)
				{
					first =prev;
					middle =root;
				}
				else
					last=root;
			}
			prev=root;
			correctBST(root.getRight(), first, middle, last, prev);
		}
		
	}
	private void swap(Node first, Node last) {

			int temp =first.getData();
			first.setData(last.getData());
			last.setData(temp);
	}
	private class Node
	{
		int data;
		Node left;
		Node right;
		public Node(){}
		public Node(int data, Node left, Node right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
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
		
	}
}
