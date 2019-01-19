/* Bryan Arnold
 * CSE 3500
 * Assignment 2
 * 4/12/17
 */

//imports for file readings
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/* FileToText Class
 * Purpose: this class takes the test data files
 * given for the assignment and translates each line
 * of it into an arraylist. Each part of the arraylist
 * will be it's own string, which is one line of given
 * test data files.
 */
public class FileToText { //start class

	private String fileName; //private member for the file name

	//simple getter to access the file name in case I need it
	public String getFileName() { //start method

		return fileName;

	} //end method

	//simple setter to change the file name in case I need it
	public void setFileName(String fileName) { //start method

		this.fileName = fileName;

	} //end method


	/* FileToText Constructor
	 * Purpose: this creates a FileToText object in order
	 * to carry out all the methods in the class as well as get
	 * a file name to read for the purpose of the project.
	 * Parameters: String fileName. The name of the file to be
	 * read is needed in order to find and read it.
	 * Returns: nothing.
	 */
	public FileToText(String fileName){ //start constructor

		this.fileName = fileName;

	} //end constructor

	public FileToText(){} //default constructor

	/* textToString Method
	 * Purpose: this method takes each line of text in the
	 * given file and puts them into an arraylist. It uses a
	 * buffer reader and file reader to take each line and add it to the
	 * list.
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

	/* This main method was
	 * just used for testing the methods in this
	 * class, not to run the end program.
	 */
	public static void main(String[] args) {

		FileToText a = new FileToText("listSeqs-errorhigh-l10_win.txt");

		ArrayList<String> b = a.textToString();

		for(int i = 0; i < b.size(); i++){ //start for i

			System.out.println(b.get(i));

		} //end for i

	} //end method

} //end class