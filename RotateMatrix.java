package com.kalpesh.ds.inputscanner;

import java.util.Scanner;

public class RotateMatrix {
	static void rotatematrix(int[][] matrix) {
		int m = 3;
		int n = 3;
		int row = 0;
		int col = 0;
		int prev;
		int curr;
		while (row < m && col < n) {
			if (row + 1 == m || col + 1 == n)
				break;
			prev = matrix[row + 1][col];
			for (int i = col; i < n; i++) {
				curr = matrix[row][i];
				matrix[row][i] = prev;
				prev = curr;
			}
			row++;
			for (int i = row; i < m; i++) {
				curr = matrix[i][n - 1];
				matrix[i][n - 1] = prev;
				prev = curr;
			}
			n--;
			if (row < m) {
				for (int i = n - 1; i >= col; i--) {
					curr = matrix[m - 1][i];
					matrix[m - 1][i] = prev;
					prev = curr;
				}
			}
			m--;
			if (col < n) {
				for (int i = m - 1; i >= row; i--) {
					curr = matrix[i][col];
					matrix[i][col] = prev;
					prev = curr;
				}
			}
			col++;
		}
		displayMatrix(matrix);
	}

	private static void displayMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {
		int[][] array = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int choice = 0;
		do {
			System.out.println("\n1.Display elements\n2.Rotate array\n3.Exit");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				displayMatrix(array);
				break;
			case 2:
				System.out.println("Rotated Array:-");
				rotatematrix(array);
				break;
			case 3:
				break;
			}
		} while (choice != 3);
	}
}