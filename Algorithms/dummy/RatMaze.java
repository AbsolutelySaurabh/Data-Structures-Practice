package dummy;

import java.util.Scanner;

public class RatMaze {
	
	public static Boolean solveMaze(int maze[][], int row, int col) {
		
		if(row == maze.length-1 && col == maze.length-1) {
			return true;
		}
		
		System.out.println("maze length: " + maze.length);
		System.out.println("row: " + row + " col: " + col);

		if(row == maze.length-1 && col!=maze.length-1) {
			return true;
		}
		if(col == maze.length-1 && row!=maze.length-1) {
			return true;
		}
		Boolean result = false;
		
		if(maze[row+1][col] == 1) {
			result = solveMaze(maze, row+1, col);
		}
		if(result) {
			System.out.println("( " + row + " , " + col +" )");
		}
		if(!result) {
			if(maze[row][col+1] == 1) {
				result = solveMaze(maze, row, col+1);
			}
		}
		if(result) {
			System.out.println("( " + row + " , " + col +" )");
		}
		return result;
	}

	public static void main(String[] args) {
		
		//see if the path exists or not
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int maze[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				maze[i][j] = s.nextInt();
			}
		}
		if(solveMaze(maze, 0, 0)) {
			System.out.println("Path exists");
		}else {
			System.out.println("No Path");
		}
		s.close();
	}
}
