import java.io.*;
import java.util.*;

public class LZWDecoder {
	private HashMap<Integer, String> codeMap;
	private int lastIndex;

	public LZWDecoder() {
		// adds first 128 ascii characters to table
		codeMap = new HashMap<Integer, String>(128);
		for (int i = 0; i < 128; i++) {
			codeMap.put(i, "" + (char) (i)); // value of ith ascii as a key is i
		}
		lastIndex = 127;
	}

<<<<<<< HEAD

	//Reads input file; while reading gets each char index and decodes it by seeing where it is in the table and then writes the corresponding value
	//Also makes the decoding table
	public void decode(String inputFile, String outputFile) throws IOException { 
=======
	public void decode(String inputFile, String outputFile) throws IOException {
>>>>>>> parent of c2a1200... Update LZWDecoder.java
		BufferedWriter outputWriter = new BufferedWriter(new FileWriter(new File(outputFile)));
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		String temp2 = "";
		String lastCode = "" + codeMap.get(reader.read());
		String current = "";
		outputWriter.write(lastCode);
		while (reader.ready()) {
			int index = reader.read();
			current = "" + codeMap.get(index);
			if (index > lastIndex) {
				current = lastCode + lastCode.charAt(0);
				outputWriter.write(current);
				lastIndex++;
				codeMap.put(lastIndex, current);

				lastCode = current;
			} else {
				outputWriter.write(current);
				lastIndex++;
				codeMap.put(lastIndex, lastCode + current.charAt(0));
				// System.out.println(lastCode+"+"+temp1+"="+lastCode+temp1);
				temp2 = "" + current.charAt(0);
				lastCode = current;
			}
		}

		outputWriter.close();
		reader.close();
	}
}
