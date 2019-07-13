package string;

import java.util.ArrayList;
import java.util.Scanner;

public class JustifiedText {
	static Scanner scan;

	public static void main(String[] args) {
		System.out.println(new JustifiedText().fullJustify(readInputString(), scan.nextInt()));
	}

	public static ArrayList<String> readInputString() {
		ArrayList<String> lst = new ArrayList<String>();
		scan = new Scanner(System.in);
		int len = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < len; i++)
			lst.add(scan.next().trim());
		return lst;
	}

	public ArrayList<String> fullJustify(ArrayList<String> a, int b) {

		ArrayList<String> lst = new ArrayList<String>();
		if (a.size() == 0)
			return lst;

		int val = 0;
		ArrayList<String> words = new ArrayList<String>();
		int linelen = 0;
		for (int i = 0; i < a.size() + 1; i++) {
			String s = "";
			if (i < a.size())
				s = a.get(i);
			System.out.println(i + " ----->" + s);
			System.out.println("sum of words " + val);
			System.out.println("linelen = " + linelen);
			if (val + s.length() > b || i == a.size()) {
				if (i != a.size())
					--i;
				else {
					words.add(s);

					val += s.length();
					linelen += s.length() ;
					System.out.println("sum at last word " + val);
					System.out.println("last line len " + linelen);
				}
				System.out.println("words -> " + words);
				String line = "";

				int size = words.size() - 1;
				int diff = b - linelen;
				int spaces = 0;
				System.out.println("diff " + diff);
				System.out.println("size= " + size);

				if (i != a.size())
					for (int j = 0; j < words.size(); j++) {
						if (size > 0) {
							spaces = (int) (Math.ceil((double) diff / size));
							System.out.println("spaces after " + words.get(j) + " is " + spaces);

							diff = diff - spaces;
							line += words.get(j);
							while (spaces-- > 0)
								line += " ";
						} else {

							line += words.get(j);
							while (diff-- > 0)
								line += " ";
						}
						System.out.println("line :[" + line + "]");
						System.out.println("diff " + diff);
						size--;

					}
				else {
					
					for (int j = 0; j < words.size()-2; j++) {
						line+=words.get(j)+" ";
							size--;
						diff --;

					}
					System.out.println("last line :[" + line + "]");
					System.out.println("diff " + diff);
				
					line+=words.get(words.size()-2);
					System.out.println("line after last word "+line);
					while(diff -- >0)
						line+=" ";
				}
				lst.add(line);
				words.clear();
				val = 0;
				linelen = 0;
			} else if (val <= b) {
				words.add(s);

				val += s.length() + 1;
				linelen += s.length();
			}

		}
		return lst;
	}
}
