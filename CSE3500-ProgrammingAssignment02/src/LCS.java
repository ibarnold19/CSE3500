/* Bryan Arnold
 * CSE 3500
 * Assignment 2
 * 4/12/17
 */

import java.util.ArrayList; //import for use later

/* LCS Class
 * Purpose: this class performs the methods in which
 * the longest common subsequence algorithm is performed.
 * First, it creates a dynamic programming table through
 * a method. Then, it takes that table to find the longest
 * common subsequence of the two strings.
 */
public class LCS { //start class

	private long time; //private member for time running

	//simple getter method to get the current time the program has run
	public long getTime() { //start method

		return time;

	} //end method

	//simple setter method to change the current time the program has run
	public void setTime(long time) { //start method

		this.time = time;

	} //end method

	/* longestCommonSubsequence Method
	 * Purpose: this method is responsible for creating the 
	 * dynamic programming table for the lcs algorithm. It has
	 * a 2D matrix that assigns each part according to how the
	 * LCS table was filled in during class, as well as
	 * the algorithm itself being the same as the one presented
	 * in class. It also starts the timer for the runtime for
	 * a given pair of strings to run LCS.
	 * Parameters: String a, String b. Two strings are needed
	 * to find the longest common subsequence between them.
	 * Returns: int[][] matches. The number of lengths that
	 * are matched at the current space, like in the table
	 * in class, are held in a 2D matrix.
	 */
	public int[][] longestCommonSubsequence(String a, String b) { //start method

		this.setTime(System.nanoTime()); //start the timer

		int[][] matches = new int[a.length() + 1][b.length() + 1]; //create the dimensions of the table

		//row 0 and column 0 are initialized to 0 already

		for (int i = 0; i < a.length(); i++) {

			for (int j = 0; j < b.length(); j++) {

				if (a.charAt(i) == b.charAt(j)) { //if two characters in the sequence are matching

					matches[i + 1][j + 1] = matches[i][j] + 1; //set the next spot in the table to whatever the current spot is + 1

				} else { //otherwise

					matches[i + 1][j + 1] = Math.max(matches[i + 1][j], matches[i][j + 1]); //set the next spot in the table to the maximum value of spots above or below

				} //end if else chain

			} //end for j

		} //end for i

		return matches; //return the table

	} //end method

	/* solutionFinder Method
	 * Purpose: this class takes the created dynamic programming
	 * table for the two strings, and finds the solution. It uses
	 * the backtracing methods of going up and back discussed in class.
	 * It also ends the timer for the method for the runtime on
	 * one pair of strings.
	 * Parameters: int[][] matches, String a, String b. The table
	 * created with the length values as well as the two strings
	 * are needed to trace back through the table while looking
	 * at the strings.
	 * Returns: String sb. The longest common subsequence is returned
	 * after backtracing.
	 */
	public String solutionFinder(int[][] matches, String a, String b){ //start class

		StringBuilder s = new StringBuilder(); //use StringBuilder because the size is not set is stone until later, makes it easier to do this

		for (int i = a.length(), j = b.length(); i != 0 && j != 0; ) { //while the iterators do not equal 0, starting at bottom right corner

			if (matches[i][j] == matches[i - 1][j]){ //if the spot being looked at is equal to the spot to the left

				i--; //go to the left

			} else if (matches[i][j] == matches[i][j - 1]) { //otherwise if the spot being looked at is equal to the one above it

				j--; //go up

			} else { //otherwise the character is in the subsequence

				assert a.charAt(i - 1) == b.charAt(j - 1); //take the character to the left and set it to the one above
				s.append(a.charAt(i-1)); //add it to the longest common subsequence

				i--; //move diagonal
				j--; //move diagonal

			} //end else if chain

		} //end for

		this.setTime(System.nanoTime() - this.getTime()); //get the time to run to overall program

		return s.reverse().toString(); //since the string is found right to left, return reverse to get left to right sequence

	} //end method

	/* runLCS Method
	 * Purpose: this method is responsible for running each pair
	 * of strings for the LCS algorithm. It displays the file being
	 * used to test, then the strings being compared, then the length 
	 * of the longest common sequence as well as the sequence itself. 
	 * Lastly, it displays to runtime to run LCS on the two strings.
	 * It does LCS for all pairs including itself, this is not
	 * necessary, but I did it to check validity of my algorithms.
	 * Parameters: String file. The file name to convert the test data
	 * in it into strings in an arraylist.
	 * Returns: nothing
	 */
	public static void runLCS(String file){

		LCS a = new LCS();

		FileToText b = new FileToText(file); //read file

		ArrayList<String> c = b.textToString(); //turn contents into strings

		System.out.println("File for given strings: " + file);
		System.out.println();

		for(int i = 0; i < c.size(); i++){ //start for i

			for(int j = 0; j < c.size(); j++){ //start for j


				System.out.println("First string being compared: " + c.get(i));
				System.out.println("Second string being compared: " + c.get(j));

				int[][] grid = a.longestCommonSubsequence(c.get(i), c.get(j));

				String sequence = a.solutionFinder(grid, c.get(i), c.get(j));

				System.out.println("The length of the longest common subsequence of the two strings: " + sequence.length());
				System.out.println("The longest common subsequence: " + sequence);
				System.out.println("The time to run LCS on these strings was: " + a.getTime() + " nanoseconds");
				System.out.println();

			} //end for j

		} //end for i

	} //end method

	/* This main method was
	 * just used for testing the methods in this
	 * class, not to run the end program.
	 */
	public static void main(String[] args) { //start method

		runLCS("listSeqs-errorhigh-l10_win.txt");

	} //end method

} //end class