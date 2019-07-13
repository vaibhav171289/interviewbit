package competition;

import java.util.ArrayList;
import java.util.Scanner;

public class Programming {
static class Programmer
{
	String name;
	int d,j;
	public Programmer(String name,int d,int j)
	{
		this.name=name;
		this.d=d;
		this.j=j;
				
	}
}

private static ArrayList<Programmer> l =new ArrayList<Programmer>();
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    for(int a0 = 0; a0 < n; a0++){
        String name = in.next();
        int d = in.nextInt();
        int j = in.nextInt();
        l.add(new Programmer(name,d,j));
    }
     Programmer p1 = null;
     int max=-1;
    for(Programmer p:l)
    {
    	if(Math.abs(p.j-p.d)>max)
    	{
    		p1=p;
    		max=Math.abs(p.j-p.d);
    	}
    }
    System.out.println(p1.name+" "+max);
}

}
