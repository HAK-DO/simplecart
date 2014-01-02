/*
 * SalesOrderManage.java
 *
 * Created on May 6, 2005, 2:55 PM
 */

package org.simplecart.webapp.actions.administration;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;
//import net.sf.hibernate.Hibernate;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import org.simplecart.contract.salesorder.SalesOrder;
import org.simplecart.dao.SalesOrderDAO;
import org.simplecart.persistence.HibernateUtility;
import org.simplecart.webapp.Constants;
import org.simplecart.webapp.forms.OrderForm;

/**
 *
 * @author Daniel Watrous
 */
@SuppressWarnings("rawtypes")
public class SalesOrderManageAction extends DispatchAction {
    
    private SalesOrderDAO dao;
    private ActionMessages errors;
    private OrderForm salesOrderForm;
    
    /**
     * Retrieves a collection of <em>SalesOrder</em> objects and
     * stores them in a collection, then forward along to 
     * the display page.
     */
    public ActionForward displayAll (ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        errors = new ActionMessages();
        
        // create DAO instance
        dao = new SalesOrderDAO();
        if (dao == null){
            errors.add(
                    ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("error.databaseDAO"));
        }
        
        // find salesOrder objects and attach to request
        Collection salesOrders = dao.findAll();
        
        // now add this collection to the request
        request.setAttribute(Constants.COLLECTION_SALES_ORDER_KEY, salesOrders);
        
        // commit Hibernate transaction and close Session
        HibernateUtility.commitTransaction();
        HibernateUtility.closeSession();
        
        // go to display page
        return mapping.findForward(Constants.DISPLAY_PAGE_ALL_KEY);
        
    }
    
    /**
     * Display details for a single <em>SalesOrder</em>.  
     */
    public ActionForward displayDetail (ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        // create a salesOrderForm from a OrderForm
        salesOrderForm = (OrderForm) form;
        
        // find the order by ID
        SalesOrder salesOrder = loadSalesOrder (salesOrderForm.getId());
        
        // now add this collection to the request
        request.setAttribute(Constants.OBJECT_SALES_ORDER, salesOrder);
        request.setAttribute(Constants.COLLECTION_SALES_ORDER_LINE_ITEMS_KEY, salesOrder.getLineItems());
        request.setAttribute(Constants.COLLECTION_SALES_ORDER_PAYMENTS_KEY, salesOrder.getPayments());
                
        // go to display page
        return mapping.findForward(Constants.DISPLAY_PAGE_DETAIL_KEY);
        
    }

    /**
     * Load a given <em>SalesOrder</em> from datasource in order
     * to populate a form object to be returned to a view.
     */
    public SalesOrder loadSalesOrder (Long id) {
        // get the object for errors
        errors = new ActionMessages();
        
        // create DAO instance
        dao = new SalesOrderDAO();
        if (dao == null){
            errors.add(
                    ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("error.database"));
            return null;
        }
        
        SalesOrder salesOrder = null;

        try {
            // find a salesOrder object and attach to request
            salesOrder = (SalesOrder) dao.findById(id, false);
            //Hibernate.initialize(salesOrder.getProducts());

            // close transaction and session
            HibernateUtility.commitTransaction();
            HibernateUtility.closeSession();
        } catch (HibernateException e) {
        }
        
        // return the stake object
        return salesOrder;
    }
    
}
