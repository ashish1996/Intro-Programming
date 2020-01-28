package a1novice;

import java.util.Scanner;

public class A1Novice {

	// Do not change the main method.	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		process(s);
	}
	
	public static void process(Scanner s) {
		// Put your code here.
		

// Store the total number of students in a variable and multiply it by 7 to produce a counter for the for loop later
		int numberOfRunsForLoop = s.nextInt() * 7;
// Run a for loop to produce desired output
		for(int i=1; i<=numberOfRunsForLoop; i++ ) {
			
			String firstName = s.next(); // String for first name
			String firstInitial= firstName.substring(0,1); // Produce first initial
			
			String lastName = s.next(); // String for last name
			
			Double assignGrade = s.nextDouble();
			Double assignGradeWt = assignGrade * .4; // Produce weighted average for assignment grades
			
			Double recGrade = s.nextDouble();
			Double recGradeWt = recGrade * .1; // Produce weighted average for recitation grades
			
			Double midtermOne = s.nextDouble();
			Double midtermOneWt = midtermOne * .15; // Produce weighted average for midterm one
			
			Double midtermTwo = s.nextDouble();
			Double midtermTwoWt = midtermTwo * .15; // Produce weighted average for midterm two
			
			Double finalExam = s.nextDouble();
			Double finalExamWt = finalExam*.2; // Produce weighted average for final exam
			
			Double finalGrade = assignGradeWt + recGradeWt + midtermOneWt + midtermTwoWt + finalExamWt; // Produce Output
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
