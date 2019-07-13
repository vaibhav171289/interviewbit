package array;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileRead {
public static void main(String[] args) throws FileNotFoundException {
	File f = new File("src/test.txt");
	Scanner sc = new Scanner(f);
	int count=0;
	while (sc.hasNext()) {
		String s = sc.next();
		count++;
	}
	System.out.println(count);
}
}
