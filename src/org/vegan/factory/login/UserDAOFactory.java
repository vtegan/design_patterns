/**
 * 
 */
package org.vegan.factory.login;

import java.util.HashMap;
import java.util.Map;

/**
 * Class is a typical Factory Method Pattern.
 * @author tegan
 *
 */
public class UserDAOFactory {
	
	/**
	 * Factory method pattern that provides flexibility for handling user authentication.
	 * 
	 * @param dao   A string that represents the DAO type.
	 * @return      A UserDAO object implementation.
	 */
	public static UserDAO createUserDAO(String dao){
		
		Map<String, UserDAO> mapDao = new HashMap<>();
		
		mapDao.put("MOCK", new UserMockDAO());
		//mapDao.put("DB_USER", new UserDbDAO())
		//mapDao.put("LDAP_USER", new UserLdapDAO());
		
		return mapDao.get(dao);
	}

}
