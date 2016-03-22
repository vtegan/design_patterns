/**
 * 
 */
package org.vegan.factory.login;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.vegan.factory.login.UserDAO;


/**
 * User DAO that is used without a database.  Uses collections to mock a database connection.  Used for unit testing purposes.
 * 
 * @author tegan
 *
 */
public class UserMockDAO implements UserDAO {


	/* (non-Javadoc)
	 * @see org.ibdusa.login.UserDAO#loadByUsernameAndPassword(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("deprecation")
	@Override
	public User loadByUsernameAndPassword(final String userName, final String password) {

		Collection<User> users = new ArrayList<>();

		users.add(new User(LoginConstants.USER_ONE, LoginConstants.PASSWORD_ONE, "Terry", "Egan", new Date("10/17/1966"), Access.FULL));
		users.add(new User(LoginConstants.USER_TWO, LoginConstants.PASSWORD_TWO, "Joe","Smith", new Date("08/16/1964"), Access.READ));
		users.add(new User(LoginConstants.USER_THREE, LoginConstants.PASSWORD_THREE, "Jane", "Doe", new Date("07/05/1956"), Access.WRITE));


		//Create predicate
		//Define the filtering condition
		@SuppressWarnings({ "rawtypes", "unchecked" })
		Predicate<User> predicate = new Predicate() {

			public boolean evaluate(Object object) {
				
				return ((User) object).getUsername().equals(userName) && ((User) object).getPassword().equals(password);  //Filtering Condition
			}
		};

		//build create the filter.
		//Perform the select operation.  The first operation is the collection and the second operation is the predicate.
		//List<User> filtered = (List<User>) CollectionUtils.select(users, predicate);
		//List<User> filtered = new ArrayList<>(CollectionUtils.select(users, predicate));  // I like this because there is not casting.
		Collection<User> filtered = CollectionUtils.select(users, predicate);
		System.out.println("Size of collection:  " + filtered.size());


		//Return the User object
		if (filtered == null || !filtered.isEmpty())
			return filtered.iterator().next();
		else return null;
	}



}
