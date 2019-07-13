package array;

import java.util.ArrayList;

public class PrettyPrint {
public static void main(String[] args) {
	ArrayList<ArrayList<Integer>> a  = new PrettyPrint().prettyPrint(5);
	System.out.println(a);
}
void printArray(int a[][])
{
	for(int i=0;i<a.length;i++)
	{
		for(int j=0;j<a[i].length;j++)
	
		{
			System.out.print(/*"i = "+i+" j = "+j +" val = "+*/a[i][j]+" ");
		}
		System.out.println();
	}
	System.out.println("---------------");
}
public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
	int val=a;
	int n=2*a-1;
	ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
	int m = n;

    int x=0; 
    int y=0;
    int arr[][] = new int[m][n];
    while(m>0 && n>0){


   	 if(m==1){
   		 System.out.println("m==1 " +a);
               for(int i=0; i<n; i++){
                   arr[x][y++]=a;
               }
//               printArray(arr);
               break;
           }else if(n==1){
        	   System.out.println("n=1 "+a);
               for(int i=0; i<m; i++){
                   arr[x++][y] =a;
               }
               break;
           }
//   	 System.out.println("round "+x+" "+y);
           
//   	 	printArray(arr);
   	 //below, process a circle
   	 
           //top - move right
           for(int i=0;i<n;i++){
               arr[x][y++] = a;
           }
//           System.out.println("right "+x+" "+y);
//           printArray(arr);
           x++;
	    	y--;
           //right - move down
           for(int i=0;i<m-1;i++){
               arr[x++][y]=a;
           }
//           System.out.println("down "+x+" "+y);
//           printArray(arr);
	    	x--;
           y--;
           //bottom - move left
           for(int i=0;i<n-1;i++){
               arr[x][y--]=a;
           }
//           System.out.println( "left "+x+" "+y);
//           printArray(arr);
	    	y++;
	    	x--;
           //left - move up
           for(int i=0;i<m-2;i++){
               arr[x--][y]=a;
           }
         
//           System.out.println("up "+x+" "+y);
//           printArray(arr);
           y++;
           x++;
           m=m-2;
           n=n-2;
           a--;
//           System.out.println("m= "+m+" n="+n);
           
    }
    n= 2*val-1;
    for(int i=0;i<n;i++)
    {
   	 ArrayList<Integer> result = new ArrayList<Integer>();
	 		for(int j=0;j<n;j++)
	 			result.add(arr[i][j]);
	 		matrix.add(result);
    }
	return matrix;
}
}
