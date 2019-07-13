package array;

import java.util.ArrayList;

public class SpiralOrderMatrixII {
	public static void main(String[] args) {
		System.out.println(new SpiralOrderMatrixII().generateMatrix(3));
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
	public ArrayList<ArrayList<Integer>> generateMatrix(int a) {
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		
		  if(a == 0) return matrix;

	     int m = a;
	     int n = a;

	     int x=0; 
	     int y=0;
	     int val=1;
	     int [][]arr = new int[m][n];
	     while(m>0 && n>0)
	     {
	    	 if(m==1){
	                for(int i=0; i<n; i++){
	                    arr[x][y++]=val++;
	                }
	                break;
	            }else if(n==1){
	                for(int i=0; i<m; i++){
	                    arr[x++][y] =val++;
	                }
	                break;
	            }
//	    	 System.out.println("round "+x+" "+y);
	            
//	    	 	printArray(arr);
	    	 //below, process a circle
	    	 
	            //top - move right
	            for(int i=0;i<n;i++){
	                arr[x][y++] = val++;
	            }
//	            System.out.println("right "+x+" "+y);
//	            printArray(arr);
	            x++;
		    	y--;
	            //right - move down
	            for(int i=0;i<m-1;i++){
	                arr[x++][y]=val++;
	            }
//	            System.out.println("down "+x+" "+y);
//	            printArray(arr);
		    	x--;
	            y--;
	            //bottom - move left
	            for(int i=0;i<n-1;i++){
	                arr[x][y--]=val++;
	            }
//	            System.out.println( "left "+x+" "+y);
//	            printArray(arr);
		    	y++;
		    	x--;
	            //left - move up
	            for(int i=0;i<m-2;i++){
	                arr[x--][y]=val++;
	            }
	          
//	            System.out.println("up "+x+" "+y);
//	            printArray(arr);
	            y++;
	            x++;
	            m=m-2;
	            n=n-2;
//	            System.out.println("m= "+m+" n="+n);
	            
	     }
//	     printArray(arr);
	     for(int i=0;i<a;i++)
	     {
	    	 ArrayList<Integer> result = new ArrayList<Integer>();
		 		for(int j=0;j<a;j++)
		 			result.add(arr[i][j]);
		 		matrix.add(result);
	     }
	    /* while(m>0 && n>0){
	    	 ArrayList<Integer> result = new ArrayList<Integer>();
	 		
	  	   
	         //if one row/column left, no circle can be formed
	         if(m==1){
	             for(int i=0; i<n; i++){
	                 result.add(val++);
	                 y++;
	             }
	             break;
	         }else if(n==1){
	             for(int i=0; i<m; i++){
	                 result.add(val++);
	                 x++;
	             }
	             break;
	         }
	         
	         System.out.println("result / left "+result);
	         //below, process a circle

	         //top - move right
	         for(int i=0;i<n;i++){
	             result.add(val++);
	             y++;
	         }
	         matrix.add(result);
	         
	         System.out.println("result / right "+result);
	         result = new ArrayList<Integer>();
		 		
	         //right - move down
	         for(int i=0;i<m;i++){
	             result.add(val++);
	             x++;
	         }

	         System.out.println("result / down "+result);
	         //bottom - move left
	         for(int i=0;i<n-1;i++){
	             result.add(val++);
	             y--;
	         }

	         System.out.println("result / left "+result);
	         //left - move up
	         for(int i=0;i<m-1;i++){
	             result.add(val++);
	             x--;
	         }

	         x++;
	         y++;
	         m=m-2;
	         n=n-2;
	     }*/

			 return matrix;
	}
}
