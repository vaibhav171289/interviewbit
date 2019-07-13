package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MaxSPProd {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n=sc.nextInt();
	ArrayList<Integer> A = new ArrayList<Integer>();
	for(int i=0;i<n;i++){
		A.add(sc.nextInt());
	}
	
	System.out.println("result "+new MaxSPProd().maxSpecialProduct(A));
}
public int maxSpecialProduct(ArrayList<Integer> A) {
	ArrayList<Integer> LS  = new ArrayList<Integer>(A.size());
	ArrayList<Integer> RS  = new ArrayList<Integer>(A.size());
	if(A.size() ==0 )return 0;
	LS.add(0);
	for(int i=1;i<A.size();i++){
        int j=i-1;
        
        while(j>=0){
            if(A.get(j)>A.get(i)){
                LS.add(j);
                break;
            }
            
            j=LS.get(j);
            if(j==0){
            	LS.add(0);
            	j=-1;
            }
        }
    }
	A.forEach((x)->RS.add(0));
	for(int i=A.size()-2;i>=0;i--){
		int j=i+1;
		while(j>0){
			if(A.get(j)>A.get(i)){
				RS.remove(i);
				RS.add(i,j);
				break;
			}
			j=RS.get(j);
			if(j==0){
				RS.remove(i);
            	RS.add(i,0);
            	j=-1;
            }
		}
	}
	double max =0;
	for(int i=0;i<LS.size();i++)
	{
		double d = LS.get(i)*RS.get(i);
		if(d >max)
			max = d;
	}
	int r = (int)(max%1000000007);
	return r;
}


}
