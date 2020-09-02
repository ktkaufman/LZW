import java.util.*;
import java.io.*;

public class LZWEncoder {
	private HashMap<String, Integer> codemap = new HashMap<String, Integer>();
	private int lastindex;
	
	public LZWEncoder() {
		for (int i = 0; i<26; i++) {
			codemap.put(Character.toString((char)(i+97)), i); //what if not all lowercase letters?
		}
		lastindex = 25;
	}
	
	
	public void encode(String inputFile, String outputFile) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		int inputCharNum = reader.read();
		String output = "";
		String buffer = Character.toString((char)inputCharNum);
		
		while(inputCharNum != -1) {
			
			
			inputCharNum = reader.read();
			buffer += Character.toString((char)inputCharNum);
		}
	}
}
