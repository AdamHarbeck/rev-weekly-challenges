package com.revature;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] reArr = new int[] {515,341,98,44,211};
		String dir = "asc";
		int[] returnedArr = reorder(reArr, dir);
		System.out.println(Arrays.toString(returnedArr));
		
		int[] parArr = new int[] {-1, -20, 5, -1, -2, 2};
		System.out.println(partition(parArr));

	}
	
	public static int[] reorder(int[] arr, String dir) {
		for(int i = 0; i < arr.length; i++) {
			String s = Integer.toString(arr[i]);
			int[] digArr =new int[s.length()];
			
			for(int x = 0; x < s.length(); x++) {
				char y = s.charAt(x);
				digArr[x] = Integer.parseInt(Character.toString(y));
			}
			
			s = "";
			Arrays.sort(digArr);

			if(dir == "desc") {
				// Descending functionality
				int[] arr2 = new int[digArr.length];
				int counter = 0;
				for(int k = digArr.length-1; k > -1; k--) {
					arr2[counter] = digArr[k];
					counter++;
				}
				for(int k = 0; k < arr2.length; k++) {
					digArr[k] = arr2[k];
				}
			}
			
			for(int j : digArr) {
				s += j;
			}
			arr[i] = Integer.parseInt(s); 
		}

		return arr;
	}
	
	public static boolean partition(int[] arr) {
		/*
			See if the numbers in an array equal an element in the array
			[2,8,4,1] 8 = 2 * 4 * 1 = true
			[-1,-10,1,-2,20] -10 * -1 * 1 * -2 = -20 = false
			[-1, -20, 5, -1, -2, 2] -20 = 5 * -1 * -1 * -2 * 2 = -20 = true
			
			Grab the largest number (pos or neg) and see if multiplying the rest equals that
		*/
		// How will i get the max number from a negative?
		int maxNum = 0;
		int minNum = 0;
		int[] toMultiply = new int[arr.length - 1];
		for (int i = 0; i < arr.length; i++) {
			if(i == 0) {
				maxNum = arr[i];
				minNum = arr[i];
			} else if(arr[i] > maxNum) {
				maxNum = arr[i];
			} else if(arr[i] < minNum) {
				minNum = arr[i];
			}
		}
		
		if(minNum * -1 > maxNum) {
			maxNum = minNum;
		}
		
		int counter = 0;
		int total = 1;
		for(int j : arr) {
			if(j != maxNum) {
				toMultiply[counter] = j;
				counter++;
				total *= j;
			}
		}
		if(total == maxNum) {
			return true;
		} else {
			return false;
		}

	}

}
