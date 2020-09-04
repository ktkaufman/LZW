import java.util.*;
import java.io.*;

public class LZWEncoder {
	//codemap is a hashmap that stores the LZW table
	private HashMap<String, Integer> codemap;
	//lastindex stores the last number that we added to the table
	private int lastindex;
	
	public LZWEncoder() {
		//add a-z as 0-25 in the table
		codemap =  new HashMap<String, Integer>(128);
		for (int i = 0; i<128; i++) {
			codemap.put(Character.toString((char)(i)), i); //what if not all lowercase letters?
		}
		lastindex = 127;
	}
	
	//encode reads an input file, and encodes it using LZW encoding and outputs it to an output file
	public void encode(String inputFile, String outputFile) throws IOException{
		//the final output to the file
		String output = "";
		
		//a buffer storing the chars that we're trying to determine the equivalent number to
		String buffer = "";
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		int inputCharNum = reader.read();
		
		while(inputCharNum != -1) {
			buffer += Character.toString((char)inputCharNum);
			if (!(codemap.containsKey(buffer))) {
				if (lastindex < 255) { //codemap has max 128 elts
					codemap.put(buffer, lastindex+1);
					lastindex++;
				}
				output += (char)((codemap.get(buffer.substring(0,buffer.length()-1))).intValue());
				buffer = buffer.substring(buffer.length()-1,buffer.length());
			}
			inputCharNum = reader.read();
		}
		
		BufferedWriter outputWriter = new BufferedWriter(new FileWriter(new File(outputFile)));
		outputWriter.write(output);
		reader.close();
		outputWriter.close();
	}
}
