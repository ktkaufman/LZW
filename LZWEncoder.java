import java.util.*;
import java.io.*;

public class LZWEncoder {
	//codeMap is a hashmap that stores the LZW table
	private HashMap<String, Integer> codeMap;
	//lastIndex stores the index of last number that we added to the table (# things in table - 1)
	private int lastIndex;
	
	public LZWEncoder() {
		//adds first 128 ascii characters to table
		codeMap =  new HashMap<String, Integer>(128);
		for (int i = 0; i<128; i++) {
			codeMap.put(Character.toString((char)(i)), i); //value of ith ascii as a key is i
		}
		lastIndex = 127;
	}
	
	//encode reads an input file, and encodes it using LZW encoding and outputs it to an output file
	public void encode(String inputFile, String outputFile) throws IOException{
		//the final output to the file
		StringBuilder output = new StringBuilder("");
		
		//input string we're about to encode
		String buffer = "";
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		int inputCharNum = reader.read();
		
		//while loop looping through all the characters in the input file
		while(inputCharNum != -1) {
			//add the new character to our buffer
			buffer += Character.toString((char)inputCharNum);
			
			//if codeMap doesn't contain buffer, it contains substring of buffer without last character
			if (!(codeMap.containsKey(buffer))) {
				//if we haven't hit our maximum table size, add buffer to the table
				if (lastIndex < 255) { //codeMap has max 256 elements
					codeMap.put(buffer, lastIndex+1);
					lastIndex++;
				}
				
				//get integer value corresponding to substring of buffer without last character from codeMap, encoded as a char

				output.append((char)((codeMap.get(buffer.substring(0,buffer.length()-1))).intValue()));

				output += ((codeMap.get(buffer.substring(0,buffer.length()-1))).intValue());

				//set buffer to its last character
				buffer = buffer.substring(buffer.length()-1,buffer.length());
			}
			inputCharNum = reader.read();
		}
		

		output.append((char)(codeMap.get(buffer).intValue()));

		output += (codeMap.get(buffer).intValue());

		
		//writing the output to the file
		BufferedWriter outputWriter = new BufferedWriter(new FileWriter(new File(outputFile)));
		outputWriter.write(output.toString());
		reader.close();
		outputWriter.close();
	}
}