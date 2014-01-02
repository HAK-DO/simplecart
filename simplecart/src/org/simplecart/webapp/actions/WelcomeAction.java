/*
 * WelcomeAction.java
 *
 * Created on February 11, 2005, 2:24 PM
 */

package org.simplecart.webapp.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



/**
 *
 * @author Daniel Watrous
 */

public class WelcomeAction extends Action {
    
    public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        // move along to the links page
        return mapping.findForward("success");
    }
}
