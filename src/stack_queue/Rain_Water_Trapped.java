package stack_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rain_Water_Trapped {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-- >0){
			int n= sc.nextInt();
			List<Integer> a = new ArrayList<Integer>();
			for(int i=0;i<n;i++)
				a.add(sc.nextInt());
			System.out.println(new Rain_Water_Trapped().trap(a));
		}
	}
	public int trap(final List<Integer> A) {
		Stack<Integer> st = new Stack<Integer>();
		int total=0;
		int i=0, L=0, R = 0;
		while(i<A.size()){
			if(st.isEmpty()){
				if(A.get(i)==0){
					i++;
					continue;
				}
				else	{
					L=A.get(i);
					st.push(A.get(i));
				}
			}else{
				if(L > A.get(i)){
					R=A.get(i);
//					System.out.println(A.get(i));
					st.push(A.get(i));
				}else{
//					int min=100000000;
					R= A.get(i);
//					System.out.println("L==R\t"+L+"=="+R);
					while(!st.isEmpty()){
						int v = st.pop();
//						System.out.println("v==>"+v);
						if(L<R)
							total+= L-v;
						else {
							if(R-v < 0)
								R=v;
							else
								total += R-v;
						}
					}
					L=A.get(i);
					st.push(A.get(i));
				}
			}
			i++;
		}
		while(!st.isEmpty()){
			int v = st.pop();
			if(L<R)
				total+= L-v;
			else {
				if(R-v <= 0)
					R=v;
				else
					total += R-v;
			}
		}
		
		return total;
	}
	//this function is without stack but works fine and faster than stack
	public int trap1(final List<Integer> A) {
	    int a=0;
    int b=A.size()-1;
    int max=0;
    int leftmax=0;
    int rightmax=0;
    while(a<=b){
        leftmax=Math.max(leftmax,A.get(a));
        rightmax=Math.max(rightmax,A.get(b));
        if(leftmax<rightmax){
            max+=(leftmax-A.get(a));       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
            a++;
        }
        else{
            max+=(rightmax-A.get(b));
            b--;
        }
    }
    return max;

	}
}

