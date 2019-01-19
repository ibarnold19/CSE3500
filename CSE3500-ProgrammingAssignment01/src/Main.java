/* Bryan Arnold
 * CSE 3500
 * Assignment 1
 * 2/8/17
 */

/* Main Class
 * Purpose: this class runs the end
 * program for each given number array sizes
 * and displays solutions as well as runtimes
 * for each method of the algorithm.
 */
public class Main { //start class

	public static void main(String[] args) { //start main

		CollectionNumbers a = new CollectionNumbers();

		//below code is commented to speed up overall runtime so seconds collection files can be seen, uncomment to see for collection files as well

		//		long start = System.nanoTime();
		//		a.runB("listNumbers-10.txt", "listNumbers-10-nsol.txt");
		//		long runTime = System.nanoTime() - start;
		//		
		//		System.out.println("The run time for the Brute-Force Method: " + runTime + " nano seconds.");
		//		System.out.println("");
		//		
		//		start = System.nanoTime();
		//		a.runE("listNumbers-10.txt", "listNumbers-10-nsol.txt");
		//		runTime = System.nanoTime() - start;
		//		
		//		System.out.println("The run time for the Improved/More Efficient Method: " + runTime + " nano seconds.");
		//		System.out.println("");
		//		
		//		start = System.nanoTime();
		//		a.runB("listNumbers-100.txt", "listNumbers-100-nsol.txt");
		//		runTime = System.nanoTime() - start;
		//		
		//		System.out.println("The run time for the Brute-Force Method: " + runTime + " nano seconds.");
		//		System.out.println("");
		//		
		//		start = System.nanoTime();
		//		a.runE("listNumbers-100.txt", "listNumbers-100-nsol.txt");
		//		runTime = System.nanoTime() - start;
		//		
		//		System.out.println("The run time for the Improved/More Efficient Method: " + runTime + " nano seconds.");
		//		System.out.println("");
		//		
		//		start = System.nanoTime();
		//		a.runB("listNumbers-1000.txt", "listNumbers-1000-nsol.txt");
		//		runTime = System.nanoTime() - start;
		//		
		//		System.out.println("The run time for the Brute-Force Method: " + runTime + " nano seconds.");
		//		System.out.println("");
		//		
		//		start = System.nanoTime();
		//		a.runE("listNumbers-1000.txt", "listNumbers-1000-nsol.txt");
		//		runTime = System.nanoTime() - start;
		//		
		//		System.out.println("The run time for the Improved/More Efficient Method: " + runTime + " nano seconds.");
		//		System.out.println("");
		//		
		//		start = System.nanoTime();
		//		a.runB("listNumbers-10000.txt", "listNumbers-10000-nsol.txt");
		//		runTime = System.nanoTime() - start;
		//		
		//		System.out.println("The run time for the Brute-Force Method: " + runTime + " nano seconds.");
		//		System.out.println("");
		//		
		//		start = System.nanoTime();
		//		a.runE("listNumbers-10000.txt", "listNumbers-10000-nsol.txt");
		//		runTime = System.nanoTime() - start;
		//		
		//		System.out.println("The run time for the Improved/More Efficient Method: " + runTime + " nano seconds.");
		//		System.out.println("");
		//		
		//		start = System.nanoTime();
		//		a.runB("listNumbers-100000.txt", "listNumbers-100000-nsol.txt");
		//		runTime = System.nanoTime() - start;
		//		
		//		System.out.println("The run time for the Brute-Force Method: " + runTime + " nano seconds.");
		//		System.out.println("");
		//		
		//		start = System.nanoTime();
		//		a.runE("listNumbers-100000.txt", "listNumbers-100000-nsol.txt");
		//		runTime = System.nanoTime() - start;
		//		
		//		System.out.println("The run time for the Improved/More Efficient Method: " + runTime + " nano seconds.");
		//		System.out.println("");
		//		
		//		start = System.nanoTime();
		//		a.runB("listNumbers-1000000.txt", "listNumbers-1000000-nsol.txt");
		//		runTime = System.nanoTime() - start;
		//		
		//		System.out.println("The run time for the Brute-Force Method: " + runTime + " nano seconds.");
		//		System.out.println("");
		//		
		//		start = System.nanoTime();
		//		a.runE("listNumbers-1000000.txt", "listNumbers-1000000-nsol.txt");
		//		runTime = System.nanoTime() - start;
		//		
		//		System.out.println("The run time for the Improved/More Efficient Method: " + runTime + " nano seconds.");
		//		System.out.println("");

		long start = System.nanoTime();
		a.runB("listNumbers2-10.txt", "listNumbers2-10-nsol.txt");
		long runTime = System.nanoTime() - start;

		System.out.println("The run time for the Brute-Force Method: " + runTime + " nano seconds.");
		System.out.println("");

		start = System.nanoTime();
		a.runE("listNumbers2-10.txt", "listNumbers2-10-nsol.txt");
		runTime = System.nanoTime() - start;

		System.out.println("The run time for the Improved/More Efficient Method: " + runTime + " nano seconds.");
		System.out.println("");

		start = System.nanoTime();
		a.runB("listNumbers2-100.txt", "listNumbers2-100-nsol.txt");
		runTime = System.nanoTime() - start;

		System.out.println("The run time for the Brute-Force Method: " + runTime + " nano seconds.");
		System.out.println("");

		start = System.nanoTime();
		a.runE("listNumbers2-100.txt", "listNumbers2-100-nsol.txt");
		runTime = System.nanoTime() - start;

		System.out.println("The run time for the Improved/More Efficient Method: " + runTime + " nano seconds.");
		System.out.println("");

		start = System.nanoTime();
		a.runB("listNumbers2-1000.txt", "listNumbers2-1000-nsol.txt");
		runTime = System.nanoTime() - start;

		System.out.println("The run time for the Brute-Force Method: " + runTime + " nano seconds.");
		System.out.println("");

		start = System.nanoTime();
		a.runE("listNumbers2-1000.txt", "listNumbers2-1000-nsol.txt");
		runTime = System.nanoTime() - start;

		System.out.println("The run time for the Improved/More Efficient Method: " + runTime + " nano seconds.");
		System.out.println("");

		start = System.nanoTime();
		a.runB("listNumbers2-10000.txt", "listNumbers2-10000-nsol.txt");
		runTime = System.nanoTime() - start;

		System.out.println("The run time for the Brute-Force Method: " + runTime + " nano seconds.");
		System.out.println("");

		start = System.nanoTime();
		a.runE("listNumbers2-10000.txt", "listNumbers2-10000-nsol.txt");
		runTime = System.nanoTime() - start;

		System.out.println("The run time for the Improved/More Efficient Method: " + runTime + " nano seconds.");
		System.out.println("");

		start = System.nanoTime();
		a.runB("listNumbers2-100000.txt", "listNumbers2-100000-nsol.txt");
		runTime = System.nanoTime() - start;

		System.out.println("The run time for the Brute-Force Method: " + runTime + " nano seconds.");
		System.out.println("");

		start = System.nanoTime();
		a.runE("listNumbers2-100000.txt", "listNumbers2-100000-nsol.txt");
		runTime = System.nanoTime() - start;

		System.out.println("The run time for the Improved/More Efficient Method: " + runTime + " nano seconds.");
		System.out.println("");

		start = System.nanoTime();
		a.runB("listNumbers2-1000000.txt", "listNumbers2-1000000-nsol.txt");
		runTime = System.nanoTime() - start;

		System.out.println("The run time for the Brute-Force Method: " + runTime + " nano seconds.");
		System.out.println("");

		start = System.nanoTime();
		a.runE("listNumbers2-1000000.txt", "listNumbers2-1000000-nsol.txt");
		runTime = System.nanoTime() - start;

		System.out.println("The run time for the Improved/More Efficient Method: " + runTime + " nano seconds.");
		System.out.println("");

	} //end main

} //end class
