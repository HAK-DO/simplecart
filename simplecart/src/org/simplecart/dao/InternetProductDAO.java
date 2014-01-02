package org.simplecart.dao;

import net.sf.hibernate.HibernateException;

import org.simplecart.shopcart.catalog.InternetProduct;

public class InternetProductDAO extends BaseDAO {

    public InternetProductDAO() {
        super();
        DAOClassType = InternetProduct.class;
    }

    /**
     * @return  InternetProduct by ID
     * @param id 
     * @param lock 
     */
    public InternetProduct findById(Long id, boolean lock)
            throws HibernateException {
        InternetProduct product = null;

        product = (InternetProduct) abstractFindById(id, lock);
        return product;
    }
}
