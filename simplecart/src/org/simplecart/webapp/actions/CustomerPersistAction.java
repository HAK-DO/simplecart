/*
 * CustomerPersist.java
 *
 * Created on February 18, 2005, 3:26 PM
 */

package org.simplecart.webapp.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.hibernate.HibernateException;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Category;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import org.simplecart.account.Customer;
import org.simplecart.base.Address;
import org.simplecart.dao.CustomerDAO;
import org.simplecart.exceptions.AuthenticationException;
import org.simplecart.persistence.HibernateUtility;
import org.simplecart.security.CustomerSecurityService;
import org.simplecart.security.SecurityService;
import org.simplecart.webapp.Constants;
import org.simplecart.webapp.forms.PartyForm;

/**
 *
 * @author Daniel Watrous
 */
public class CustomerPersistAction extends DispatchAction {
    
    private CustomerDAO dao;
    private static Category cat = Category.getInstance(CustomerPersistAction.class.getName());
    /**
     */
    public ActionForward enter(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        ActionMessages errors = new ActionMessages();

        // get the session to store the new user object
        HttpSession session = request.getSession();
        
        // cast my form to a useful Type
        PartyForm customerForm = (PartyForm) form;
        
        // copy form-bean values to new Stake and Address objects
        Address newAddress = new Address();
        PropertyUtils.copyProperties(newAddress, customerForm);
        Customer newCustomer = new Customer();
        PropertyUtils.copyProperties(newCustomer, customerForm);
        
        // attache the address to this new customer
        newCustomer.setAddress(newAddress);
        
        // store customer object in the session
        session.setAttribute(Constants.LOGGED_IN_USER_KEY,newCustomer);
        
        // get a DAO for the new Stake
        dao = new CustomerDAO();
        
        // store the new Stake
        dao.makePersistent(newCustomer);
        
        // commit this transaction
        HibernateUtility.commitTransaction();
        HibernateUtility.closeSession();
        
        //********** NOW LOG the CUSTOMER IN **********
        
        SecurityService securityService = new CustomerSecurityService();
        Customer customer = null;

        // perform authentication
        try {
            customer = (Customer) securityService.authenticate(customerForm.getUsername(), customerForm.getPassword());
        } catch (AuthenticationException e) {
            if (e.getMessage().equals("Error initializing dao")) 
                errors.add(
                        ActionMessages.GLOBAL_MESSAGE,
                        new ActionMessage("error.database"));
            else if (e.getMessage().equals("Error validating user"))
                errors.add(
                        ActionMessages.GLOBAL_MESSAGE,
                        new ActionMessage("error.login"));
            else errors.add(
                    ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("error.login"));
        }
        
        // Report back any errors, and exit if any
        if (!errors.isEmpty()) {
            this.saveErrors(request, errors);
            return (mapping.getInputForward());
        } else {
            // add user to session
            session.setAttribute(Constants.LOGGED_IN_USER_KEY,customer);
            return mapping.findForward(Constants.SUCCESS_KEY);
        }

    }
    
    /**
     */
    public ActionForward edit(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        // cast my form to a useful Type
        PartyForm customerForm = (PartyForm) form;
        
        // get a DAO for the new Stake
        dao = new CustomerDAO();
        
        Customer customer = null;
        
        try {
            // find customer objects and attach to request
            customer = dao.findById(customerForm.getId(), false);
            
            // copy form-bean values to new Stake and Address objects
            // NOTE: PropertyUtils will not work in this situation since there
            //       is an ID field which is different for Stake and Address
            customer.setNameFirst(customerForm.getNameFirst());
            customer.setNameLast(customerForm.getNameLast());
            customer.setUsername(customerForm.getUsername());
            customer.setPassword(customerForm.getPassword());
            customer.setEmailAddress(customerForm.getEmailAddress());
            customer.setCompanyName(customerForm.getCompanyName());
            customer.setPhone(customerForm.getPhone());
            customer.getAddress().setStreetLine1(customerForm.getStreetLine1());
            customer.getAddress().setStreetLine2(customerForm.getStreetLine2());
            customer.getAddress().setCity(customerForm.getCity());
            customer.getAddress().setState(customerForm.getState());
            customer.getAddress().setPostalCode(customerForm.getPostalCode());
            
            // update the Stake
            dao.makePersistent(customer);
            
            // close transaction and session
            HibernateUtility.commitTransaction();
            HibernateUtility.closeSession();
        } catch (HibernateException e) {
            cat.info("An exception occured: " + e.toString());
        }
        
        return mapping.findForward(Constants.SUCCESS_KEY);

    }

}
