/* Bryan Arnold
 * CSE 3500
 * Assignment 2
 * 4/12/17
 */

/* MainLCS Class
 * Purpose: this class is responsible for running
 * each of the data test files with the LCS algorithm.
 */
public class MainLCS { //start class

	/* This main method runs all
	 * of the data files with the LCS
	 * method. Most of them are commented
	 * out in order to keep the console 
	 * clean and able to find a good amount of results.
	 * Not commenting some will result in not a lot of
	 * results being displayed. Comment out calls and
	 * comment calls not interested in to see results
	 * cleanly.
	 */
	public static void main(String[] args) { //start method

		System.out.println("This is all of the tests for running LCS on the given files.");
		System.out.println("All of the possible pairs of strings in each file are run together");
		System.out.println("including each string with itself (for validity verfication not really necessary).");
		System.out.println();

		LCS.runLCS("listSeqs-errorhigh-l10_win.txt");
		System.out.println();

		LCS.runLCS("listSeqs-errorhigh-l100_win.txt");
		System.out.println();

		//		LCS.runLCS("listSeqs-errorhigh-l1000_win.txt");
		//		System.out.println();

		//		LCS.runLCS("listSeqs-errorhigh-l50_win.txt");
		//		System.out.println();
		//		
		//		LCS.runLCS("listSeqs-errorhigh-l500_win.txt");
		//		System.out.println();
		//		
		//		LCS.runLCS("listSeqs-errorlow-l10_win.txt");
		//		System.out.println();
		//		
		//		LCS.runLCS("listSeqs-errorlow-l100_win.txt");
		//		System.out.println();
		//		
		//		LCS.runLCS("listSeqs-errorlow-l1000_win.txt");
		//		System.out.println();
		//		
		//		LCS.runLCS("listSeqs-errorlow-l50_win.txt");
		//		System.out.println();
		//		
		//		LCS.runLCS("listSeqs-errorlow-l500_win.txt");
		//		System.out.println();

	} //end method

} //end class