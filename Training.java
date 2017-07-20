package lift;
import java.util.*;

public class Training {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter your lift in the following format:");
		System.out.println("lift,bodyweight,liftweight,liftreps");
		System.out.println();
		System.out.print("Enter here: ");
		
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		scanner.close();
		String info[] = input.split(",");
		
		Lift test = new Lift(info[2], info[3], info[1], info[0]);
		test.printLiftInfo();
	}

}
