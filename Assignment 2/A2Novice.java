package a2novice;

import java.util.Scanner;

public class A2Novice {

	public static void main(String[] args) { // initialize the scanner
		Scanner s = new Scanner(System.in);

		process(s);

	}

	public static void process(Scanner s) {
		// Put your code here.
		
		int picWidth = s.nextInt();
		int picHeight = s.nextInt();
		int maxValue = 0;
		int minValue = 99;
		int [][] pixelArray = new int [picWidth][picHeight];
		
		//Populate an array that holds the pixel's
		for (int i = 0; i<picWidth; i++ ) {
			for ( int j = 0; j<picHeight; j++) {
				pixelArray [i][j] = s.nextInt();
			}
		}
			
	//Print appropriate symbols for each pixel value	
		double sumOfPixelValues = 0;
		for (int i = 0; i<picHeight; i++) {
			for ( int j=0; j<picWidth; j++) {
			
				if (pixelArray [j][i] >=0 && pixelArray [j][i]<=9) {
					sumOfPixelValues = sumOfPixelValues + pixelArray [j][i];
					System.out.print("#");
				} else if (pixelArray[j][i]>=10 && pixelArray[j][i]<=19) {
					sumOfPixelValues = sumOfPixelValues + pixelArray [j][i];
					System.out.print("M");
				} else if (pixelArray[j][i]>=20 && pixelArray[j][i]<=29) {
					sumOfPixelValues = sumOfPixelValues + pixelArray [j][i];
					System.out.print("X");
				} else if (pixelArray[j][i]>=30 && pixelArray[j][i]<=39) {
					sumOfPixelValues = sumOfPixelValues + pixelArray [j][i];
					System.out.print("D");
				} else if (pixelArray[j][i]>=40 && pixelArray[j][i]<=49) {
					sumOfPixelValues = sumOfPixelValues + pixelArray [j][i];
					System.out.print("<");
				} else if (pixelArray[j][i]>=50 && pixelArray[j][i]<=59) {
					sumOfPixelValues = sumOfPixelValues + pixelArray [j][i];
					System.out.print(">");
				} else if (pixelArray[j][i]>=60 && pixelArray[j][i]<=69) {
					sumOfPixelValues = sumOfPixelValues + pixelArray [j][i];
					System.out.print("s");
				} else if (pixelArray[j][i]>=70 && pixelArray[j][i]<=79) {
					sumOfPixelValues = sumOfPixelValues + pixelArray [j][i];
					System.out.print(":");
				} else if (pixelArray[j][i]>=80 && pixelArray[j][i]<=89) {
					sumOfPixelValues = sumOfPixelValues + pixelArray [j][i];
					System.out.print("-");
				} else {System.out.print(" ");
						sumOfPixelValues = sumOfPixelValues + pixelArray[j][i];};
					
			}
			System.out.println();
		}
		
		//Calculate Max Value
		for(int i=0;i<picHeight;i++){           
            for(int j=0;j<picWidth;j++)        
            	if(pixelArray[j][i] > maxValue){           
                    maxValue = pixelArray[j][i];           
            	}
		}
		
		//Calculate Minimum Value
		for(int i=0;i<picHeight;i++){           
            for(int j=0;j<picWidth;j++)        
            	if(pixelArray[j][i] < minValue){           
                    minValue = pixelArray[j][i];           
            	}
		}
		
		//Print max and minimum values
		System.out.println("Min value = " + minValue);
		System.out.println("Max value = " + maxValue);
		
		//Calculate and Print Average Value
		double averageValue = sumOfPixelValues/(picWidth*picHeight);
		System.out.println("Average value = "+ averageValue);
                                                                   

            }
	}

