package org.vegan.factory.login;

/**
 * Interface that handles user details.  Primarily used for authentication and authorization.
 *  
 * @author tegan
 *
 */
public interface UserDAO {
	
	/**
	 * Load and retrieve data from the the data source to the User object.
	 * 
	 * @param userName - A String that represents the username. 
	 * @param password - A String that represents the password.
	 * @return A <User> object that contains details for the user.
	 */
	public User loadByUsernameAndPassword(String userName, String password);

}
