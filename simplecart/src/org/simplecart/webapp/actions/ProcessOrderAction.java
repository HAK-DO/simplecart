/*
 * ProcessOrderAction.java
 *
 * Created on February 18, 2005, 3:27 PM
 */

package org.simplecart.webapp.actions;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.simplecart.account.Customer;
import org.simplecart.account.billing.CreditCardBillingDetails;
import org.simplecart.base.Address;
import org.simplecart.contract.payment.InternetPayment;
import org.simplecart.contract.salesorder.InternetSalesOrder;
import org.simplecart.contract.salesorder.SalesOrderLineItem;
import org.simplecart.dao.InternetProductOptionDAO;
import org.simplecart.dao.SalesOrderDAO;
import org.simplecart.persistence.HibernateUtility;
import org.simplecart.shopcart.Shopcart;
import org.simplecart.shopcart.ShopcartItem;
import org.simplecart.shopcart.catalog.ProductOption;
import org.simplecart.webapp.Constants;

/**
 *
 * @author Daniel Watrous
 */
@SuppressWarnings("rawtypes")
public class ProcessOrderAction extends Action {
    
	@SuppressWarnings("unchecked")
	public ActionForward execute (ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        // load the sesion for this request
        HttpSession session = request.getSession();
        
        // get the customer object from the session
        Customer customer = (Customer) session.getAttribute(Constants.LOGGED_IN_USER_KEY);
        
        // attache address to order
        Address orderAddress = (Address) session.getAttribute(Constants.PREPARE_ORDER_ADDRESS);
        
        // create a new order object
        InternetSalesOrder newOrder = new InternetSalesOrder (customer,orderAddress);
        
        // create the line items and add to order
        Shopcart shopcart = (Shopcart) session.getAttribute(Constants.SHOPCART);
        Iterator cartItems = shopcart.getItems().iterator();
        ShopcartItem currentItem;
        SalesOrderLineItem currentLineItem;
        ProductOption currentOption;

        // get a DAO for the new Stake
        InternetProductOptionDAO optionDAO = new InternetProductOptionDAO();
        
        while (cartItems.hasNext()) {
            currentItem = (ShopcartItem) cartItems.next();
            currentOption = optionDAO.findById(currentItem.getOptionId(),false);
            currentLineItem = 
            	new SalesOrderLineItem(
                    currentItem.getAmount(),
                    currentItem.getPrice(),
                    currentItem.getComment(),
                    currentOption);
            newOrder.getLineItems().add(currentLineItem);
        }
        
        // create the payment and attache to the order
        InternetPayment payment = new InternetPayment();
        CreditCardBillingDetails billing = (CreditCardBillingDetails) customer.getBillingDetails().iterator().next();
        payment.setCreditCardType(billing.getCreditCardType().toString());
        payment.setCreditCardNumber(billing.getCreditCardNumber());
        payment.setCreditCardCVVSCode(billing.getCreditCardCVVSCode());
        payment.setExpirationDate(billing.getCreditCardExpirationMonth()+"/"+billing.getCreditCardExpirationYear());
        payment.setPaymentAmount(shopcart.getCartTotal());
        payment.setPaymentDate(new java.util.Date());
        payment.setPaymentMethod("Credit Card");
        
        // add this payment to the newOrder
        newOrder.addPayment(payment);
        
        // create a customerDAO
        SalesOrderDAO orderDAO = new SalesOrderDAO();
        
        // persist the changes
        orderDAO.makePersistent(newOrder);

        // commit this transaction
        HibernateUtility.commitTransaction();
        HibernateUtility.closeSession();
        
        // clear out the session
        session.invalidate();

        // forward along to success
        return mapping.findForward(Constants.SUCCESS_KEY);
        
    }
}
