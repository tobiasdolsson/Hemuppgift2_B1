package main;

import java.math.BigInteger;
import java.util.Arrays;

public class DC {

	private String SA, DA, SB, DB, m;
	private int b;

	public DC(String SA, String DA, String SB, String DB, String m, int b) {

		this.b = b;
		this.SA = SA;
		this.DA = DA;
		this.SB = SB;
		this.DB = DB;
		this.m = m;

		if (b == 1) {
			System.out.println(sendMessage());
		} else {
			System.out.println(noMessage());
		}

	}

	private String sendMessage() {

		String brodcastedData = notXor(toBinary(SA), toBinary(SB), toBinary(m));
		
		return toHex(brodcastedData);
		
	}

	private String noMessage() {
		String brodcastedData = xor(toBinary(SA), toBinary(SB));
		String ABbrodcastedData = xor(toBinary(DA), toBinary(DB));
		String message = xor(brodcastedData, ABbrodcastedData);
		return toHex((brodcastedData + message));
	
	}

	private String xor(String s1, String s2) {
		s1 = "0000000000000000".substring(s1.length()) + s1;
		s2 = "0000000000000000".substring(s2.length()) + s2;
		String done = "";

		for (int i = 0; i < 16; i++) {

			int xor = (Integer.valueOf(s1.substring(i, i + 1))) ^ (Integer.valueOf(s2.substring(i, i + 1)));
			done += xor;

		}

		return done;
	}

	private String notXor(String s1, String s2, String m) {
		s1 = "0000000000000000".substring(s1.length()) + s1;
		s2 = "0000000000000000".substring(s2.length()) + s2;
		m = "0000000000000000".substring(m.length()) + m;
		String done = "";

		for (int i = 0; i < 16; i++) {
			// 1 NOTXOR
			// 0 XOR

			if ((Integer.valueOf(m.substring(i, i + 1))) == 0) {

				int xor = (Integer.valueOf(s1.substring(i, i + 1))) ^ (Integer.valueOf(s2.substring(i, i + 1)));

				done += xor;
			} else {
				int xor = (Integer.valueOf(s1.substring(i, i + 1))) ^ (Integer.valueOf(s2.substring(i, i + 1)));

				int notxor = xor ^ 1;

				done += notxor;
			}

		}
		
		return done;
	}
	
	private String toBinary(String s){
		return new BigInteger(s, 16).toString(2);
	}
	
	private String toHex(String s){
		return new BigInteger(s, 2).toString(16);
	}
	

}
