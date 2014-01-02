
package org.simplecart.dao;

import java.util.Collection;

import net.sf.hibernate.Criteria;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.LockMode;
import net.sf.hibernate.Session;
import net.sf.hibernate.expression.Example;

import org.apache.log4j.Category;
import org.simplecart.base.Persistent;
import org.simplecart.persistence.HibernateUtility;

/**
 * <p></p>
 *
 */
@SuppressWarnings("rawtypes")
public abstract class BaseDAO {
    
    /**
     * DAOClassType is the type of class for which this
     * DAO can retrieve objects
     */
	protected Class DAOClassType;
    private static Category cat = Category.getInstance(BaseDAO.class.getName());
    
    /**
     * Standard constructor
     */
    public  BaseDAO() {
        try {
            cat.debug("Initialize Base DAO");
            HibernateUtility.beginTransaction();
        } catch (HibernateException ex) {
            System.out.println("Failed to start Hibernate Transaction in BaseDAO!!!");
        }
    }
    
    /**
     * @throws HibernateException
     *
     * @return all matching objects
     */
    public Collection findAll() throws HibernateException {
        Collection objects;
        try {
            objects = HibernateUtility.getSession().createCriteria(DAOClassType).list();
        } catch (HibernateException ex) {
            throw new HibernateException(ex);
        }
        return objects;
    }
    
    /**
     * @throws HibernateException
     *
     * @param example
     * @return all objects that match example
     */
    public java.util.Collection findByExample(Persistent example) throws HibernateException {
        Collection objects;
        cat.debug("Begin Find By Example");
        cat.debug("Example object class type: " + example.getClass());
        cat.debug("Current DAO object class type: " + DAOClassType);
        
        try {
            Criteria crit = HibernateUtility.getSession().createCriteria(DAOClassType);
            objects = crit.add(Example.create(example)).list();
        } catch (HibernateException ex) {
            throw new HibernateException(ex);
        }
        return objects;
    }
    
    /**
     * @throws HibernateException
     *
     * @return this is an instance of some Persisten class
     * @param id
     * @param lock
     */
    public Persistent abstractFindById(Long id, boolean lock) throws HibernateException {
        Session session = HibernateUtility.getSession();
        Persistent object = null;
        try {
            if (lock) {
                object = (Persistent) session.load(DAOClassType, id, LockMode.UPGRADE);
            } else {
                object = (Persistent) session.load(DAOClassType, id);
            }
        }  catch (HibernateException ex) {
            throw new HibernateException(ex);
        }
        return object;
    }
    
    /**
     * @throws HibernateException
     *
     * @param object
     */
    public void makePersistent(Persistent object) throws HibernateException {
        try {
            HibernateUtility.getSession().saveOrUpdate(object);
        } catch (HibernateException ex) {
            throw new HibernateException(ex);
        }
    }
    
    /**
     * @throws HibernateException
     *
     * @param object
     */
    public void makeTransient(Persistent object) throws HibernateException {
        try {
            HibernateUtility.getSession().delete(object);
        } catch (HibernateException ex) {
            throw new HibernateException(ex);
        }
    }
}
