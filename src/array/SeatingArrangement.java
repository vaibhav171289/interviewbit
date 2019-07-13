package array;

public class SeatingArrangement {
	 
    private static final int MOD = 10000003;
    public static void main(String[] args) {
		
    	System.out.println(new SeatingArrangement().seats(".x.x.x.xx...x"));
	}
    	
	public int seats(String A) {
		System.out.println(A);
	    int n;
	    int i;
	    int first, last;
	    int countLeft[];
	    int total = 0;
	    int midVal;
	    
	    if (A == null || A.length() == 0)
	        return 0;
	    
	    n = A.length();
	    countLeft = new int[n];
	    first = last = -1;
	    
	    for (i = 0; i < n; i++) {
	        countLeft[i] = i > 0 ? countLeft[i - 1] : 0;
	        System.out.println("count ["+i+"]="+countLeft[i]);
	        if (A.charAt(i) == 'x') {
	            if (first == -1)
	                first = i;
	            last = i;
	            countLeft[i]++;
	            total++;
	        }
	    }
	    
	    midVal = (total + 1) / 2;
	    System.out.println("mid value = "+midVal );
        if (first == -1 || first == last)
            return 0;
	    
	    int mid;
	    
	    for (i = first; i <= last; i++) {
	        if (countLeft[i] == midVal)
	            break;
	    }
	    
	    mid = i;
	    System.out.println("mid with i "+mid);
	    long res = 0;
	    int count = 0;
	    
	    for (i = mid; i >= first; i--) {
	        if (A.charAt(i) == 'x') {
	            res += (mid - i - count);
	           
	            res %= MOD;
	            count++;
	        }
	    }
	    
	    count = 0;
	    
	    mid++;
	    for (i = mid; i <= last; i++) {
	    	System.out.println(A.charAt(i));
	        if (A.charAt(i) == 'x') {
	            res += (i - mid - count);
	            System.out.println(res);
	            res %= MOD;
	            count++;
	        }
	    }
	    
	    return (int) res;
	}
}