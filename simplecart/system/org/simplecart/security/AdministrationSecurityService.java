/*
 * WardListSecurityService.java
 *
 * Created on February 4, 2005, 11:08 AM
 */

package org.simplecart.security;

import java.util.Collection;
import java.util.Iterator;

import net.sf.hibernate.HibernateException;

import org.simplecart.administration.Administrator;
import org.simplecart.base.Party;
import org.simplecart.dao.AdministratorDAO;
import org.simplecart.exceptions.AuthenticationException;
import org.simplecart.persistence.HibernateUtility;

/**
 *
 * @author Daniel Watrous
 */
public class AdministrationSecurityService implements SecurityService {
    
    /** Creates a new instance of WardListSecurityService */
    public AdministrationSecurityService() {
    }
    
    public Party authenticate (String username, String password) throws AuthenticationException, HibernateException {
        // this should happen at DAO creation
        // begin Hibernate transaction
        //HibernateUtil.beginTransaction();
        
        // create DAO instance
        AdministratorDAO dao = new AdministratorDAO();
        if (dao == null){
            throw new AuthenticationException ("Error initializing dao");
        }

        // create example object for query
        Administrator loginAdministrator = new Administrator();
        loginAdministrator.setUsername(username);
        
        // find member object by example
        Collection matchingAdministrators = dao.findByExample(loginAdministrator);
        Iterator memberIter = matchingAdministrators.iterator();
        if (memberIter.hasNext()) {
            loginAdministrator = (Administrator) memberIter.next();
        } else loginAdministrator = null;

        if ((loginAdministrator == null) || !password.equals(loginAdministrator.getPassword())) {
            throw new AuthenticationException ("Error validating user");
        }

        // commit this transaction
        HibernateUtility.commitTransaction();
        HibernateUtility.closeSession();

        return loginAdministrator;
    }
}
