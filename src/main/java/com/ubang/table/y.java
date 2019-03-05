package com.ubang.table;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class y {
	public static void main(String[] args) {
		  Pattern r = Pattern.compile("(\\[)(.*)(\\])");
	        Matcher m = r.matcher("[r,w]");
	        if (m.find( )) { 
	            System.out.println("Found value: " + m.group(2) );
	        } else {
	            System.out.println("NO MATCH");
	        }
	}
}
