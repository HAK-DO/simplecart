package org.simplecart.dao;

import net.sf.hibernate.HibernateException;

import org.simplecart.shopcart.catalog.InternetProductCategory;

public class InternetProductCategoryDAO extends BaseDAO {

    public InternetProductCategoryDAO() {
        super();
        DAOClassType = InternetProductCategory.class;
    }

    /**
     * @return InternetProductCategory by ID
     * @param id 
     * @param lock 
     */
    public InternetProductCategory findById(Long id, boolean lock)
            throws HibernateException {
        InternetProductCategory category = null;

        category = (InternetProductCategory) abstractFindById(id, lock);
        return category;
    }
}
