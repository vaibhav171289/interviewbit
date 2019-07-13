package competition;

import java.util.Scanner;

public class SimpleString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- >0){
			System.out.println("----------------------");
			int n = sc.nextInt();
			int q = sc.nextInt();
			String str  = sc.next();
			sc.nextLine();
			SimpleString ss = new SimpleString();
			for(int i=0;i<q;i++){
				int type = sc.nextInt();
				if(type == 1){
				   int L = sc.nextInt();
				   int R = sc.nextInt();
				   int K = sc.nextInt();
				   long total = ss.findSubString(str.substring(L-1, R), K);
				   System.out.println(total%1000000007);
				}else{
					int id = sc.nextInt();
					char c =  sc.next().charAt(0);
					str = ss.replace(str, id, c);
				}
			}
		}
	}
	long findSubString(String str ,int K){
		long total = 0;
		System.out.println(str);
		for(int i=0;i<str.length();i++){
			char c1 = str.charAt(i);
			for(int j=i;j<str.length();j++){
				char c2 = str.charAt(j);
				if((int)Math.abs(c1-c2)==K){
					System.out.println(c1+"-->"+c2);
					total++;
				}
			}
		}
		return total;
	}
	String replace(String str, int id, char c){
		String s = "";
		for(int i=0;i<str.length();i++){
			if(i==id-1)
				s+= c;
			else
				s+=str.charAt(i);
		}
		return s;
	}
}
