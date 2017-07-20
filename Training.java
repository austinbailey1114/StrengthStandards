package lift;
import java.util.*;
import  java.io.*;

public class Training {

	public static void main(String[] args) {
		System.out.print("Enter your name.txt here: ");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		scanner.close();
		
		InputStream filereader = null;
		try {
			filereader = new FileInputStream(name);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		BufferedReader buf = new BufferedReader(new InputStreamReader(filereader));
		String info[] = new String[9];
		for(int i = 0; i < 9; i++) {
			try {
				info[i] = buf.readLine();
			} catch (IOException e) {
				System.out.println("Line not found at index" + i);
			}
		}
		Person austin = new Person(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8]);
	}

}
