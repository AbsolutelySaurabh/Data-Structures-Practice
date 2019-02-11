package cdv_2017;

import java.util.Scanner;

public class SortingBoxes {
	
	public static int effort = 0;
	public static int findLargest(int boxes[]){
	
		int maxIndex = -1, max = -1;
		for(int i = 0; i<boxes.length; i++){
			if(boxes[i] > max){
				max = boxes[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	public static int findSmallest(int boxes[]){
		
		int minIndex = -1, min = Integer.MAX_VALUE;
		for(int i = 0; i<boxes.length; i++){
			if(boxes[i] < min){
				min = boxes[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	public static void swap(int boxes[], int a, int b){
		int temp = boxes[b];
		boxes[b] = boxes[a];
		boxes[a] = temp;
		
		effort = effort + boxes[a]*boxes[b];
	}
	
	public static void solve(int boxes[], int nearest){
		
		//find largest
		int largestIndex = findLargest(boxes);
		int smallestIndex = findSmallest(boxes);
		
		//check if max already at nearest
		if(boxes[nearest] != boxes[largestIndex]){
			
			//replace nearest with slammestIndex
			swap(boxes, smallestIndex, nearest);
			
			//swap nearest(smallest now) with largest
			swap(boxes, largestIndex, nearest);
			
			if(!isSorted(boxes)){
				//check where, smallest is present now with respect to nearest
				int smallestIndexNow = findSmallest(boxes);
				if(smallestIndexNow > nearest){
					//smallestIndexNow is on rightSide of heaviest
					while(!iSorted(boxes, nearest+1, boxes.length)){
						
						//sort the right part and return the smallestIndex
						
					}
					
					//find the largest element present in the left
					
					
					//swap the smallest with the left largest element
					while(!isSorted(boxes, 0, nearest)){
						
						//sorth the left part
						
					}
					
				}else{
					
					//repeat the above with the left part
					
				}
			}
			
			
		}
		
		
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String size = s.nextLine();
		int n  = Integer.parseInt(size);
		
		String k = s.nextLine();
		int nearest = Integer.parseInt(k);
		
		String values = s.nextLine();
		String []arr_boxes = values.split(" ");
		
		int boxes[] = new int[arr_boxes.length];
		for(int i = 0;i <arr_boxes.length; i++){
			boxes[i] = Integer.parseInt(arr_boxes[i]);
		}
		
		solve(boxes, nearest-1);
		s.close();
	}

}
