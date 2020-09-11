import java.util.*;
public class LZWTester {

	public static void main (String [] args) throws IOException
	{
		LZWEncoder test = new LZWEncoder();
		test.encode("inputTest.txt","outputTest.txt");
	}
	

}
