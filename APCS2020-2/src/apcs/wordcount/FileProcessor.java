package apcs.wordcount;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
//import javax.swing.JFileChooser;
public class FileProcessor {

	WordCountList list = new WordCountList();
	Scanner fileScanner;
	PrintWriter p;
	
	
	public static void main(String[] args) throws FileNotFoundException {
		new FileProcessor().start();

	}

	private void start() throws FileNotFoundException {
		p = new PrintWriter(new File("output.txt"));
		// prompt the user for the file to process.  This will be the contents
		// of a novel (text file).
		promptAndOpenFile();
		//fileScanner = new Scanner(new File("thelastquestion.txt"));
		// The file will be scanned (using a scanner) inputting one token at a time
		// cleaning and standardizing the token, then adding the token to our 
		WordCountList list = new WordCountList();
		//list.get(-2);
		// we will use fileScanner methods hasNext() which tells us if there is more 
		// to be scanned from the file, and the    next() method which returns the latest
		// token and advances the file pointer.
		
		while(fileScanner.hasNext()) {
			String s = fileScanner.next();
			s = standardize(s);
			list.addWord(s);
//			System.out.println(s);
//			System.out.println(list);
		}
		
		//After the file is done being processed, the results 
		// will be displayed.  This will include displaying the words alphabetically, 
		// or by frequency or by length (depending on the user's choice).
		
		System.out.println(list.size());
		p.println(list);
		p.close();
		
		
	}
	
	/**
	 * Prompts the user for a file to be processed.  JFileChooser Objects are 
	 * GREAT for this!!  
	 * 
	 * After prompting for the file, this method assigns the class variable
	 * fileScanner to a new Scanner that points to the desired file.
	 * @throws FileNotFoundException 
	 */
	private void promptAndOpenFile() throws FileNotFoundException  {
		// TODO Auto-generated method stub
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text", "txt");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       System.out.println("You chose to open this file: " +
	            chooser.getSelectedFile().getName());
	       fileScanner = new Scanner(chooser.getSelectedFile());
	    }
	    
	}

	/**
	 * This method lowercases the String.  
	 * This method cleans off any characters from the front and back of the 
	 * specified String.   Example:  if s = "Happy,", "happy" is returned
	 * @param s  The String to be standardized.  
	 * @return  the standardized String
	 */
	private String standardize(String s) {
		String result = s;
		result = result.toLowerCase();
		int i = 0;
		while(i<result.length()&&(!(result.charAt(i)>='a'&&result.charAt(i)<='z'))){
			i++;
		}
		result = result.substring(i,result.length());
		i = result.length()-1;
		while(i>=0&&(!(result.charAt(i)>='a'&&result.charAt(i)<='z'))){
			i--;
		}
		result = result.substring(0,i+1);
		return result;
	}
	

}
