package cdv_2017;

import java.util.Scanner;

public class BallPassing {
	
	public static int steps = 0, poles = 0;
	public static Boolean found = false;
	
	public static void goLeft(int x, int y, int maze[][]){
		
		y-=1;
		if(x >= 0 && x < maze.length && y<maze[0].length && y>=0){
			
			if(maze[x][y] == 0){
				steps+=1;
				goLeft(x, y, maze);
			}else
				if(maze[x][y] == 1){
					steps+=1;
					poles+=1;
					goDown(x, y, maze);
				}else
					if(maze[x][y] == 2){
						steps+=1;
						poles+=1;
						goUp(x, y, maze);
					}else
						if(maze[x][y] == -1){
							//A found
							steps+=1;
							found = true;
						}
			
		}
		
	}
	
	public static void goRight(int x, int y, int maze[][]){
		
		y+=1;
		if(x >= 0 && x < maze.length && y<maze[0].length && y>=0){
			
			if(maze[x][y] == 0){
				steps+=1;
				goRight(x, y, maze);
			}else
				if(maze[x][y] == 1){
					steps+=1;
					poles+=1;
					goUp(x, y, maze);
				}else
					if(maze[x][y] == 2){
						steps+=1;
						poles+=1;
						goDown(x, y, maze);
					}else
						if(maze[x][y] == -1){
							//A found
							steps+=1;
							found = true;
						}
			
		}
		
	}

	public static void goDown(int x, int y, int maze[][]){
		
		x+=1;
		if(x >= 0 && x < maze.length && y<maze[0].length && y>=0){
			
			System.out.println("down x: " + x + " y: " + y);
			if(maze[x][y] == 0){
				steps+=1;
				goDown(x, y, maze);
			}else
				if(maze[x][y] == 1){
					steps+=1;
					poles+=1;
					goLeft(x, y, maze);
				}else
					if(maze[x][y] == 2){
						steps+=1;
						poles+=1;
						goRight(x, y, maze);
					}else
						if(maze[x][y] == -1){
							//A found
							steps+=1;
							found = true;
						}
			
		}
		
	}
	
	public static void goUp(int x, int y, int maze[][]){
	
		x-=1;
		if(x >= 0 && x < maze.length && y<maze[0].length && y>=0){
			
			if(maze[x][y] == 0){
				steps+=1;
				goUp(x, y, maze);
			}else
				if(maze[x][y] == 1){
					steps+=1;
					poles+=1;
					goRight(x, y, maze);
				}else
					if(maze[x][y] == 2){
						steps+=1;
						poles+=1;
						goLeft(x, y, maze);
					}else
						if(maze[x][y] == -1){
							//A found
							steps+=1;
							found = true;
						}
			
		}
		
	}
	public static void solve(int a_x, int a_y, int b_x, int b_y, int maze[][]){
		
		goUp(b_x, b_y, maze);
		if(!found){
			steps = 0;
			poles = 0;
			goDown(b_x, b_y, maze);
		}else{
			System.out.println("Up found");
			return;
		}
		if(!found){
			steps = 0;
			poles = 0;
			goRight(b_x, b_y, maze);
		}else{
			System.out.println("Down found");
			return;
		}
		if(!found){
			steps = 0;
			poles = 0;
			goLeft(b_x, b_y, maze);
		}else{
			System.out.println("Right found");
			return;
		}
		if(!found){
			steps = 0;
			poles = 0;
			//impossible
			System.out.println("-1");
		}else{
			System.out.println("Left found");
			return;
		}
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		s.nextLine();
		String a = s.nextLine();
		System.out.println("a: " + a);
		String b = s.nextLine();
		System.out.println("b: " + b);

		String a_[] = a.split(" ");
		String b_[] = b.split(" ");
		
		int a_x = Integer.parseInt(a_[0]);
		int a_y = Integer.parseInt(a_[1]);
		
		int b_x = Integer.parseInt(b_[0]);
		int b_y = Integer.parseInt(b_[1]);
		
		int maze[][] = new int[size][size];
		
		//assign the values to 0 in maze
		for(int i=0; i<maze.length; i++){
			for(int j=0 ;j<maze[0].length; j++){
				maze[i][j] = s.nextInt();
			}
		}
		//A = -1, B = -2;
		maze[a_x][a_y] = -1;
		maze[b_x][b_y] = -2;
		
		solve(a_x, a_y, b_x, b_y, maze);
		if(found){
			System.out.println("found : " + " steps: " + steps + " poles: " + poles);
		}
		s.close();
	}

}
