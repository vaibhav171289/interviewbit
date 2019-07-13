package string;

import java.util.Arrays;

public class StringMultiplication {
	int count=0;
	public static void main(String[] args) {
		System.out.println(new StringMultiplication().multiply("367", "28"));
	}
public String multiply(String a, String b)
{
	String c="";
	int m=a.length();
	int n=b.length();
	int aux[] = new int[m+n];
	int temp[];
	if(m>=n)
	temp = new int [m+1];
	else
		temp=new int[n+1];
	Arrays.fill(aux, 0);
	
	for(int i=n-1;i>=0;i--)
	{
		int k=temp.length-1;
		int borrow=0;
		for(int j=m-1;j>=0;j--)
		{
//			System.out.println(a.charAt(j)+" * " + b.charAt(i));
			int res = Character.getNumericValue(a.charAt(j))*Character.getNumericValue(b.charAt(i)) + borrow;
//			System.out.println("res = "+res);
			int rem = res%10;
			
			temp[k--] = rem;
			borrow = res/10;
//			System.out.println(res +" -- "+borrow);
		}
		temp[k] =borrow;
//		System.out.println("temp array");
//		for(int x:temp)
//			System.out.print(x);
//		System.out.println();
		aux= add(aux,temp);
//		System.out.println("aux array");
//		for(int x:aux)
//			c+=x;
//		System.out.println("aux "+c);
		Arrays.fill(temp, 0);
//		c="";
	}
	for(int i:aux)
		c+=i;
	return c;
}
public int [] add(int []aux, int []temp)
{
	int i=temp.length-1,j=aux.length-1;
	int quo=0,rem=0;
	for(;i>=0 && j-count>-1;i--,j--)
	{
//		System.out.println("j-count "+(j-count));
		int val = aux[j-count]+temp[i]+quo;
//		System.out.println("val = "+val);
		 rem = val%10;
		quo = val/10;
		aux[j-count]=rem;
	}
	count++;
	return aux;
}
}
