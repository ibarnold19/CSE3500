/* Bryan Arnold
 * CSE 3500
 * Assignment 1
 * 2/8/17
 */

//imports for file readings
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CollectionNumbers {

	private String fileName; //private member for the file name

	//simple getter to access the file name in case I need it
	public String getFileName() { //start method

		return fileName;

	} //end method

	//simple setter to change the file name in case I need it
	public void setFileName(String fileName) { //start method

		this.fileName = fileName;

	} //end method


	/* WordFinder Constructor
	 * Purpose: this creates a WordFinder object in order
	 * to carry out all the methods in the class as well as get
	 * a file name to read for the purpose of the project.
	 * Parameters: String fileName. The name of the file to be
	 * read is needed in order to find and read it.
	 * Returns: nothing.
	 */
	public CollectionNumbers(String fileName){ //start constructor

		this.fileName = fileName;

	} //end constructor

	public CollectionNumbers(){} //default constructor

	/* textToString Method
	 * Purpose: this method takes each line of text in the
	 * given file and puts them into an arraylist. It uses a
	 * buffer reader and file reader to take each line and add it to the
	 * list. These lines are one string, which will be separated later.
	 * Parameters: none.
	 * Returns: an array list of strings, each being a line in the
	 * text document.
	 */
	public ArrayList<String> textToString(){ //start method

		ArrayList<String> words = new ArrayList<String>(); //list of lines

		String str = null; //string to be a line

		try { //start try

			FileReader fileReader = new FileReader(this.getFileName());

			BufferedReader buffReader = new BufferedReader(fileReader);

			while((str = buffReader.readLine()) != null){ //while the next line in the text isn't null

				if(str.isEmpty()){ // excludes newlines with no text to be added

				} else {

					words.add(str); //adds new line to the list

				} //end if else chain

			} //end while

			buffReader.close(); //need to close buffer readers

		} catch (FileNotFoundException e) { //can't find the file, so send an error

			System.out.println("Cannot open given file name: " + this.getFileName());

		} catch (IOException e) { //cannot read a file, so send an error

			System.out.println("Cannot read given file: " + this.getFileName());

		} //end catch

		return words;

	}

	/* convert Method
	 * Purpose: this method takes the array list of
	 * strings taken from the text file, and turns
	 * them all into integers for easier computations
	 * in both the brute force and improved methods
	 * later one.
	 * Parameters: the array list that was taken from the
	 * text document.
	 * Returns: and integer array for use in the other methods
	 */
	public int[] convert(ArrayList<String> nums){ //start method

		ArrayList<Integer> newNums = new ArrayList<Integer>();

		for(int i = 0; i < nums.size(); i++){ //start for i

			int newNum = Integer.parseInt(nums.get(i));

			newNums.add(newNum);

		} //end for i

		int[] arrayForm = new int[newNums.size()];

		for(int j = 0; j < newNums.size(); j++){ //start for j

			arrayForm[j] = newNums.get(j);

		} //end for j

		return arrayForm;

	} //end method

	/* runB Method
	 * Purpose: this method runs the end program
	 * for the brute force method. First, it displays the
	 * files of both the solutions and given integers being used.
	 * Then, it does the brute force method of finding if solutions 
	 * exist, then they are displayed. 
	 * Parameters: the files for the given arrays and the
	 * numbers we wish to see are sums of numbers in the
	 * given array.
	 * Returns: nothing
	 */
	public void runB(String numbers, String numbersSolutions){ //start method

		SumOfTwoNumbers a = new SumOfTwoNumbers();

		CollectionNumbers b = new CollectionNumbers(numbers);

		ArrayList<String> nums = b.textToString();

		int[] array = b.convert(nums);

		System.out.println("File for given integers: " + numbers);

		CollectionNumbers c = new CollectionNumbers(numbersSolutions);

		ArrayList<String> nums1 = c.textToString();

		int[] array1 = c.convert(nums1);

		System.out.println("File for solutions to find: " + numbersSolutions);

		System.out.println("");

		System.out.println("Brute-Force Method");

		a.runBrute(array, array1);

	} //end method

	/* runE Method
	 * Purpose: this method runs the end program
	 * for the improved method. First, it displays the
	 * files of both the solutions and given integers being used.
	 * Then, it does the improved method of finding if solutions 
	 * exist, then they are displayed. 
	 * Parameters: the files for the given arrays and the
	 * numbers we wish to see are sums of numbers in the
	 * given array.
	 * Returns: nothing
	 */
	public void runE(String numbers, String numbersSolutions){ //start method

		SumOfTwoNumbers a = new SumOfTwoNumbers();

		CollectionNumbers b = new CollectionNumbers(numbers);

		ArrayList<String> nums = b.textToString();

		int[] array = b.convert(nums);

		System.out.println("File for given integers: " + numbers);

		CollectionNumbers c = new CollectionNumbers(numbersSolutions);

		ArrayList<String> nums1 = c.textToString();

		int[] array1 = c.convert(nums1);

		System.out.println("File for solutions to find: " + numbersSolutions);

		System.out.println("");

		System.out.println("Improved/More Efficient Method");

		a.efficientMethod(array, array1);

	} //end method

	/* This main method was
	 * just used for testing the methods in this
	 * class, not to run the end program.
	 */
	public static void main(String[] args) { //start testing

		CollectionNumbers a = new CollectionNumbers();

		long start = System.nanoTime();
		a.runB("listNumbers-10.txt", "listNumbers-10-nsol.txt");
		long runTime = System.nanoTime() - start;

		System.out.println("The run time for the Brute-Force Method: " + runTime + " nano seconds.");
		System.out.println("");

		long start1 = System.nanoTime();
		a.runE("listNumbers-10.txt", "listNumbers-10-nsol.txt");
		long runTime1 = System.nanoTime() - start1;

		System.out.println("The run time for the Brute-Force Method: " + runTime1 + " nano seconds.");
		System.out.println("");

	} //end testing

} //end class
