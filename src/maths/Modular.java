package maths;

import java.util.Scanner;

public class Modular {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Modular m = new Modular();
		System.out.println(m.solution(sc.nextInt(),sc.nextInt()));
	}
	public int solution(int A, int B) {
        // write your code in Java SE 8
        int n=1;
        int prev=1;
        int next;
        int max=0;
        int i=1;
        while(n++<=B)
        {
            next = (A*prev)%B;
            System.out.println(i++ +" next "+next);
            
            if(next>max)
                max=next;
           
            prev=next;
        }
        //System.out.println("max "+max);
        return max;
    }
}
