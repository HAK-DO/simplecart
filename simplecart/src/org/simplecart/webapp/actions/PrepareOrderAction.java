/*
 * PrepareOrderAction.java
 *
 * Created on February 18, 2005, 3:27 PM
 */

package org.simplecart.webapp.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Category;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.simplecart.account.Customer;
import org.simplecart.account.billing.CreditCardBillingDetails;
import org.simplecart.account.billing.CreditCardType;
import org.simplecart.base.Address;
import org.simplecart.dao.CustomerDAO;
import org.simplecart.persistence.HibernateUtility;
import org.simplecart.webapp.Constants;
import org.simplecart.webapp.forms.OrderForm;


/**
 *
 * @author Daniel Watrous
 */
public class PrepareOrderAction extends DispatchAction {
    
    private CustomerDAO cdao;
    @SuppressWarnings("unused")
	private static Category cat = Category.getInstance(PrepareOrderAction.class.getName());

    /**
     */
    public ActionForward enterAddress(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        // cast my form to a useful Type
        OrderForm orderForm = (OrderForm) form;

        // get the session to store the new user object
        HttpSession session = request.getSession();
        
        Address orderAddress = new Address();
        PropertyUtils.copyProperties(orderAddress, orderForm);
        
        // store customer object in the session
        session.setAttribute(Constants.PREPARE_ORDER_ADDRESS,orderAddress);
        
        return mapping.findForward(Constants.ENTER_BILLING_KEY);
        
    }

    /**
     */
    public ActionForward enterBilling(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        // get the session to store the new user object
        HttpSession session = request.getSession();
        
        // cast form to appropriate type
        OrderForm billingForm = (OrderForm) form;
        
        // get the customer object from the session
        Customer customer = (Customer) session.getAttribute(Constants.LOGGED_IN_USER_KEY);
        
        // copy form-bean values to new Stake and Address objects
        CreditCardBillingDetails creditCardDetails = new CreditCardBillingDetails();
        creditCardDetails.setCreditCardType(CreditCardType.getInstance(billingForm.getCreditCardType()));
        creditCardDetails.setCreditCardExpirationMonth(billingForm.getCreditCardExpirationMonth());
        creditCardDetails.setCreditCardExpirationYear(billingForm.getCreditCardExpirationYear());
        creditCardDetails.setCreditCardNumber(billingForm.getCreditCardNumber());
        creditCardDetails.setCreditCardCVVSCode(billingForm.getCreditCardCVVSCode());
        
        // attache the address to this new customer
        customer.addBillingDetails(creditCardDetails);
        
        // get a DAO for the new Stake
        cdao = new CustomerDAO();
        
        // store the new Stake
        cdao.makePersistent(customer);
        
        // place billing details in session for convenience
        session.setAttribute(Constants.PREPARE_ORDER_BILLING, creditCardDetails);
        
        // commit this transaction
        HibernateUtility.commitTransaction();
        HibernateUtility.closeSession();
                
        return mapping.findForward(Constants.REVIEW_ORDER_KEY);
    }

    /**
     */
    public ActionForward displayDetails(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        return mapping.findForward(Constants.REVIEW_ORDER_KEY);
    }

}
