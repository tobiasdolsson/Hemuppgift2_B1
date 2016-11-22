package main;

import java.math.BigInteger;
import java.util.Arrays;

public class DC {

	public DC() {

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
