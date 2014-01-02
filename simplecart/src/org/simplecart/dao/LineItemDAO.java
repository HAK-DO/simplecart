package org.simplecart.dao;

import net.sf.hibernate.HibernateException;

import org.simplecart.contract.LineItem;

public class LineItemDAO extends BaseDAO {

    public LineItemDAO() {
        super();
        DAOClassType = LineItem.class;
    }

    /**
     * @return LineItem by ID 
     * @param id 
     * @param lock 
     */
    public LineItem findById(Long id, boolean lock) throws HibernateException {
        LineItem lineItem = null;

        lineItem = (LineItem) abstractFindById(id, lock);
        return lineItem;
    }
}
