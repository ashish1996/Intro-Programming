package a2jedi;

import java.util.Scanner;

public class A2Jedi {

	public static void main(String[] args) {
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
		
		
		//Populate an array representing bin indexes
		for (int i = 0; i< numOfPixels; i++) {
			double pixelCounter = s.nextInt();
			double binIndexDouble = pixelCounter/(binWidth);
			double binIndex = Math.floor(binIndexDouble);
			binArray[(int) binIndex] = binArray[(int)binIndex] +1;
				}


		//Populate an array that has the percentages for each bin
		for (int i = 0; i<numOfBins; i++) {
			binPercentArray[i] = ((binArray[i]/numOfPixels*100));
			binPercentArray[i] = Math.round(binPercentArray[i]);
		}
		
		//Extract max value of percent array
	double maxValue=0;
		for (int i = 0; i<numOfBins; i++) {
			if (binPercentArray[i]>maxValue) {
				maxValue = binPercentArray[i];
			}
		}
		
		//Print asterisk's for histogram
		for (int i = (int) maxValue; i>0; i--) {
			for ( int j = 0; j< numOfBins; j++) {
			if (i<=binPercentArray[j]) {
				System.out.print("*");
			}
			else { System.out.print(" ");
			}
		}
			System.out.println();
		}
		
		//Print dashed lines
		for (int i=0; i<numOfBins; i++) {
			
		System.out.print("-");
		}
		System.out.println();
			
		//Print tens place of bin numbers vertically
		for (int i=0; i<binArray.length; i++){
			int tens = ( i*(int) binWidth)/10;
			if (tens==0) {
				System.out.print(" ");
			}else{
				System.out.print(tens);
				
			}
		}
		
		//Print ones place of bin numbers
		System.out.println();
		for (int i=0; i<binArray.length; i++) {
			System.out.print(i*(int)binWidth%10);
		}
		}
		
		
		
		
	




	}


