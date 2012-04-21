package com.ram.jmtt.zr.core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
	  private Pattern pattern;
	  private Matcher matcher;

	  private static final String EMAIL_PATTERN = 
                 "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	  public EmailValidator(){
		  pattern = Pattern.compile(EMAIL_PATTERN);
	  }

	  /**
	   * Validate hex with regular expression
	   * @param hex hex for validation
	   * @return string if valid, null if invalid
	   */
	  public String validate(final String hex){

		  matcher = pattern.matcher(hex);
		  return matcher.matches() ? hex : null;

	  }
}
