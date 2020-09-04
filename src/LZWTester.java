import java.util.*;
import java.io.*;

public class LZWTester {
	public static void main (String[] args) throws IOException {
		LZWEncoder e = new LZWEncoder();
		e.encode("encodertest.txt", "testout.txt");

	}
}