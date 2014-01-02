/*
 * AdministratorDAO.java
 *
 * Created on February 11, 2005, 5:58 PM
 */

package org.simplecart.dao;

import net.sf.hibernate.HibernateException;

import org.simplecart.administration.Administrator;

/**
 *
 * @author Daniel Watrous
 */
public class AdministratorDAO extends BaseDAO {
    
    //private Class DAOClassType = Administrator.class;
    
    /** Creates a new instance of AdministratorDAO */
    public AdministratorDAO() {
        super();
        DAOClassType = Administrator.class;
    }
    
    /**
     * @return administrator
     * @param id
     * @param lock
     */
    public Administrator findById(Long id, boolean lock) throws HibernateException {
        Administrator administrator = null;
        
        administrator = (Administrator) abstractFindById(id, lock);
        return administrator;
    }
}
