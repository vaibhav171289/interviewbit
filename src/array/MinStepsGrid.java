package array;

import java.util.ArrayList;

public class MinStepsGrid {
	 public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
		 int s1=X.size(), s2=Y.size(),ans=0;

		    for(int i=1;i<s1;i++)

		    {

		        ans = ans +
		        	(Math.abs(X.get(i)-X.get(i-1))<Math.abs(Y.get(i)-Y.get(i-1))
		        			?Math.abs(Y.get(i)-Y.get(i-1)):Math.abs(X.get(i)-X.get(i-1)));

		    }

		    return ans;  
	 }
}
