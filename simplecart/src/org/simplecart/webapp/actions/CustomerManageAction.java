/*
 * CustomerManage.java
 *
 * Created on February 18, 2005, 3:25 PM
 */

package org.simplecart.webapp.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import org.simplecart.account.Customer;
import org.simplecart.dao.CustomerDAO;
import org.simplecart.exceptions.AuthenticationException;
import org.simplecart.security.CustomerSecurityService;
import org.simplecart.security.SecurityService;
import org.simplecart.webapp.Constants;
import org.simplecart.webapp.forms.PartyForm;

/**
 *
 * @author Daniel Watrous
 */
@SuppressWarnings("unused")
public class CustomerManageAction extends DispatchAction {

	private CustomerDAO dao;
    private ActionMessages errors;
    private PartyForm customerForm;

    /**
     */
    public ActionForward dispaly(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        errors = new ActionMessages();
        HttpSession session = request.getSession();

        // try first to find a logged in user object
        Customer customer = (Customer) session.getAttribute(Constants.LOGGED_IN_USER_KEY);

        // if no user is found fail otherwise succeed
        if (customer == null) return mapping.findForward(Constants.DISPLAY_PAGE_KEY);
        else return mapping.findForward(Constants.ERROR_KEY);

    }

    /**
     * Retrieves a collection of <em>Administrator</em> objects and
     * stores them in a collection, then forward along to
     * the display page.
     */
    public ActionForward login(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String username = (String) PropertyUtils.getSimpleProperty(form,"username");
        String password = (String) PropertyUtils.getSimpleProperty(form,"password");
        ActionMessages errors = new ActionMessages();
        SecurityService securityService = new CustomerSecurityService();
        Customer customer = null;

        // perform authentication
        try {
            customer = (Customer) securityService.authenticate(username, password);
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
    public ActionForward signin(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String username = (String) PropertyUtils.getSimpleProperty(form,"username");
        String password = (String) PropertyUtils.getSimpleProperty(form,"password");
    	CustomerDAO cdao = new CustomerDAO();
        Customer customer = new Customer();
        customer.setEmailAddress(username);
        customer.setUsername(username);
        customer.setPassword(password);
        cdao.makePersistent(customer);
        ActionMessages errors = new ActionMessages();
        SecurityService securityService = new CustomerSecurityService();
        // perform authentication
        try {
            customer = (Customer) securityService.authenticate(username, password);
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
}
