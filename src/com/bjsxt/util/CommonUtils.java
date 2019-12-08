package com.bjsxt.util;

import java.io.UnsupportedEncodingException;

public class CommonUtils {

	public static String changeUTF(String str) {
		String newStr = null;
		
		try {
			newStr = new String(str.getBytes("iso8859-1"),"utf-8");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return newStr;
	}
}
