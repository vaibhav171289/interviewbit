package binarysearch;

public class FloorSqrt {
	public static int sqrt(int a) {
		long x = (long)a;
	      // Base Cases
      if (x == 0 || x == 1)
          return (int)x;
//      System.out.println(x);
      // Do Binary Search for floor(sqrt(x))
      long start = 1, end = x, ans=0;
      while (start <= end)
      {
//    	  System.out.println("end "+end);
          long mid = (start + end) / 2;
//           System.out.println((long)mid*mid);
          // If x is a perfect square
          if ((long)mid*mid == x)
              {
//        	  	System.out.println("square found");
        	  	return (int)mid;
              }

          // Since we need floor, we update answer when mid*mid is
          // smaller than x, and move closer to sqrt(x)
          if ((long)mid*mid < x)
          {
              start = mid + 1;
              ans = mid;
          }
          else   // If mid*mid is greater than x
              end = mid - 1;
      }
      return (int)ans;
	}
	  public static void main(String args[])
	    {
	        int x = 2147483647;
	        System.out.println(sqrt(x));
	    }
}
