package com.hyla.utils;

import java.nio.charset.Charset;

import org.springframework.security.crypto.codec.Base64;

public class CommonUtils {
	public static String getAuthHeader(final String username, final String password){
		String auth = username + ":" + password;
        byte[] encodedAuth = Base64.encode(auth.getBytes(Charset.forName("UTF-8")));
        return "Basic " + new String(encodedAuth);
	}
}
