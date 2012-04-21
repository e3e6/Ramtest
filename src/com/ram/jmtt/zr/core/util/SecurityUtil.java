package com.ram.jmtt.zr.core.util;

public class SecurityUtil {

	/**
	 * Create password
	 * TODO @param Length of password
	 * TODO @param Using symbols
	 * @return
	 */
	public static final String createPassword(){
		
		//TODO Create password generator
		
		return "111111";
	}
	
	/**
	 * Get MD5 hash from password string
	 * @param string
	 * @return
	 */
	public static final String getHash(String string){
		
		//TODO replace with real function
		
		return "" + string.hashCode();
	}
}
