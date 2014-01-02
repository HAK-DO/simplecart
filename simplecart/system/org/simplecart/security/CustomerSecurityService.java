/*
 * WardListSecurityService.java
 *
 * Created on February 4, 2005, 11:08 AM
 */

package org.simplecart.security;

import java.util.Collection;
import java.util.Iterator;

import net.sf.hibernate.HibernateException;

import org.simplecart.account.Customer;
import org.simplecart.base.Party;
import org.simplecart.dao.CustomerDAO;
import org.simplecart.exceptions.AuthenticationException;
import org.simplecart.persistence.HibernateUtility;

/**
 *
 * @author Daniel Watrous
 */
public class CustomerSecurityService implements SecurityService {
    
    /** Creates a new instance of WardListSecurityService */
    public CustomerSecurityService() {
    }
    
    public Party authenticate (String username, String password) throws AuthenticationException, HibernateException {
        // this should happen at DAO creation
        // begin Hibernate transaction
        //HibernateUtil.beginTransaction();
        
        // create DAO instance
        CustomerDAO dao = new CustomerDAO();
        if (dao == null){
            throw new AuthenticationException ("Error initializing dao");
        }

        // create example object for query
        Customer loginCustomer = new Customer();
        loginCustomer.setUsername(username);
        
        // find member object by example
        Collection matchingCustomers = dao.findByExample(loginCustomer);
        Iterator memberIter = matchingCustomers.iterator();
        if (memberIter.hasNext()) {
            loginCustomer = (Customer) memberIter.next();
        } else loginCustomer = null;

        if ((loginCustomer == null) || !password.equals(loginCustomer.getPassword())) {
            throw new AuthenticationException ("Error validating user");
        }

        // commit this transaction
        HibernateUtility.commitTransaction();
        HibernateUtility.closeSession();

        return loginCustomer;
    }
}
