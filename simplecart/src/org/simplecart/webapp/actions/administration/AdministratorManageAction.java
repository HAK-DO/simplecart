/*
 * ManageAdministrator.java
 *
 * Created on February 12, 2005, 2:51 PM
 */

package org.simplecart.webapp.actions.administration;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import org.simplecart.administration.Administrator;
import org.simplecart.dao.AdministratorDAO;
import org.simplecart.persistence.HibernateUtility;
import org.simplecart.webapp.Constants;
import org.simplecart.webapp.forms.PartyForm;

/**
 *
 * @author Daniel Watrous
 */
public class AdministratorManageAction extends DispatchAction  {
    
    private AdministratorDAO dao;
    private ActionMessages errors;
    private PartyForm administratorForm;
    
    /**
     * Retrieves a collection of <em>Administrator</em> objects and
     * stores them in a collection, then forward along to
     * the display page.
     */
    @SuppressWarnings("rawtypes")
	public ActionForward display(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        errors = new ActionMessages();
        
        // create DAO instance
        dao = new AdministratorDAO();
        if (dao == null){
            errors.add(
                    ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("error.databaseDAO"));
        }
        
        // find administrator objects and attach to request
        Collection administrators = dao.findAll();
        
        // now add this collection to the request
        request.setAttribute(Constants.COLLECTION_ADMINISTRATOR_KEY, administrators);
        
        // commit Hibernate transaction and close Session
        HibernateUtility.commitTransaction();
        HibernateUtility.closeSession();
        
        // go to display page
        return mapping.findForward(Constants.DISPLAY_PAGE_KEY);
        
    }
    
    /**
     * Forward along to the view with a form containing
     * fields to add a new <em>Administrator</em>.  This leaves
     * each field blank.
     */
    public ActionForward enter(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        // create a administratorForm from a PartyForm
        administratorForm = (PartyForm) form;
        
        // set activity field in form-bean
        administratorForm.setActivity(Constants.ENTER_PAGE_KEY);
        
        // go to display page
        return mapping.findForward(Constants.ENTER_PAGE_KEY);
        
    }
    
    /**
     * Populate fields for a given <em>Administrator</em> and foward
     * along to a view containing a form with fields to edit an
     * existing Administrator.
     */
    public ActionForward edit(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        // extract id from the request
        Long id = Long.decode(request.getParameter("administratorId"));
        
        // get Administrator object
        Administrator administrator = loadAdministrator(id);
        
        // create a administratorForm from a PartyForm
        administratorForm = (PartyForm) form;
        
        // copy properties to form-bean
        PropertyUtils.copyProperties(administratorForm, administrator);
        PropertyUtils.copyProperties(administratorForm, administrator.getAddress());
        administratorForm.setActivity(Constants.EDIT_PAGE_KEY);
        administratorForm.setId(administrator.getId());
        
        // go to display page
        return mapping.findForward(Constants.EDIT_PAGE_KEY);
        
    }
    
    /**
     * Populate fields for a given <em>Administrator</em> and foward along
     * to a view containing a form with fields to delete an
     * existing Administrator.
     */
    public ActionForward delete(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        // extract id from the request
        Long id = Long.decode(request.getParameter("administratorId"));
        
        // get Administrator object
        Administrator administrator = loadAdministrator(id);
        
        // create a administratorForm from a PartyForm
        administratorForm = (PartyForm) form;
        
        // copy properties to form-bean
        PropertyUtils.copyProperties(administratorForm, administrator);
        PropertyUtils.copyProperties(administratorForm, administrator.getAddress());
        administratorForm.setActivity(Constants.DELETE_PAGE_KEY);
        administratorForm.setId(administrator.getId());
        
        // go to display page
        return mapping.findForward(Constants.DELETE_PAGE_KEY);
        
    }
    
    /**
     * Load a given <em>Administrator</em> from datasource in order
     * to populate a form object to be returned to a view.
     */
    public Administrator loadAdministrator(Long id) {
        // get the object for errors
        errors = new ActionMessages();
        
        // create DAO instance
        dao = new AdministratorDAO();
        if (dao == null){
            errors.add(
                    ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("error.database"));
            return null;
        }
        
        Administrator administrator = null;
        
        try {
            // find stake objects and attach to request
            administrator = dao.findById(id, false);
            
            // close transaction and session
            HibernateUtility.commitTransaction();
            HibernateUtility.closeSession();
        } catch (HibernateException e) {
        }
        
        // return the stake object
        return administrator;
    }
    
}
