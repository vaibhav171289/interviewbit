package array;

import java.util.ArrayList;
import java.util.Scanner;

class Interval {
	public   int start,end;
	   public Interval() { start = 0; end = 0; }
	   public Interval(int s, int e) { this.start = s; this.end = e; }
}
public class MergeIntervals {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int test = sc.nextInt();
		int test =1;
		while(test -- >0){
			System.out.println("new test case "+(test+1));
		int n = sc .nextInt();
		ArrayList<Interval> lst = new ArrayList<Interval>();
		MergeIntervals mi = new MergeIntervals();
		while(n-- >0){
			int i = sc.nextInt();
			int j = sc.nextInt();
			Interval v=new Interval(i,j);
			lst.add(v);
		}
		
		ArrayList<Interval> res = mi.insert(lst, new Interval(sc.nextInt(), sc.nextInt()));
		System.out.println("\n------result------\n"); 
		
		res.forEach((x)->System.out.println(x.start+" , "+x.end));
		}
	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> res = new ArrayList<Interval>();
		
		if(newInterval.start > newInterval.end){
	    	int tmp = newInterval.start;
	    	newInterval.start=newInterval.end;
	    	newInterval.end= tmp;
	    }
	    if(intervals.isEmpty()){
	    	res.add(newInterval);
	    	return res;
	    }
		intervals.forEach((x)->System.out.println(x.start+" , "+x.end));
		System.out.println("new interval");
		System.out.println(newInterval.start+" , "+newInterval.end);
		int i=0;
		
		for(i=0;i<intervals.size();i++){
			if(newInterval.start >intervals.get(i).start 
					&& newInterval.start > intervals.get(i).end){
//				System.out.println(newInterval.start+"==="+intervals.get(i).end);
//				System.out.println("i==="+i);
				res.add(intervals.get(i));
			}else if(newInterval.start >=intervals.get(i).start 
					&& newInterval.start < intervals.get(i).end){
				int x = intervals.get(i).start;
//				res.add(intervals.get(i));
				
					System.out.println(newInterval.end+"==="+intervals.get(i).end);
					System.out.println("i==="+i);
				
				while(i<intervals.size() && newInterval.end > intervals.get(i).end) i++;
				System.out.println(newInterval.end+"==="+intervals.get(i).end);
				System.out.println("i==="+i);
				if(i<intervals.size() && newInterval.end < intervals.get(i).start){
					res.add(new Interval(x,newInterval.end));
					i++;
					break;
				}
				int y=0;
				if(i == intervals.size())
					y = newInterval.end;
				else
				 y = intervals.get(i).end;
				res.add(new Interval(x,y));
				i++;
				break;
				
			}
			else if(newInterval.end > intervals.get(i).start 
					&& newInterval.end > intervals.get(i).end){
				System.out.println(newInterval.start+"==="+intervals.get(i).end);
				System.out.println("i==="+i);
				while(i<intervals.size()
						&& newInterval.end > intervals.get(i).start 
						&& newInterval.end >= intervals.get(i).end) i++;
				System.out.println(newInterval.start+"==="+intervals.get(i).end);
				System.out.println("i==="+i);
				if(i<intervals.size()
						&& newInterval.end > intervals.get(i).start &&  newInterval.end <= intervals.get(i).end ){
					res.add(new Interval(newInterval.start,intervals.get(i).end));
					i++;
					break;
				}
				res.add(newInterval);
				break;
			}
			else  if(newInterval.end > intervals.get(i).start 
					&& newInterval.end <= intervals.get(i).end){
				
				res.add(new Interval(newInterval.start,intervals.get(i).end));
				i++;
				break;
			}
			else{
				
				res.add(newInterval);
				
				if(newInterval.start == intervals.get(i).start 
						&& newInterval.start == intervals.get(i).end)
					i++;
				break;
			}
		}
		while(i< intervals.size()){
			res.add(intervals.get(i++));
		}
		
		if(i!=0 && res.get(res.size()-1).end < newInterval.end)
			res.add(newInterval);
		
		return res;
	}
}