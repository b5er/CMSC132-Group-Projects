package util;

public class InversionCount {

	public static int count(int[] array) {
		
		//base case for the last recursion
		if (array.length < 2){
			return 0;
		}
		//mid point
		int mid = array.length/2;
		//initializing the length of the left array. which is as 
		//long as the midpoint integer.
		int[] left = new int[mid];
		
		//initializing the length of the right array. The right
		//array will be as big as the midpoint integer, if the 
		//entire array have an even total of indices. If its odd
		//the right array will hold one more index.
		int[] right;
		if(array.length % 2 == 0){
			right = new int[mid];
		} else{
			right = new int[mid+1];
		}
		
		//the left array will always be up to the midpoint
		for(int i = 0; i < mid; i++){
			left[i] = array[i];
		}
		
		//the right array will be from the mid point to the end
		int count = 0;
		for(int j = mid; j < array.length; j++){
			right[count] = array[j];
			count++;
		}

		return count(left) + count(right) + merge(array, left, right);
	}

	private static int merge(int[] arr, int[] left, int[] right) {
		int i = 0, j = 0, count = 0;
		//the while makes sure it goes through each index
		//without having an out of bound exception, within either
		//right/left array.
		while (i < left.length || j < right.length) {
			if (i == left.length) {
				arr[i + j] = right[j];
				j++;
			} else if (j == right.length) {
				arr[i + j] = left[i];
				i++;
			} else if (left[i] <= right[j]) {
				arr[i + j] = left[i];
				i++;
			} else {
				arr[i + j] = right[j];
				count += left.length - i;
				j++;
			}
		}
		return count;
	}

}