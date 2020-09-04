import java.util.*;
import java.io.*;

public class LZWEncoder {
	//codeMap is a hashmap that stores the LZW table
	private HashMap<String, Integer> codeMap;
	//lastIndex stores the last number that we added to the table
	private int lastIndex;
	
	public LZWEncoder() {
		//add a-z as 0-25 in the table
		codeMap =  new HashMap<String, Integer>(128);
		for (int i = 0; i<128; i++) {
			codeMap.put(Character.toString((char)(i)), i); //what if not all lowercase letters?
		}
		lastIndex = 127;
	}
	
	//encode reads an input file, and encodes it using LZW encoding and outputs it to an output file
	public void encode(String inputFile, String outputFile) throws IOException{
		//the final output to the file
		String output = "";
		
		//a buffer storing the chars that we're trying to determine the equivalent number to
		String buffer = "";
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		int inputCharNum = reader.read();
		
		//while loop looping through all the characters in the input file
		while(inputCharNum != -1) {
			//add the new character to our buffer
			buffer += Character.toString((char)inputCharNum);
			
			//if codeMap doesn't contain buffer, that means codeMap does contain buffer without its last element
			if (!(codeMap.containsKey(buffer))) {
				//if we haven't hit out maximum table size, add buffer to the table
				if (lastIndex < 255) { //codeMap has max 256 elements
					codeMap.put(buffer, lastIndex+1);
					lastIndex++;
				}
				
				//since we know buffer without its last element is in codeMap, we add its corresponding value to output, encoded as a char
				output += (char)((codeMap.get(buffer.substring(0,buffer.length()-1))).intValue());
				//we then remove that part of buffer that we encoded from buffer
				buffer = buffer.substring(buffer.length()-1,buffer.length());
			}
			inputCharNum = reader.read();
		}
		
		//if the last few elements of the input file will not get read by the while loop. As a result, we add those into the output
		output += (char)(codeMap.get(buffer).intValue());
		
		//writing the output to the file
		BufferedWriter outputWriter = new BufferedWriter(new FileWriter(new File(outputFile)));
		outputWriter.write(output);
		reader.close();
		outputWriter.close();
	}
}
