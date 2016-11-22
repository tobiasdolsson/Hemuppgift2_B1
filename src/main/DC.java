package main;

import java.math.BigInteger;
import java.util.Arrays;

public class DC {

	private BigInteger SA, DA, SB, DB, m;
	private int b;

	public DC(BigInteger SA, BigInteger DA, BigInteger SB, BigInteger DB, BigInteger m, int b) {

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

		String brodcastedData = notXor(SA.toString(2), SB.toString(2), m.toString(2));
		String ABbrodcastedData = xor(DA.toString(2), DB.toString(2));
		String message = xor(brodcastedData, ABbrodcastedData);
		return message;
	}

	private String noMessage() {
		String brodcastedData = xor(SA.toString(2), SB.toString(2));
		String ABbrodcastedData = xor(DA.toString(2), DB.toString(2));
		String message = xor(brodcastedData, ABbrodcastedData);

		return brodcastedData + message;
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
		System.out.println(done);
		return done;
	}

}
