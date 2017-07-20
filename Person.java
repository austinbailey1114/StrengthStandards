package lift;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Person {	
	static String name, bodyWeight, height, deadliftWeight, deadliftReps, squatWeight, squatReps, benchWeight, benchReps;
	@SuppressWarnings("unused")
	public Person(String n, String b, String h, String dlw, String dlr, String sw, String sr, String bw, String br) {
		name = n; bodyWeight = b; height = h; deadliftWeight = dlw; deadliftReps = dlr; squatWeight = sw; squatReps = sr; benchWeight = bw; benchReps = br;
		System.out.println("----------------------------------------------------------------");
		Lift bench = new Lift(benchWeight, benchReps, bodyWeight, "bench");
		System.out.println("----------------------------------------------------------------");
		Lift squat = new Lift(squatWeight, squatReps, bodyWeight, "squat");
		System.out.println("----------------------------------------------------------------");
		Lift deadlift = new Lift(deadliftWeight, deadliftReps, bodyWeight, "deadlift");
	}
	
	static void updateInfo(String filename, String data[], String updateField) {
		FileWriter filewriter = null;
		try {
			filewriter = new FileWriter(filename);
		} catch (IOException e) {
			System.out.println("File not found");
		}
		BufferedWriter buf = new BufferedWriter(filewriter);
		if (updateField.equals("weight")) updateWeight(data);
		else if (updateField.equals("height")) updateHeight(data);
		else if (updateField.equals("deadlift")) updateDeadlift(data);
		else if (updateField.equals("squat")) updateSquat(data);
		else if (updateField.equals("bench")) updateBench(data);
		for(int i = 0; i < 9; i++) {
			try {
				buf.write(data[i] + "\n");
			} catch (IOException e) {
				System.out.println("Cannot write to file");
			}				
		}
		try {
			buf.close();
		} catch (IOException e) {
			System.out.println("cannot close buf");
		}
	}
	static public void updateWeight(String info[]) {
		Scanner updater = new Scanner(System.in);
		System.out.print("Enter new body weight: ");
		info[1] = updater.nextLine();
		updater.close();
		Person person = new Person(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8]);
	}
	static public void updateHeight(String info[]) {
		Scanner updater = new Scanner(System.in);
		System.out.print("Enter new height ");
		info[2] = updater.nextLine();
		updater.close();
		Person person = new Person(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8]);

	}
	static public void updateDeadlift(String info[]) {
		Scanner updater = new Scanner(System.in);
		System.out.print("Enter new deadlift (weight,reps): ");
		String newLift[] = updater.nextLine().split(",");
		info[3] = newLift[0];
		info[4] = newLift[1];
		updater.close();
		Person person = new Person(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8]);
	}
	static public void updateSquat(String info[]) {
		Scanner updater = new Scanner(System.in);
		System.out.print("Enter new squat (weight,reps): ");
		String newLift[] = updater.nextLine().split(",");
		info[5] = newLift[0];
		info[6] = newLift[1];
		updater.close();
		Person person = new Person(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8]);

	}
	static public void updateBench(String info[]) {
		Scanner updater = new Scanner(System.in);
		System.out.print("Enter new bench (weight,reps): ");
		String newLift[] = updater.nextLine().split(",");
		info[7] = newLift[0];
		info[8] = newLift[1];
		updater.close();
		Person person = new Person(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8]);
	}

}
