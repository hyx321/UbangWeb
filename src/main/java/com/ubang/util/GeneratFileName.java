package com.ubang.util;

import java.util.Random;

public class GeneratFileName {
	
	public static String getRandomName() {
		 String string = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    char[] ch = new char[4];
	    for (int i = 0; i < 10; i++) {
	        Random random = new Random();
	        int index = random.nextInt(string.length());
	        ch[i] = string.charAt(index);
	    }
	    return ch.toString();
	}

}
