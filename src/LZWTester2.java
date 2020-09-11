import java.io.*;
public class LZWTester2 {

	public static void main (String [] args) throws IOException
	{
		LZWEncoder test = new LZWEncoder();
		test.encode("inputTest.txt","outputTest.txt");
	}
	

}
