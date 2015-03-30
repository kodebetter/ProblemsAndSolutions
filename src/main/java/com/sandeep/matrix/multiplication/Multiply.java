/**
 * 
 */
package com.sandeep.matrix.multiplication;

/**
 * @author sandeept
 *
 */
public class Multiply {
	
	
	public void  twodarraymultiplication() {
		int a [][] = {{1,2},{1,2},{1,2}};
		int b [][] = {{1,2,3},{1,2,3}};	
		int c[][] = new int[3][3];
		int sum =0;
		for(int i = 0 ;i < 3; i++){
			for(int j = 0 ;j<3;j++){
				for(int k = 0 ;k<2;k++){
					sum = sum +(a[i][k]*b[k][j]);		
				}
				c[i][j] = sum;
				System.out.print(sum + " ");
				sum =0;
			}
			System.out.println();
		}
		
	}
}
