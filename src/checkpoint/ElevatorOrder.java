package checkpoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ElevatorOrder {

public static void solveProblem(String cur[],String order[]) {
	ArrayList<Integer> up = new ArrayList<Integer>();

	ArrayList<Integer> down = new ArrayList<Integer>();
	for(int i=0;i<order.length;i++)
	{
		String s[] = order[i].split("-");
		if(s[1].trim().equalsIgnoreCase("up"))
			up.add(Integer.parseInt(s[0].trim()));
		else
			down.add(Integer.parseInt(s[0].trim()));
	}
	Collections.sort(up);
	Collections.sort(down);
	int i=0,j=0;
	int curFloor = Integer.parseInt(cur[0]);
	ArrayList<Integer> res = new ArrayList<>();
	if(cur[1].trim().equalsIgnoreCase("up"))
	{
		for(;i<up.size();i++)
		{
			if(curFloor <= up.get(i))
				res.add(up.get(i));
		}
		for(j=down.size()-1;j>0;j--)
			res.add(down.get(j));

		for(i=0;i<up.size();i++)
		{
			if(curFloor > up.get(i))
				res.add(up.get(i));
		}
	}
	else
	{
		for(;i<down.size();i++)
		{
			if(curFloor >= up.get(i))
				res.add(down.get(i));
		}
		for(j=up.size()-1;j>0;j--)
			res.add(up.get(j));
		for(i=0;i<down.size();i++)
		{
			if(curFloor < down.get(i))
				res.add(down.get(i));
		}
	}
		for(i=0;i<res.size()-1;i++)
			System.out.print(res.get(i)+",");
		System.out.print(res.get(res.size()-1));
}

//Sample code only. Feel free to change to accept the input described in the problem.

public static void main (String[] args) throws java.lang.Exception
{
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	in.nextLine();
	String cur [] = in.nextLine().trim().split("-");
	String order [] = in.nextLine().split("\\,");
	solveProblem(cur, order);
	System.out.println("This is the output");
}
}