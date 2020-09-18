import java.io.*;
public class LZWTester2 
{
	public static void main (String [] args) throws IOException
	{
		LZWEncoder test = new LZWEncoder();
		LZWDecoder decoder=new LZWDecoder();
		test.encode("inputTest.txt","outputTest.txt");
		decoder.decode("outputTest.txt","newOutput.txt");
	}
	

}
