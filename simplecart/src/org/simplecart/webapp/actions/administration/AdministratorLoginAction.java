package org.simplecart.webapp.actions.administration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.simplecart.administration.Administrator;
import org.simplecart.exceptions.AuthenticationException;
import org.simplecart.security.AdministrationSecurityService;
import org.simplecart.security.SecurityService;
import org.simplecart.webapp.Constants;

public class AdministratorLoginAction extends Action {
    
    public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String username = (String) PropertyUtils.getSimpleProperty(form,"username");
        String password = (String) PropertyUtils.getSimpleProperty(form,"password");
        ActionMessages errors = new ActionMessages();
        SecurityService securityService = new AdministrationSecurityService ();
        Administrator administrator = null;

        // perform authentication
        try {
            administrator = (Administrator) securityService.authenticate(username, password);
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
            session.setAttribute(Constants.LOGGED_IN_ADMIN_KEY,administrator);
            return mapping.findForward("success");
        }

    }
}