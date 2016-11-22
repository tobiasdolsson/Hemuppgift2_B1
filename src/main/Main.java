package main;

import java.math.BigInteger;

public class Main {
	
	
	
	public static void main (String args[]){
		
		String aliceHex = "27C2";
		BigInteger aliceSecret = new BigInteger(aliceHex, 16);
		String bobHex = "0879";
		BigInteger bobSecret = new BigInteger(bobHex, 16);
		String aliceBroadcast = "35F6";
		BigInteger aBroadcast = new BigInteger(aliceBroadcast, 16);
		String bobBroadcast = "1A4D";
		BigInteger bBroadcast = new BigInteger(bobBroadcast, 16);
		String message = "27BC";
		BigInteger m = new BigInteger(message, 16);
		int b = 1;
		
		DC dc = new DC();
		
		if(b==1){
			dc.sendMessage();
		}else{
			dc.noMessage();
		}
	
		System.out.println(dc.xor(aliceSecret.toString(2), bobSecret.toString(2)));
		
	}

}
