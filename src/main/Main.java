package main;

import java.math.BigInteger;
import java.util.Arrays;

public class Main {

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

	public Main() {
		System.out.println(aliceSecret);

		String str = aliceSecret.toString(2);
		System.out.println(str);
		String str1 = str.substring(1, 2);
		System.out.println(str1);

		// System.out.println(bobSecret);
	}

	public static void main(String args[]) {
		Main m = new Main();
		m.timeToXor();
	}

	public void timeToXor() {
		String alice = aliceSecret.toString(2);
		String bob = bobSecret.toString(2);
		// System.out.println(aliceSecret);
		System.out.println(bob);
		System.out.println(alice);
		String done = "";
		for (int i = 0; i < bob.length(); i++) {

			int xor = (Integer.valueOf(alice.substring(i, i + 1))) ^ (Integer.valueOf(bob.substring(i, i + 1)));
			// System.out.println(xor);
			done += xor;

		}
		System.out.println(done);
	}

}
