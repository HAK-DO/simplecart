package org.simplecart.dao;

import net.sf.hibernate.HibernateException;

import org.simplecart.account.Customer;

public class CustomerDAO extends BaseDAO {

    public CustomerDAO() {
        super();
        DAOClassType = Customer.class;
    }

    /**
     * @return Customer object by ID 
     * @param id 
     * @param lock 
     */
    public Customer findById(Long id, boolean lock) throws HibernateException {
        Customer customer = null;

        customer = (Customer) abstractFindById(id, lock);
        return customer;
    }
}
