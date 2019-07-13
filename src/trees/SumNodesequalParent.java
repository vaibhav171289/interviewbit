package trees;

public class SumNodesequalParent {
public static void main(String[] args) {
//	String a[] = {"20","15","5","8","7","3","6","2","-","-","-","-","1","-","-"};
//	System.out.println(new SumNodesequalParent().postOrderSum(a, 0));
	SumNodesequalParent tree = new SumNodesequalParent();
     tree.root = new Node(20);
     tree.root.left = new Node(15);
     tree.root.right = new Node(5);
     tree.root.left.left = new Node(8);
     tree.root.left.right = new Node(7);
     tree.root.right.left = new Node(3);
     tree.root.right.right = new Node(6);
    tree.root.left.left.left= new Node(2);
     tree.root.right.left.right = new Node(1);
     
     int sum = tree.sum(tree.root);
     if(sum == tree.root.data)
    	 System.out.println("match "+sum);
//         System.out.println("The given tree is a sum tree");
//     else
//         System.out.println("The given tree is not a sum tree");
}
/* A binary tree node has data, left child and right child */
static class Node 
{
    int data;
    Node left, right, nextRight;
  
    Node(int item) 
    {
        data = item;
        left = right = nextRight = null;
    }
}
private Node root;
int sum(Node node) 
{
	 if ((node == null) )
        return 0;
	 
	if(node.left == null)
		return sum(node.right);
    if(node.right == null)
    	return sum(node.left);
	int sum = (sum(node.left)+node.data+sum(node.right) );
    int val = node.data;
//    System.out.println("val "+val);
//    System.out.println("sum "+sum);
    if(sum == val)
    System.out.println("match "+sum);
    return node.data;
}

/* returns 1 if sum property holds for the given
   node and both of its children */
void isSumTree(Node node) 
{
    int ls, rs;

    /* If node is NULL or it's a leaf node then
       return true */
   

    /* Get sum of nodes in left and right subtrees */
//    int val =node.data;
    ls = sum(node);
    /*System.out.println("ls = "+ls);
    rs = sum(node.right,node.data);
    System.out.println(" rs="+rs);
     if the node and both of its children satisfy the
       property return 1 else 0
    if ((val == ls + rs))
        System.out.println("-->"+node.data);
   */
    	
}
private int postOrderSum(String a[],int i)
{
	if(i<=a.length)
	{
		System.out.println("i= "+i);
		int x= postOrderSum(a, 2*i+1);
		int y= postOrderSum(a, 2*i+2);
		System.out.println("x = "+x +"  y= "+y); 
		
		/* if((x!=-1 &&a[x]!="-" )||( y!=-1 && a[y]=="-"))
		{

//			System.out.println("a["+x+"]="+a[x]);
			System.out.println(Integer.parseInt(a[x]));
		}
		else if((x!=-1  && a[x]=="-")||( y!=-1 && a[y]!= "-"))
		{

//			System.out.println("a["+x+"]="+a[x]+"  a["+y+"]="+a[y]);
			System.out.println(Integer.parseInt(a[y]));
		}
		else if((x!=-1 && a[x]!="-" )&&( y!=-1 && a[y]!= "-"))
		{
//			System.out.println("a["+x+"]="+a[x]+"  a["+y+"]="+a[y]);
			System.out.println(Integer.parseInt(a[x])+Integer.parseInt(a[y]));
		}*/
	 return i-1;
	}
	return 0;
}
}
