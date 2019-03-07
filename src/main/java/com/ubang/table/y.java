package com.ubang.table;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class y {
	public static void main(String[] args) {
		  Pattern r = Pattern.compile("(\\[)(.*)(\\])");
	        Matcher m = r.matcher("[r,w]");
	        try {
		        if (m.find( )) { 
		            System.out.println("Found value: " + m.group(2) );
		            for(int i=0;i< m.group(2).split(",").length;i++) {
	                   System.out.println(m.group(2).split(",")[i]);
	                }
		        } else {
		            System.out.println("NO MATCH");
		        }
	        }catch (Exception e) {
				// TODO: handle exception
	        	e.printStackTrace();
			}
	}
}
