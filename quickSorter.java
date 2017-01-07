import java.util.Arrays;//A practice example of the "quicksort" algorithm
class quickSorter {
	private int[] nums;
	public static void main(String[] args) {
		int[] numbers = {8, 6, 2, 5, 3, 71, 23, 11, 91, 105};// ten psuedo random numbers
		System.out.println(Arrays.toString(numbers));//pre test
		quickSorter test = new quickSorter();
		test.quickSort(numbers);//Quicksort
		System.out.println("===");//print seperator
		System.out.println(Arrays.toString(numbers));//post test
	}
	public void quickSort(int[] numbers){//Call method for main method to invoke
		this.nums = numbers;
		quickSort(0, nums.length-1);
	}
	private void swap(int lPointer, int rPointer){//Method used to swap numbers at given positions in nums array
		int temp = nums[rPointer];// Swap numbers
		nums[rPointer] = nums[lPointer];
		nums[lPointer] = temp;
	}
	private void quickSort(int left, int right){//Overloaded method that actually does everything
		int middle = nums[left + (right - left) / 2];//possible edge case here -- used for simplicity
		int l = left; 	int r = right;//used to preserve orginal values
		while (l < r) {//while L and R have not met
			while(nums[l] < middle) l++;//Scan rightwards until you find a higher number
			while(nums[r] > middle) r--;//Scan leftwards until you find a smaller number
			if(l <= r){// If L and R have still not met
				swap(l, r); //Swap the numbers at positions L and R
				l++;//after we've swapped.. move to next letter
				r--;//after we've swapped.. move to next letter
			}
			if (r > left) {
				quickSort(left, r);//Recurse the left side
			}
			if (l < right) {
				quickSort(l, right);//Recurse the right side
			}
		}
	}
}


// Shrivitza
// google maps
// 4 interviews -- then inperson