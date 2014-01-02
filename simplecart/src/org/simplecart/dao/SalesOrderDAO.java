package org.simplecart.dao;

import net.sf.hibernate.HibernateException;

import org.simplecart.contract.salesorder.InternetSalesOrder;
import org.simplecart.contract.salesorder.SalesOrder;

public class SalesOrderDAO extends BaseDAO {

    public SalesOrderDAO() {
        super();
        DAOClassType = InternetSalesOrder.class;
    }

    /**
     * @return SalesOrder by ID 
     * @param id 
     * @param lock 
     */
    public SalesOrder findById(Long id, boolean lock) throws HibernateException {
        SalesOrder order = null;

        order = (SalesOrder) abstractFindById(id, lock);
        return order;
    }
}
