package university_codesprint;

import java.util.Scanner;

public class CubesAnCylinders {
	
	static int maximumPackages(int[] arr_packs_length, int[] arr_packs_copy, int[] arr_cyl_length, int[] arr_cyl_max) {
		int ans=0;
		
		for(int i=0;i<arr_packs_length.length;i++) {
			
			for(int j=0;j<arr_cyl_length.length;j++) {
				
				if(arr_packs_length[i] <= arr_cyl_length[j] && (arr_packs_copy[i] > 0 && arr_cyl_max[j] > 0) ) {
					
					while(arr_packs_copy[i] > 0 && arr_cyl_max[j] > 0) {
						
						ans++;
						arr_packs_copy[i] -= 1;
						arr_cyl_max[j] -=1;
					}
				}
			}
		}
		return ans;
   }

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int num_packages = s.nextInt();
		int num_cylinders = s.nextInt();
		
		int[] arr_packs_length = new int[num_packages];
		int[] arr_packs_copy = new int[num_packages];
		int[] arr_cyl_length = new int[num_cylinders];
		int[] arr_cyl_max = new int[num_cylinders];
		
		for(int i=0;i<num_packages;i++) {
			arr_packs_length[i] = s.nextInt();
		}
		for(int i=0;i<num_packages;i++) {
			arr_packs_copy[i] = s.nextInt();
		}
		
		for(int i=0;i<num_cylinders;i++) {
			arr_cyl_length[i] = s.nextInt();
		}
		for(int i=0;i<num_cylinders;i++) {
			arr_cyl_max[i] = s.nextInt();
		}
		
		System.out.println(maximumPackages(arr_packs_length, arr_packs_copy, arr_cyl_length, arr_cyl_max));
		s.close();
	}

}
