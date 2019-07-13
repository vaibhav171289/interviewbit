package maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class PrimeSum {
	public static void main(String[] args) {
		PrimeSum p = new PrimeSum();
		
		System.out.println(p.primesum(4));
	}
	
	 public ArrayList<Integer> primesum(int a) {
		 ArrayList<Integer> plist = sieve(a);
			System.out.println(plist);
			ArrayList<Integer> res = new ArrayList<Integer>();
			for(int i=0,j=plist.size()-1;i>=0 && i<=j && j<plist.size();)
			{
				if(plist.get(i)+plist.get(j)==a)
					{
//					System.out.println("plist "+plist.get(i)+"-->"+plist.get(j));
						if(res.isEmpty())
						{
							res.add(plist.get(i));
							res.add(plist.get(j));
						}
						else
						{
							int x = res.get(0);
							int y =res.get(1);
//							System.out.println("x "+x +"y "+y);
							Comparator<Integer> compare = new Comparator<Integer>() {
								@Override
								public int compare(Integer x,Integer y)
								{
									return x.toString().compareTo(y.toString());
								}
							};
//							System.out.println(compare.compare(x, plist.get(i)));
//							System.out.println(compare.compare(y, plist.get(j)));
//							System.out.println("-----------------------");
						}
						i--;j--;
					}
				else if(plist.get(i)+plist.get(j)>a)
				{
					j--;
				}
				else
					i++;
			}
			
		 return res;
	    }
	public ArrayList<Integer> sieve(int a) {
		boolean b[] = new boolean[a + 1];
		Arrays.fill(b, true);
		for (int i = 2; i < b.length; i++) {
			if (b[i] == true) {

				int j = i;
				while ((long) j * i < (long) b.length) {
					b[j * i] = false;

					j++;
				}
				int t = (int) Math.pow(i, 2);
				if (t < b.length)
					b[t] = false;
			}
		}
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for (int i = 2; i < b.length; i++)
			if (b[i] == true)
				lst.add(i);
//		System.out.println(lst);
		return lst;
	}
}
