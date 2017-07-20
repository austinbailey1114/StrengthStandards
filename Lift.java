package lift;

public class Lift {
	double bodyWeight; //kgs
	double weight; // 
	double reps;
	String liftType;
	double wilks_constants[] = {-216.0475144, 16.2606339, -0.002388645, -0.00113732, 7.01863e-06, -1.291e-08};
	public Lift(String w, String r, String bw, String l) {
		bodyWeight = Double.parseDouble(bw);
		weight = Double.parseDouble(w);
		reps = Double.parseDouble(r);
		liftType = l;
		this.printLiftInfo();
	}
	
	private double max() {
		return weight *(1 +(reps/30));
	}
	private double wilks() {
		return ((500) / ((wilks_constants[0] + (wilks_constants[1] * bodyWeight) + (wilks_constants[2] * Math.pow(bodyWeight, 2)) +
				(wilks_constants[3] * Math.pow(bodyWeight, 3)) + (wilks_constants[4] * Math.pow(bodyWeight, 4)) + (wilks_constants[5] * Math.pow(bodyWeight, 5)))));
	}
	
	private double wilksWeight() {
		return this.max() * this.wilks();
	}
	
	private void printEstimatedReps() {
		System.out.println("\tEstimated Reps at % of One Rep Maximum");
		System.out.println("Reps:  1     2     3     4     5     6     7     8     9     10");
		System.out.println("%:    100    95    90    88    86    83    80    78    76    75");
		System.out.println("Wght: " + (int) this.max() + "   " + (int) (this.max() * .95) + "   " + (int) (this.max() * .9) + "   " + 
				(int) (this.max() * .88) + "   " + (int) (this.max() * .86) + "   " + (int) (this.max() * .83) + "   " + (int) (this.max() * .8)
				+ "   " + (int) (this.max() * .78) + "   " + (int) + (this.max() * .76) + "   " + (int) (this.max() * .75));
	}
	
	public void printLiftInfo() {
		System.out.println(liftType);
		System.out.println();
		System.out.println("One Rep Max: " + (int) this.max());
		System.out.println();
		System.out.println("Level: " + this.levelChecker());
		System.out.println();
		this.printEstimatedReps();
	}
	
	public String levelChecker() {
		double noviceS = 147.51; double intermediateS = 178.42; double advancedS = 244.93; double eliteS = 319.72;
		double noviceD = 183.18; double intermediateD = 211.31; double advancedD = 286.78; double eliteD = 348.53; 
		double noviceI = 82.33; double intermediateI = 113.20; double advancedI = 164; double eliteI = 209.26;

		if (this.liftType.equals("deadlift")) {
			if((this.wilksWeight() < noviceD)) {
				return "Untrained";
			} else if((this.wilksWeight() >= noviceD) && (this.wilksWeight() < intermediateD)) {
				return "Novice";
			} else if((this.wilksWeight() >= intermediateD) && (this.wilksWeight() < advancedD)) {
				return "Intermediate";
			} else if((this.wilksWeight() >= advancedD) && (this.wilksWeight() < eliteD)) {
				return "Advanced";
			}
			else return "Elite";
		}
		else if (this.liftType.equals("squat")) {
			if((this.wilksWeight() < noviceS)) {
				return "Untrained";
			} else if((this.wilksWeight() >= noviceS) && (this.wilksWeight() < intermediateS)) {
				return "Novice";
			} else if((this.wilksWeight() >= intermediateS) && (this.wilksWeight() < advancedS)) {
				return "Intermediate";
			} else if((this.wilksWeight() >= advancedS) && (this.wilksWeight() < eliteS)) {
				return "Advanced";
			}
			else return "Elite";
		}
		else if (this.liftType.equals("bench")) {
			if((this.wilksWeight() < noviceI)) {
				return "Untrained";
			} else if((this.wilksWeight() >= noviceI) && (this.wilksWeight() < intermediateI)) {
				return "Novice";
			} else if((this.wilksWeight() >= intermediateI) && (this.wilksWeight() < advancedI)) {
				return "Intermediate";
			} else if((this.wilksWeight() >= advancedI) && (this.wilksWeight() < eliteI)) {
				return "Advanced";
			}
			else return "Elite";
		}
		return "None";
			
	}
	

	
}
