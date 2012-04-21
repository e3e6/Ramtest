package com.ram.jmtt.zr.core.robots;

import com.ram.jmtt.zr.core.util.MailerDaemon;

public class MailRobot {

	/**
	 * Send email to user with password and confirm registration link
	 * @param email
	 * @param pwd
	 * @return TODO Add return type to check sending email
	 */
	public static final void sendRegistrationEmail(String email, String pwd){
		
		
		StringBuilder text = new StringBuilder();
						text.append("Greetings from %companyname%\n");
						text.append("Take your password [" + pwd + "].\n");
						text.append("And please confirm your registration ");
						text.append("<a href=\"link\">Yes, i want to use your service</a>");
		
						//TODO Approve the text
						
		MailerDaemon.sendEmail(email, "Confirm registration", text.toString());
	}
}
