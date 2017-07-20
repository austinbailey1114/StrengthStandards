package lift;
import java.util.*;
import  java.io.*;

public class Training {

	public static void main(String[] args) {
		System.out.print("Are you a new user? (yes/no): ");
		Scanner scanner = new Scanner(System.in);
		if(scanner.nextLine().equals("no")) {
			System.out.print("Enter your name here: ");
			String name = scanner.nextLine() + ".txt";
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
		else {
			System.out.print("Enter your name: ");
			String filename = scanner.nextLine() + ".txt";
			FileWriter filewriter = null;
			try {
				filewriter = new FileWriter(filename);
			} catch (IOException e) {
				System.out.println("File not found");
			}
			BufferedWriter buf = new BufferedWriter(filewriter);
			System.out.println("Enter your information in the following format:");
			System.out.println("name,bodyweight,height,deadliftweight,deadliftreps,squatweight,squatreps,benchweight,benchreps");
			String data[] = scanner.nextLine().split(",");
			for(int i = 0; i < 9; i++) {
				try {
					buf.write(data[i] + "\n");
					//buf.newLine();
				} catch (IOException e) {
					System.out.println("Cannot write to file");
				}				
			}
			try {
				buf.close();
			} catch (IOException e) {
				System.out.println("cannot close buf");
			}
			Person newPerson = new Person(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8]);
		}
		
		
	}

}
