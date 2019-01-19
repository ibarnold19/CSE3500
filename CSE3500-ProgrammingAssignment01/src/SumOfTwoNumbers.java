/* Bryan Arnold
 * CSE 3500
 * Assignment 1
 * 2/8/17
 */

/* SumOfTwoNumbers Class
 * Purpose: this class is responsible for
 * creating the methods for both the brute force
 * algorithm and the improved version of it
 * discussed in homework 2. 
 */
public class SumOfTwoNumbers { //start class

	/* bruteMethod Method
	 * Purpose: this method is the brute method design of the algorithm 
	 * for homework 2 question 3. It looks at each integer in the array
	 * and adds them together to check whether or not they equal the desired
	 * integer to find. It runs at O(n^2) time.
	 * Parameters: an array of integers and an integer to add elements
	 * together to find if elements add to said integer.
	 * Returns: true or false if a solution exists
	 */
	public boolean bruteMethod(int[] array, int search){ //start method

		boolean checker = false;

		for(int i = 0; i < array.length; i++){ //start for i

			for(int j = 0; j < array.length; j++){ //start for j

				if(array[i] + array[j] == search){ //start if

					System.out.println("True: There exists a pair of integers in the given array that add up to the given integer: " + search + ".");

					checker = true;

					i = array.length - 1;

				} //end if

			} //end for j

		} //end for i	

		if(checker == false){ //start if

			System.out.println("False: There does not exist a pair of integers in the given array that add up to the given integer: " + search + ".");

		} //end if

		return checker;

	} //end method

	/* runBrute Method
	 * Purpose: this method just runs each integer
	 * in the given array of numbers we want to see if
	 * elements in another array (solution array) equal the number in the
	 * solutions array.
	 * Parameters: the solutions and given array of integers must be
	 * given.
	 * Returns: nothing
	 */
	public void runBrute(int[] array, int[] solutions){ //start method

		SumOfTwoNumbers a = new SumOfTwoNumbers();

		for(int i = 0; i < solutions.length; i++){ //start for i

			a.bruteMethod(array, solutions[i]);

		} //end for i

	} //end method

	/* mergeSort Method
	 * Purpose: this method takes the integers that we
	 * are adding up to see if they equal a desired integer
	 * and sorts them from least to greatest. This is used as 
	 * an improved because it allows us to use binary sort, which
	 * will be more efficient than the brute force algorithm.
	 * Parameters: the array of given integers to add to another
	 * must be given to sort.
	 * Returns: a sorted version of the given integers in array
	 */
	public int[] mergeSort(int[] array){ //start method

		if(array.length > 1){ //start if

			int numElements1 = array.length/2;

			int numElements2 = numElements1;

			if((array.length % 2) == 1){ //start if

				numElements2 += 1;

			} //end if

			int[] temp1 = new int[numElements1];
			int[] temp2 = new int[numElements2];

			for(int i = 0; i < numElements1; i++){ //start for i

				temp1[i] = array[i];

			} //end for i

			for(int j = numElements1; j < numElements1 + numElements2; j++){ //start for j


				temp2[j - numElements1] = array[j];

			} //end for j

			temp1 = mergeSort(temp1);
			temp2 = mergeSort(temp2);

			int counter1 = 0, counter2 = 0, counter3 = 0;

			while(temp1.length != counter2 && temp2.length != counter3){ //start while

				if(temp1[counter2] < temp2[counter3]){ //start if

					array[counter1++] = temp1[counter2++];

				} else {

					array[counter1++] = temp2[counter3++];

				} //end if else chain

			} //end while

			while(temp1.length != counter2){ //start while

				array[counter1++] = temp1[counter2++];

			} //end while

			while(temp2.length != counter3){ //start while

				array[counter1++] = temp2[counter3++];

			} //end while

		} //end if

		return array;

	} //end method

	/* binarySearch Method
	 * Purpose: this is the binarySearch
	 * method of finding if two integers
	 * in the array add up to a desired integer.
	 * It's an implementation of a binarySearch, so
	 * it will run at O(logn) time, which
	 * is much faster than the brute force method.
	 * Parameters: the array of given integers, the desired
	 * integers to see if it is a solution, and another element
	 * in the array must be given to search.
	 * Returns: true or false if a solution exists.
	 */
	public boolean binarySearch(int[] array, int search, int toAdd) { //start method

		int low = 0;
		int high = array.length - 1;


		while(high >= low) { //start while

			int middle = (low + high) / 2;

			if(search - toAdd == array[middle]) { //start if

				return true;

			} //end if

			if(search - toAdd > array[middle]) { //start if

				low = middle + 1;

			} //end if

			if(search - toAdd < array[middle]) { //start if

				high = middle - 1;

			} //end if

		} //end while

		return false;

	} //end method

	/* efficientMethod Method
	 * Purpose: this method is used to run the binary search,
	 * merge sort, and tell if solutions exist for the more
	 * improved version of the algorithm. It sorts, then searches,
	 * then displays whether or not one exists for each number in
	 * the solutions array. This will run in O(nlogn) time.
	 * Parameters: both the given array of integers to add
	 * and the solutions array must be given.
	 * Returns: nothing
	 */
	public void efficientMethod(int[] array, int[] solutions){ //start method

		SumOfTwoNumbers a = new SumOfTwoNumbers();

		int[] temp = new int[array.length];

		for(int i = 0; i < array.length; i++){ //start for i

			temp[i] = array[i];

		} //end for i

		a.mergeSort(temp);

		for(int j = 0; j < solutions.length; j++){ //start for j

			boolean checker = false;

			for(int k = 0; k < temp.length; k++){ //start for k

				if(a.binarySearch(array, solutions[j], temp[k]) == true){ //start if

					System.out.println("True: There exists a pair of integers in the given array that add up to the given integer: " + solutions[j] + ".");
					checker = true;

					k = temp.length - 1;

				} //end if

			} //end for k

			if(checker == false){ //start if

				System.out.println("False: There does not exists a pair of integers in the given array that add up to the given integer: " + solutions[j] + ".");

			} //end if

		} //end for j

	} //end method

	/* This main method is just
	 * used for testing this
	 * class' methods, not for running
	 * the end program.
	 */
	public static void main(String[] args){ //start testing

		SumOfTwoNumbers a = new SumOfTwoNumbers();

		int[] numbers = {21, 56, 67, 38, 76, 49, 67, 42, 85, 12};

		int[] sols = {5,
				67,
				63,
				17,
				42,
				63,
				27,
				70,
				116,
				161,
		};

		a.runBrute(numbers, sols);

		System.out.println("");

		a.efficientMethod(numbers, sols);

	} //end testing	

} //end class
