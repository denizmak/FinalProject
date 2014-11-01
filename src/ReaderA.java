import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



/**
 * The Class Reader.
 */
public class ReaderA  {
	
	 private ArrayList <String> accessCodes = new ArrayList<>();
	private boolean open;
	
	ReaderA(){

	}

	/** The file. */
	File file = new File("/Data/log.txt");
	

	/** Write to a text file */
	
	void write(String string) throws Exception {
		FileWriter fileWriter = new FileWriter(file,true);
		fileWriter.append(string+"\n");
		fileWriter.close();
	}



	/** Read safe code from file and add to a string array. */
	void read() { 
		File safeCode = new File("/Data/log.txt");
		Scanner codes = null;
		try {
			codes = new Scanner(safeCode);
			
		} catch (FileNotFoundException ex) {
			// 
		}

		do {  // converts code to string and add to an array
			accessCodes.add(codes.nextLine());	
			//accessCodes =String.valueOf(accessCodes);
		}
		while(codes.hasNextLine());
		codes.close(); // close file
	}
	
	/** Check if access code is correct */
	public boolean checkCode(String codeAccess) {
		if (accessCodes.contains(codeAccess)) {
			open = true;
		} 
		else {
			open = false;
		}
     
		return open;
	}
	
	public void clearAccessCodes(){
		accessCodes.clear();
	}

}
