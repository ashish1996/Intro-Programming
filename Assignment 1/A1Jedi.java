package a1jedi;

import java.util.Scanner;

public class A1Jedi {

	// Do not change the main method.	
	public static void main(String[] args) {
		Scanner s3 = new Scanner(System.in);

		process(s3);

	}

	public static void process(Scanner s3) {
		// Put your code here.
		
		
		// Number of Assignments and Total Assignment Points
		int numberOfAssignments = s3.nextInt();
		int totalPointsForAssignments = 0;
		for (int i=0; i<numberOfAssignments; i++) {
		int nextPointValue = s3.nextInt();
		totalPointsForAssignments = totalPointsForAssignments + nextPointValue;	
		}
		
		//Read in the Number of Students 
		int numberCounter = 6+numberOfAssignments;
		int numberOfStudents1 = s3.nextInt();
		int numberOfStudents = numberOfStudents1 * numberCounter;
		
		// Initialize Arrays for Each component
		Double[] assignGradeArray;
		assignGradeArray = new Double[numberOfStudents1];
		Double[] recGradeArray;
		recGradeArray = new Double[numberOfStudents1];
		Double[] midtermOneArray;
		midtermOneArray = new Double[numberOfStudents1];
		Double[] midtermTwoArray;
		midtermTwoArray = new Double[numberOfStudents1];
		Double[] finalExamArray;
		finalExamArray = new Double[numberOfStudents1];
		String[] firstNameArray;
		String[] lastNameArray;
		firstNameArray = new String[numberOfStudents1];
		lastNameArray = new String[numberOfStudents1];
		
		//For loop to populate each component's array

		for(int i=0; i<numberOfStudents1; i++ ) {
			
			firstNameArray[i] = s3.next(); //Scan First Name but don't store in variable
			lastNameArray[i] = s3.next(); //Scan last name but don't store in variable
			
			Double numberOfRecitations = s3.nextDouble();
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
			recGradeArray[i] = recGrade * .1;
			
			Double earnedPointsForAssignments = 0.0;
			for (int j=0; j<numberOfAssignments; j++) {
			Double nextPointValue2 = s3.nextDouble();
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
			} else if (percentageForAssignments>=40 && percentageForAssignments < 70) {
				assignGrade = .05*percentageForAssignments -2.0;
			} else { assignGrade = 0.0; }
			assignGradeArray[i] = assignGrade * .4;
			
			Double midtermOne = s3.nextDouble();
			midtermOneArray[i] = midtermOne; //* .15;
			
			Double midtermTwo = s3.nextDouble();
			midtermTwoArray[i] = midtermTwo; //* .15;
			
			Double finalExam = s3.nextDouble();
			finalExamArray[i] = finalExam; //*.2;
		}
		
		//Calculate the average and standard deviation of Midterm One
		double midtermOneArraySum = 0;
		for (int i = 0; i<midtermOneArray.length; i++) {
			midtermOneArraySum = midtermOneArraySum + midtermOneArray[i];
		}
		double midtermOneAverage = midtermOneArraySum/midtermOneArray.length;
		
		double[] midtermOneStandardDeviationArray;
		midtermOneStandardDeviationArray = new double[midtermOneArray.length];
		for (int i = 0; i<midtermOneArray.length; i++) {
			midtermOneStandardDeviationArray [i]= Math.pow(midtermOneArray[i] - midtermOneAverage, 2);	
		}
		
		double midtermOneStandardDeviationArraySum = 0;
		for (int i = 0; i<midtermOneArray.length; i++) {
			midtermOneStandardDeviationArraySum = midtermOneStandardDeviationArraySum + midtermOneStandardDeviationArray[i];
		}
		
		double midtermOneStandardDeviationAverage = midtermOneStandardDeviationArraySum/midtermOneArray.length; 
		double midtermOneStandardDeviation = Math.sqrt(midtermOneStandardDeviationAverage);
		
		//Calculate the Average and Standard Deviation of Midterm Two
		double midtermTwoArraySum = 0;
		for (int i = 0; i<midtermTwoArray.length; i++) {
			midtermTwoArraySum = midtermTwoArraySum + midtermTwoArray[i];
		}
		double midtermTwoAverage = midtermTwoArraySum/midtermTwoArray.length;
		
		double[] midtermTwoStandardDeviationArray;
		midtermTwoStandardDeviationArray = new double[midtermTwoArray.length];
		for (int i = 0; i<midtermTwoArray.length; i++) {
			midtermTwoStandardDeviationArray [i]= Math.pow(midtermTwoArray[i] - midtermTwoAverage, 2);	
		}
		
		double midtermTwoStandardDeviationArraySum = 0;
		for (int i = 0; i<midtermTwoArray.length; i++) {
			midtermTwoStandardDeviationArraySum = midtermTwoStandardDeviationArraySum + midtermTwoStandardDeviationArray[i];
		}
		
		double midtermTwoStandardDeviationAverage = midtermTwoStandardDeviationArraySum/midtermTwoArray.length; 
		double midtermTwoStandardDeviation = Math.sqrt(midtermTwoStandardDeviationAverage);
		
		// Calculate the Average and Standard Deviation of Final Exam
		double finalExamArraySum = 0;
		for (int i = 0; i<finalExamArray.length; i++) {
			finalExamArraySum = finalExamArraySum + finalExamArray[i];
		}
		double finalExamAverage = finalExamArraySum/finalExamArray.length; 
			
		double[] finalExamStandardDeviationArray;
		finalExamStandardDeviationArray = new double[finalExamArray.length];
		for (int i = 0; i<finalExamArray.length; i++) {
			finalExamStandardDeviationArray [i]= Math.pow(finalExamArray[i] - finalExamAverage, 2);	
		}
		
		double finalExamStandardDeviationArraySum = 0;
		for (int i = 0; i<finalExamArray.length; i++) {
			finalExamStandardDeviationArraySum = finalExamStandardDeviationArraySum + finalExamStandardDeviationArray[i];
		}
		
		double finalExamStandardDeviationAverage = finalExamStandardDeviationArraySum/finalExamArray.length; 
		double finalExamStandardDeviation = Math.sqrt(finalExamStandardDeviationAverage);
		
		
		//Initialize variables and arrays needed to count grades
		int counterA = 0;
		int counterAMinus = 0;
		int counterBPlus = 0;
		int counterB = 0;
		int counterBMinus = 0;
		int counterCPlus = 0;
		int counterC = 0;
		int counterCMinus = 0;
		int counterDPlus = 0;
		int counterD = 0;
		int counterF = 0;
		Double[] midtermOneArrayNormalized;
		midtermOneArrayNormalized = new Double[numberOfStudents1];
		Double[] midtermOneArrayCurved;
		midtermOneArrayCurved = new Double[numberOfStudents1];
		Double[] midtermTwoArrayNormalized;
		midtermTwoArrayNormalized = new Double[numberOfStudents1];
		Double[] midtermTwoArrayCurved;
		midtermTwoArrayCurved = new Double[numberOfStudents1];
		Double[] finalExamArrayNormalized;
		finalExamArrayNormalized = new Double[numberOfStudents1];
		Double[] finalExamArrayCurved;
		finalExamArrayCurved = new Double[numberOfStudents1];
		
		//For loop to count grades
		for (int i = 0; i<numberOfStudents1; i++) {
			
			midtermOneArrayNormalized[i] = (midtermOneArray[i] - midtermOneAverage)/midtermOneStandardDeviation;
			if(midtermOneArrayNormalized[i] >= 1.0) {
				midtermOneArrayCurved[i] = 4.0*.15;}
			else if (midtermOneArrayNormalized[i] >= 0.0 && midtermOneArrayNormalized[i] < 1.0) {
				midtermOneArrayCurved[i] = (midtermOneArrayNormalized[i] + 3.0)*.15; }
			else if (midtermOneArrayNormalized[i] >= -1.0 && midtermOneArrayNormalized[i] < 0.0) {
				midtermOneArrayCurved[i] = (midtermOneArrayNormalized[i] + 3.0)*.15; }
			else if (midtermOneArrayNormalized[i] >= -1.5 && midtermOneArrayNormalized[i]< -1.0) {
				midtermOneArrayCurved[i] = (midtermOneArrayNormalized[i]*2.0 + 4.0)*.15; }
			else if (midtermOneArrayNormalized[i] >= -2.0 && midtermOneArrayNormalized[i] < -1.5) {
				midtermOneArrayCurved[i] = (midtermOneArrayNormalized[i]*2.0 + 4.0)*.15; }
			else { midtermOneArrayCurved[i]= 0.0*.15;}
			
			midtermTwoArrayNormalized[i] = (midtermTwoArray[i] - midtermTwoAverage)/midtermTwoStandardDeviation;
			if(midtermTwoArrayNormalized[i] >= 1.0) {
				midtermTwoArrayCurved[i] = 4.0*.15;}
			else if (midtermTwoArrayNormalized[i] >= 0.0 && midtermTwoArrayNormalized[i] < 1.0) {
				midtermTwoArrayCurved[i] = (midtermTwoArrayNormalized[i] + 3.0)*.15; }
			else if (midtermTwoArrayNormalized[i] >= -1.0 && midtermTwoArrayNormalized[i] < 0.0) {
				midtermTwoArrayCurved[i] = (midtermTwoArrayNormalized[i] + 3.0)*.15; }
			else if (midtermTwoArrayNormalized[i] >= -1.5 && midtermTwoArrayNormalized[i]< -1.0) {
				midtermTwoArrayCurved[i] = (midtermTwoArrayNormalized[i]*2.0 + 4.0)*.15; }
			else if (midtermTwoArrayNormalized[i] >= -2.0 && midtermTwoArrayNormalized[i] < -1.5) {
				midtermTwoArrayCurved[i] = (midtermTwoArrayNormalized[i]*2.0 + 4.0)*.15; }
			else { midtermTwoArrayCurved[i]= 0.0*.15;}
			
			finalExamArrayNormalized[i] = (finalExamArray[i] - finalExamAverage)/finalExamStandardDeviation;
			if(finalExamArrayNormalized[i] >= 1.0) {
				finalExamArrayCurved[i] = 4.0*.2;}
			else if (finalExamArrayNormalized[i] >= 0.0 && finalExamArrayNormalized[i] < 1.0) {
				finalExamArrayCurved[i] = (finalExamArrayNormalized[i] + 3.0)*.2; }
			else if (finalExamArrayNormalized[i] >= -1.0 && finalExamArrayNormalized[i] < 0.0) {
				finalExamArrayCurved[i] = (finalExamArrayNormalized[i] + 3.0)*.2; }
			else if (finalExamArrayNormalized[i] >= -1.5 && finalExamArrayNormalized[i]< -1.0) {
				finalExamArrayCurved[i] = (finalExamArrayNormalized[i]*2.0 + 4.0)*.2; }
			else if (finalExamArrayNormalized[i] >= -2.0 && finalExamArrayNormalized[i] < -1.5) {
				finalExamArrayCurved[i] = (finalExamArrayNormalized[i]*2.0 + 4.0)*.2; }
			else { finalExamArrayCurved[i]= 0.0*.2;}
			
			
			Double finalGrade = assignGradeArray[i] + recGradeArray[i] + midtermOneArrayCurved[i] + midtermTwoArrayCurved[i] + finalExamArrayCurved[i];
			if (finalGrade>=3.85) {
				counterA = counterA + 1;
				
			} else if (finalGrade>=3.5 && finalGrade<3.85) {
				counterAMinus = counterAMinus + 1;
				
			} else if (finalGrade>= 3.15 && finalGrade < 3.5) {
				counterBPlus = counterBPlus + 1;
				
			} else if (finalGrade>= 2.85 && finalGrade <3.15) {
				counterB = counterB + 1;
				
			} else if (finalGrade>= 2.5 && finalGrade< 2.85){
				counterBMinus = counterBMinus + 1;
				
			} else if (finalGrade >= 2.15 && finalGrade<2.5) {
				counterCPlus = counterCPlus + 1;
				
			} else if (finalGrade >= 1.85 && finalGrade< 2.15) {
				counterC = counterC + 1;
				
			} else if (finalGrade >= 1.5 && finalGrade < 1.85) {
				counterCMinus = counterCMinus + 1;
				
			} else if (finalGrade >=1.15 && finalGrade < 1.5) {
				counterDPlus = counterDPlus + 1;
				
			} else if (finalGrade >=0.85 && finalGrade < 1.15) {
				counterD = counterD + 1;
				
			} else {counterF = counterF +1; }
						
		}
		
		
		//Print code
		System.out.println("A: " + counterA);
		System.out.println("A-: " + counterAMinus);
		System.out.println("B+: " + counterBPlus);
		System.out.println("B: " + counterB);
		System.out.println("B-: " + counterBMinus);
		System.out.println("C+: " + counterCPlus);
		System.out.println("C: " + counterC);
		System.out.println("C-: " + counterCMinus);
		System.out.println("D+: " + counterDPlus);
		System.out.println("D: " + counterD);
		System.out.println("F: " + counterF);
		
			
		
			}	
	}


