package string;

public class PowerOf2 {
	public static void main(String[] args) {
		System.out.println(new PowerOf2().power("128"));
	}

	public int power(String a) {
		char c[] = a.toCharArray();
		while (true) {
			int n = c.length;
			int rem = 0, quo = 0, cur = Character.getNumericValue(c[0]);
			String res = "";
			for (int i = 1; i <= n; i++) {
				// System.out.println("cur ="+cur);
				rem = cur % 2;
				quo = cur / 2;
				if(i==n && rem ==1)
					return 0;
				// System.out.println("rem = "+rem +" quo= "+quo);
				res += quo;
				if (i < n) {
					// System.out.println("c["+i+"] = "+c[i]);
					cur = rem * 10 + Character.getNumericValue(c[i]); // next
																		// char
																		// in
																		// string
				}
				// System.out.println("res = "+res);

			}
//			System.out.println(res);
			int i = 0;
			while (res.charAt(i) == '0')
				i++;
			res = res.substring(i, res.length());
//			System.out.println("--" + res);
			 if(res.equalsIgnoreCase("1"))
				return 1;
			c = res.toCharArray();
		}
	}
}
