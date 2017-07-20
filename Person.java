package lift;

public class Person {	
	String name, bodyWeight, height, deadliftWeight, deadliftReps, squatWeight, squatReps, benchWeight, benchReps;
	public Person(String n, String b, String h, String dlw, String dlr, String sw, String sr, String bw, String br) {
		name = n; bodyWeight = b; height = h; deadliftWeight = dlw; deadliftReps = dlr; squatWeight = sw; squatReps = sr; benchWeight = bw; benchReps = br;
		Lift bench = new Lift(benchWeight, benchReps, bodyWeight, "bench");
		System.out.println();
		Lift squat = new Lift(squatWeight, squatReps, bodyWeight, "squat");
		System.out.println();
		Lift deadlift = new Lift(deadliftWeight, deadliftReps, bodyWeight, "deadlift");
	}

}
