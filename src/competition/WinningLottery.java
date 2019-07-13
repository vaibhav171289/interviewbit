package competition;

import java.util.ArrayList;
import java.util.Scanner;

public class WinningLottery {
	 static int winningLotteryTicket(String[] tickets) {
		int total = 0;
		for (int i = 0; i < tickets.length; i++) {
			ArrayList<Character> l = new ArrayList<Character>();
			l.add('0');
			l.add('1');
			l.add('2');
			l.add('3');
			l.add('4');
			l.add('5');
			l.add('6');
			l.add('7');
			l.add('8');
			l.add('9');

			String t1 = tickets[i];
			int index = 0;

			while (index < t1.length() && !l.isEmpty()) {
				if (l.contains(t1.charAt(index))) {
					int in = l.indexOf(t1.charAt(index));
					l.remove(in);
				}
				index++;
			}
			for (int j = i + 1; j < tickets.length; j++) {

				String t2 = tickets[j];
				index = 0;
				ArrayList<Character> l1 = new ArrayList<Character>(l);
				while (index < t2.length() && !l1.isEmpty()) {
					if (l1.contains(t2.charAt(index))) {
						int in = l1.indexOf(t2.charAt(index));
						l1.remove(in);
					}
					index++;
				}
				if (l1.isEmpty())
					{
						total++;
						
					}
			}
		}
		return total;
	}

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        String[] tickets = new String[n];
	        for(int tickets_i = 0; tickets_i < n; tickets_i++){
	            tickets[tickets_i] = in.next();
	        }
	        int result = winningLotteryTicket(tickets);
	        System.out.println(result);
	        in.close();
	    }
	}
