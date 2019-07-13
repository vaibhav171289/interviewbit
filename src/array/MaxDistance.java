package array;

import java.util.List;

public class MaxDistance {
	public int maximumGap(final List<Integer> a) {
	    if(a.size()==1)
	    return 0;
	     int maxDiff;
        int i, j;
        int n = a.size();
        int RMax[] = new int[n];
        int LMin[] = new int[n];
 
        /* Construct LMin[] such that LMin[i] stores the minimum value
           from (arr[0], arr[1], ... arr[i]) */
        LMin[0] = a.get(0);
        for (i = 1; i < n; ++i)
            LMin[i] = Math.min(a.get(i), LMin[i - 1]);
 
        /* Construct RMax[] such that RMax[j] stores the maximum value
           from (arr[j], arr[j+1], ..arr[n-1]) */
        RMax[n - 1] = a.get(n-1);
        for (j = n - 2; j >= 0; --j)
            RMax[j] = Math.max(a.get(j), RMax[j + 1]);
 
        /* Traverse both arrays from left to right to find optimum j - i
           This process is similar to merge() of MergeSort */
        i = 0; j = 0; maxDiff = -1;
        while (j < n && i < n) 
        {
            if (LMin[i] <= RMax[j]) 
            {
                maxDiff = Math.max(maxDiff, j - i);
                j = j + 1;
            } 
            else
                i = i + 1;
        }
 
        return maxDiff;
	}
}
