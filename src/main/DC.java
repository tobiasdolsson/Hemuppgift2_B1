package main;

import java.math.BigInteger;
import java.util.Arrays;

public class DC {

	public String aliceHex = "27C2";
	public BigInteger aliceSecret = new BigInteger(aliceHex, 16);
	public String bobHex = "0879";
	public BigInteger bobSecret = new BigInteger(bobHex, 16);
	public String aliceBroadcast = "35F6";
	public BigInteger aBroadcast = new BigInteger(aliceBroadcast, 16);
	public String bobBroadcast = "1A4D";
	public BigInteger bBroadcast = new BigInteger(bobBroadcast, 16);
	public String message = "27BC";
	public BigInteger m = new BigInteger(message, 16);

	public DC() {
		System.out.println(aliceSecret);

		String str = aliceSecret.toString(2);
		System.out.println(str);
		String str1 = str.substring(1, 2);
		System.out.println(str1);

		// System.out.println(bobSecret);
	}

	
	
	public String xor(String s1, String s2){
		s1 = "0000000000000000".substring(s1.length()) + s1;
		s2 = "0000000000000000".substring(s2.length()) + s2;
		String done = "";
		
		for (int i = 0; i < 16; i++) {

			int xor = (Integer.valueOf(s1.substring(i, i + 1))) ^ (Integer.valueOf(s2.substring(i, i + 1)));
			// System.out.println(xor);
			done += xor;

		}
		
		return done;
	}


}
