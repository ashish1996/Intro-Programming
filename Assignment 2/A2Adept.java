package a2adept;

import java.util.Scanner;

public class A2Adept {

	public static void main(String[] args) { //initialize scanner
		Scanner s = new Scanner(System.in);

		process(s);

	}

	public static void process(Scanner s) {
		// Put your code here.
		
		double binWidth = s.nextInt();
		double picWidth = s.nextInt();
		double picHeight = s.nextInt();
		double numOfPixels = picHeight*picWidth;
		double numOfBinsDouble = (100/binWidth);
		double numOfBins = Math.ceil(numOfBinsDouble); 
		double [] binArray = new double [(int) (numOfBins)];
		double [] binPercentArray = new double [(int) numOfBins];
		
		
		//Populate an array to represent an bin indexes.
		for (int i = 0; i< numOfPixels; i++) {
			double pixelCounter = s.nextInt();
			double binIndexDouble = pixelCounter/(binWidth);
			double binIndex = Math.floor(binIndexDouble);
			binArray[(int) binIndex] = binArray[(int)binIndex] +1;
				}
			
			
		//Populate and print an array/histogram representing the percentage of bins
		int binWidthNew = (int) binWidth;
		for (int i = 0; i<numOfBins; i++) {
			binPercentArray[i] = ((binArray[i]/numOfPixels*100));
			binPercentArray[i] = Math.round(binPercentArray[i]);
			
			if (i*binWidthNew < 10) {
				System.out.print(" " + i*binWidthNew + ":");
			}
			
			else{
			System.out.print(i*binWidthNew + ":");
			}
			for (int j=0; j<binPercentArray[i]; j++) {
				
					System.out.print("*");
				
				
			}
			System.out.println();
		}
		
		
		
	}

}
