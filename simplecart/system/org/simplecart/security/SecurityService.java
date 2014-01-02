/*
 * SecurityService.java
 *
 * Created on February 4, 2005, 11:03 AM
 */

package org.simplecart.security;

import net.sf.hibernate.HibernateException;

import org.simplecart.base.Party;
import org.simplecart.exceptions.AuthenticationException;

/**
 *
 * @author Daniel Watrous
 */
public interface SecurityService {
    public Party authenticate (String username, String password) throws AuthenticationException, HibernateException;
}
