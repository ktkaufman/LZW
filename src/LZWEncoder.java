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
	
	public void encode(String inputFile, String outputFile) {
		
	}
}
