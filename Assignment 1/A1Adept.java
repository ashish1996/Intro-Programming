package a1adept;

import java.util.Scanner;

public class A1Adept {
	
	// Do not change the main method.	
	public static void main(String[] args) {
		Scanner s2 = new Scanner(System.in);
		
		process(s2);
		
	}
	
	public static void process(Scanner s2) {
		// Put your code here.
		
		//Calculate Number of Assignments and Points alotted for them
		
		int numberOfAssignments = s2.nextInt();
		int totalPointsForAssignments = 0;
		for (int i=0; i<numberOfAssignments; i++) {
		int nextPointValue = s2.nextInt();
		totalPointsForAssignments = totalPointsForAssignments + nextPointValue;	
		}
		
		// Number of Students and Counter Variable
		
		int numberCounter = 6+numberOfAssignments;
		int numberOfStudents1 = s2.nextInt();
		int numberOfStudents = numberOfStudents1 * numberCounter;

		
		//For Loop that calculates recitations and Assignments
		for(int i=0; i<numberOfStudents; i++ ) {
			
			String firstName = s2.next();
			String firstInitial= firstName.substring(0,1);
			
			String lastName = s2.next();
			
			Double numberOfRecitations = s2.nextDouble();
			Double percentageForRecitations = numberOfRecitations/15*100;
			Double recGrade;
			if (percentageForRecitations>= 95) {
				recGrade = 4.0;
			} else if (percentageForRecitations>= 90 && percentageForRecitations< 95) {
				recGrade = .1*percentageForRecitations - 5.5;
			} else if (percentageForRecitations>= 80 && percentageForRecitations<90) {
				recGrade = .1*percentageForRecitations - 5.5;
			} else if (percentageForRecitations>= 70 && percentageForRecitations< 80) {
				recGrade = .1*percentageForRecitations - 5.5;
			} else if (percentageForRecitations>40 && percentageForRecitations < 70) {
				recGrade = .05*percentageForRecitations -2;
			} else { recGrade = 0.0; }
			Double recGradeWt = recGrade * .1;
			
			Double earnedPointsForAssignments = 0.0;
			for (int j=0; j<numberOfAssignments; j++) {
			Double nextPointValue2 = s2.nextDouble();
			earnedPointsForAssignments = earnedPointsForAssignments + nextPointValue2;	
			}
			Double assignGrade= 0.0;
			Double percentageForAssignments = earnedPointsForAssignments/totalPointsForAssignments * 100;
			if (percentageForAssignments>= 95) {
				assignGrade = 4.0;
			} else if (percentageForAssignments>= 90 && percentageForAssignments< 95) {
				assignGrade = .1*percentageForAssignments - 5.5;
			} else if (percentageForAssignments>= 80 && percentageForAssignments<90) {
				assignGrade = .1*percentageForAssignments - 5.5;
			} else if (percentageForAssignments>= 70 && percentageForAssignments< 80) {
				assignGrade = .1*percentageForAssignments - 5.5;
			} else if (percentageForAssignments>40 && percentageForAssignments < 70) {
				assignGrade = .05*percentageForAssignments -2.0;
			} else { assignGrade = 0.0; }
			Double assignGradeWt = assignGrade * .4;
			
			Double midtermOne = s2.nextDouble();
			Double midtermOneWt = midtermOne * .15;
			
			Double midtermTwo = s2.nextDouble();
			Double midtermTwoWt = midtermTwo * .15;
			
			Double finalExam = s2.nextDouble();
			Double finalExamWt = finalExam*.2;
			
			Double finalGrade = assignGradeWt + recGradeWt + midtermOneWt + midtermTwoWt + finalExamWt;
			if (finalGrade>=3.85) {
				String finalOutput = firstInitial + ". " + lastName + " A";
				System.out.println(finalOutput);
			} else if (finalGrade>=3.5 && finalGrade<3.85) {
				String finalOutput = firstInitial + ". " +lastName + " A-";
				System.out.println(finalOutput);
			} else if (finalGrade>= 3.15 && finalGrade < 3.5) {
				String finalOutput = firstInitial + ". " +lastName + " B+";
				System.out.println(finalOutput);
			} else if (finalGrade>= 2.85 && finalGrade <3.15) {
				String finalOutput = firstInitial + ". " +lastName + " B";
				System.out.println(finalOutput);
			} else if (finalGrade>= 2.5 && finalGrade< 2.85){
				String finalOutput = firstInitial + ". " +lastName + " B-";
				System.out.println(finalOutput);
			} else if (finalGrade >= 2.15 && finalGrade<2.5) {
				String finalOutput = firstInitial + ". " +lastName + " C+";
				System.out.println(finalOutput);
			} else if (finalGrade >= 1.85 && finalGrade< 2.15) {
				String finalOutput = firstInitial + ". " +lastName + " C";
				System.out.println(finalOutput);
			} else if (finalGrade >= 1.5 && finalGrade < 1.85) {
				String finalOutput = firstInitial + ". " +lastName + " C-";
				System.out.println(finalOutput);
			} else if (finalGrade >=1.15 && finalGrade < 1.5) {
				String finalOutput = firstInitial + ". " +lastName + " D+";
				System.out.println(finalOutput);
			} else if (finalGrade >=0.85 && finalGrade < 1.15) {
				String finalOutput = firstInitial + ". " +lastName + " D";
				System.out.println(finalOutput);
			} else {
				String finalOutput = firstInitial + ". " + lastName + " F";
				System.out.println(finalOutput);
			}

		}		
		
	}

}
