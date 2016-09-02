package com.sandeep.spoj;

import java.util.Scanner;

public class ANARC08h {

	
	
 
	public static int[][] readFromConsole() {
		
		Scanner scan;
		int matrix[][];
		int row, column;
		
		scan = new Scanner(System.in);
		
		System.out.println("Matrix Creation");
		
		System.out.println("\nEnter number of rows :");
		row = Integer.parseInt(scan.nextLine());
		
		System.out.println("Enter number of columns :");
		column = Integer.parseInt(scan.nextLine());
		
		matrix = new int[row][column];
		System.out.println("Enter the data :");
 
		for(int i=0; i<row; i++) {
			
			for(int j=0; j<column; j++) {
				
				matrix[i][j] = scan.nextInt();
			}
		}
		return matrix;
	}

	public static void main(String[] args) {
		
		int [][] input = readFromConsole();
		int [] creaditArray =  new int[4];
		int [] debitArray =  new int[4];
		for(int i = 0 ; i < 4 ; i++){
			for(int j=0; j < 4 ;j ++){
				creaditArray[i] = creaditArray[i] + input[i][j];
				debitArray[i] = debitArray[i] + input[j][i];
			}
		}
		int totalMoneyLeft =0;
		int totalSum  = 0;
		for(int i = 0 ; i< creaditArray.length; i++ ){
			if((creaditArray[i] - debitArray[i]) >= 0)
			 totalMoneyLeft = totalMoneyLeft + (creaditArray[i] - debitArray[i]);
			 totalSum = totalSum + creaditArray[i];	
		}
		System.out.println(totalMoneyLeft );
		System.out.println(totalSum);
		
	}
}
