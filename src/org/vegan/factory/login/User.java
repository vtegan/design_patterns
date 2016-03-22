package org.vegan.factory.login;

import java.util.Date;

/**
 * VO object that contains a user details from the UserDAO object.
 * Used for authentication and authorization.
 * 
 * @author tegan
 *
 */
public class User {
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private Access permission;
	
	
	
	/**
	 * No-args constructor.
	 */
	public User() {
		//No-args constructor
	}
	
	
	/**
	 * Constructor that accepts values from a query.
	 * 
	 * @param username 
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param birthDate
	 * @param permission - A String that lists the permission from the datasource.
	 */
	public User(String username, String password, String firstName,
			String lastName, Date birthDate, Access permission) {
		
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.permission = permission;
	}


	/**
	 * Retrieve userid.
	 * 
	 * @return - A String that represents the username.
	 */
	public String getUsername() {
		return username;
	}


	/**
	 * Retrieve password.
	 * 
	 * @return - A String that represents the password.
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * Retrieve the user's first name.
	 * 
	 * @return - A String that represents the user's first name.
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * Retrieve the user's last name.
	 * 
	 * @return - A String that represents the user's last name.
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * Retrieve the user's date of birth.
	 * 
	 * @return - A <Date> that represents the user's data of birth.
	 */
	public Date getBirthDate() {
		return birthDate;
	}


	/**
	 * Retrieve the user's permission.
	 * @return - An <Access> Enum that represents the user's permissions.
	 */
	public Access getPermission() {
		return permission;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}
