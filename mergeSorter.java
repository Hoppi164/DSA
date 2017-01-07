import java.util.Arrays;//A practice example of the "mergesort" algorithm
class mergeSorter {
	private int[] nums;
	private int[] helper;
	public static void main(String[] args) {
		int[] numbers = {8, 3, 6, 2, 11, 87, 43, 76, 99, 100};//Psuedo random numbers
		System.out.println(Arrays.toString(numbers));//Pre test
		System.out.println("===");//Seperator
		mergeSorter test = new mergeSorter();
		test.mergeSort(numbers);//Call sorting method
		System.out.println(Arrays.toString(numbers));//Post test		
	}
	public void mergeSort(int[] numbers){// publicly invoked method for mergesort
		this.nums = numbers;//copy across array
		this.helper = new int[nums.length];//Instantiated as zeros 
		mergeSort(0, nums.length-1);//invoke actual sort method
	}
	private void mergeSort(int low, int high){//Actual mergesort that does everything
		if (low < high) {// If low is not < high -- then array is already sorted = ignore it.
			int middle = low + (high - low) / 2;//Get middle point
			mergeSort(low, middle);//Recursively mergeSort left
			mergeSort(middle+1, high);//Recursively MergeSort Right
			merge(low, middle, high);//Call merge function (which sorts values)
		}
	}
	private void merge(int low, int middle, int high){
		for( int i = low; i<=high; i++ ){//Copy nums -> helper array
			helper[i] = nums[i];
		}
		int i = low;// Keeps track of low 
		int j = middle +1;// Keeps track of middle
		int k = low;//Writing pointer for nums array
		while( i <= middle && j <= high ){//While there are numbers in the array
			if (helper[i] <= helper[j]) {//write the smaller number to nums
				nums[k] = helper[i];
				i++;//Continue to next number
			} else {
				nums[k] = helper[j];
				j++;//Continue to next number
			}
			k++;//Increment write pointer
		}
		while( i <= middle ){// Copy the rest of the left half of array into nums
			nums[k] = helper[i];// (this stuff may not be sorted yet, but will be upon later repetitions)
			k++;
			i++;
		}

	}
}