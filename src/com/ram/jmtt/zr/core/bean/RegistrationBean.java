package com.ram.jmtt.zr.core.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.ram.jmtt.zr.core.dao.RegisterDao;
import com.ram.jmtt.zr.core.entity.User;
import com.ram.jmtt.zr.core.robots.MailRobot;
import com.ram.jmtt.zr.core.util.EmailValidator;
import com.ram.jmtt.zr.core.util.SecurityUtil;

//import org.hibernate.validator.*;


/**
 * Mapping for register.xhtml
 *
 */
@ManagedBean(name="registrationBean")
//@SessionScoped
@RequestScoped
public class RegistrationBean  implements Serializable{


	private static final long serialVersionUID = 1L;
	
	/**
	 * Username
	 */
	//@NotEmpty
	//@Pattern(regex=".*[^\\s].*", message="This string contain only spaces")
	//@Length(min=3,max=12)
	private String name;
	/**
	 * Email adress
	 */
    //@Email
    //@NotEmpty
	private String email;
	/**
	 * Date of birth
	 */
	private Date birthDate;
	
	private User user;
	
	private String answer = ""; 
	
	public String getName() {
		return name;
	}
	public void setName(String username) {
		this.name = username;
	}
	public String getEmail() {
		
		System.out.println("get email [" + validateEmail() + "]");
		
		return validateEmail();
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

	
	/**
	 * Validate all fields
	 * @return
	 */
	private boolean validateFields(){

		return (user == null) && 
			   (name != null && name.length() > 0) &&
			   (validateDate(birthDate) 
				&& (validateEmail() != null) 
				);
	}
	
	/**
	 * Check string
	 * @param text
	 * @return
	 */
	public String validateEmail(){
		
		return email;
	}
	
	/**
	 * Validate Date
	 * @param date
	 * @return true if  ((today - 100) < date < now)
	 */
	private boolean validateDate(Date date){
		Calendar min = Calendar.getInstance();
				 min.roll(Calendar.YEAR, -1 * MAX_REGISTRATION_AGE);
		
		Calendar max = Calendar.getInstance();
				 max.roll(Calendar.YEAR, MIN_REGISTRATION_AGE);
		
		return (date != null && (date.after(min.getTime()) && date.before(max.getTime())));
	}
	
	/**
	 * Register new user
	 * @return
	 */
	public String addUser(){
		System.out.println("addUser [" + user + "] - " + email);
		if(validateFields()){
			
			User newUser = new User();
      			 newUser.setUsername(name);
      			 newUser.setEmail(email);
      			 newUser.setBirthDate(birthDate);
      			 
      			 String pwd = SecurityUtil.createPassword();
      			 
      			 newUser.setpHash(SecurityUtil.getHash(pwd));
      			 
      			 //TODO Store UserPic
      			//newUser.setUserImage(RegisterDao.storeEnity(files.get(0)));
	 

			 user = RegisterDao.storeEnity(newUser);
			 
			 if(user != null){
				 MailRobot.sendRegistrationEmail(email, pwd);
				 
				 setAnswer("We send the email to you with password.");
			 }
			 
			 pwd = null;
		} else {
			answer = "Check your email adress and you must be at least 16 years old.";
		}

    	System.out.println("added [" + user + "]");
    	
    	return null;
	}


	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public static final int MIN_REGISTRATION_AGE = 16;
	public static final int MAX_REGISTRATION_AGE = 100;
}