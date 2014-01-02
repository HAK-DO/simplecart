package org.simplecart.dao;

import net.sf.hibernate.Criteria;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.expression.Expression;

import org.simplecart.persistence.HibernateUtility;
import org.simplecart.shopcart.catalog.InternetProductOption;

public class InternetProductOptionDAO extends BaseDAO {

    public InternetProductOptionDAO() {
        super();
        DAOClassType = InternetProductOption.class;
    }

    /**
     * @return  InternetProductOption by ID
     * @param id 
     * @param lock 
     */
    public InternetProductOption findById(Long id, boolean lock)
            throws HibernateException {
        InternetProductOption option = null;

        option = (InternetProductOption) abstractFindById(id, lock);
        return option;
    }
    
    public InternetProductOption findBySkuIdentifier (String skuIdentifier)
            throws HibernateException {
        InternetProductOption option = null;

        Criteria criteria = HibernateUtility.getSession().createCriteria(InternetProductOption.class);
        criteria.add(Expression.like("stockKeepingUnitIdentifier", skuIdentifier));
        option = (InternetProductOption) criteria.list().iterator().next();
        return option;
    }
}
