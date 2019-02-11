package cdv_2017;

import java.util.Scanner;

public class ForestFire {
	
	public static Boolean all_caught = false;
	public static int max_minute = 0;
	
	public static void goSouthEast(int x, int y, int initial, int forest[][]){
		
		x+=1;
		y+=1;
		if(x>=0 && x<forest.length && y<forest[0].length && y>=0){
			
			//if tree present
			if(forest[x][y] == 0){
				System.out.print("Tree: " + " index: " + x + " y: " + y + " initial: " + initial);
				forest[x][y]+=initial+1;
				System.out.print(" final " + forest[x][y]);
				if(forest[x][y] > max_minute){
					max_minute = forest[x][y];
				}
				System.out.println(" max_minute: " + max_minute);
				initial = forest[x][y];
				goNorthEast(x, y,initial, forest);
				goEast(x, y,initial, forest);
				goSouth(x, y,initial, forest);
				goSouthEast(x, y,initial, forest);
				goSouthWest(x, y,initial, forest);

			}
			
		}
		
	}
	
	public static void goSouthWest(int x, int y, int initial, int forest[][]){
		
		x+=1;
		y-=1;
		if(x>=0 && x<forest.length && y<forest[0].length && y>=0){
			
			//if tree present
			if(forest[x][y] == 0){
				System.out.print("Tree: " + " index: " + x + " y: " + y + " initial: " + initial);
				forest[x][y]+=initial+1;
				System.out.print(" final " + forest[x][y]);
				if(forest[x][y] > max_minute){
					max_minute = forest[x][y];
				}
				System.out.println(" max_minute: " + max_minute);
				initial = forest[x][y];
				goNorthWest(x, y,initial, forest);
				goWest(x,y,initial, forest);
				goSouth(x, y,initial, forest);
				goSouthEast(x, y,initial, forest);
				goSouthWest(x, y,initial, forest);

			}
			
		}
		
	}
	
	public static void goSouth(int x, int y, int initial, int forest[][]){
		
		x+=1;
		if(x>=0 && x<forest.length && y<forest[0].length && y>=0){
			
			//if tree present
			if(forest[x][y] == 0){
				System.out.print("Tree: " + " index: " + x + " y: " + y + " initial: " + initial);
				forest[x][y]+=initial+1;
				System.out.print(" final " + forest[x][y]);
				if(forest[x][y] > max_minute){
					max_minute = forest[x][y];
				}
				System.out.println(" max_minute: " + max_minute);
				initial = forest[x][y];
				goSouth(x, y,initial, forest);
				goSouthEast(x, y,initial, forest);
				goSouthWest(x, y,initial, forest);

			}
			
		}
		
	}
	
	public static void goWest(int x, int y, int initial, int forest[][]){
		
		y-=1;
		if(x>=0 && x<forest.length && y<forest[0].length && y>=0){
			
			//if tree present
			if(forest[x][y] == 0){
				System.out.print("Tree: " + " index: " + x + " y: " + y + " initial: " + initial);
				forest[x][y]+=initial+1;
				System.out.print(" final " + forest[x][y]);
				if(forest[x][y] > max_minute){
					max_minute = forest[x][y];
				}
				System.out.println(" max_minute: " + max_minute);
				initial = forest[x][y];
				goNorthWest(x, y,initial, forest);
				goWest(x, y,initial, forest);
				goSouthWest(x, y,initial, forest);
			}
			
		}else{
			System.out.println("West not allowed.");
		}
		
	}
	
	public static void goEast(int x, int y, int initial, int forest[][]){
		
		y+=1;
		if(x>=0 && x<forest.length && y<forest[0].length && y>=0){
			
			//if tree present
			if(forest[x][y] == 0){
				System.out.print("Tree: " + " index: " + x + " y: " + y + " initial: " + initial);
				forest[x][y]+=initial+1;
				System.out.print(" final " + forest[x][y]);
				if(forest[x][y] > max_minute){
					max_minute = forest[x][y];
				}
				System.out.println(" max_minute: " + max_minute);
				initial = forest[x][y];
				goNorthEast(x, y,initial, forest);
				goEast(x, y,initial, forest);
				goSouthEast(x, y,initial, forest);
			}
			
		}else{
			System.out.println("East not allowed.");
		}
		
	}
	
	public static void goNorthEast(int x, int y, int initial, int forest[][]){
		
		x-=1;
		y+=1;
		if(x>=0 && x<forest.length && y<forest[0].length && y>=0){
			
			//if tree present
			if(forest[x][y] == 0){
				System.out.print("Tree: " + " index: " + x + " y: " + y + " initial: " + initial);
				forest[x][y]+=initial+1;
				System.out.print(" final " + forest[x][y]);
				if(forest[x][y] > max_minute){
					max_minute = forest[x][y];
				}
				System.out.println(" max_minute: " + max_minute);
				initial = forest[x][y];
				goNorth(x, y, initial, forest);
				goNorthEast(x, y,initial, forest);
				goNorthWest(x, y,initial, forest);
				goEast(x, y,initial, forest);
				goSouthEast(x, y,initial, forest);
			}
			
		}else{
			System.out.println("North East not allowed.");
		}
		
	}
	
	public static void goNorthWest(int x, int y, int initial, int forest[][]){
		
		x-=1;
		y-=1;
		if(x>=0 && x<forest.length && y<forest[0].length && y>=0){
			
			//if tree present
			if(forest[x][y] == 0){
				System.out.print("Tree: " + " index: " + x + " y: " + y + " initial: " + initial);
				forest[x][y]+=initial+1;
				System.out.print(" final " + forest[x][y]);
				if(forest[x][y] > max_minute){
					max_minute = forest[x][y];
				}
				System.out.println(" max_minute: " + max_minute);
				initial = forest[x][y];
				goNorth(x, y, initial, forest);
				goNorthEast(x, y,initial, forest);
				goNorthWest(x, y,initial, forest);
				goWest(x,y,initial, forest);
				goSouthWest(x, y,initial, forest);

			}
			
		}else{
			System.out.println("North West not allowed.");
		}
		
	}
	
	public static void goNorth(int x, int y, int initial, int forest[][]){
		
		x-=1;
		if(x>=0 && x<forest.length && y<forest[0].length && y>=0){
			
			//if tree present
			if(forest[x][y] == 0){
				
				System.out.print("Tree: " + " index: " + x + " y: " + y + " initial: " + initial);
				forest[x][y]+=initial+1;
				System.out.print(" final " + forest[x][y]);
				if(forest[x][y] > max_minute){
					max_minute = forest[x][y];
				}
				System.out.println(" max_minute: " + max_minute);
				initial = forest[x][y];
				goNorth(x, y, initial, forest);
				goNorthEast(x, y,initial, forest);
				goNorthWest(x, y,initial, forest);

			}
			
		}else{
			System.out.println("North not allowed");
		}
		
	}
	public static void solve(int forest[][], int ep_x, int ep_y){
		
		forest[ep_x][ep_y] = 1;
		int initial = forest[ep_x][ep_y];
		goNorth(ep_x, ep_y, initial, forest);
		goNorthEast(ep_x, ep_y,initial, forest);
		goNorthWest(ep_x, ep_y,initial, forest);
		goEast(ep_x, ep_y,initial, forest);
		goWest(ep_x, ep_y,initial, forest);
		goSouth(ep_x, ep_y,initial, forest);
		goSouthEast(ep_x, ep_y,initial, forest);
		goSouthWest(ep_x, ep_y,initial, forest);

	}
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String row_col = s.nextLine();
		String rc[] = row_col.split(" ");
		int rows = Integer.parseInt(rc[0]);
		int col = Integer.parseInt(rc[1]);
		
		String epicenter = s.nextLine();
		String ep[] = epicenter.split(" ");
		int ep_x = Integer.parseInt(ep[0]);
		int ep_y = Integer.parseInt(ep[1]);
		
		//now, input forest
		int forest[][] = new int[rows][col];
		for(int i=0;i <forest.length; i++){
			for(int j = 0; j<forest[0].length; j++){
				char c = s.nextLine().charAt(0);
				if(c == 'T'){
					forest[i][j] = 0;
				}else
				if(c == 'W'){
					forest[i][j] = -1;
				}
			}
		}
		
		System.out.println("initially maze: ");
		for(int i=0;i <forest.length; i++){
			for(int j = 0; j<forest[0].length; j++){
				System.out.print(forest[i][j] + " ");
			}
			System.out.println();
		}
		
		solve(forest, ep_x-1, ep_y-1);
		System.out.println("finally maze: ");
		for(int i=0;i <forest.length; i++){
			for(int j = 0; j<forest[0].length; j++){
				System.out.print(forest[i][j] +  " ");
			}
			System.out.println();
		}
		System.out.println("minute: " + max_minute);
		s.close();
	}

}
