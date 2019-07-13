package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MaxConsecutiveGap {
	static Scanner scan = null;
	private static ArrayList<Integer> readInput()
	{

		scan = new Scanner(System.in);
		int size = scan.nextInt();
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for(int i=0;i<size;i++)
		{
			lst.add(scan.nextInt());
		}
		return lst;
	}
	public static void main(String[] args) {
		System.out.println(new MaxConsecutiveGap().maximumGap(readInput()));
	}
	public int maximumGap(final List<Integer> a) {
		List<Integer> lst = new ArrayList<Integer>();
		lst.addAll(a);
	bucketSort(a);
	int max=0;
	for(int i=1;i<a.size();i++)
	{
		int diff = a.get(i)-a.get(i-1);
		if(diff>max)
			max=diff;
	}
		return max;
	}
	public  void bucketSort(List<Integer> input) {
	    // get hash codes
	    final int[] code = hash(input);
	    
	    // create and initialize buckets to ArrayList: O(n)
	    List[] buckets = new List[code[1]];
	    for (int i = 0; i < code[1]; i++) {
	      buckets[i] = new ArrayList();
	    }
	    
	    // distribute data into buckets: O(n)
	    for (int i : input) {
	      buckets[hash(i, code)].add(i);
	    }
	   
	    // sort each bucket O(n)
	    for (List bucket : buckets) {
	      Collections.sort(bucket);
	    }
	    
	    int ndx = 0;
	    // merge the buckets: O(n)
	    for (int b = 0; b < buckets.length; b++) {
	      for (Object v : buckets[b]) {
	        input.set(ndx++, (int)v);
	      }
	    }
	  }

	  /**
	   * 
	   * @param input
	   * @return an array containing hash of input
	   */
	  private  int[] hash(List<Integer> input) {
	    int m = input.get(0);
	    for (int i = 1; i < input.size(); i++) {
	      if (m < input.get(i)) {
	        m = input.get(i);
	      }
	    }
	    return new int[] { m, (int) Math.sqrt(input.size()) };
	  }

	  /**
	   * 
	   * @param i
	   * @param code
	   * @return
	   */
	  private  int hash(int i, int[] code) {
	    return (int) ((double) i / code[0] * (code[1] - 1));
	  }


	/*public int maximumGap(final List<Integer> a) {
		
		int max= Integer.MIN_VALUE;
		int s=-1,e=-1;
		for(int i=0,j=1;i<a.size();i++)
		{
			int diff = a.get(j)-a.get(i);
			j++;
			if(diff>0 && diff > max)
			{
				max  =diff;
				s=i;e=j;
			}
			else if(diff <0)
			{
				int k=i-1;
				diff = a.get(j)-a.get(k);
				while(k>=0 && diff < 0)
					k--;
				
				if( k ==s)
				{
					max= Integer.MIN_VALUE;
					diff = a.get(j)-a.get(k);
					if(diff>max)
						max=diff;
					k++;
					diff = a.get(k)-a.get(e);
					if(diff>max)
						max=diff;
					k=e+1;
					while(k<i)
					{
						diff = a.get(i)-a.get(k);
						if(diff>max)
							max=diff;
						k++;
					}
				}
				else {
					if(diff>max)
						max= diff;
					k++;
					diff = a.get(k)-a.get(j);
					if(diff>max)
						max=diff;
					while(k<=i)
					{
						diff = a.get(k+1)-a.get(k);
						if(diff>max)
							max=diff;
						k++;
					}

				}
			}
			
		}
	return max;
	}*/
}
