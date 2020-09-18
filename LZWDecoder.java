import java.io.*;
import java.util.*;
public class LZWDecoder
{
	private HashMap<Integer, String> codeMap;
	private int lastIndex;
	public LZWDecoder() {
		//adds first 128 ascii characters to table
		codeMap =  new HashMap<Integer, String>(128);
		for (int i = 0; i<128; i++) {
			codeMap.put(i, ""+(char)(i)); //value of ith ascii as a key is i
		}
		lastIndex = 127;
	}

	public void decode(String inputFile, String outputFile) throws IOException {
		BufferedWriter outputWriter = new BufferedWriter(new FileWriter(new File(outputFile)));
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		String temp1 = "";
		String temp2 = "";
		String lastCode = "" + (char)reader.read();
		outputWriter.write(lastCode);
		while (reader.ready())
		{
			if(codeMap.containsKey(lastCode));{
				outputWriter.write(codeMap.get(lastCode));
			}
			else{
				
			}
			outputWriter.write(temp1);
			
		}
	}

}
