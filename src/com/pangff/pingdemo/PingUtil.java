package com.pangff.pingdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PingUtil {

	public static String ping(String url) {
	    String str = "";
	    try {
	        Process process = Runtime.getRuntime().exec("/system/bin/ping -c 3 " + url);
	        BufferedReader reader = new BufferedReader(new InputStreamReader(
	                process.getInputStream()));
	        int i;
	        char[] buffer = new char[4096];
	        StringBuffer output = new StringBuffer();
	        while ((i = reader.read(buffer)) > 0)
	            output.append(buffer, 0, i);
	        reader.close();
	        str = output.toString();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return str;
	}
}
