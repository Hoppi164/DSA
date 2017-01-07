// import java.util.Arrays;//A practice example of the "quicksort" algorithm
import java.io.*;
import java.util.*;
class quickSorterStrings {
	private String[] nums;
	public static void main(String[] args) throws Exception {
		String[] numbers = new String[16];//strings
		Scanner in = new Scanner(new BufferedReader(new FileReader("list.txt")));
		int i = 0;
		while(in.hasNext()){
			numbers[i]=in.nextLine();
			i++;
		}
		System.out.println(Arrays.toString(numbers));//pre test
		quickSorterStrings test = new quickSorterStrings();
		test.quickSort(numbers);//Quicksort
		System.out.println("===");//print seperator
		System.out.println(Arrays.toString(numbers));//post test
		BufferedWriter out = new BufferedWriter(new FileWriter("out.txt"));
		for (String word : numbers) {
			out.write(word);
			out.newLine();
		}
		out.close();
	}
	public void quickSort(String[] numbers){//Call method for main method to invoke
		this.nums = numbers;
		quickSort(0, nums.length-1);
	}
	private void swap(int lPointer, int rPointer){//Method used to swap numbers at given positions in nums array
		String temp = nums[rPointer];// Swap numbers
		nums[rPointer] = nums[lPointer];
		nums[lPointer] = temp;
	}
	private void quickSort(int left, int right){//Overloaded method that actually does everything
		String middle = nums[left + (right - left) / 2];//possible edge case here -- used for simplicity
		int l = left; 	int r = right;//used to preserve orginal values
		while (l < r) {//while L and R have not met
			while(nums[l].compareTo(middle) < 0) l++;//Scan rightwards until you find a number higher than middle
			while(nums[r].compareTo(middle) > 0) r--;//Scan leftwards until you find a number smaller than middle
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
