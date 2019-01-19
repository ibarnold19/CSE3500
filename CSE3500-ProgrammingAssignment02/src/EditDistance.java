/* Bryan Arnold
 * CSE 3500
 * Assignment 2
 * 4/12/17
 */

import java.util.ArrayList; //import for later

/* EditDistance Method
 * Purpose: this class runs the edit distance algorithm.
 * Since the number of edits necessary is equivalent to the
 * number of optimal operations to change one string into another,
 * that is the only number reported.
 */
public class EditDistance { //start class

	private long time; //private member for time running

	//simple getter method to get the current time the program has run
	public long getTime() { //start method

		return time;

	} //end method

	//simple setter method to change the current time the program has run
	public void setTime(long time) { //start method

		this.time = time;

	} //end method

	/* min Method
	 * Purpose: this method takes three integer values
	 * and finds the minimum of the three. This method helps with the edit
	 * distance method later on. A spot in the dynamic programming
	 * table for edit distance is determined by the surrounding spots
	 * to the left, above, and diagonally + 1. So, this method just finds
	 * the minimum of those three positions. 
	 * Parameters: int a, int b, int c. Three integers, the three
	 * spots compared to the current spot, to find the minimum of them.
	 * Returns: the minimum integer of the three.
	 */
	public static int min(int a, int b, int c) { //start method

		if (a < b && a < c){ //compared a to b and c, if less than both

			return a; //a is minimum

		} //end if

		if (b < a && b < c){ //compared b to a and c, if less than both

			return b; //b is minimum

		} else { //otherwise

			return c; //c is minimum

		} //end else if chain

	} //end method

	/* editDistance Method
	 * Purpose: this method creates the dynamic programming
	 * table for the edit distance algorithm, as well as evaluates
	 * the optimal number of errors/edits to change string 1 to string
	 * 2. It makes the table, then eventually evaluates the minimum 
	 * surrounding spots of the table to create a solution. Also,
	 * this method times each pairs runtime to convert one to
	 * the other.
	 * Parameters: String a, String b, int m, int n. The two strings
	 * that we want to convert one to the other, as well as their respective 
	 * lengths are needed to create and evaluate the table.
	 * Returns: int dp[m][n]. The optimal number of edits will
	 * show up in the bottom right of the table, the lengths of
	 * the strings.
	 */
	public int editDistance(String a, String b, int m, int n) { //start method

		this.setTime(System.nanoTime()); //start the timer

		int table[][] = new int[m + 1][n + 1]; // create a table to store results of each subproblem, 0 0 at start

		for (int i = 0; i <= m; i++) { //start for i, to fill table from bottom up

			for (int j = 0; j <= n; j++) { //start for j

				if (i == 0){ // if first string is empty, insert all characters of second string

					table[i][j] = j;  // minimum operations will be = j

				} else if (j == 0){ // Likewise, if second string is empty, remove all characters of second string

					table[i][j] = i; // minimum operations will be = j

				} else if (a.charAt(i - 1) == b.charAt(j - 1)) { // if the previous characters were the same, ignore last character and recur for remaining string

					table[i][j] = table[i-1][j-1];

				} else {  // if the previous characters were different, all possibilities  could be minimum, so use them to find minimum


					table[i][j] = 1 + min(table[i][j-1], table[i-1][j], table[i-1][j-1]); // Replace spot with minimum of surroundings + 1

				} //end else if chain

			} //end for j

		} //end for i

		this.setTime(System.nanoTime() - this.getTime()); //end timing of program

		return table[m][n]; //return bottom right of table, which will be the minimum

	} //end method

	/* runEdit Method
	 * Purpose: this method is responsible for running each pair
	 * of strings for the edit distance algorithm. It displays the file being
	 * used to test, then the strings being used, to convert
	 *  string 1 to string 2, then number of optimal operations/errors
	 *  to trun string 1 into string 2. 
	 * Lastly, it displays to runtime to run edit distance on the two strings.
	 * It does edit distance for all pairs including itself, this is not
	 * necessary, but I did it to check validity of my algorithm.
	 * Parameters: String file. The file name to convert the test data
	 * in it into strings in an arraylist.
	 * Returns: nothing
	 */
	public static void runEdit(String file){ //start method

		EditDistance a = new EditDistance();

		FileToText b = new FileToText(file); //read file

		ArrayList<String> c = b.textToString(); //turn file's contents to strings

		System.out.println("File for given strings: " + file);
		System.out.println();

		for(int i = 0; i < c.size(); i++){ //for i

			for(int j = 0; j < c.size(); j++){ //for j


				System.out.println("First string to be converted: " + c.get(i));
				System.out.println("Second string for first string to be converted to: " + c.get(j));

				int error = a.editDistance(c.get(i), c.get(j), c.get(i).length(), c.get(j).length());

				System.out.println("The number of operations to convert string 1 to string 2 is: " + error);
				System.out.println("The runtime to convert string 1 into string 2 is: " + a.getTime() + " nanoseconds.");
				System.out.println();

			} //end for j

		} //end for i

	} //end method

	/* This main method was
	 * just used for testing the methods in this
	 * class, not to run the end program.
	 */
	public static void main(String[] args) { //start method

		runEdit("listSeqs-errorhigh-l10_win.txt");

	} //end method

} //end class