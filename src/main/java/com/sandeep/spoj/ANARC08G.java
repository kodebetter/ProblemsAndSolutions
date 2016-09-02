package com.sandeep.spoj;

import java.util.Scanner;

public class ANARC08G {

	public static void main(String[] args) {

		int input[][];
		int row, column;

		Scanner scan = new Scanner(System.in);

		System.out.println("Matrix Creation");

		System.out.println("\nEnter number of rows :");
		row = Integer.parseInt(scan.nextLine());
		column = row;

		input = new int[row][column];
		System.out.println("Enter the data :");

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < column; j++) {

				input[i][j] = scan.nextInt();
			}
		}
		
		int[] creaditArray = new int[row];
		int[] debitArray = new int[row];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				creaditArray[i] = creaditArray[i] + input[i][j];
				debitArray[i] = debitArray[i] + input[j][i];
			}
		}
		int totalMoneyLeft = 0;
		int totalSum = 0;
		for (int i = 0; i < creaditArray.length; i++) {
			if ((creaditArray[i] - debitArray[i]) >= 0)
				totalMoneyLeft = totalMoneyLeft + (creaditArray[i] - debitArray[i]);
			totalSum = totalSum + creaditArray[i];
		}
		System.out.println(totalMoneyLeft);
		System.out.println(totalSum);

	}
}
