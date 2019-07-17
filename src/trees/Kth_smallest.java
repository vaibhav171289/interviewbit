package trees;

/**
 * @author vaibhav jain
 */
/*
 * 
 * 
 * Given a binary search tree, write a function to find the kth smallest element
 * in the tree.
 * 
 * Example :
 * 
 * Input :  2 
 *         / \ 
 *        1   3
 * 
 * and k = 2
 * 
 * Return : 2
 * 
 * As 2 is the second smallest element in the tree.
 * 
 * NOTE : You may assume 1 <= k <= Total number of nodes in BST
 * 
 * 
 */

import java.util.Scanner;
/* Definition for binary tree */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
    TreeNode(){
    	left=right =null;
    }
	TreeNode(int x) {
		val = x;
		left=right =null;
	}
}
public class Kth_smallest {
	

	boolean found = false;
	int val = 0;

	private int inorder(TreeNode root, int k) {
		if (root != null && k > 0) {
			if (root.left == null && root.right == null) {
				--k;
				if (k == 0)
					val = root.val;
				return k;
			}
			if (k > 0)
				k = inorder(root.left, k);
			--k;
			if (k == 0)
				val = root.val;
			if (k > 0)
				k = inorder(root.right, k);
		}
		return k;
	}

	public int kthsmallest(TreeNode root, int k) {
		inorder(root, k);
		return val;
	}
    private TreeNode createTree(TreeNode root,int vals[],int index){
    	//base case when -1 means no node is present and index should not exceed array length
    	if( index<vals.length && vals[index]!=-1 ){
    		
    		TreeNode node = new TreeNode(vals[index]);
    		root=node;
    		//array property where left child is at index 2*i+1
    		root.left = createTree(root.left,vals,2*index+1);

    		//array property where left child is at index 2*i+2
    		root.right = createTree(root.right,vals,2*index+2);
    	}
    	return root;
    }
    private void printInorder(TreeNode root){
    	if(root!=null){
    		printInorder(root.left);
    		System.out.print(root.val+" ");
    		printInorder(root.right);
    	}
    }
    
    /*input tree should be a binary search tree format
    ex:
	    7     //n_f nodes
	    5 2 9 1 3 -1 10 // tree values
	    5     //k value to find in tree
	*/
	public static void main(String[] args) {
		Kth_smallest s = new Kth_smallest();
		Scanner scan = new Scanner(System.in);
		int n_f_nodes = scan.nextInt();
		TreeNode root =null;
//-1 denotes no node is present
		int vals[] =  new int[n_f_nodes];
		scan.nextLine();
		for(int i=0;i<n_f_nodes;i++){
			vals[i]=scan.nextInt();
		}
		root= s.createTree(root, vals, 0);
		s.printInorder(root);   // use this function to print your tree
		scan.nextLine();
		int k= scan.nextInt();
		System.out.println(s.kthsmallest(root, k));
	}
	
}
