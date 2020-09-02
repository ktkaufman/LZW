import java.util.*;
import java.io.*;

public class LZWEncoder {
	
	private HashMap<Integer, String> codemap = new HashMap<Integer, String>();
	private int lastindex = 25;
	
	
	public void encode(String inputFile, String outputFile) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		int inputCharNum = reader.read();
		while(inputCharNum != -1) {
			
			
			inputcharNum = reader.read();
		}
	}
}
