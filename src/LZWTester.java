import java.util.*;
import java.io.*;

public class LZWTester {
	public static void main (String[] args) throws IOException {
		LZWEncoder e = new LZWEncoder();
		e.encode("encodertest.txt", "testout.txt");
		System.out.println("reading");
		LZWTester.read("testout.txt");
	}

	public static void read(String infile) throws IOException {
		String output = "";
		
		//a buffer storing the chars that we're trying to determine the equivalent number to
		String buffer = "";
		BufferedReader reader = new BufferedReader(new FileReader(infile));
		int inputCharNum = reader.read();
		while (inputCharNum != -1) {
			inputCharNum = reader.read();
		}
	}
}