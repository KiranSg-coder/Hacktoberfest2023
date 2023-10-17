// Java code to implement of the approach 

class class { 

	// Function to return the maximum 
	// water that can be stored 
	public static int maxWater(int[] arr, int n) 
	{ 

		// To store the maximum water 
		// that can be stored 
		int res = 0; 

		// For every element of the array 
		// except first and last element 
		for (int i = 1; i < n - 1; i++) { 

			// Find maximum element on its left 
			int left = arr[i]; 
			for (int j = 0; j < i; j++) { 
				left = Math.max(left, arr[j]); 
			} 

			// Find maximum element on its right 
			int right = arr[i]; 
			for (int j = i + 1; j < n; j++) { 
				right = Math.max(right, arr[j]); 
			} 

			// Update maximum water value 
			res += Math.min(left, right) - arr[i]; 
		} 
		return res; 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }; 
		int n = arr.length; 

		System.out.print(maxWater(arr, n)); 
	} 
} 

// Time Complexity: O(N2). There are two nested loops traversing the array.
// Space Complexity: O(1). No extra space is required.
//--------------------------------------------------------------------------------------------------/

// Java program to find maximum amount of water that can 
// be trapped within given set of bars. 

class Test { 
	static int arr[] 
		= new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }; 

	// Method for maximum amount of water 
	static int findWater(int n) 
	{ 
		// left[i] contains height of tallest bar to the 
		// left of i'th bar including itself 
		int left[] = new int[n]; 

		// Right [i] contains height of tallest bar to 
		// the right of ith bar including itself 
		int right[] = new int[n]; 

		// Initialize result 
		int water = 0; 

		// Fill left array 
		left[0] = arr[0]; 
		for (int i = 1; i < n; i++) 
			left[i] = Math.max(left[i - 1], arr[i]); 

		// Fill right array 
		right[n - 1] = arr[n - 1]; 
		for (int i = n - 2; i >= 0; i--) 
			right[i] = Math.max(right[i + 1], arr[i]); 

		// Calculate the accumulated water element by 
		// element consider the amount of water on i'th bar, 
		// the amount of water accumulated on this 
		// particular bar will be equal to min(left[i], 
		// right[i]) - arr[i] . 
		for (int i = 0; i < n; i++) 
			water += Math.min(left[i], right[i]) - arr[i]; 

		return water; 
	} 

	// Driver method to test the above function 
	public static void main(String[] args) 
	{ 

		System.out.println(findWater(arr.length)); 
	} 
}
//Time Complexity: O(N). Only one traversal of the array is needed, So time Complexity is O(N).
//Space Complexity: O(N). Two extra arrays are needed, each of size N.
